package org.codeandmagic.affected.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codeandmagic.affected.service.SvnProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private SvnProjectService svnProjectService;

	@Required
	@Autowired
	public void setSvnProjectService(SvnProjectService svnProjectService) {
		this.svnProjectService = svnProjectService;
	}

	@RequestMapping("/index-simple")
	public ModelAndView indexSimple(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView("index-simple");
		mv.addObject("projects", this.svnProjectService.getAll());
		return mv;
	}
}
