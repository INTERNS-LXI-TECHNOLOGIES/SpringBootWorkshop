package com.lxisoft.vegetablestore.controller;

import com.lxisoft.vegetablestore.entity.Category;
import com.lxisoft.vegetablestore.entity.Vegetable;
import com.lxisoft.vegetablestore.service.VegetableStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@MultipartConfig
public class VegetableStoreController {

    @Autowired
    VegetableStoreService vegetableStoreService;


@GetMapping("/")
public String readVegetable(Model model) {

    model.addAttribute("vegetables",vegetableStoreService.readVegetable());

    model.addAttribute("categories",vegetableStoreService.readCategories());


    return "vegetable";
    }


@GetMapping("/add-form")
public String addVegetableForm(){

return "addVegetable";
}


@PostMapping("/create-vegetable")
public String createVegetable(@ModelAttribute Vegetable vegetable,@ModelAttribute Category category) throws IOException {

    vegetableStoreService.addVegetable(vegetable,category);

    return "vegetableConfirm";
}


@GetMapping("/select-vegetable")
public String selectVegetable(@RequestParam("id")int id, Model model) {

        model.addAttribute("vegetable",vegetableStoreService.selectData(id));

    return "updateVegetable";
}


@PostMapping("/update-vegetable")
    public String updateVegetable(@ModelAttribute Vegetable vegetable,@ModelAttribute Category category) throws IOException {

    vegetableStoreService.updateVegetable(vegetable,category);

return "redirect:/";
    }


@PostMapping("/delete-vegetable")
public String delete(@RequestParam("id")int id) {

 vegetableStoreService.deleteVegetable(id);

return "redirect:/";
}


@GetMapping("categories")
public String categories(@RequestParam(required=false,name="id")Integer id, Model model) {
    System.out.println("start");
   model.addAttribute("vegetables",vegetableStoreService.categories(id));

    return "category";
}

@GetMapping("/search")
public String search(@RequestParam("search")String word,Model model){

        model.addAttribute("vegetables", vegetableStoreService.search(word));

return "vegetable";
}


@GetMapping("/image")
public void image(@RequestParam("name")String name, HttpServletResponse response) throws IOException {

    vegetableStoreService.image(name,response);
}



}

