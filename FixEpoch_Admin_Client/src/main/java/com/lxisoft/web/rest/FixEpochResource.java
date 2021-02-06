package com.lxisoft.web.rest;

import com.lxisoft.domain.Admin;
import com.lxisoft.domain.Category;
import com.lxisoft.domain.Firm;
import com.lxisoft.domain.Firm;
import com.lxisoft.repository.AdminRepository;
import com.lxisoft.repository.CategoryRepository;
import com.lxisoft.repository.FirmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * FixEpochResource controller
 */
@Controller
//@RequestMapping("/api/fix-epoch")
public class FixEpochResource {
    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;
    private final FirmRepository firmRepository;

    private final Logger log = LoggerFactory.getLogger(FixEpochResource.class);

    public FixEpochResource(AdminRepository adminRepository, CategoryRepository categoryRepository, FirmRepository firmRepository) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.firmRepository = firmRepository;
    }

    @GetMapping("/home")
    public String Home()
    {
        return "index";
    }

    @GetMapping("/adminIndex")
    public ModelAndView AdminIndex()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin-index");
        return modelAndView;
    }

    @GetMapping("/adminIntro")
    public String showUpdateForm(Model model) {
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "admin-intro";
    }

    @GetMapping("newAdmin")
    public String newAdmin(Admin admin, Model model)
    {
       return "add-admin";
    }

    @PostMapping("addAdmin")
    public String addAdmin(@Valid Admin admin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        adminRepository.save(admin);
        return "adminIntro";
    }

    @GetMapping("editAdmin/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Admin admin = adminRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("admin", admin);
        return "update-admin";
    }

    @PostMapping("updateAdmin/{id}")
    public String updateAdmin(@PathVariable("id") long id, @Valid Admin admin, BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            admin.setId(id);
            return "update-Admin";
        }

        adminRepository.save(admin);
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "admin-intro";
    }

    @GetMapping("newCategory")
    public String newCategory(Category category, Model model)
    {
        return "add-category";
    }

    @PostMapping("addCategory")
    public String addCategory(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }

        categoryRepository.save(category);
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "admin-intro";
    }

    @GetMapping("editCategory/{id}")
    public String showUpdateCategory(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        model.addAttribute("category", category);
        return "update-category";
    }

    @PostMapping("updateCategory/{id}")
    public String updateCategory(@PathVariable("id") long id, @Valid Category category, BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-category";
        }

        categoryRepository.save(category);
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "admin-intro";
    }

    @GetMapping("newFirm")
    public String newFirm(Firm firm, Model model)
    {
        return "add-firm";
    }

    @PostMapping("addFirm")
    public String addFirm(@Valid Firm firm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-firm";
        }

        firmRepository.save(firm);
        model.addAttribute("categorys", categoryRepository.findAll());
        model.addAttribute("admins", adminRepository.findAll());
        return "admin-intro";
    }

}
