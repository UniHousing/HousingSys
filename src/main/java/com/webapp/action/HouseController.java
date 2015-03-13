package com.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.common.config.Global;
import com.webapp.dao.Page;
import com.webapp.model.House;
import com.webapp.service.HouseService;


/**
 * houseController
 * @author ThinkGem
 * @version 2015-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/or/house")
public class HouseController {

	@Autowired
	private HouseService houseService;
	
	@ModelAttribute
	public House get(@RequestParam(required=false) String id) {
		System.out.println(id);
		if (StringUtils.isNotBlank(id)&&!id.equals("0")){
			return houseService.get(Integer.parseInt(id));
		}else{
			return new House();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(House house, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<House> page = houseService.find(new Page<House>(request, response), house); 
        model.addAttribute("page", page);
		return "modules/" + "or/houseList";
	}

	@RequestMapping(value = "form")
	public String form(House house, Model model) {
		model.addAttribute("house", house);
		return "modules/" + "or/houseForm";
	}

	@RequestMapping(value = "save")
	public String save(House house, Model model, RedirectAttributes redirectAttributes) {
		houseService.save(house);
		return "redirect:"+Global.getAdminPath()+"/or/house/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(House house, RedirectAttributes redirectAttributes) {
		houseService.delete(house);
		 
		return "redirect:"+Global.getAdminPath()+"/or/house/?repage";
	}

}
