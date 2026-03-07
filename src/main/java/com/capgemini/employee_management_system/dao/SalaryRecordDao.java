package com.capgemini.employee_management_system.dao;

import java.util.List;
import javax.persistence.*;

import com.capgemini.employee_management_system.entity.SalaryRecord;

public class SalaryRecordDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ems");
    EntityManager entitymanager = entityManagerFactory.createEntityManager();

    public void insert(SalaryRecord s) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        s.calculateNetSalary();

        entitymanager.persist(s);

        transaction.commit();
    }

    public void update(int id, double bonus, double tax) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        SalaryRecord s = entitymanager.find(SalaryRecord.class, id);

        s.setBonus(bonus);
        s.setTax(tax);

        s.calculateNetSalary();

        transaction.commit();
    }

    public void delete(int id) {

        EntityTransaction transaction = entitymanager.getTransaction();
        transaction.begin();

        SalaryRecord s = entitymanager.find(SalaryRecord.class, id);

        entitymanager.remove(s);

        transaction.commit();
    }

    public List<SalaryRecord> getByEmployeeCode(String code) {

        String jpql = "select s from SalaryRecord s where s.employeeCode = :c";

        return entitymanager.createQuery(jpql, SalaryRecord.class)
                .setParameter("c", code)
                .getResultList();
    }

    public SalaryRecord getByMonth(String month) {

        String jpql = "select s from SalaryRecord s where s.salaryMonth = :m";

        return entitymanager.createQuery(jpql, SalaryRecord.class)
                .setParameter("m", month)
                .getSingleResult();
    }

    public List<SalaryRecord> getAllByEmployee(String code) {

        String jpql = "select s from SalaryRecord s where s.employeeCode = :c";

        return entitymanager.createQuery(jpql, SalaryRecord.class)
                .setParameter("c", code)
                .getResultList();
    }
}