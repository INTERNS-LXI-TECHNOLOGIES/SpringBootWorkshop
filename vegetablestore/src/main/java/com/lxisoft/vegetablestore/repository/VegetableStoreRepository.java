package com.lxisoft.vegetablestore.repository;

import com.lxisoft.vegetablestore.vegetable.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableStoreRepository extends JpaRepository<Vegetable, Integer> {



}/*package com.lxisoft.vegetablestore.dao;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.lxisoft.vegetablestore.vegetable.Vegetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class VegetableDao {

	public VegetableDao() {
	}

	public List<Vegetable> readVegetable(){


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();


		List<Vegetable>vegetables = session.createQuery("from Vegetable").list();

		session.close();

		return vegetables;

	}


	public void addVegetable(Vegetable vegetable) throws IOException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
session.beginTransaction();


		session.save(vegetable);
		session.getTransaction().commit();

		session.close();

	}


	public List<Vegetable> selectData(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();


		List<Vegetable> vegetables = new ArrayList<>();

		Vegetable vegetable =session.get(Vegetable.class,id);

		session.getTransaction().commit();

		session.close();

		vegetables.add(vegetable);

		return vegetables;

	}
	public void updateVegetable(Vegetable vegetable) throws IOException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		 session.beginTransaction();


		session.update(vegetable);

		session.getTransaction().commit();


		session.close();

	}

	public void deleteVegetable(int id) {

	}


	public List<Vegetable> search(String word) {


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		List<Vegetable> vegetables= (List<Vegetable>) session.createQuery("from Vegetable where name like '%"+word+"%'").list();

session.close();
		return vegetables;
	}
}*/