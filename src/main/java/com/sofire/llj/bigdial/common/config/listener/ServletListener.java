package com.sofire.llj.bigdial.common.config.listener;



import com.sofire.llj.bigdial.common.prize.PrizeProperty;
import com.sofire.llj.bigdial.common.prize.PrizeSetProperty;
import com.sofire.llj.bigdial.game.util.ExcelFileMessageUtils;
import com.sofire.llj.bigdial.game.util.PrizeRandomInit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("系统启动！");
        //填充奖品池及随机生成获奖集
        ExcelFileMessageUtils excelFileMessageUtils = new ExcelFileMessageUtils();
        PrizeRandomInit randomInit = new PrizeRandomInit();
        //从配置文件中获取人员信息
        List<PrizeProperty> prizeProperties = excelFileMessageUtils.readExcelToPrizeProperty(randomInit.getPrizemessage());
        //从配置文件中获取奖品信息
        List<PrizeSetProperty> prizeSetProperties = excelFileMessageUtils.readExcelToPrizeSetProperty(randomInit.getPrizeSet());
        //系统随机配置获奖信息
        randomInit.prizeRandomStaffInit(prizeProperties);
        randomInit.prizeRandomSetInit(prizeSetProperties);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("系统退出！");
    }




}
