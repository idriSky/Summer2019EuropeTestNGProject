package com.cybertek.tests.day17_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo  {

    @Test
    public void readExcelFile(){

        // create an object from Excelutil
        //it accepts two arguments
        //Argument1: location of the file(path)
        //

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        System.out.println("Row count: "+ qa3short.rowCount());

        System.out.println("Column Count = " + qa3short.columnCount());

        System.out.println("column Names = " + qa3short.getColumnsNames());

        System.out.println("first column name = " + qa3short.getColumnsNames().get(0));

        List<Map<String, String>> dataList = qa3short.getDataList();

        System.out.println(dataList.get(0).get("firstname"));
      /*  for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
        }*/

      //get all data in 2d Array
      String [][] dayaArray = qa3short.getDataArray();
      //print the Array
      System.out.println(Arrays.deepToString(dayaArray));

    }

}
