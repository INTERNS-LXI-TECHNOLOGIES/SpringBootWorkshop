package com.lxisoft.controller;

import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.model.*;
import com.lxisoft.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


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
    private examServiceChem examservicechem;
    @Autowired
    private examServiceMedium examServiceMedium;
    @Autowired
    private examServiceChemMedium examServiceChemMedium;
    @Autowired
    private examServiceHard examServiceHard;
    @Autowired
    private examServiceChemHard examServiceChemHard;


    @RequestMapping(value = "/notice")
    public ModelAndView notice() {
        ModelAndView model = new ModelAndView();
        model.setViewName("notice");
        return model;
    }
    @RequestMapping(value = "/noticePython")
    public ModelAndView noticePython() {
        ModelAndView model = new ModelAndView();
        model.setViewName("noticePython");
        return model;
    }
@GetMapping("/")
public String root() {
    return "index";
}

    @GetMapping("/subjects")
    public String subject() {
        return "subjects";
    }
    @GetMapping("/subjectStudent")
    public String subjectStudent() {
        return "subjectStudent";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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
//Chemistry

    @RequestMapping(value = "/addChem",method = RequestMethod.GET)
    public String addChem(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        ExamChem theExam = new ExamChem();
        theModel.addAttribute("exam", theExam);
        return "addChem";
    }
    @RequestMapping(value = "/addChemMedium",method = RequestMethod.GET)
    public String addChemMedium(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        ExamChemMedium theExam = new ExamChemMedium();
        theModel.addAttribute("exam", theExam);
        return "addChemMedium";
    }
    @RequestMapping(value = "/addChemHard",method = RequestMethod.GET)
    public String addChemHard(Model theModel) {

        LOG.debug("inside show exam-form handler method");
        ExamChemHard theExam = new ExamChemHard();
        theModel.addAttribute("exam", theExam);
        return "addChemHard";
    }
    @RequestMapping(value = "/saveChemExam",method = RequestMethod.POST)
    public String saveChemExam(@ModelAttribute("exam") ExamChem theExam) {
        examservicechem.save(theExam);
        return "redirect:listChem";

    }
    @RequestMapping(value = "/saveChemExamMedium",method = RequestMethod.POST)
    public String saveChemExamMedium(@ModelAttribute("exam") ExamChemMedium examMedium) {
        examServiceChemMedium.saveMedium(examMedium);
        return "redirect:listChemMedium";

    }

    @RequestMapping(value = "/saveChemExamHard",method = RequestMethod.POST)
    public String saveChemExamHard(@ModelAttribute("exam") ExamChemHard examHard) {
        examServiceChemHard.saveHard(examHard);
        return "redirect:listChemHard";

    }
    @RequestMapping(value = "/listChem", method = RequestMethod.GET)
    public String listChemCustomers(Model theModel) {
        List < ExamChem > theExam = examservicechem.getExam();
        theModel.addAttribute("exam", theExam);
        return "listChem";
    }
    @RequestMapping(value = "/listChemMedium", method = RequestMethod.GET)
    public String listCustomersChemMedium(Model theModel) {
        List <ExamChemMedium> examMedium = examServiceChemMedium.getExamMedium();
        theModel.addAttribute("exam", examMedium);
        return "listChemMedium";
    }
    @RequestMapping(value = "/listChemHard", method = RequestMethod.GET)
    public String listCustomersChemHard(Model theModel) {
        List < ExamChemHard > examHard = examServiceChemHard.getExamHard();
        theModel.addAttribute("exam", examHard);
        return "listChemHard";
    }
    @RequestMapping(value = "/editChem/{id}", method = RequestMethod.GET)
    public String showFormForUpdateChem(@PathVariable("id") int theId,
                                    Model theModel) throws ResourceNotFoundException {
        ExamChem theExam = examservicechem.getExam(theId);
        theModel.addAttribute("exam", theExam);
        return "updateChem";
    }
    @RequestMapping(value = "/deleteChem/{id}", method = RequestMethod.GET)
    public String deleteExamChem(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examservicechem.deleteExam(theId);
        return "redirect:/listChem";
    }

    @RequestMapping(value = "/deleteChemMedium/{id}", method = RequestMethod.GET)
    public String deleteChemExamMedium(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examServiceChemMedium.deleteExamMedium(theId);
        return "redirect:/listChemMedium";
    }
    @RequestMapping(value = "/editChemMedium/{id}", method = RequestMethod.GET)
    public String showFormForUpdateChemMedium(@PathVariable("id") int theId,
                                          Model theModel) throws ResourceNotFoundException {
        ExamChemMedium medium = examServiceChemMedium.getExamMedium(theId);
        theModel.addAttribute("exam", medium);
        return "updateChemMedium";
    }

    @RequestMapping(value = "/editChemHard/{id}", method = RequestMethod.GET)
    public String showFormForUpdateChemHard(@PathVariable("id") int theId,
                                        Model theModel) throws ResourceNotFoundException {
        ExamChemHard theExam = examServiceChemHard.getExamHard(theId);
        theModel.addAttribute("exam", theExam);
        return "updateChemHard";
    }
    @RequestMapping(value = "/deleteChemHard/{id}", method = RequestMethod.GET)
    public String deleteExamChemHard(@PathVariable("id") int theId) throws ResourceNotFoundException {
        examServiceChemHard.deleteExamHard(theId);
        return "redirect:/listChemHard";
    }



    @RequestMapping(value = "/startChem", method = RequestMethod.GET)
    public String selectedOptionChem(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<ExamChem> listQuestions = (List<ExamChem>)sessions.getAttribute("exam");

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
        return "redirect:/examChem";

    }
    @RequestMapping(value = "/startChemMedium", method = RequestMethod.GET)
    public String selectedOptionMediumChem(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<ExamChemMedium> listQuestions = (List<ExamChemMedium>)sessions.getAttribute("exam");

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
        return "redirect:/examChemMedium";

    }

    @RequestMapping(value = "/startChemHard", method = RequestMethod.GET)
    public String selectedOptionHardChem(HttpServletRequest request, HttpServletResponse response, Model models) throws IOException
    {
        HttpSession sessions = request.getSession(true);
        int selectedOption =  Integer.parseInt(request.getParameter("opt"));
        @SuppressWarnings("unchecked")
        List<ExamChemHard> listQuestions = (List<ExamChemHard>)sessions.getAttribute("exam");

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
        return "redirect:/examChemHard";

    }


    @RequestMapping(value = "/resultChem", method = RequestMethod.GET)
    public ModelAndView resultExamChem(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<ExamChem> listQuestions = (List<ExamChem>)sessions.getAttribute("listQuestions");
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
        model.setViewName("resultChem");
        return model;
    }

    @RequestMapping(value = "/resultChemMedium", method = RequestMethod.GET)
    public ModelAndView resultExamMediumChem(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<ExamChemMedium> listQuestions = (List<ExamChemMedium>)sessions.getAttribute("listQuestions");
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
        model.setViewName("resultChemMedium");
        return model;
    }

    @RequestMapping(value = "/resultChemHard", method = RequestMethod.GET)
    public ModelAndView resultExamHardChem(HttpServletRequest request,Model theModel)
    {
        int resultCount = 0;
        HttpSession sessions = request.getSession(true);
        HttpSession session1 = request.getSession(true);
        List<Integer>select=new ArrayList<Integer>();
        @SuppressWarnings("unchecked")
        List<ExamChemHard> listQuestions = (List<ExamChemHard>)sessions.getAttribute("listQuestions");
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
        model.setViewName("resultChemHard");
        return model;
    }

    @RequestMapping(value = "/examChem", method = RequestMethod.GET)
    public String startExamChem(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<ExamChem> listExam =  examservicechem.getExam();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "examChem";
        }
        else
        {  count=0;
            return "redirect:/resultChem";
        }
    }
    @RequestMapping(value = "/examChemMedium", method = RequestMethod.GET)
    public String startExamMediumChem(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<ExamChemMedium> listExam =  examServiceChemMedium.getExamMedium();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "examChemMedium";
        }
        else
        {  count=0;
            return "redirect:/resultChemMedium";
        }
    }

    @RequestMapping(value = "/examChemHard", method = RequestMethod.GET)
    public String startExamHardChem(Model theModel,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<ExamChemHard> listExam =  examServiceChemHard.getExamHard();
        session.setAttribute("exam", listExam);
        if(count<listExam.size())
        {
            theModel.addAttribute("exam",listExam.get(count));
            return "examChemHard";
        }
        else
        {  count=0;
            return "redirect:/resultChemHard";
        }
    }
    @RequestMapping(value = "/showFormChem", method = RequestMethod.GET)
    public String showFormForAddChem(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        ExamChem theExam = new ExamChem();
        theModel.addAttribute("exam", theExam);
        return "redirect:/listChem";
    }
    @RequestMapping(value = "/showFormChemMedium", method = RequestMethod.GET)
    public String showFormForAddMediumChem(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        ExamChemMedium theExam = new ExamChemMedium();
        theModel.addAttribute("exam", theExam);
        return "redirect:/listChemMedium";
    }
    @RequestMapping(value = "/showFormChemHard", method = RequestMethod.GET)
    public String showFormForAddHardChem(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        ExamChemHard theExam = new ExamChemHard();
        theModel.addAttribute("exam", theExam);
        return "redirect:/listChemHard";
    }

}
