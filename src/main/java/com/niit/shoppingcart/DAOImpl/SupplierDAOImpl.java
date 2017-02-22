package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public List<Supplier> listSupplier() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
	}
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier = sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listsupplier;

	}

	@Transactional
	public Supplier get(int id) {
		String hql = "from Supplier where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = query.list();
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}


	@Transactional
	public List getAllSuppliers() {
		Session session = sessionFactory.openSession();
		List list = session.createQuery("from Supplier").list();
		session.close();
		return list;
	}

	@Transactional
	public Supplier getSingleSupplier(int id) {
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.load(Supplier.class, id);
		return supplier;
	}
	


	@Transactional
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		
	}
	@Transactional
	public void saveOrUpdate(Supplier supplier) 
	{
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

	}

	@Transactional
	public void delete(int id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
	}
	public Supplier SingleUpdate(int id) {
		Session session = sessionFactory.openSession();
		Supplier supplier = (Supplier) session.load(Supplier.class, id);
		
		return null;
	}

}
