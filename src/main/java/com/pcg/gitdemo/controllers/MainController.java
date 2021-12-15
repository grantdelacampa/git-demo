package com.pcg.gitdemo.controllers;

import java.util.Map;
import java.util.TreeMap;

import com.pcg.gitdemo.services.AssetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private AssetService astService;
    @RequestMapping("/")
    public String loadHome(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("Purchased", astService.countStatus("Purchased"));
        graphData.put("Shipped", astService.countStatus("Shipped"));
        graphData.put("Installed", astService.countStatus("Installed"));
        graphData.put("Registered", astService.countStatus("Registered"));
        graphData.put("Obsolete", astService.countStatus("Obsolete"));
        model.addAttribute("chartData", graphData);
        Map<String, Integer> graphData2 = new TreeMap<>();
        graphData2.put("Digital", astService.countType("Digital"));
        graphData2.put("Physical", astService.countType("Physical"));
        graphData2.put("External", astService.countType("External"));
        model.addAttribute("chart2Data", graphData2);
        return "index";
    }
    @RequestMapping("/api")
    public String loadApiHome(){
        return "apiHome";
    }
}
