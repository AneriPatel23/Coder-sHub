package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CompanyVO;
import VO.CountryVO;
import VO.LoginVO;



public class CompanyDAO
{
	public List searchCompany(CompanyVO companyVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from CompanyVO where loginVO="+companyVO.getLoginVO().getUserId());
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public List searchCompanyDetails(LoginVO  loginVO)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from CompanyVO where userId="+loginVO.getUserId());
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
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

			Query q = session.createQuery("from CompanyVO companyVO company where email='"+to+"'");

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
	/*public Boolean isRightEmail(CompanyVO companyVO){

		System.out.println("Searching in DAO..");
		List list = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Query query = session.createQuery("from CompanyVO where email='"+companyVO.getEmail()+"'");
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
	}*/
	
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
	public List loadState(CountryVO countryVO) {
		List list = new ArrayList();
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from StateVO where cv="+countryVO.getCountryId());
			list = query.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	
	public void insertCompany(CompanyVO v)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(v);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	public List searchCompany()
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from CompanyVO");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	public void deleteCompany(CompanyVO v)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.delete(v);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	public List editCompany(CompanyVO v)
	{
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from CompanyVO where id='"+v.getCompanyId()+"' ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public void updateCompany(CompanyVO v)
	{
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(v);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
}
