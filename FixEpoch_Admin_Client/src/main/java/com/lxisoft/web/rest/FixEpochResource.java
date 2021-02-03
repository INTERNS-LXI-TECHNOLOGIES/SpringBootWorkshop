package com.lxisoft.web.rest;

import com.lxisoft.domain.Admin;
import com.lxisoft.repository.AdminRepository;
import com.lxisoft.repository.CategoryRepository;
import com.lxisoft.repository.FirmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * FixEpochResource controller
 */
@RestController
@RequestMapping("/api/fix-epoch")
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
    public String login()
    {
        return "index";
    }

    @GetMapping("newAdmin")
    public String newAdmin(Admin admin, Model model)
    {
        model.addAttribute("movies", adminRepository.findAll());
        return "add-admin";
    }

    @PostMapping("addAdmin")
    public String addAdmin(@Valid Admin admin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        adminRepository.save(admin);
        return "redirect:admin-intro";
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
        return "admin-intro";
    }

}
