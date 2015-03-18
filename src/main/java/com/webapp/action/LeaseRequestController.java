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
import com.webapp.model.LeaseRequest;
import com.webapp.service.LeaseRequestService;
import com.webapp.service.LeaseService;


/**
 * leaseRequestController
 * @author ThinkGem
 * @version 2015-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/or/leaseRequest")
public class LeaseRequestController {

	@Autowired
	private LeaseRequestService leaseRequestService;
	@Autowired
	private LeaseService leaseService;
	
	
	@ModelAttribute
	public LeaseRequest get(@RequestParam(required=false) String id) {
		System.out.println(id);
		if (StringUtils.isNotBlank(id)&&!id.equals("0")){
			return leaseRequestService.get(Integer.parseInt(id));
		}else{
			return new LeaseRequest();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(LeaseRequest leaseRequest, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<LeaseRequest> page = leaseRequestService.find(new Page<LeaseRequest>(request, response), leaseRequest); 
        model.addAttribute("page", page);
		return "modules/" + "or/leaseRequestList";
	}

	@RequestMapping(value = "form")
	public String form(LeaseRequest leaseRequest, Model model) {
		model.addAttribute("leaseRequest", leaseRequest);
		return "modules/" + "or/leaseRequestForm";
	}

	@RequestMapping(value = "save")
	public String save(LeaseRequest leaseRequest, Model model, RedirectAttributes redirectAttributes) {
		leaseRequest.setStatus("Pending");
		leaseRequestService.save(leaseRequest);
		return "redirect:"+Global.getAdminPath()+"/or/leaseRequest/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(LeaseRequest leaseRequest, RedirectAttributes redirectAttributes) {
		leaseRequestService.delete(leaseRequest);
		 
		return "redirect:"+Global.getAdminPath()+"/or/leaseRequest/?repage";
	}
	@RequestMapping(value ="approve")
	public String approve(LeaseRequest leaseRequest,RedirectAttributes redirectAttributes){
		leaseRequest.setStatus("Approved");
		leaseRequestService.save(leaseRequest);
		leaseService.save(leaseRequest);
		return "redirect:"+Global.getAdminPath()+"/or/leaseRequest/?repage";
	}
}
