package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.constant.SmsTemplate;
import com.xxb.exception.Assert;
import com.xxb.model.entity.*;
import com.xxb.model.enums.TelephoneType;
import com.xxb.model.enums.UpdateStatus;
import com.xxb.model.mapper.PackagesMapper;
import com.xxb.model.service.*;
import com.xxb.utils.SmsUtil;
import com.xxb.web.dto.ApplicationDetailDto;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ConditionProjectDto;
import com.xxb.web.dto.PackageDownloadDto;
import com.xxb.web.param.CreateApplicationParam;
import com.xxb.web.param.PackageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * @Date 2018/7/17.
 */
@Service
public class PackagesServiceImpl extends ServiceImpl<PackagesMapper, Packages> implements IPackagesService {
    @Autowired
    private IDictService iDictService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IProjectsService iProjectsService;
    @Autowired
    private IApplicationsService iApplicationsService;
    /**
     * @param 自定义线程池
     */
    private static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,20,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(100) );
    /**
     * 往发包表中插入数据
     * @param param 创建应用的参数
    */
    @Override
    public Integer insertPackage(CreateApplicationParam param) {
        //比较系统是否有这个包
        Wrapper<Packages> ew=new EntityWrapper<Packages>();
        ew.eq("application_id",param.getApplicationId());
        ew.eq("delete_flag",0);
        List<Packages> packagesList = baseMapper.selectList(ew);
        Assert.isTrue(packagesList.size()<1,"此包已存在，请先删除再发包");
        Packages packages = new Packages();
        packages.setUpdateBrief(param.getUpdateBrief());
//        Packages packages = DtoUtil.convertObject(param, Packages.class);
        packages.setDict_ids(param.getAppStoreIds());
        packages.setDownloadUrl(param.getDownloadUrl());
        packages.setDownloadTotal(param.getDownloadTotal());
        packages.setApplicationId(param.getApplicationId());
        packages.setSizes(param.getSizes());
        packages.setDict_ids(param.getAppStoreIds());
        packages.setRoleId(param.getRoleId());
        packages.setUpdateDescription(param.getUpdateDescription());
        packages.setForceUpdate(param.getForceUpdate());
        packages.setStartTime(param.getStartTime());
        packages.setEndTime(param.getEndTime());
        packages.setUserId(param.getUserId());
        packages.setCode(param.getCode());
        if(param!=null&&param.getRoleId()!=null&&param.getProjectId()!=null){
            Projects projects = iProjectsService.selectById(param.getProjectId());
            Assert.notNull(projects,"没有这个项目");
            String[] ids = param.getRoleId().split(",");
            List<Users> users = iUserRoleService.getUsersByRole(ids);
            threadPoolExecutor.execute(()->{
                try {
                    SmsUtil.sendSms(users,projects.getProductName(),projects.getVersion(), SmsTemplate.APPLICATION_TEMPLATE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Integer column = baseMapper.insert(packages);
        return column;
    }

    /**
     * 查看单个发包详情
     * @param id 发包记录id
    */
    @Override
    public ApplicationDetailDto selectDetailPackage(Integer id) {
        ApplicationDetailDto applicationDetailDto = baseMapper.selectDetailPackage(id);
        //根据id查询当前的应用商店集合
        Packages packages = baseMapper.selectById(id);
        if(packages!=null&&packages.getDict_ids()!=null){
            String[] split = packages.getDict_ids().split(",");
            List<String> roleIds = Arrays.asList(split);
            //通过角色id查询所有的角色信息
            List<Dict> dicts = iDictService.selectBatchIds(roleIds);
            if(dicts!=null&&dicts.size()>0){
                List<String> stringList = dicts.stream().map(e -> e.getName()).collect(Collectors.toList());
                applicationDetailDto.setApps(stringList);
            }
        }
        return applicationDetailDto;
    }

    /**
     * @param page 分页参数
     * @param cpd  条件分页查询
     */
    @Override
    public List<ApplicationManagerDto> selectPackageList(Pagination page, ConditionProjectDto cpd) {
        List<ApplicationManagerDto> packages=baseMapper.selectPackageList(page,cpd);
        if(packages!=null&&packages.size()>0){
            packages.forEach(e->{
                //获取商店拼接的名称Id
                String dictId = e.getDictId();
                if(dictId!=null){
                    String[] ids = dictId.split(",");
                    List<String> roleIds = Arrays.asList(ids);
                    List<Dict> dicts = iDictService.selectBatchIds(roleIds);
                    if(dicts!=null&&dicts.size()>0){
                        List<String> stringList = dicts.stream().map(n -> n.getName()).collect(Collectors.toList());
                        e.setAppNames(stringList);
                    }
                }
            });
        }
        return packages;
    }

    /**
     * @param param 校验版本是否是最新的参数
    */
    @Override
    public PackageDownloadDto updateCheck(PackageParam param) {
        PackageDownloadDto packageDownloadDto=new PackageDownloadDto();
        packageDownloadDto.setForceUpdate(UpdateStatus.不更新.getCode());
        //查询最新包的信息
        Packages packageInfo = baseMapper.selectPackageNew(param);
        //查询最新包返回参数信息
        PackageDownloadDto pdd=baseMapper.selectNewest(param);
        if(pdd==null){
            return packageDownloadDto;
        }
        if(packageInfo==null||packageInfo.getStatus()==0){
            return packageDownloadDto;
        }
        //只有android才需要判断当前手机品牌是否在更新的里面
        if(param.getSystemType().equals(TelephoneType.Android)) {
            //通过传进来的名字匹配dictId
            Wrapper<Dict> ew=new EntityWrapper<>();
            ew.eq("name", param.getSourceName());
            ew.eq("type",1);
            Dict dict = iDictService.selectOne(ew);
            if (dict == null) {
                Wrapper<Dict> ew1 = new EntityWrapper<>();
                ew1.eq("name", "其它");
                ew1.eq("type", 1);
                dict = iDictService.selectOne(ew1);
            }
            //判断传入的渠道来源是否在系统允许的渠道中
            String dict_ids = packageInfo.getDict_ids();
            String[] split = dict_ids.split(",");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(dict.getId().toString())) {
                    break;
                }
                if ((split.length - 1) <= i) {
                    return packageDownloadDto;
                }
            }
            //判断用户当前的code码有没有系统最新的大(android有code码,ios没有code码)
            if(pdd.getCode()!=null){
                if(param.getCode().equals(pdd.getCode())){
                    return packageDownloadDto;
                }
            }
        }
        //判断当前包的下载量(若下载量没有达到设置量,提示不更新)
        if(packageInfo.getDownloadTotal()!=null&&packageInfo.getDownloadComplete()!=null){
            if(packageInfo.getDownloadTotal()<=packageInfo.getDownloadComplete()){
                return packageDownloadDto;
            }
        }
        //判断开始时间和结束时间
        if(packageInfo.getStartTime()!=null &&packageInfo.getEndTime()!=null){
               if(System.currentTimeMillis()<packageInfo.getStartTime().getTime()||System.currentTimeMillis()>packageInfo.getEndTime().getTime()){
                    return packageDownloadDto;
               }
        }
        return pdd;
    }

    /**
     * 增加下载量
     * @param param 最新版本参数
    */
    @Override
    public Integer increaseDownloadNum(PackageParam param) {
        Projects projects = iProjectsService.selectByProjectNameAndVersion(param.getProjectName(), param.getVersion());
        Integer column=null;
        if(projects!=null){
            Applications app = iApplicationsService.getAppByProjectIdAndSystemType(projects.getId(), param.getSystemType());
            //应用与包是一对一关系，根据应用查询包的信息
            Packages packages = new Packages();
            Packages packageInfo=null;
            if(app!=null &&app.getId()!=null){
                packages.setApplicationId(app.getId());
                packages.setDeleteFlag(0);
                packageInfo = baseMapper.selectOne(packages);
            }
            //判断已下载量和设置下载量、
            if(packageInfo!=null &&packageInfo.getDownloadTotal()!=null&&packageInfo.getDownloadComplete()!=null){
                if(packageInfo.getDownloadTotal()>packageInfo.getDownloadComplete()){
                   //更改已下载量数据
                    column=baseMapper.increaseDownloadNum(packageInfo.getId());
                }
            }
        }
        return column;
    }
}
