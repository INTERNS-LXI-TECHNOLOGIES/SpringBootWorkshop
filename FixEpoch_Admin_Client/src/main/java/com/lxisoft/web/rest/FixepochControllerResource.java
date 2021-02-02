package com.lxisoft.web.rest;

import com.lxisoft.domain.Admin;
import com.lxisoft.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * FixepochControllerResource controller
 */
@RestController
//@RequestMapping("/api/fixepoch-controller")
public class FixepochControllerResource {

    private final AdminRepository adminRepository;
    private final CatagorieResource catagorieResource;

    private final Logger log = LoggerFactory.getLogger(FixepochControllerResource.class);

    public FixepochControllerResource(AdminRepository adminRepository, CatagorieResource catagorieResource) {
        this.adminRepository = adminRepository;
        this.catagorieResource = catagorieResource;
    }

    /**
    * GET add
    */
    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/home")
    public String login()
    {
        return "index";
    }

    @GetMapping("newAdmin")
    public String newActor(Admin admin, Model model)
    {
        model.addAttribute("movies",adminRepository.findAll());
        return "add-admin";
    }

    @PostMapping("addAdmin")
    public String addActor(@Valid Admin admin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        adminRepository.save(admin);
        return "redirect:index";
    }
}
