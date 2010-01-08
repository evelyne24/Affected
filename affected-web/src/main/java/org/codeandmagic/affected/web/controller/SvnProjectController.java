package org.codeandmagic.affected.web.controller;

import org.codeandmagic.affected.service.api.SvnProjectService;
import org.codeandmagic.affected.service.api.UserService;
import org.codeandmagic.affected.svn.api.SvnException;
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
    private SvnProjectService svnProjectService;
    private UserService userService;
    private SvnProjectProcessor processor;

    @Required
    @Autowired
    public void setSvnProjectService(SvnProjectService svnProjectService) {
        this.svnProjectService = svnProjectService;
    }

    @Required
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
            m.addObject("proj", svnProjectService.get(request.getParameter("name")));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }

    @RequestMapping("/svnproject/create")
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/create");
        try {
            m.addObject("proj", svnProjectService.create(request.getParameter("name"), request.getParameter("url"), Long.parseLong(request.getParameter("lastCheckedVer"))));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }

    @RequestMapping("/svnproject/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/delete");
        try {
            svnProjectService.delete(request.getParameter("name"));
            m.addObject("result", "OK");
        } catch (SvnException e) {
            m.addObject("exc", e);
        }

        return m;
    }

    @RequestMapping("/svnproject/process")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView m = new ModelAndView("svnproject/process");
        try {
            m.addObject("result", processor.process(svnProjectService.get(request.getParameter("name")), userService.get(request.getParameter("username"))));
        } catch (SvnException e) {
            m.addObject("exc", e);
        }
        return m;
    }
}
