package com.atguigu.excelpoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangyanan
 * @create 2019-09-29 18:38
 */
public class ExcelReadTest {

    @Test
    public void testRead01() throws IOException {
        FileInputStream input = new FileInputStream("d:/excel-poi/test-write03.xls");

        Workbook workbook = new HSSFWorkbook(input);
        //System.out.println(workbook.getSheetAt(0));
        Sheet sheet = workbook.getSheetAt(0);

        for (int rowNum = 0; rowNum < 65535; rowNum++) {
            Row row = sheet.getRow(rowNum);
            for (int cellNum = 0; cellNum < 6; cellNum++) {
                Cell cell = row.getCell(cellNum);
                System.out.print(cell.getStringCellValue() + " hhhh");
            }
            System.out.println("");
        }

        input.close();

        System.out.println("文件写入成功");

    }
}
