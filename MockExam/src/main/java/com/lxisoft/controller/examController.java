package com.lxisoft.controller;

import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.model.Exam;
import com.lxisoft.model.ExamHard;
import com.lxisoft.model.ExamMedium;
import com.lxisoft.service.examService;
import com.lxisoft.service.examServiceHard;
import com.lxisoft.service.examServiceMedium;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class examController {
    private static final Logger LOG = LoggerFactory.getLogger(examController.class);
    int count=0;

    @Autowired
    private examService examservice;
    @Autowired
    private examServiceMedium examServiceMedium;
    @Autowired
    private examServiceHard examServiceHard;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView index()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
    @RequestMapping(value = "/notice")
    public ModelAndView notice() {
        ModelAndView model = new ModelAndView();
        model.setViewName("notice");
        return model;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        Exam theExam = new Exam();
        theModel.addAttribute("exam", theExam);
        return "add";
    }
    @RequestMapping(value = "/addMedium",method = RequestMethod.GET)
    public String addMedium(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        ExamMedium theExam = new ExamMedium();
        theModel.addAttribute("exam", theExam);
        return "addMedium";
    }
    @RequestMapping(value = "/addHard",method = RequestMethod.GET)
    public String addHard(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        ExamHard theExam = new ExamHard();
        theModel.addAttribute("exam", theExam);
        return "addHard";
    }
    @RequestMapping(value = "/saveExam",method = RequestMethod.POST)
    public String saveExam(@ModelAttribute("exam") Exam theExam) {
        examservice.save(theExam);
        return "redirect:list";

    }
    @RequestMapping(value = "/saveExamMedium",method = RequestMethod.POST)
    public String saveExamMedium(@ModelAttribute("exam") ExamMedium examMedium) {
        examServiceMedium.saveMedium(examMedium);
        return "redirect:listMedium";

    }

    @RequestMapping(value = "/saveExamHard",method = RequestMethod.POST)
    public String saveExamHard(@ModelAttribute("exam") ExamHard examHard) {
        examServiceHard.saveHard(examHard);
        return "redirect:listHard";

    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model theModel) {
        List < Exam > theExam = examservice.getExam();
        theModel.addAttribute("exam", theExam);
        return "list";
    }
    @RequestMapping(value = "/listMedium", method = RequestMethod.GET)
    public String listCustomersMedium(Model theModel) {
        List <ExamMedium> examMedium = examServiceMedium.getExamMedium();
        theModel.addAttribute("exam", examMedium);
        return "listMedium";
    }
    @RequestMapping(value = "/listHard", method = RequestMethod.GET)
    public String listCustomersHard(Model theModel) {
        List < ExamHard > examHard = examServiceHard.getExamHard();
        theModel.addAttribute("exam", examHard);
        return "listHard";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showFormForUpdate(@PathVariable("id") int theId,
                                    Model theModel) throws ResourceNotFoundException {
        Exam theExam = examservice.getExam(theId);
        theModel.addAttribute("exam", theExam);
        return "update";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExam(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examservice.deleteExam(theId);
        return "redirect:/list";
    }

    @RequestMapping(value = "/deleteMedium/{id}", method = RequestMethod.GET)
    public String deleteExamMedium(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examServiceMedium.deleteExamMedium(theId);
        return "redirect:/listMedium";
    }
    @RequestMapping(value = "/editMedium/{id}", method = RequestMethod.GET)
    public String showFormForUpdateMedium(@PathVariable("id") int theId,
                                    Model theModel) throws ResourceNotFoundException {
        ExamMedium medium = examServiceMedium.getExamMedium(theId);
        theModel.addAttribute("exam", medium);
        return "updateMedium";
    }

    @RequestMapping(value = "/editHard/{id}", method = RequestMethod.GET)
    public String showFormForUpdateHard(@PathVariable("id") int theId,
                                    Model theModel) throws ResourceNotFoundException {
        ExamHard theExam = examServiceHard.getExamHard(theId);
        theModel.addAttribute("exam", theExam);
        return "updateHard";
    }
    @RequestMapping(value = "/deleteHard/{id}", method = RequestMethod.GET)
    public String deleteExamHard(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examServiceHard.deleteExamHard(theId);
        return "redirect:/listHard";
    }



    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String selectedOption(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<Exam> listQuestions = (List<Exam>)sessions.getAttribute("exam");

        if(selectedOption == 1)
        {
            listQuestions.get(count).setSelectedOption(1);
        }
        else if(selectedOption == 2)
        {
            listQuestions.get(count).setSelectedOption(2);
        }
        else if(selectedOption == 3)
        {
            listQuestions.get(count).setSelectedOption(3);
        }
        else if(selectedOption == 4)
        {
            listQuestions.get(count).setSelectedOption(4);
        }
        sessions.setAttribute("listQuestions", listQuestions);
        count++;
        return "redirect:/exam";

    }
    @RequestMapping(value = "/startMedium", method = RequestMethod.GET)
    public String selectedOptionMedium(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<ExamMedium> listQuestions = (List<ExamMedium>)sessions.getAttribute("exam");

        if(selectedOption == 1)
        {
            listQuestions.get(count).setSelectedOptionm(1);
        }
        else if(selectedOption == 2)
        {
            listQuestions.get(count).setSelectedOptionm(2);
        }
        else if(selectedOption == 3)
        {
            listQuestions.get(count).setSelectedOptionm(3);
        }
        else if(selectedOption == 4)
        {
            listQuestions.get(count).setSelectedOptionm(4);
        }
        sessions.setAttribute("listQuestions", listQuestions);
        count++;
        return "redirect:/examMedium";

    }

    @RequestMapping(value = "/startHard", method = RequestMethod.GET)
    public String selectedOptionHard(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<ExamHard> listQuestions = (List<ExamHard>)sessions.getAttribute("exam");

        if(selectedOption == 1)
        {
            listQuestions.get(count).setSelectedOptionh(1);
        }
        else if(selectedOption == 2)
        {
            listQuestions.get(count).setSelectedOptionh(2);
        }
        else if(selectedOption == 3)
        {
            listQuestions.get(count).setSelectedOptionh(3);
        }
        else if(selectedOption == 4)
        {
            listQuestions.get(count).setSelectedOptionh(4);
        }
        sessions.setAttribute("listQuestions", listQuestions);
        count++;
        return "redirect:/examHard";

    }


    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView resultExam(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<Exam> listQuestions = (List<Exam>)sessions.getAttribute("listQuestions");
        for(int i =0;i<listQuestions.size();i++)
        {
            select.add(listQuestions.get(i).getSelectedOption());
            if(listQuestions.get(i).getAns()==(listQuestions.get(i).getSelectedOption()))
            {
                resultCount++;
            }
        }
        session1.setAttribute("select", select);
        ModelAndView model = new ModelAndView();
        model.addObject("result",resultCount);
        model.addObject("listQuestions",listQuestions);
        model.setViewName("result");
        return model;
    }

    @RequestMapping(value = "/resultMedium", method = RequestMethod.GET)
    public ModelAndView resultExamMedium(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<ExamMedium> listQuestions = (List<ExamMedium>)sessions.getAttribute("listQuestions");
        for(int i =0;i<listQuestions.size();i++)
        {
            select.add(listQuestions.get(i).getSelectedOptionm());
            if(listQuestions.get(i).getAnsm()==(listQuestions.get(i).getSelectedOptionm()))
            {
                resultCount++;
            }
        }
        session1.setAttribute("select", select);
        ModelAndView model = new ModelAndView();
        model.addObject("result",resultCount);
        model.addObject("listQuestions",listQuestions);
        model.setViewName("resultMedium");
        return model;
    }

    @RequestMapping(value = "/resultHard", method = RequestMethod.GET)
    public ModelAndView resultExamHard(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<ExamHard> listQuestions = (List<ExamHard>)sessions.getAttribute("listQuestions");
        for(int i =0;i<listQuestions.size();i++)
        {
            select.add(listQuestions.get(i).getSelectedOptionh());
            if(listQuestions.get(i).getAnsh()==(listQuestions.get(i).getSelectedOptionh()))
            {
                resultCount++;
            }
        }
        session1.setAttribute("select", select);
        ModelAndView model = new ModelAndView();
        model.addObject("result",resultCount);
        model.addObject("listQuestions",listQuestions);
        model.setViewName("resultHard");
        return model;
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public String startExam(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Exam> listExam =  examservice.getExam();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "exam";
        }
        else
        {  count=0;
            return "redirect:/result";
        }
    }
    @RequestMapping(value = "/examMedium", method = RequestMethod.GET)
    public String startExamMedium(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<ExamMedium> listExam =  examServiceMedium.getExamMedium();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "examMedium";
        }
        else
        {  count=0;
            return "redirect:/resultMedium";
        }
    }

    @RequestMapping(value = "/examHard", method = RequestMethod.GET)
    public String startExamHard(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<ExamHard> listExam =  examServiceHard.getExamHard();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "examHard";
        }
        else
        {  count=0;
            return "redirect:/resultHard";
        }
    }
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Exam theExam = new Exam();
        theModel.addAttribute("exam", theExam);
        return "redirect:/list";
    }
    @RequestMapping(value = "/showFormMedium", method = RequestMethod.GET)
    public String showFormForAddMedium(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        ExamMedium theExam = new ExamMedium();
        theModel.addAttribute("exam", theExam);
        return "redirect:/listMedium";
    }
    @RequestMapping(value = "/showFormHard", method = RequestMethod.GET)
    public String showFormForAddHard(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        ExamHard theExam = new ExamHard();
        theModel.addAttribute("exam", theExam);
        return "redirect:/listHard";
    }
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String checkPage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(hasRole)
        {
            return "redirect:/list";
        }
        else
        {
            return "redirect:/notice";
        }
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "no");
        }

        if (logout != null) {
            model.addObject("message", "no");
        }

        model.setViewName("index");
        return model;
    }
//    @RequestMapping(value="/logout", method = RequestMethod.POST)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/index.html";
//    }

}
