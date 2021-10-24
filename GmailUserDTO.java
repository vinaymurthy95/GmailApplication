package com.vinay.gmail.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "gmail_user")
public class GmailUserDTO {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	private String email;
	private String userName;
	private String password;
	private String question;
	private String answer;

	@Override
	public boolean equals(Object obj) {
		GmailUserDTO gt = (GmailUserDTO) obj;
		return this.email.equals(gt.email) && this.userName.equals(gt.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, userName);
	}

}
