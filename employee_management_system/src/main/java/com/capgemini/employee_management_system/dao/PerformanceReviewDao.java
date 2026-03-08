package com.capgemini.employee_management_system.dao;

import java.util.List;
import javax.persistence.*;

import com.capgemini.employee_management_system.entity.PerformanceReview;

public class PerformanceReviewDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ems");
    EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void insert(PerformanceReview p) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        entitymanager.persist(p);

        transaction.commit();
    }

    public void update(int id, int rating, String comments) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        PerformanceReview p = entitymanager.find(PerformanceReview.class, id);

        p.setRating(rating);
        p.setComments(comments);

        transaction.commit();
    }

    public void delete(int id) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        PerformanceReview p = entitymanager.find(PerformanceReview.class, id);

        entitymanager.remove(p);

        transaction.commit();
    }

    public List<PerformanceReview> getByEmployee(String code) {

        String jpql = "select p from PerformanceReview p where p.employeeCode = :c";

        return entitymanager.createQuery(jpql, PerformanceReview.class)
                .setParameter("c", code)
                .getResultList();
    }
}