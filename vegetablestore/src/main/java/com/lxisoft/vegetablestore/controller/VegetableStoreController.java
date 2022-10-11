package com.lxisoft.vegetablestore.controller;

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


    return "home";
    }


@GetMapping("/add-form")
public String addVegetableForm(Model model){

    model.addAttribute("categories",vegetableStoreService.readCategories());

return "addVegetable";
}


@PostMapping("/create-vegetable")
public String createVegetable(@ModelAttribute Vegetable vegetable) throws IOException {

    vegetableStoreService.addVegetable(vegetable);

    return "vegetableConfirm";
}


@GetMapping("/select-vegetable")
public String selectVegetable(@RequestParam("id")int id, Model model) {

        model.addAttribute("vegetable",vegetableStoreService.selectData(id));
    model.addAttribute("categories",vegetableStoreService.readCategories());
    return "updateVegetable";
}


@PostMapping("/update-vegetable")
    public String updateVegetable(@ModelAttribute Vegetable vegetable) throws IOException {

    vegetableStoreService.updateVegetable(vegetable);

return "redirect:/";
    }

@PostMapping("/delete-vegetable")
public String delete(@RequestParam("id")int id) {

 vegetableStoreService.deleteVegetable(id);

return "redirect:/";
}


@GetMapping("/categories")
public String categories(@RequestParam(required=false,name="id")Integer id, Model model) {

   model.addAttribute("vegetables",vegetableStoreService.categories(id));
    model.addAttribute("categories",vegetableStoreService.readCategories());
    return "showResult";
}

    @PostMapping("/create-category")
    public String createCategories(@RequestParam("category") String category) {

   vegetableStoreService.addCategory(category);

        return "addVegetable";
    }

@GetMapping("/search")
public String search(@RequestParam("search")String word,Model model){

        model.addAttribute("vegetables", vegetableStoreService.search(word));
    model.addAttribute("categories",vegetableStoreService.readCategories());

return "showResult";
}


@GetMapping("/image")
public void image(@RequestParam("name")String name, HttpServletResponse response) throws IOException {

    vegetableStoreService.image(name,response);
}

@GetMapping("/login")
    public String login(){

    return "login";
}

}

