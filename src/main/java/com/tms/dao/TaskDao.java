package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tms.dto.Task;

public class TaskDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public Task saveTask(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();
		return task;
	}

	public Task updateTask(Task task) {
		entityTransaction.begin();
		entityManager.merge(task);
		entityTransaction.commit();
		return task;
	}

	public boolean deleteTask(Task task) {
		entityTransaction.begin();
		entityManager.remove(task);
		entityTransaction.commit();
		return true;
	}

	public Task findTaskById(int t_id) {
		return entityManager.find(Task.class,t_id);
	}

	public List<Task> fetchAllTask(){
		Query query=entityManager.createQuery("select t from Task");
		return query.getResultList();
	}



}
