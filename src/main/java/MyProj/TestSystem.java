package MyProj;

import java.util.List;
//import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestSystem {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("MyProj");
	
	public static void main(String[] args) {
//		addCustomer(1, "A", "Z");
//		addCustomer(2, "A2", "Z2");
//		addCustomer(3, "A3", "Z3");
//		addCustomer(4, "A4", "Z4");
//		addCustomer(5, "A5", "Z5");
//		addCustomer(6, "A6", "Z6");
		
		getCustomer(1);
		getCustomer(5);
		
		getCustomers();
		
		changeFName(3, "B3");
		
		deleteCustomer(4);
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void addCustomer(int id, String fName, String lName) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Customer cust = new Customer();
			cust.setID(id);
			cust.setFName(fName);
			cust.setLName(lName);
			em.persist(cust);
			et.commit();
		}
		catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void getCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "Select c from Customer c where c.id = :custID";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("custID", id);
		Customer cust = null;
		
		try {
			cust = tq.getSingleResult();
			System.out.print("Customer Name for ID " + id + " is ");
			System.out.println(cust.getFName() + "-" + cust.getLName());
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void getCustomers() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "Select c from Customer c where c.id is not null";
		
		TypedQuery<Customer> tq = em.createQuery(strQuery, Customer.class);
		List<Customer> custs;
		
		try {
			custs = tq.getResultList();
//			custs.forEach(new Consumer<Customer>() {
//				public void accept(Customer cst) {
//					System.out.println(cst.getFName() + "-" + cst.getLName());
//				}
//			});
			System.out.println("All Customers List Given Below...");
			custs.forEach(cust -> System.out.println(cust.getID() + ":" +cust.getFName() + "-" + cust.getLName()));
			
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void changeFName(int id, String fName) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Customer cust = null;
		try {
			et = em.getTransaction();
			et.begin();
			cust = em.find(Customer.class, id);
			cust.setFName(fName);
			
			em.persist(cust);
			et.commit();
			System.out.println("Renamed FirstName to " + fName);
			getCustomer(id);
		}
		catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void deleteCustomer(int id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Customer cust = null;
		try {
			et = em.getTransaction();
			et.begin();
			cust = em.find(Customer.class, id);
			em.remove(cust);
			
			em.persist(cust);
			et.commit();
			System.out.print("Removed Customer ID " + id);
		}
		catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
}
