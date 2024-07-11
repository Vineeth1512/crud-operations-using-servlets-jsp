package com.example.dao;

import java.util.List;

import com.example.dto.Developer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DeveloperDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vineeth");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Developer saveDeveloper(Developer developer) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		if (developer != null) {
			entityTransaction.begin();
			entityManager.persist(developer);
			entityTransaction.commit();
		}

		return developer;
	}

	public Developer updateDeveloper(Developer developer) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Developer findDev = entityManager.find(Developer.class, developer.getDeveloperId());
		if (findDev != null) {
			entityTransaction.begin();
			entityManager.merge(developer);// must use developer object
			entityTransaction.commit();
		}
		return findDev;
	}

	public Developer getDeveloperById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Developer editDev = entityManager.find(Developer.class, id);
		return editDev;
	}

//	public List<Developer> getAllDevelopers() {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Query query = entityManager.createQuery("select a from developer a");
//
//		return query.getResultList();
//	}

	public Developer getDeleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Developer dev = entityManager.find(Developer.class, id);
		if (dev != null) {
			entityTransaction.begin();
			entityManager.remove(dev);
			entityTransaction.commit();
		}

		return dev;

	}
}
