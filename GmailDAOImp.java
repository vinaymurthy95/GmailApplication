package com.vinay.gmail.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vinay.gmail.model.GmailUserDTO;
import com.vinay.gmail.model.MailDTO;

@Component
public class GmailDAOImp implements GmailDAO {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public GmailUserDTO loginGmail(String email, String password) {
		System.out.println("dao perform login validation  with database");
		try {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from GmailUserDTO where email=?0 and password=?1");
			query.setParameter(0, email);
			query.setParameter(1, password);
			return (GmailUserDTO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void SignUpGmail(GmailUserDTO gdto) {
		System.out.println("gmail Data received  by dao and persists it to the database");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(gdto);
		transaction.commit();
		manager.close();

	}

	@Override
	public void SaveMail(MailDTO mdto) {
		System.out.println("Mail received  by dao and persists it to the database");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(mdto);
		transaction.commit();
		manager.close();
	}

	@Override
	public List<MailDTO> inbox(String email) {
		List<MailDTO> lismdto = null;
		Query query = null;
		EntityManager manager = factory.createEntityManager();
		query = manager.createQuery("from MailDTO where toemail=?0");
		query.setParameter(0, email);
		lismdto = query.getResultList();
		manager.close();
		return lismdto;
	}

	@Override
	public List<MailDTO> sent(String email) {
		List<MailDTO> lismdto = null;
		Query query = null;
		EntityManager manager = factory.createEntityManager();
		query = manager.createQuery("from MailDTO where fromemail=?0");
		query.setParameter(0, email);
		lismdto = query.getResultList();
		manager.close();
		return lismdto;
	}

	@Override
	public List<GmailUserDTO> find(GmailUserDTO gdto) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("from GmailUserDTO");
			transaction.commit();
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GmailUserDTO forgotpassword(String email, String question, String answer) {
		System.out.println("dao perform login validation  with database");
		try {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from GmailUserDTO where email=?0 and question=?1 and answer=?2");
			query.setParameter(0, email);
			query.setParameter(1, question);
			query.setParameter(2, answer);
			return (GmailUserDTO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public int changePassword(String email, String password) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("update GmailUserDTO set password=?0 where email=?1");
			query.setParameter(0, password);
			query.setParameter(1, email);
			int row = query.executeUpdate();
			transaction.commit();
			return row;
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public List<GmailUserDTO> findbyEmailid(MailDTO mdto) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("from GmailUserDTO where email=?0");
			query.setParameter(0, mdto.getToemail());
			transaction.commit();
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MailDTO> draft(String email) {
		List<MailDTO> lismdto = null;
		Query query = null;
		EntityManager manager = factory.createEntityManager();
		query = manager.createQuery("from MailDTO where draft=?0");
		query.setParameter(0, "yes");
		lismdto = query.getResultList();
		manager.close();
		return lismdto;
	}

	@Override
	public void delete(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		MailDTO mdto = manager.find(MailDTO.class, id);
		manager.remove(mdto);
		transaction.commit();
		manager.close();

	}

}
