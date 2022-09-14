package com.lxisoft.vegetablestore.service;

import com.lxisoft.vegetablestore.repository.VegetableStoreRepository;
import com.lxisoft.vegetablestore.vegetable.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class VegetableStoreService{

    @Autowired
    VegetableStoreRepository repository;


    public List<Vegetable> readVegetable() {

        return repository.findAll();
    }

    public void addVegetable(Vegetable vegetable) throws IOException {

        InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

        byte[]image = new byte[inputStream.available()];

        inputStream.read(image);

        vegetable.setImage(image);

        repository.save(vegetable);
    }


    public Vegetable selectData(int id) {

        return repository.findById(id).get();

    }


    public void updateVegetable(Vegetable vegetable) throws IOException {

        InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

        byte[]image = new byte[inputStream.available()];

        inputStream.read(image);
        vegetable.setImage(image);

        repository.save(vegetable);
    }

    public void deleteVegetable(int id) {

        repository.deleteById(id);

    }

    public List<Vegetable> search(String word) {

        return repository.search(word);
    }

}