package com.pcg.gitdemo.controllers;

import java.util.List;

import com.pcg.gitdemo.services.AssetService;
import com.pcg.gitdemo.models.Asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AssetController {
    
    @Autowired
    private AssetService service;

    @RequestMapping("/asset")
    public String viewAssets(Model model){
        List<Asset> listAssets = service.listAll();
        model.addAttribute("listAssets", listAssets);
        return "assetHome";
    }

    @RequestMapping("/asset/new")
    public String createAsset(Model model){
        Asset asset = new Asset();
        model.addAttribute("asset", asset);
        return "assetNew";
    }

    @RequestMapping("/asset/import")
    public String importAsset(Model model){
        return "assetImport";
    }

    @RequestMapping("/asset/edit/{id}")
    public ModelAndView editAsset(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("assetEdit");
        Asset asset = service.get(id);
        mav.addObject("asset", asset);
        return mav;
    }

    @RequestMapping(value="asset/save", method = RequestMethod.POST)
    public String saveAsset(@ModelAttribute("asset") Asset asset){
        service.save(asset);
        return "redirect:/asset";
    }

    @RequestMapping("/asset/delete/{id}")
    public String deleteAsset(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/asset";
    }
}
