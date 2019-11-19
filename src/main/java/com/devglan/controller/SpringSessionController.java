package com.devglan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSessionController {


	/*
	 * @GetMapping("/") public String process(HttpSession session) {
	 * 
	 * @SuppressWarnings("unchecked") List<String> messages = (List<String>)
	 * session.getAttribute("MY_SESSION_MESSAGES");
	 * 
	 * if (messages == null) { messages = new ArrayList<>(); }
	 * model.addAttribute("sessionMessages", messages);
	 * 
	 * return "index"; }
	 */

	@PostMapping("/persistMessage")
	public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		}
		messages.add(msg);
		request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
		return "persisted";
	}

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}