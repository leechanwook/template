package com.cu.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DashboardController {

    @RequestMapping("/admin/dashboard")
    public Map getDashboard(){
        Map item = new HashMap();
        item.put("test", "1234");
        return item;
    }

}
