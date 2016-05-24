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

public class WorldRead {
  public static void main(String[] args) {
    readXml("M:/world1-2.xlsx");
  }

  public static void readXml(String fileName) {

    Map<String, String> twoMap = new LinkedHashMap<>();
    Map<String, String> threeMap = new LinkedHashMap<>();
    Map<String, String> fourMap = new LinkedHashMap<>();
    Map<String, String> fiveMap = new LinkedHashMap<>();
    Map<String, String> sixMap = new LinkedHashMap<>();
    Map<String, String> sevenMap = new LinkedHashMap<>();
    Map<String, String> eightMap = new LinkedHashMap<>();
    Map<String, String> nineMap = new LinkedHashMap<>();
    Map<String, String> tenMap = new LinkedHashMap<>();
    Map<String, String> elevenMap = new LinkedHashMap<>();
    Map<String, String> tweleMap = new LinkedHashMap<>();
    Map<String, String> therTeenMap = new LinkedHashMap<>();
    Map<String, String> fourTeenMap = new LinkedHashMap<>();
    Map<String, String> moreTeenMap = new LinkedHashMap<>();

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
        int i = 1;
        while (cells.hasNext()) {
          Cell cell = cells.next();
          if (i == 2) {
            String value = ReadExcel001.getCellValue(cell);
            if (value.length() == 2) {
              twoMap.put(value, value);
            } else if (value.length() == 3) {
              threeMap.put(value, value);
            } else if (value.length() == 4) {
              fourMap.put(value, value);
            } else if (value.length() == 5) {
              fiveMap.put(value, value);
            } else if (value.length() == 6) {
              sixMap.put(value, value);
            } else if (value.length() == 7) {
              sevenMap.put(value, value);
            } else if (value.length() == 8) {
              eightMap.put(value, value);
            } else if (value.length() == 9) {
              nineMap.put(value, value);
            } else if (value.length() == 10) {
              tenMap.put(value, value);
            } else if (value.length() == 11) {
              elevenMap.put(value, value);
            } else if (value.length() == 12) {
              tweleMap.put(value, value);
            } else if (value.length() == 13) {
              therTeenMap.put(value, value);
            } else if (value.length() == 14) {
              fourTeenMap.put(value, value);
            } else {
              moreTeenMap.put(value, value);
            }
          }
          i++;
        }
      }
      System.out.println("两个字母：");
      System.out.println(twoMap.keySet());
      System.out.println();
      System.out.println("三个字母：");
      System.out.println(threeMap.keySet());
      System.out.println();
      System.out.println("四个字母：");
      System.out.println(fourMap.keySet());
      System.out.println();
      System.out.println("五个字母：");
      System.out.println(fiveMap.keySet());
      System.out.println();
      System.out.println("六个字母：");
      System.out.println(sixMap.keySet());
      System.out.println();
      System.out.println("七个字母：");
      System.out.println(sevenMap.keySet());
      System.out.println();
      System.out.println("八个字母：");
      System.out.println(eightMap.keySet());
      System.out.println();
      System.out.println("九个字母：");
      System.out.println(nineMap.keySet());
      System.out.println();
      System.out.println("十个字母：");
      System.out.println(tenMap.keySet());
      System.out.println();
      System.out.println("十一个字母：");
      System.out.println(elevenMap.keySet());
      System.out.println();
      System.out.println("十二个字母：");
      System.out.println(tweleMap.keySet());
      System.out.println();
      System.out.println("十三个字母：");
      System.out.println(therTeenMap.keySet());
      System.out.println();
      System.out.println("十四个字母：");
      System.out.println(fourTeenMap.keySet());
      System.out.println();
      System.out.println("更多个字母：");
      System.out.println(moreTeenMap.keySet());
      System.out.println();

//      String headStr = "多一个首字母：";
//      String footStr = "多一个尾字母：";
//      String middleStr = "多个中间字母：";
//
//      String headDif = "首字母不相同：";
//      String footDif = "尾字母不相同：";
//      String middleDif = "中间某不相同：";
//
//      String startWith = "以此作为开始：";
//      String endWith = "以此作为结束：";
//
//      String totalAddHead = headStr;
//      String totalAddFoot = footStr;
//      String totalAddMiddle = middleStr;
//
//      String totalDifHead = headDif;
//      String totalDifFoot = footDif;
//      String totalDifMiddle = middleDif;
//
//      String totalStartWith = startWith;
//      String totalEndWith = endWith;
//
//      Map<String, String> exist = new LinkedHashMap<>();
//
//      System.out.println("开始处理：");
//
//      for (String world : worldMap.keySet()) {
//        for (String check : worldMap.keySet()) {
//
//          // 相等长度
//          if (world.length() == check.length() && !world.equals(check)) {
//            int len = check.length();
//            for (int i = 0; i < len; i++) {
//              String subWorld = world.substring(0, i) + world.substring(i + 1, len);
//              String subCheck = check.substring(0, i) + check.substring(i + 1, len);
//              if (subWorld.equals(subCheck)) {
//                if (i == 0) {
//                  if (totalDifHead.equals(headDif)) {
//                    totalDifHead += check;
//                  } else {
//                    totalDifHead += (" , " + check);
//                  }
//                } else if (i == len - 1) {
//                  if (totalDifFoot.equals(footDif)) {
//                    totalDifFoot += check;
//                  } else {
//                    totalDifFoot += (" , " + check);
//                  }
//                } else {
//                  if (totalDifMiddle.equals(middleDif)) {
//                    totalDifMiddle += check;
//                  } else {
//                    totalDifMiddle += (" , " + check);
//                  }
//                }
//                exist.put(world, world);
//                exist.put(check, check);
//              }
//            }
//          }
//
//          // 多一个长度
//          else if (world.length() == (check.length() - 1)) {
//            int len = check.length();
//            for (int i = 0; i < len; i++) {
//
//              String subCheck = check.substring(0, i) + check.substring(i + 1, len);
//
//              if (world.equals(subCheck)) {
//                if (i == 0) {
//                  if (totalAddHead.equals(headStr)) {
//                    totalAddHead += check;
//                  } else {
//                    totalAddHead += (" , " + check);
//                  }
//                } else if (i == len - 1) {
//                  if (totalAddFoot.equals(footStr)) {
//                    totalAddFoot += check;
//                  } else {
//                    totalAddFoot += (" , " + check);
//                  }
//                } else {
//                  if (totalAddMiddle.equals(middleStr)) {
//                    totalAddMiddle += check;
//                  } else {
//                    totalAddMiddle += (" , " + check);
//                  }
//                }
//                exist.put(world, world);
//                exist.put(check, check);
//              }
//            }
//          }
//
//          // 包含于
//          else if (world.length() > 3 && world.length() < (check.length() - 1)) {
//            if (check.startsWith(world)) {
//              if (totalStartWith.equals(startWith)) {
//                totalStartWith += check;
//              } else {
//                totalStartWith += (" , " + check);
//              }
//              exist.put(world, world);
//              exist.put(check, check);
//            } else if (check.endsWith(world)) {
//              if (totalEndWith.equals(endWith)) {
//                totalEndWith += check;
//              } else {
//                totalEndWith += (" , " + check);
//              }
//              exist.put(world, world);
//              exist.put(check, check);
//            }
//          }
//
//        }
//        if (!totalAddHead.equals(headStr)
//                || !totalAddFoot.equals(footStr)
//                || !totalAddMiddle.equals(middleStr)
//                || !totalDifHead.equals(headDif)
//                || !totalDifFoot.equals(footDif)
//                || !totalDifMiddle.equals(middleDif)
//                || !totalStartWith.equals(startWith)
//                || !totalEndWith.equals(endWith)) {
//          System.out.println("【 " + world + " 】");
//          if (!totalDifHead.equals(headDif)) {
//            System.out.println(totalDifHead);
//            totalDifHead = headDif;
//          }
//          if (!totalDifFoot.equals(footDif)) {
//            System.out.println(totalDifFoot);
//            totalDifFoot = footDif;
//          }
//          if (!totalDifMiddle.equals(middleDif)) {
//            System.out.println(totalDifMiddle);
//            totalDifMiddle = middleDif;
//          }
//
//          if (!totalAddHead.equals(headStr)) {
//            System.out.println(totalAddHead);
//            totalAddHead = headStr;
//          }
//          if (!totalAddFoot.equals(footStr)) {
//            System.out.println(totalAddFoot);
//            totalAddFoot = footStr;
//          }
//          if (!totalAddMiddle.equals(middleStr)) {
//            System.out.println(totalAddMiddle);
//            totalAddMiddle = middleStr;
//          }
//
//          if (!totalStartWith.equals(startWith)) {
//            System.out.println(totalStartWith);
//            totalStartWith = startWith;
//          }
//          if (!totalEndWith.equals(endWith)) {
//            System.out.println(totalEndWith);
//            totalEndWith = endWith;
//          }
//          System.out.println();
//        }
//      }
//      System.out.println("单词共计：" + exist.size() + "个");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}




