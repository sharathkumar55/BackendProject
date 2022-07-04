package com.example.assignment.dao;

import com.example.assignment.entity.BlinkList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BlinkListDAOImpl implements BlinkListDAO {

    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public BlinkListDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<BlinkList> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<BlinkList> theQuery =
                currentSession.createQuery("from BlinkList", BlinkList.class);

        // execute query and get result list
        return theQuery.getResultList();

        // return the results
    }


    @Override
    public BlinkList findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee

        return currentSession.get(BlinkList.class, theId);

        // return the employee

    }


    @Override
    public void save(BlinkList theBlinkList) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theBlinkList);
    }


    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
//        Query theQuery =
//                currentSession.createQuery(
//                        "delete from BlinkList where id=:blinkListId");
//        theQuery.setParameter("blinkListId", theId);

        //theQuery.executeUpdate();
    }
}
