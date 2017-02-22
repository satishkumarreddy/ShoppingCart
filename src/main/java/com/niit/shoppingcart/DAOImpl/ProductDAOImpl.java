package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {
		@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@Transactional
	public void delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}

	@Transactional
	public Product get(int id) {
		// sessionFactory.getCurrentSession().get(Product.class,id);
		String hql = "from Product where Id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = query.list();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}

	@Transactional
	public List getAllProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List list=session.createQuery("from Product").list();
		session.close();
		return list;
		}


	@Transactional
	public int deleteProduct(int id) {
		Session session=sessionFactory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		Product product=(Product)session.load(Product.class, id);
		session.delete(product);
		tx.commit();
		
		session.close();
		return id;
			
	}
	@Transactional
	public Product getSingleProduct(int id) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.load(Product.class, id);
		return product;
		}
	
	@Transactional
	public void updateProduct(Product product) 
	{
		Session s1=sessionFactory.openSession();
		Transaction t1=s1.beginTransaction();
		s1.update(product);
	    t1.commit();
		
     }

}
