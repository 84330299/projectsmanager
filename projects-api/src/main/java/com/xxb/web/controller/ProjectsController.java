package com.xxb.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xxb.annotation.Token;
import com.xxb.constant.ResultCode;
import com.xxb.exception.Assert;
import com.xxb.model.entity.Applications;
import com.xxb.model.entity.Projects;
import com.xxb.model.service.IApplicationsService;
import com.xxb.model.service.IProjectsService;
import com.xxb.model.service.IUserRoleService;
import com.xxb.utils.DtoUtil;
import com.xxb.utils.GetUserUtils;
import com.xxb.web.dto.*;
import com.xxb.web.param.ApplicationsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @author 陈亮
 * @since 2018-07-05
 */
@Api(tags = "项目管理(张玉)")
@RestController
@RequestMapping("/projects")
    public class ProjectsController implements Serializable{
    private ResultJson resultJson = new ResultJson();

    @Autowired
    private IProjectsService iprojectsService;
    @Autowired
    private IApplicationsService iApplicationsService;
    @Autowired
    private IUserRoleService iUserRoleService;
    /**
     * @param 自定义线程池
     */
    private static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,20,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(100) );

    @ApiOperation(value = "添加 - projects")
    @PostMapping(value = "insert")
    @Token
    public ResultJson insert(@RequestBody ProjectsDto model,@RequestHeader String token){
        Projects entity=DtoUtil.convertObject(model,Projects.class);
        entity.setUserId(GetUserUtils.getUser().getId());
        //判断当前项目中是否有同样的项目名和版本号
        if(model!=null&&model.getProductName()!=null&&model.getVersion()!=null){
            Wrapper<Projects>ew=new EntityWrapper<Projects>();
            ew.eq("product_name",model.getProductName());
            ew.eq("version",model.getVersion());
            ew.eq("delete_flag",0);
            Projects projects = iprojectsService.selectOne(ew);
            Assert.isNull(projects,"已存在该项目，不能创建");
        }
        boolean flag=iprojectsService.insert(entity);
        if(flag){
            //根据roleId查找到userId
//            String[] ids = model.getRoleId().split(",");
//            List<Users> users = iUserRoleService.getUsersByRole(ids);
//            if(users!=null &&users.size()>0){
//            //获取用户信息
//            threadPoolExecutor.execute(()->{
//                try {
//                    SmsUtil.sendSms(users,model.getProductName(),model.getVersion(),SmsTemplate.APPLICATION_TEMPLATE);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });}
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG);
        }
    }

    @ApiOperation(value = "根据id查询商品详情")
    @GetMapping(value = "detail/{id}")
    @Token
    public ResultJson<ProjectsDetailDto> getDetail(@ApiParam(value = "应用id")@PathVariable Integer id,@RequestHeader String token){
        //传入的是应用名id
        Applications applications = iApplicationsService.selectById(id);
        ProjectsDetailDto pdd=null;
        if(applications!=null&&applications.getId()!=null){
            //调用service根据id查询项目详情
            Wrapper<Projects> ew=new EntityWrapper<Projects>();
            ew.eq("id",applications.getProjectId());
            ew.eq("delete_flag",0);
            Projects projects = iprojectsService.selectOne(ew);
            Assert.notNull(projects,"该产品不存在");
            //将projects里面的数据封装到projectsDetatilDto里面
          pdd=iprojectsService.getDetail(projects);
        }
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(pdd);
    }

    /**
     * 查询所有的项目名
    */
    @ApiOperation(value = "所有项目名下拉列表")
    @GetMapping(value = "getNames")
    @Token
    public ResultJson<List<String>> getProductNames(@RequestHeader String token){
        Wrapper<Projects> projectsEntityWrapper = new EntityWrapper<>();
        projectsEntityWrapper.eq("delete_flag",0);
        projectsEntityWrapper.groupBy("product_name");
        List<String> list = iprojectsService.selectList(projectsEntityWrapper).stream().map(e -> e.getProductName()).collect(Collectors.toList());
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    /**
     * 通过项目名称查询版本号
    */
    @ApiOperation(value = "根据项目名查询版本号")
    @GetMapping(value = "getVersions/{name}")
    @Token
    public ResultJson<List<ProductVersion>> getVersions(@ApiParam(value = "项目名") @PathVariable String name,@RequestHeader String token){
        Wrapper<Projects> ew = new EntityWrapper<>();
        ew.eq("product_name", name);
        ew.eq("delete_flag",0);
        List<Projects> projects = iprojectsService.selectList(ew);
        List<ProductVersion> list=null;
        if(projects!=null &&projects.size()>0){
           list = projects.stream().map(e -> {ProductVersion pv = new ProductVersion();pv.setId(e.getId());pv.setName(e.getVersion());return pv;}).collect(Collectors.toList());
        }
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }


    @ApiOperation(value = "逻辑删除项目")
    @DeleteMapping(value = "delete/{id}")
    @Token
    public ResultJson delete(@ApiParam(value = "应用id")@PathVariable Integer id,@RequestHeader String token){
        //swagger是删除项目实际上是删除应用
        iApplicationsService.upDeleteFlag(id);
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
    }

    @ApiOperation(value = "批量删除项目")
    @PostMapping(value = "batchDelete")
    @Token
    public ResultJson batchDeleteProject(@ApiParam(value = "应用id数组")@RequestBody Integer[] ids,@RequestHeader String token){
        //这里的批量删除在swagger删除的是项目，但是实际上删除的是应用
        List<Applications> applications = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            Applications app = new Applications();
            app.setId(ids[i]);
            app.setDeleteFlag(1);
            applications.add(app);
        }
        Boolean flag=iApplicationsService.updateBatchById(applications);
        if(flag) {
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "项目启用和禁用状态修改")
    @PostMapping(value = "updateStatus/{id}/{status}")
    @Token
    public ResultJson updateProjectStatus(@ApiParam(value = "项目id",required = true) @PathVariable Integer id,@ApiParam(value = "修改状态(0:启用,1:关闭)",required = true) @PathVariable Integer status,@RequestHeader String token){
        Applications applications=new Applications();
        applications.setId(id);
        applications.setStatus(status);
        applications.setUpdateTime(new Date());
        Wrapper<Applications> ew=new EntityWrapper<Applications>();
        ew.eq("id",id);
        boolean flag = iApplicationsService.update(applications,ew);
        if(flag){
            return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(null);
        }else{
            return resultJson.setCode(ResultCode.FAIL).setMsg(ResultCode.FAIL_MSG).setData(null);
        }
    }

    @ApiOperation(value = "应用管理列表查看")
    @PostMapping(value = "getApps")
    @Token
    public ResultJson<Page<ProjectManagerDto>> getProjectPage(@RequestBody ApplicationsParam applicationsParam,@RequestHeader String token){
        Page<ProjectManagerDto> page=new Page<ProjectManagerDto>(applicationsParam.getCurrent(),applicationsParam.getSize());
        //查询分页信息
        Page<ProjectManagerDto> list = page.setRecords(iApplicationsService.selectApplicationsList(page,applicationsParam));
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }

    /**
     *根据项目id查询系统类型
     */
    @ApiOperation(value = "根据项目id,查询系统类型")
    @GetMapping(value = "getSystemType/{id}")
    @Token
    public ResultJson<List<Integer>> getSystemTypeByProjectId(@ApiParam(value = "项目id")@PathVariable Integer id,@RequestHeader String token){
        Wrapper<Applications> ew=new EntityWrapper<Applications>();
        ew.eq("project_id",id);
        ew.eq("delete_flag",0);
        List<Applications> applicationsList = iApplicationsService.selectList(ew);
        List<Integer> list=null;
        if(applicationsList!=null&&applicationsList.size()>0){
            list = applicationsList.stream().map(e -> e.getSystemType()).collect(Collectors.toList());
        }
        return resultJson.setCode(ResultCode.SUCCESS).setMsg(ResultCode.SUCCESS_MSG).setData(list);
    }
}

