package user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import user.dto.User;

public class UserDao {

	public void saveuser(User user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vinod");
		EntityManager em =emf.createEntityManager();
		EntityTransaction tran=em.getTransaction();

		tran.begin();
		em.persist(user);
		tran.commit();	
	}

	public void update(int id,User usr) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vinod");
		EntityManager  em=emf.createEntityManager();

		User db= em.find(User.class, id);

		if(db!=null) {
			EntityTransaction  tran =em.getTransaction();
			tran.begin();
			usr.setId(id);
			em.merge(db);
			tran.commit();
		}

		else {
			System.out.println("Id not Found");
		}
	}
	public void findall() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vinod");
		EntityManager em=emf.createEntityManager();

		Query  qr=em.createQuery("Select u from User u ");
		
		List<User> ls=qr.getResultList();
		System.out.println(ls);

	}
	public void finduser (int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vinod");
		EntityManager em=emf.createEntityManager();

		User dbusr=em.find(User.class, id);
		if(dbusr!=null) {
			System.out.println(dbusr);
		}
		else {
			System.out.println("Id not Found");
		}

	}
	public void deleteuser(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vinod");
		EntityManager em=emf.createEntityManager();

		User dbusr=em.find(User.class, id);

		if(dbusr!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(dbusr);
			et.commit();
		}
		else {
			System.out.println("id is not present to delete");
		}

	}


}



