package com.sofire.llj.bigdial.game.util;

import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取填充数据
 */
public class ExcelFileMessageUtils {

    /**
     * 获取参加抽奖人的信息
     * @param in
     * @return
     */
    public List<PrizeProperty> readExcelToPrizeProperty(InputStream in) {
        List<PrizeProperty> prizeProperties = new ArrayList<PrizeProperty>();
        try {
            Workbook wb = new HSSFWorkbook(in);//解析xls格式
            Sheet sheet = wb.getSheetAt(0);//第一个工作表  ，第二个则为1，以此类推...
            int firstRowIndex = sheet.getFirstRowNum();
            int lastRowIndex = sheet.getLastRowNum();
            /**
             * 第一行的说明不进行数据录入
             */
            for (int rIndex = firstRowIndex+1; rIndex <= lastRowIndex; rIndex++) {
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    // int lastCellIndex = row.getLastCellNum();
                    PrizeProperty prizeProperty = new PrizeProperty();
                    for (int cIndex = firstCellIndex; cIndex < 6; cIndex++) {
                        Cell cell = row.getCell(cIndex);
                        String value = "";
                        if (cell != null) {
                            value = cell.toString();
                            switch (cIndex) {
                                case 0:
                                    prizeProperty.setMemCode(value.substring(0,value.indexOf(".")));
                                    break;
                                case 1:
                                    prizeProperty.setMemName(value);
                                    break;
                                case 2:
                                    prizeProperty.setRandomPize(value);
                                    break;
                                case 3:
                                    prizeProperty.setIsFlag(value.substring(0,value.indexOf(".")));
                                    break;
                                case 4:
                                    prizeProperty.setMemOrigin(value);
                                    break;
                                case 5:
                                    prizeProperty.setLoginpassword(value.substring(0,value.indexOf(".")));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    prizeProperties.add(prizeProperty);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prizeProperties;
    }

    /**
     * 获取奖品信息
     * @param in
     * @return
     */
    public List<PrizeSetProperty> readExcelToPrizeSetProperty(InputStream in) {
        List<PrizeSetProperty> prizeSetProperties = new ArrayList<PrizeSetProperty>();
        in = getClass().getClassLoader().getResourceAsStream("prizeSet.xls");
        Workbook wb = null;
        try {

            wb = new HSSFWorkbook(in);//解析xls格式
            Sheet sheet = wb.getSheetAt(0);//第一个工作表  ，第二个则为1，以此类推...
            int firstRowIndex = sheet.getFirstRowNum();
            int lastRowIndex = sheet.getLastRowNum();
            /**
             * 第一行的说明数据不进行录入
             */
            for (int rIndex = firstRowIndex+1; rIndex <= lastRowIndex; rIndex++) {
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    // int lastCellIndex = row.getLastCellNum();
                    PrizeSetProperty prizeSetProperty = new PrizeSetProperty();
                    for (int cIndex = firstCellIndex; cIndex < 6; cIndex++) {
                        Cell cell = row.getCell(cIndex);
                        String value = "";
                        if (cell != null) {
                            value = cell.toString();
                            switch (cIndex) {
                                case 0:
                                    prizeSetProperty.setPrizeCode(value.substring(0,value.indexOf(".")));
                                    break;
                                case 1:
                                    prizeSetProperty.setPrizeName(value);
                                    break;
                                case 2:
                                    prizeSetProperty.setPrizeDesc(value);
                                    break;
                                case 3:
                                    prizeSetProperty.setPrizeImg(value);
                                    break;
                                case 4:
                                    prizeSetProperty.setPrizeNum(Integer.parseInt(value.substring(0,value.indexOf("."))));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    prizeSetProperties.add(prizeSetProperty);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prizeSetProperties;
    }

}
