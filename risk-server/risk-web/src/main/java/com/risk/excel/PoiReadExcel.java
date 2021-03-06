package com.risk.excel;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * poi解析excel文件
 * Created by zhenge.feng.
 */
public class PoiReadExcel {
    /**
     * POI解析Excel文件内容
     * @param args
     */
    public static void main(String[] args) {

        //需要解析的excel文件

        File file = new File("e:/poi_test.xls");
        try {
            //创建excel,读取文件内容 高版本XSSFWorkbook
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

            //获取第一个工作表workbook.getSheet("Sheet0");
            //HSSFSheet sheet = workbook.getSheet("Sheet0");
            //读取默认第一个工作表sheet
            HSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = 0;
            //获取sheet中最后一行
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i < lastRowNum; i++) {
                HSSFRow row = sheet.getRow(i);
                //获取当前行最后单元格列号
                int lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    HSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.print(value + "  ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
