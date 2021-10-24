package com.vinay.gmail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vinay.gmail.dao.GmailDAO;
import com.vinay.gmail.model.GmailUserDTO;
import com.vinay.gmail.model.MailDTO;

@Component
public class GmailServiceImp implements GmailService {

	@Autowired
	private GmailDAO gdao;

	@Override
	public void SignUpGmail(GmailUserDTO gdto) {
		gdao.SignUpGmail(gdto);

	}

	@Override
	public GmailUserDTO loginGmail(String email, String password) {
		return gdao.loginGmail(email, password);
	}

	@Override
	public void SaveMail(MailDTO mdto) {
		gdao.SaveMail(mdto);
	}

	@Override
	public List<MailDTO> inbox(String email) {
		return gdao.inbox(email);
	}

	@Override
	public List<MailDTO> sent(String email) {
		return gdao.sent(email);
	}

	@Override
	public List<GmailUserDTO> find(GmailUserDTO gdto) {
		return gdao.find(gdto);
	}

	@Override
	public GmailUserDTO forgotpassword(String email, String question, String answer) {
		return gdao.forgotpassword(email, question, answer);
	}

	@Override
	public int changePassword(String email, String password) {
		return gdao.changePassword(email, password);
	}

	@Override
	public List<GmailUserDTO> findbyEmailid(MailDTO mdto) {
		return gdao.findbyEmailid(mdto);
	}

	@Override
	public List<MailDTO> draft(String email) {
		return gdao.draft(email);
	}

	@Override
	public void delete(int id) {
		gdao.delete(id);

	}

}
