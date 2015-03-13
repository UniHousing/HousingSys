package com.webapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.webapp.model.User;
import com.webapp.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;

}
