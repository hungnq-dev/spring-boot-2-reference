package com.acme.persistence;

import com.acme.domain.Product;
import com.acme.domain.ProductRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        sessionFactory
                .getCurrentSession()
                .persist(product);
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Product", Product.class)
                .list();
    }
}
