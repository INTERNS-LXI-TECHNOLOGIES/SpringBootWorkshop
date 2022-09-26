package com.lxisoft.vegetablestore.service;

import com.lxisoft.vegetablestore.entity.Category;
import com.lxisoft.vegetablestore.entity.Vegetable;

import com.lxisoft.vegetablestore.repository.CategoryRepository;
import com.lxisoft.vegetablestore.repository.VegetableStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collections;
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


    public void image(String name, HttpServletResponse response) throws IOException {

        String path ="../../../vegetablestore/src/main/resources/picture/"+ name;

        byte [] image = getImageAsBytes(path);

        response.setContentType("image/jpeg");
        response.setContentLength(image.length);
        response.getOutputStream().write(image);
    }
    private byte[] getImageAsBytes(String name) {


        File imgPath = new File(name);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            BufferedImage bufferedImage = ImageIO.read(imgPath);
            ImageIO.write(bufferedImage, "jpg", bos );
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();

    }

    public List<Vegetable> categories(int id) {
        System.out.println("start2");

List<Vegetable>list = categoryRepository.findVegetableInCategory(id);

if(list.size()==0){
    System.out.println("null");
}
        return list;

    }
}