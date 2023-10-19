package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tms.dto.User;

public class UserDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager = emf.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User findUserbyId(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public User findUserByEmailAndPassword(String email,String password) {
		Query q= entityManager.createQuery("select u from user1 where email=?1,password=?2");
//		q.setParameter(1, email);
//		q.setParameter(2, password);
	List<User> user	=q.getResultList();
	for (User user2 : user) {
		if(user2.getEmail()==email&&user2.getPassword()==password) {
			return user2;
		}
	}
	return null;
	}
	
	public void fecthAllUser() {
		Query q= entityManager.createQuery("select u from User1 u");
		List<User>  user = q.getResultList();
		for (User user2 : user) {
			System.out.println("user id-->"+user2.getUser_id());
			System.out.println("user name-->"+user2.getName());
			System.out.println("user email-->"+user2.getEmail());
			System.out.println("user role--->"+user2.getRole());
			System.out.println("==============================");
		}

	}
	public User updateUser(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
		
	}
	public boolean deleteUser(int id) {
	User user	=findUserbyId(id);
	entityTransaction.begin();
	entityManager.remove(user);
	entityTransaction.commit();
	return true;
	}

}