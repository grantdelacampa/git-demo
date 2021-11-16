package com.pcg.gitdemo.controllers;

import com.pcg.gitdemo.models.Asset;
import com.pcg.gitdemo.services.AssetService;
import com.pcg.gitdemo.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/Asset")
public class AssetRestController {
    
    @Autowired
    private AssetService assetService;

    @GetMapping
    public ResponseEntity<List<Asset>> readAssets(){
        return ResponseEntity.ok(assetService.listAll());
    }

}
