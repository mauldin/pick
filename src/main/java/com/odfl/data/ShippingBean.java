/**
 * ShippingBean.java
 *
 * Copyright (c) 2014 - Old Dominion Freight Line
 *
 */
package com.odfl.data;

import com.odfl.model.Shipper;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Enter type doc here.
 *
 * $Header$
 *
 */
@Stateless
@Local
public class ShippingBean {

    @Inject
    private EntityManager em;

    public Shipper execute(Integer id) {
        System.out.println("hey ;) " + id);
        return em.find(Shipper.class, id);
    }

}
