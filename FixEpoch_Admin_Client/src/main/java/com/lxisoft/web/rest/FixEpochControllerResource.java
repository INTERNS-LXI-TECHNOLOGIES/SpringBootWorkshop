package com.lxisoft.web.rest;

import com.lxisoft.domain.Admin;
import com.lxisoft.domain.Categorie;
import com.lxisoft.domain.Firm;
import com.lxisoft.domain.User;
import com.lxisoft.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * FixEpochControllerResource controller
 */
@Controller
//@RequestMapping("/api/fix-epoch-controller")
public class FixEpochControllerResource {

    private final AdminRepository adminRepository;
    private final Categorie categorie;
    private final Firm firm;
    private final User user;

    private final Logger log = LoggerFactory.getLogger(FixEpochControllerResource.class);

    public FixEpochControllerResource(AdminRepository adminRepository, Categorie categorie, Firm firm, User user) {
        this.adminRepository = adminRepository;
        this.categorie = categorie;
        this.firm = firm;
        this.user = user;
    }

    /**
    * HOme
    */
    @GetMapping("/home")
    public String login()
    {
        return "index";
    }

    @GetMapping("newadmin")
    public String newActor(Admin admin, Model model)
    {
        return "add-admin";
    }

    @PostMapping("addadmin")
    public String addActor(@Valid Admin admin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-admin";
        }

        adminRepository.save(admin);
        return "redirect:index";
    }

//    @GetMapping("newActor")
//    public String newActor(Admin admin, Model model)
//    {
//        return "add-actor";
//    }
//
//    @PostMapping("addActor")
//    public String addActor(@Valid Admin admin, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-actor";
//        }
//
//        adminRepository.save(admin);
//        return "redirect:index";
//    }

}
