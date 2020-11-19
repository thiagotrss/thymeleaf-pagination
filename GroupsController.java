package br.com.rss.generico.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rss.generico.dto.busca.FindGroupsDTO;
import br.com.rss.generico.pojo.Group;
import br.com.rss.generico.service.GroupService;

/**
 * 
 * @author Thiago Rodrigues
 * @since 27 de fev de 2020
 *
 */
@Controller
@RequestMapping("/groups")
public class GroupsController {

	private static final String GROUP = "group";
	
	@Autowired
	private GroupService groupService;
	
	@GetMapping("/find")
	public ModelAndView find(@ModelAttribute("searchData") FindGroupsDTO searchData) {
		Page<Group> groups = groupService.findByExample(searchData);
		
		ModelAndView mav = new ModelAndView(GROUP + "/find");
		mav.addObject("pagination", groups);
		return mav;
	}
}
