package com.bob.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WorldReadSeperate {
  public static void main(String[] args) {
    readXml("/Users/adolphor/Downloads/aria2/20000_words调序完整版.xlsx");
  }

  public static void readXml(String fileName) {

    TreeMap<Integer, Map> total = new TreeMap<>();

    boolean isE2007 = false; // 判断是否是excel2007格式
    if (fileName.endsWith("xlsx"))
      isE2007 = true;
    try {
      InputStream input = new FileInputStream(fileName); // 建立输入流
      Workbook wb = null;
      // 根据文件格式(2003或者2007)来初始化
      if (isE2007)
        wb = new XSSFWorkbook(input);
      else
        wb = new HSSFWorkbook(input);
      Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
      Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器

      String md = "";
      while (rows.hasNext()) { // 行遍历
        Row row = rows.next();
        Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器

        Integer key = 0;
        String value = "";

        int i = 1;
        while (cells.hasNext()) { // 列遍历
          Cell cell = cells.next();
          if (i == 1) {
            String keyVal = ReadExcel001.getCellValue(cell);
            key = Integer.parseInt(keyVal);
            i++;
          } else if (i == 2) {
            value = ReadExcel001.getCellValue(cell);
            md += ("## " + value + "\n");
            md += ("* " + key + "\n\n");
            break;
          }
        }

        if (key % 100 == 99) {

          String mdName = getStr(key - 99) + "-" + getStr(key) + ".md";

          File file = new File("/Users/adolphor/Downloads/temp/" + mdName);
          if (!file.exists()) {
            file.createNewFile();
          }
          FileWriter writer = new FileWriter(file);
          writer.write(md);
          writer.flush();

          md = "";
        }

      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static String getStr(int i) {
    return String.format("%0" + 5 + "d", i);
  }


}




