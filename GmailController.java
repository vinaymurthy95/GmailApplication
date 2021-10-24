package com.vinay.gmail.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vinay.gmail.model.GmailUserDTO;
import com.vinay.gmail.model.MailDTO;
import com.vinay.gmail.service.GmailService;

@Controller
public class GmailController {

	@Autowired
	private GmailService service;

	@RequestMapping("/link1")
	public String getView1() {
		return "login";
	}

	@RequestMapping("/link2")
	public String getView2() {
		return "signup";
	}

	@PostMapping("/logingmail")
	public ModelAndView loginGmailApplication(HttpServletRequest request, @RequestParam String email,
			@RequestParam String password) {
		System.out.println("Data received by controller and passed it to the service ");
		GmailUserDTO gdto = service.loginGmail(email, password);
		// System.out.println(gdto.getEmail());
		if (gdto != null) {
			HttpSession ss = request.getSession(true);
			ss.setAttribute("usr", email);
			System.out.println("Welcomee to setting servlets Mr/Mrs :)" + ss.getAttribute("usr"));
			return new ModelAndView("loginsuccess", "gdto", gdto);
		} else {
			return new ModelAndView("login", "msg", "login failed pls try again");
		}
	}

	@PostMapping("/signup")
	public String register(@ModelAttribute GmailUserDTO gdto) {
		List<GmailUserDTO> gdtos = service.find(gdto);
		if (gdtos.contains(gdto)) {
			return "duplicate";
		} else {
			service.SignUpGmail(gdto);
			return "signupsuccess";
		}
	}

	@RequestMapping("/compose")
	public String compose() {
		return "compose";
	}

	@PostMapping("/mailcompose")
	public String mailcompose(@ModelAttribute MailDTO mdto) {
		List<GmailUserDTO> gdtos = service.findbyEmailid(mdto);
		System.out.println(gdtos + " gdtos");
		if (gdtos != null && !gdtos.isEmpty()) {
			service.SaveMail(mdto);
			return "mailsentsuccess";
		} else {
			mdto.setDraft("yes");
			service.SaveMail(mdto);
			return "saveddraft";
		}
	}

	@RequestMapping("/inbox")
	public String inboxreturn() {
		return "inbox";
	}

	@GetMapping("inbox")
	public ModelAndView inbox(HttpServletRequest request) {
		HttpSession ss = request.getSession(false);
		String email = (String) ss.getAttribute("usr");
		List<MailDTO> lismdto = service.inbox(email);
		if (lismdto != null && !lismdto.isEmpty()) {
			return new ModelAndView("inbox", "lismdto", lismdto);
		} else {
			return new ModelAndView("searchfail");
		}

	}

	@GetMapping("sent")
	public ModelAndView Sent(HttpServletRequest request) {
		HttpSession ss = request.getSession(false);
		String email = (String) ss.getAttribute("usr");
		List<MailDTO> lismdto = service.sent(email);
		if (lismdto != null && !lismdto.isEmpty()) {
			return new ModelAndView("sent", "lismdto", lismdto);
		} else {
			return new ModelAndView("searchfail");
		}
	}

	@RequestMapping("/forgot")
	public String forgot() {
		return "forgotpage";
	}

	@PostMapping("/forgotpassword")
	public ModelAndView SearchInDatabase(@RequestParam String email, @RequestParam String question,
			@RequestParam String answer) {
		System.out.println("data recieved by controller and pass it to the service");
		GmailUserDTO gdto = service.forgotpassword(email, question, answer);
		if (gdto != null) {
			return new ModelAndView("passwordchange");
		} else {
			return new ModelAndView("forgotpage", "msg", "Sorry .. Invalid Credentials");
		}

	}

	@GetMapping("draft")
	public ModelAndView drafts(HttpServletRequest request) {
		HttpSession ss = request.getSession(false);
		String email = (String) ss.getAttribute("usr");
		List<MailDTO> lismdto = service.draft(email);
		if (lismdto != null && !lismdto.isEmpty()) {
			return new ModelAndView("draft", "lismdto", lismdto);
		} else {
			return new ModelAndView("draftfail");
		}

	}

	@GetMapping("delete")
	public String delete(@RequestParam int id) {
		service.delete(id);
		return "redirect:/inbox";
	}
	
	

	@GetMapping("/logout")
	public String logoutGmailApplication(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/";
	}

	@PostMapping("/update")
	public String updatePassword(@RequestParam String email, @RequestParam String password) {
		int row = service.changePassword(email, password);
		if (row == 1) {
			return "successupdate";
		} else {
			return "failupdate";

		}
	}

}
