package com.bob.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WorldRead {
  public static void main(String[] args) {
    readXml("M:/world1.xlsx");
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
            break;
          }
        }

        int length = value.length();
        Map<Integer, String> map = total.get(length);
        if (map == null) {
          map = new TreeMap();
          total.put(length, map);
        }
        map.put(key, value);
      }

      printMap(total);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static void printMap(Map map) {

    Set<Integer> lenSet = map.keySet();

    Long count = 0l;
    for (Integer length : lenSet) {
      System.out.println("\n\n长度为" + length + "的单词：");
      TreeMap<Integer, String> words = (TreeMap<Integer, String>) map.get(length);
      Set<Integer> indexSet = words.keySet();

      count += indexSet.size();

      for (Integer index : indexSet) {
        System.out.println("[" + index + "]" + words.get(index));
      }
    }

    System.out.println("单词共计：" + count + "个");


  }

}




