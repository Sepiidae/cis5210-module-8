/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fit.module8.entity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author rhianresnick
 */
public class AppController {

    EntityManagerFactory emf;
    EntityManager em;

    public AppController() {
        emf = Persistence.createEntityManagerFactory("edu.fit_Module8_war_1.0-SNAPSHOTPU");
    }

    public Person getPerson(int id) {
        em = emf.createEntityManager();

        Query q = em.createQuery("select p from Person p where p.id = :id");
        q.setParameter("id", id);

        List<Person> people = q.getResultList();
        if (people.size() > 0) {
            return people.get(0);
        }
        return new Person();
    }

    public List<Person> getPeople() {
        em = emf.createEntityManager();

        Query q = em.createQuery("select p from Person p");

        List<Person> people = q.getResultList();
        return people;
    }

    public Person createPerson(String firstName, String lastName, String email, String employeeNumber) {
        Person person = null;
        em = emf.createEntityManager();

        person = new Person();
        person.setEmail(email);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmployeeNumber(employeeNumber);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        em.flush();

        transaction.commit();
        em.close();

        return person;
    }

    public Person updatePerson(int id, String firstName, String lastName, String email, String employeeNumber) {
        Person person = getPerson(id);
        System.out.println(person);
        em = emf.createEntityManager();

        if (email != null) {
            person.setEmail(email);
        }
        if (employeeNumber != null) {
            person.setEmployeeNumber(employeeNumber);
        }
        if (firstName != null) {
            person.setFirstName(firstName);
        }
        if (lastName != null) {
            person.setLastName(lastName);
        }
        System.out.println(person);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(person);
        em.flush();

        transaction.commit();
        em.close();

        return person;
    }
}
