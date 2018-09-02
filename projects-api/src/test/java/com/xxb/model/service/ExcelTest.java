package com.xxb.model.service;

import com.xxb.web.dto.ItemDto;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghe
 * @date 2018/7/17  19:00
 */

public class ExcelTest {
    private static List<ItemDto> getMember() throws Exception {
        List list = new ArrayList();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        ItemDto user1 = new ItemDto();
        ItemDto user2 = new ItemDto();
        ItemDto user3 = new ItemDto();
        user1.setId(1);
        user1.setName("hehe");
        user2.setId(2);
        user2.setName("xixi");
        user3.setId(3);
        user3.setName("junjun");
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }

    @Test
    public void excelPoi() throws Exception{
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
        List<ItemDto> list = ExcelTest.getMember();

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            ItemDto stu = (ItemDto) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(stu.getId());
            row.createCell((short) 1).setCellValue(stu.getName());

        }
        // 第六步，将文件存到指定位置
        try
        {
            System.out.println(System.getProperty("projectsmanager"));
            FileOutputStream fout = new FileOutputStream("E:/Members.xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception
    {

    }
}
