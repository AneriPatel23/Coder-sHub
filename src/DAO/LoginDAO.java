package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.DeveloperVO;
import VO.LoginVO;


public class LoginDAO {
	
	
	public List searchRegisteredUserDetails(LoginVO  loginVO) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from LoginVO where userId='"+loginVO.getUserId()+"'");

			ls = q.list();
			
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return ls;
	}
	
	public List searchByEmail(String to) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from LoginVO loginVO where email='"+to+"'");

			ls = q.list();
			System.out.println(ls.size());
			System.out.println("Done");
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ls;
		
	}

	public Boolean isRightEmail(LoginVO loginVO){

		System.out.println("Searching in DAO..");
		List list = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Query query = session.createQuery("from LoginVO as r where r.email='"+loginVO.getEmail()+"'");
		list =  query.list();
		System.out.println("isRightMail list size :: "+list.size());
		tr.commit();

		System.out.println("HQL :- "+query);
		System.out.println("Searching in DAO Completed!");

		if(list.size()==0){
			System.out.println("returning false!");
			return false;
		}
		else {
			System.out.println("returning true!");
			return true;
		}
	}
	public void insertUserPassword(LoginVO loginVO)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(loginVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	public List searchUser()
	{
		List ls=null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO");

			ls = q.list();
	
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
		return ls;
	}
	public List searchRegisteredUser()
	{
		List ls=null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO where usertype='registereedUser'");

			ls = q.list();
	
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
		return ls;
	}

	public List searchDeveloper()
	{
		List ls=null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO where usertype='developer'");

			ls = q.list();
	
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
		return ls;
	}

	public List searchCompany()
	{
		List ls=null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query q = session.createQuery("from LoginVO where usertype='company'");

			ls = q.list();
	
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
		return ls;
	}

	
	public void Insert(LoginVO vo) {
		// TODO Auto-generated method stub

		try {
			// This step will read hibernate.cfg.xml

			// and prepare hibernate for use
			System.out.println("In DAO of Login");

			
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();
			// Create new instance of Contact and set

			// values in it by reading them from form object
			System.out.println("Inserting Record");

			session.save(vo);

			tr.commit();
			System.out.println("Done");
			session.flush();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public List search() {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from LoginVO vo");

			ls = q.list();
			System.out.println(ls.size());
			System.out.println("Done");
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return ls;
	}
	public List complainAdmin() {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionfactory.openSession();

			Query q = session.createQuery("from LoginVO where userName= 'admin'");

			ls = q.list();
		/*	System.out.println(ls.size());
			System.out.println("Done");*/
			// session.flush();
			// session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return ls;
	}

	public void delete(LoginVO r) {
		// TODO Auto-generated method stub

		try {
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();

			session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();

			// Query q = session.createQuery("delete regvo where fn="
			// + r.getFn());
			session.delete(r);
			tr.commit();
			session.flush();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List edit(LoginVO vo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		try {

			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();

			session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();

			Query q = session.createQuery("from LoginVO where id='"+ vo.getUserId() + "'");
			ls = q.list();
			session.flush();
			session.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public void update(LoginVO vo) {
		// TODO Auto-generated method stub

		try {
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();

			session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();

			session.saveOrUpdate(vo);
			tr.commit();
			System.out.println("Done");

			session.flush();
			session.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public List authentication(LoginVO loginVO) {
		List ls = new ArrayList();

		try {
		Session session = null;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from LoginVO where username='"+ loginVO.getUserName() + "'and password='"+loginVO.getPassword()+"'");
		ls = q.list();
		session.flush();
		session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

}