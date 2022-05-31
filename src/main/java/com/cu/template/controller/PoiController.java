package com.cu.template.controller;

import com.cu.template.repository.mybatis.Tables;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PoiController {

    @Autowired
    Tables tables;

    @RequestMapping("/excel")
    public List<Map> excel(String schema){
        log.debug("schema["+schema+"]");
        List<Map> tableList = tables.findAll(schema);
        log.debug("tableList["+tableList+"]");


        XSSFWorkbook workbook = new XSSFWorkbook();

        for (Map item:tableList
             ) {
            String tableName = ""+item.get("TABLE_NAME");
            XSSFSheet sheet = workbook.createSheet(tableName);



        }



        return tableList;
    }

    public static void main(String[] args) {



    }
}
