package org.codeandmagic.affected.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codeandmagic.affected.service.SvnProjectService;
import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnProjectProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
public class SvnProjectController {
	private SvnProjectService svnProjectService;
	private SvnProjectProcessor processor;

	@Required
	@Autowired
	public void setSvnProjectService(SvnProjectService svnProjectService) {
		this.svnProjectService = svnProjectService;
	}

	@Required
	@Autowired
	public void setProjectProcessor(SvnProjectProcessor processor) {
		this.processor = processor;
	}

	@RequestMapping("/svnproject/view")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/view");
		m.addObject("proj", svnProjectService.get(Integer.parseInt(request
				.getParameter("id"))));
		return m;
	}

	@RequestMapping("/svnproject/create")
	public ModelAndView create(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/create");
		m.addObject("proj", svnProjectService.create(request
				.getParameter("name"), request.getParameter("url"), Long
				.parseLong(request.getParameter("lastCheckedVer"))));
		return m;
	}

	@RequestMapping("/svnproject/delete")
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/delete");
		svnProjectService.delete(Integer.parseInt(request.getParameter("id")));
		m.addObject("result", "OK");
		return m;
	}

	@RequestMapping("/svnproject/process")
	public ModelAndView process(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/process");
		try {
			m.addObject("result", processor.process(svnProjectService
					.get(Integer.parseInt(request.getParameter("id")))));
		} catch (SvnException e) {
			m.addObject("exc", e);
		}
		return m;
	}
}
