package com.pcg.gitdemo.services;

import java.util.List;

import com.pcg.gitdemo.models.Asset;
import com.pcg.gitdemo.repositories.AssetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssetService {
    
    @Autowired
    private AssetRepository repo;

    public List<Asset> listAll(){
        return repo.findAll();
    }

    public void save(Asset ast){
        repo.save(ast);
    }

    public Asset get(int id){
        return repo.findById(id).get();
    }

    public void delete(int id){
        repo.deleteById(id);
    }
    public void count(){
        repo.count();
    }

    public int countStatus(String s){
        return repo.countByStatus(s);
    }

    public int countType(String s){
        return repo.countByType(s);
    }
}
