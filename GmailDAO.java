package com.vinay.gmail.dao;

import java.util.List;

import com.vinay.gmail.model.GmailUserDTO;
import com.vinay.gmail.model.MailDTO;

public interface GmailDAO {

	void SignUpGmail(GmailUserDTO gdto);

	GmailUserDTO loginGmail(String email, String password);

	void SaveMail(MailDTO mdto);

	List<MailDTO> inbox(String email);

	List<MailDTO> sent(String email);

	List<GmailUserDTO> find(GmailUserDTO gdto);

	GmailUserDTO forgotpassword(String email, String question, String answer);

	int changePassword(String email, String password);

	List<GmailUserDTO> findbyEmailid(MailDTO mdto);

	List<MailDTO> draft(String email);

	void delete(int id);

}
