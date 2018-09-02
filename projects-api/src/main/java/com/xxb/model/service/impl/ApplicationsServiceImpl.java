package com.xxb.model.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xxb.model.entity.Applications;
import com.xxb.model.entity.Dict;
import com.xxb.model.enums.ApplicationType;
import com.xxb.model.mapper.ApplicationsMapper;
import com.xxb.model.service.IApplicationsService;
import com.xxb.model.service.IDictService;
import com.xxb.web.dto.ApplicationManagerDto;
import com.xxb.web.dto.ProjectManagerDto;
import com.xxb.web.param.ApplicationsParam;
import com.xxb.web.param.CreateApplicationParam;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 陈亮
 * @since 2018-07-05
 */
@Service
public class ApplicationsServiceImpl extends ServiceImpl<ApplicationsMapper, Applications> implements IApplicationsService {
    @Autowired
    private IDictService iDictService;
    /**
     * 更新删除状态
     * @param id 应用id
    */
    @Override
    public Integer upDeleteFlag(Integer id) {
        Applications applications = new Applications();
        applications.setId(id);
        applications.setDeleteFlag(1);
        return baseMapper.updateById(applications);
    }

    @Override
    public Integer updateCompleteNum(Integer appId) {
        return baseMapper.updateCompleteNum(appId);
    }


    /**
     * @param param 创建应用参数
    */
    @Override
    public void insertApplication(CreateApplicationParam param) {
        Applications applications = new Applications();
        applications.setProjectId(param.getProjectId());
        applications.setSystemType(param.getSystemType());
        applications.setUserId(param.getUserId());
        Integer i = baseMapper.insert(applications);
    }

    /**
     * 分页条件查询
     * @param page 分页参数
     * @param applicationsParam 分页条件
    */
    @Override
    public List<ProjectManagerDto> selectApplicationsList(Pagination page, ApplicationsParam applicationsParam) {
        //判断传入的type值为0,还是1
        if(applicationsParam!=null&&applicationsParam.getKey()!=null){
            Integer type = applicationsParam.getType();
            if(type.equals(ApplicationType.App名称.getCode())){
                //讲key的值设置为app名称
                applicationsParam.setProjectName(applicationsParam.getKey());
            }else if(type.equals(ApplicationType.创建人.getCode())){
                applicationsParam.setUserName(applicationsParam.getKey());
            }
        }

        //通过创建人查询到创建人id
        return baseMapper.selectApplicationsList(page,applicationsParam);
    }

    /**
     * 根据项目id和系统类型查询应用信息
     * @param projectId 项目id
     * @param systemType 系统类型
    */
    @Override
    public Applications getAppByProjectIdAndSystemType(Integer projectId, Integer systemType) {
        Applications app = new Applications();
        app.setProjectId(projectId);
        app.setSystemType(systemType);
        app.setDeleteFlag(0);
        return baseMapper.selectOne(app);
    }

    /**
     * @param ids 需要导出的id值
    */
    @Override
    public void exportPackage(Integer[] ids) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        //查找数据
        List<ApplicationManagerDto> list = baseMapper.selectExportPackage(Arrays.asList(ids));
        //获取角色权限
        if (list == null || list.size() == 0) {
            return;
        }
        //添加列名
        List<String> colName = new ArrayList<>();
        colName.add("ID");
        colName.add("app名称");
        colName.add("版本号");
        colName.add("更新内容");
        colName.add("系统类型");
        colName.add("发包人");
        colName.add("发包时间");
        colName.add("下载地址");
        colName.add("渠道");
        colName.add("下载总量");
        colName.add("已下载量");
        colName.add("强制更新");
        colName.add("有效时间");
        colName.add("版本大小");
        colName.add("状态");
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("应用包表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 创建一个居中格式

        //添加列名
        HSSFCell cell = row.createCell((short) 0);
        for (int i = 0; i < colName.size(); i++) {
            if (i != 0) {
                cell = row.createCell((short) i);
            }
            cell.setCellValue(colName.get(i));
            cell.setCellStyle(style);
        }

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            ApplicationManagerDto pmd = (ApplicationManagerDto) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(pmd.getId());
            row.createCell((short) 1).setCellValue(pmd.getProjectName());
            row.createCell((short) 2).setCellValue(pmd.getVersion());
            row.createCell((short) 3).setCellValue(pmd.getUpdateDescription());
            row.createCell((short) 4).setCellValue(pmd.getSystemType());
            row.createCell((short) 5).setCellValue(pmd.getUserName());
            row.createCell((short) 6).setCellValue(pmd.getCreateTime());
            row.createCell((short) 7).setCellValue(pmd.getDownloadUrl());
            String dictId = pmd.getDictId();
            if(dictId!=null){
                String[] split = dictId.split(",");
                //查询商店
                List<Dict> dictList = iDictService.selectBatchIds(Arrays.asList(split));
                StringBuffer sf = new StringBuffer();
                dictList.forEach(e->{
                    sf.append(e.getName());
                });
                String dicts = sf.toString();
                row.createCell((short) 8).setCellValue(dicts);
            }else {
                row.createCell((short) 8).setCellValue("");
            }
            row.createCell((short) 9).setCellValue(pmd.getDownloadTotal());
            row.createCell((short) 10).setCellValue(pmd.getConstraintUpdate());
            if(pmd.getStartTime()==null ||pmd.getStartTime()==null){
                row.createCell((short) 11).setCellValue("");
            }else{
                row.createCell((short) 11).setCellValue(sdf.format(pmd.getStartTime())+"-"+sdf.format(pmd.getEndTime()));
            }

            row.createCell((short) 12).setCellValue(pmd.getSize());
            row.createCell((short) 13).setCellValue(pmd.getStatus());
        }
        // 第六步，将文件存到指定位置
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            String fileName = "应用包表.xls";// 文件名
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            wb.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
