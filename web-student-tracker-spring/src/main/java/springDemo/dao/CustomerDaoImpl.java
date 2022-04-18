package springDemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springDemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> query = currentSession.createNativeQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public int saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		int result = (int) currentSession.save(customer);
		return result;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		String q = "Select * from Customer where id = ? order by last_name";
		Query<Customer> query = currentSession.createNativeQuery(q, Customer.class).setParameter(1, id);

		Customer customer = query.getSingleResult();
		return customer;
	}

	@Override
	@Transactional
	public boolean updateCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = new Customer(id);
		currentSession.delete(customer);
		return true;
	}

}
