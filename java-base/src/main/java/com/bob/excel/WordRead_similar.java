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
import java.util.LinkedHashMap;
import java.util.Map;

public class WordRead_similar {
  public static void main(String[] args) {
    readXml("M:/world1.xlsx");
  }

  public static void readXml(String fileName) {

    LinkedHashMap<Integer, String> worldMap = new LinkedHashMap<>();

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
      while (rows.hasNext()) {
        Row row = rows.next(); // 获得行数据
        Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器

        Integer key = 0;
        String value = "";

        int i = 1;
        while (cells.hasNext()) {
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

        if (worldMap.containsValue(value))
          continue;
        worldMap.put(key, value);

      }

      String headStr = "多一个首字母：";
      String footStr = "多一个尾字母：";
      String middleStr = "多个中间字母：";

      String headDif = "首字母不相同：";
      String footDif = "尾字母不相同：";
      String middleDif = "中间某不相同：";

      String startWith = "以此作为开始：";
      String endWith = "以此作为结束：";

      String totalAddHead = headStr;
      String totalAddFoot = footStr;
      String totalAddMiddle = middleStr;

      String totalDifHead = headDif;
      String totalDifFoot = footDif;
      String totalDifMiddle = middleDif;

      String totalStartWith = startWith;
      String totalEndWith = endWith;

      System.out.println("开始处理：");

      for (Integer mainKey : worldMap.keySet()) {
        for (Integer checkKey : worldMap.keySet()) {

          String world = worldMap.get(mainKey);
          String check = worldMap.get(checkKey);
          String addValue = "[" + checkKey + "] " + check;

          // 相等长度
          if (world.length() == check.length() && !world.equals(check)) {
            int len = check.length();
            for (int i = 0; i < len; i++) {
              String subWorld = world.substring(0, i) + world.substring(i + 1, len);
              String subCheck = check.substring(0, i) + check.substring(i + 1, len);
              if (subWorld.equals(subCheck)) {
                if (i == 0) {
                  if (totalDifHead.equals(headDif)) {
                    totalDifHead += addValue;
                  } else {
                    totalDifHead += (" , " + addValue);
                  }
                } else if (i == len - 1) {
                  if (totalDifFoot.equals(footDif)) {
                    totalDifFoot += addValue;
                  } else {
                    totalDifFoot += (" , " + addValue);
                  }
                } else {
                  if (totalDifMiddle.equals(middleDif)) {
                    totalDifMiddle += addValue;
                  } else {
                    totalDifMiddle += (" , " + addValue);
                  }
                }
              }
            }
          }

          // 多一个长度
          else if (world.length() == (check.length() - 1)) {
            int len = check.length();
            for (int i = 0; i < len; i++) {

              String subCheck = check.substring(0, i) + check.substring(i + 1, len);

              if (world.equals(subCheck)) {
                if (i == 0) {
                  if (totalAddHead.equals(headStr)) {
                    totalAddHead += addValue;
                  } else {
                    totalAddHead += (" , " + addValue);
                  }
                } else if (i == len - 1) {
                  if (totalAddFoot.equals(footStr)) {
                    totalAddFoot += addValue;
                  } else {
                    totalAddFoot += (" , " + addValue);
                  }
                } else {
                  if (totalAddMiddle.equals(middleStr)) {
                    totalAddMiddle += addValue;
                  } else {
                    totalAddMiddle += (" , " + addValue);
                  }
                }
              }
            }
          }

          // 包含于
          else if (world.length() > 3 && world.length() < (check.length() - 1)) {
            if (check.startsWith(world)) {
              if (totalStartWith.equals(startWith)) {
                totalStartWith += addValue;
              } else {
                totalStartWith += (" , " + addValue);
              }
            } else if (check.endsWith(world)) {
              if (totalEndWith.equals(endWith)) {
                totalEndWith += addValue;
              } else {
                totalEndWith += (" , " + addValue);
              }
            }
          }

        }
        if (!totalAddHead.equals(headStr)
                || !totalAddFoot.equals(footStr)
                || !totalAddMiddle.equals(middleStr)
                || !totalDifHead.equals(headDif)
                || !totalDifFoot.equals(footDif)
                || !totalDifMiddle.equals(middleDif)
                || !totalStartWith.equals(startWith)
                || !totalEndWith.equals(endWith)) {
          System.out.println("【 [" + mainKey + "] " + worldMap.get(mainKey) + " 】");
          if (!totalDifHead.equals(headDif)) {
            System.out.println(totalDifHead);
            totalDifHead = headDif;
          }
          if (!totalDifFoot.equals(footDif)) {
            System.out.println(totalDifFoot);
            totalDifFoot = footDif;
          }
          if (!totalDifMiddle.equals(middleDif)) {
            System.out.println(totalDifMiddle);
            totalDifMiddle = middleDif;
          }

          if (!totalAddHead.equals(headStr)) {
            System.out.println(totalAddHead);
            totalAddHead = headStr;
          }
          if (!totalAddFoot.equals(footStr)) {
            System.out.println(totalAddFoot);
            totalAddFoot = footStr;
          }
          if (!totalAddMiddle.equals(middleStr)) {
            System.out.println(totalAddMiddle);
            totalAddMiddle = middleStr;
          }

          if (!totalStartWith.equals(startWith)) {
            System.out.println(totalStartWith);
            totalStartWith = startWith;
          }
          if (!totalEndWith.equals(endWith)) {
            System.out.println(totalEndWith);
            totalEndWith = endWith;
          }
          System.out.println();
        }
      }
      System.out.println("单词共计：" + worldMap.size() + "个");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}




