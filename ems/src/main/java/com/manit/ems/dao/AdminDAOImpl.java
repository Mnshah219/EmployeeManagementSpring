package com.manit.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manit.ems.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Admin getAdminByEmail(String myEmail) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Admin> query = currentSession.createQuery("from Admin where email= :myEmail");
		query.setParameter("myEmail", myEmail);
		List<Admin> adminList = query.getResultList();
		if(adminList.size()==0) {
		return null;
	}
		else {
			return adminList.get(0);
		}
	}

}
