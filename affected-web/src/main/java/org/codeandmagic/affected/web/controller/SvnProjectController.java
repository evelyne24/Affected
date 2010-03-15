/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
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
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/view");
		try {
			m.addObject("proj", svnProjectService.get(request.getParameter("name")));
		}
		catch (SvnException e) {
			m.addObject("exc", e);
		}
		return m;
	}

	@RequestMapping("/svnproject/create")
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/create");
		try {
			m.addObject("proj", svnProjectService.create(request.getParameter("name"), request
					.getParameter("url"), Long.parseLong(request.getParameter("lastCheckedVer"))));
		}
		catch (SvnException e) {
			m.addObject("exc", e);
		}
		return m;
	}

	@RequestMapping("/svnproject/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/delete");
		try {
			svnProjectService.delete(request.getParameter("name"));
			m.addObject("result", "OK");
		}
		catch (SvnException e) {
			m.addObject("exc", e);
		}

		return m;
	}

	@RequestMapping("/svnproject/process")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		ModelAndView m = new ModelAndView("svnproject/process");
		try {
			m.addObject("result", processor.process(svnProjectService.get(request
					.getParameter("name"))));
		}
		catch (SvnException e) {
			m.addObject("exc", e);
		}
		return m;
	}
}
