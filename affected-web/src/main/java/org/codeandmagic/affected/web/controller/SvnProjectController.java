package org.codeandmagic.affected.web.controller;

import org.codeandmagic.affected.service.api.SvnProjectService;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.svn.api.SvnProjectProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
public class SvnProjectController {
    private SvnProjectService service;
    private SvnProjectProcessor processor;

    @Required
    @Autowired
    public void setService(SvnProjectService service) {
        this.service = service;
    }

    @Required
    @Autowired
    public void setProjectProcessor(SvnProjectProcessor processor) {
        this.processor = processor;
    }

    @RequestMapping("/svnproject/view")
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/view");
        try {
            m.addObject("proj", service.get(request.getParameter("url")));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }

    @RequestMapping("/svnproject/create")
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/create");
        try {
            m.addObject("proj", service.create(request.getParameter("url"), Long.parseLong(request.getParameter("localver")),
                    request.getParameter("username"), request.getParameter("pass")));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }

    @RequestMapping("/svnproject/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/delete");
        service.delete(request.getParameter("url"));
        m.addObject("OK");
        return m;
    }

    @RequestMapping("/svnproject/process")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/process");
        try {
            SvnProject proj = service.get(request.getParameter("url"));
            m.addObject("resultMap", processor.process(proj));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }
}
