package org.codeandmagic.affected.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codeandmagic.affected.service.ComponentService;
import org.codeandmagic.affected.service.SvnProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComponentController {
	private ComponentService componentService;
	private SvnProjectService projectService;

	/**
	 * @param componentService
	 *            the componentService to set
	 */
	@Autowired
	@Required
	public void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}

	@Autowired
	@Required
	public void setProjectService(SvnProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping("/component/view")
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelAndView m = new ModelAndView("component/view");
		m.addObject("comp", componentService.get(Integer.parseInt(request
				.getParameter("id"))));
		return m;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/component/create")
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView m = new ModelAndView("component/create");
		m.addObject("projects", projectService.getAll());
		m.addObject("components", componentService.getAll());
		return m;
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/component/create")
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestParam(required = true, value = "prettyName") String prettyName,
			@RequestParam(required = true, value = "tag") String tag,
			@RequestParam(required = true, value = "projectId") Integer projectId,
			@RequestParam(required = false, value = "parentId") Integer parentId) {

		ModelAndView m = this.create(request, response, session);
		m.addObject("comp", componentService.create(prettyName, tag, projectId, parentId));
		return m;
	}

}
