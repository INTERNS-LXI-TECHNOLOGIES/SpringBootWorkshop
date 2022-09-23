package com.lxisoft.vegetablestore.service;

import com.lxisoft.vegetablestore.entity.Category;
import com.lxisoft.vegetablestore.entity.Vegetable;

import com.lxisoft.vegetablestore.repository.CategoryRepository;
import com.lxisoft.vegetablestore.repository.VegetableStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
public class VegetableStoreService{

    @Autowired
    VegetableStoreRepository vegetableRepository;

@Autowired
CategoryRepository categoryRepository;

    public List<Vegetable> readVegetable() {

        return vegetableRepository.findAll();
    }

    public List<Category> readCategories() {

        return categoryRepository.findAll();
    }


    public void addVegetable(Vegetable vegetable, Category category) throws IOException {

        InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

        byte[]image = new byte[inputStream.available()];

        inputStream.read(image);

        vegetable.setImage(image);

        category.getVegetables().add(vegetable);

       categoryRepository.save(category);
    }


    public Vegetable selectData(int id) {

        return vegetableRepository.findById(id).get();

    }


    public void updateVegetable(Vegetable vegetable,Category category) throws IOException {

        InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

        byte[]image = new byte[inputStream.available()];

        inputStream.read(image);
        vegetable.setImage(image);

        category.getVegetables().add(vegetable);

        categoryRepository.save(category);
    }

    public void deleteVegetable(int id) {

        vegetableRepository.deleteById(id);

    }

    public List<Vegetable> search(String word) {

        return vegetableRepository.search(word);
    }


}