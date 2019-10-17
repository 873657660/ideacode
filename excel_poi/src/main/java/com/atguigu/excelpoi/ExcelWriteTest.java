package com.atguigu.excelpoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangyanan
 * @create 2019-09-29 11:30
 */
public class ExcelWriteTest {

    @Test
    public void testWrite01() throws IOException {
        Workbook workbook = new HSSFWorkbook();
        FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write03.xls");

        // 创建工作表，默认为Sheet0
        Sheet sheet = workbook.createSheet();
        // 创建行（row 1）
        Row row = sheet.createRow(0);
        // 创建单元格
        Cell cell = row.createCell(0);
        cell.setCellValue("今日人数");

        Cell cell1 = row.createCell(1);
        cell1.setCellValue(123);

        Cell cell2 = row.createCell(2);
        String DateTime = new DateTime().toString("yy-MM-dd HH:mm:ss");
        cell1.setCellValue(DateTime);

        workbook.write(out);

        out.close();

        System.out.println("文件生成成功");
    }

    @Test
    public void testWrite02() throws IOException {
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("循环");
        for (int rowNum = 0; rowNum < 65535; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 6; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(rowNum + "-" + cellNum);
            }
        }
        System.out.println("文件写入成功");

        FileOutputStream out = new FileOutputStream("d:/excel-poi/test-write03.xls");
        workbook.write(out);

        out.close();

        System.out.println("文件生成成功");
    }
}
