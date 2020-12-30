package com.lxisoft.controller;

import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
public class ContactController {


    @Autowired ContactService contactservice;


    @GetMapping(value = {"/", "/home"})
    public String indexPage() {

        return "index";
    }
    @RequestMapping(value = "/AddContact",method = RequestMethod.GET)
    public ModelAndView AddContact(ModelAndView model)
    {
        Contact contact=new Contact();
        model.addObject("contact",contact);
        model.setViewName("AddContact");
        return model;
    }
    @RequestMapping(value = "/AddServlet",method = RequestMethod.GET)
    public ModelAndView AddContact(@ModelAttribute Contact contact)
    {
        contactservice.add(contact);
        return new ModelAndView("redirect:/ViewServletUser");

    }

    @RequestMapping(value = "/ViewServletUser",method=RequestMethod.GET )
    public ModelAndView ViewServletUser(ModelAndView model)
    {
       // HttpSession session = request.getSession();
        List<Contact> contactList = contactservice.viewData();
        //ModelAndView model = new ModelAndView();
        //session.setAttribute("contactList",contactList);

        model.addObject("contactList",contactList);
        model.setViewName("ViewContactUser");
        return model;
    }

    @RequestMapping(value = "/ViewServlet",method = RequestMethod.GET)
    public ModelAndView ViewServletAdmin(ModelAndView model)
    {

        List<Contact> contactListAdmin =  contactservice.viewData();

        model.addObject("contactList",contactListAdmin);
        model.setViewName("ViewContact");
        return model;
    }

    @GetMapping (value = "/UpdateContactSelected")
    public ModelAndView UpdateContactSelected(HttpServletRequest request,ModelAndView model)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        Contact contact=new Contact();
        contact=contactservice.getContactById(id);
        model.addObject("contact",contact);
        model.setViewName("UpdateContactSelected");
        return model;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Contact contact, ModelAndView model,HttpServletRequest request)
    {
       int id=Integer.parseInt(request.getParameter("id"));
        contactservice.delete(id);

        //Contact contact=new Contact();
       // contact=contactservice.getContactById(id);
            contactservice.saveContact(contact);
//        return new ModelAndView("redirect:/ViewContact");
        List<Contact> contactListUpdate=new ArrayList<Contact>();
        contactListUpdate=contactservice.viewData();
        model.addObject("contactList",contactListUpdate);
        model.setViewName("ViewContact");
        return model;
    }

    @GetMapping(value = "/DeleteContact")
    public void DeleteContact(HttpServletRequest request)
    {
        ModelAndView model=new ModelAndView();
    int id=Integer.parseInt(request.getParameter("id"));


    }
    @RequestMapping(value = "/DeleteContactServlet",method = RequestMethod.GET)
    public ModelAndView DeleteContactServlet(ModelAndView model,HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        contactservice.delete(id);
        List<Contact> contactListUpdate=new ArrayList<Contact>();
        contactListUpdate=contactservice.viewData();
        model.addObject("contactList",contactListUpdate);
        model.setViewName("ViewContact");
        return model;
    }

}
