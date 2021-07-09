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
        emf = Persistence.createEntityManagerFactory("derbyUnit");
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

    /**
     * Search for a record in the person table, returning a list of people
     * 
     * if a parameter is null it will not search on that parameter
     * 
     * @param email
     * @param firstName
     * @param lastName
     * @param employeeNumber
     * @return 
     */
    public List<Person> search(String email, String firstName, String lastName, String employeeNumber) {
        em = emf.createEntityManager();

        // Build a sql string to submit to the database 
        StringBuilder sql = new StringBuilder();
        // A 1=1 always returns true, so it will return all records
        sql.append("select p from Person p where 1=1");

        // Add a filter, % is the same as a wild card, we need to wrap our string 
        // in "%" so it performs a wildcard lookup/search
        if (email != null) {
            email = "%" + email + "%";
            sql.append(" and p.email like :email");
        }

        if (firstName != null) {
            firstName = "%" + firstName + "%";
            sql.append(" and p.firstName like :firstName");
        }

        if (lastName != null) {
            lastName = "%" + lastName + "%";
            sql.append(" and p.lastName like :lastName");
        }
        if (employeeNumber != null) {
            employeeNumber = "%" + employeeNumber + "%";
            sql.append(" and p.employeeNumber like :employeeNumber");
        }
        
        // create a query object to submit our query, it expects a sql entry
        Query q = em.createQuery(sql.toString());
        
        // Pass the user input via parameters to the query
        if (email != null) {
            q.setParameter("email", email);
        }
        if (firstName != null) {
            q.setParameter("firstName", firstName);
        }
        if (lastName != null) {
            q.setParameter("lastName", lastName);
        }
        if (employeeNumber != null) {
            q.setParameter("employeeNumber", employeeNumber);
        }

        // Execute the query
        List<Person> people = q.getResultList();
        
        // Return the results of the query
        return people;

    }
}
