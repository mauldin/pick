/**
 * PickupBean.java
 *
 * Copyright (c) 2014 - Old Dominion Freight Line
 *
 */
package com.odfl.managed;

import com.odfl.data.ShippingBean;
import com.odfl.model.Caller;
import com.odfl.model.Shippickup;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Enter type doc here.
 *
 * $Header$
 *
 */
@Named
@ConversationScoped
public class PickupBean implements Serializable {

    private static final long serialVersionUID = -6541718762358561835L;

    @Inject
    private Conversation conversation;
    
    @EJB
    private ShippingBean shipEjb;

    private Shippickup ship;
    private Caller caller;
    
    public Shippickup getShip() {
        return ship;
    }

    public void setShip(Shippickup ship) {
        this.ship = ship;
    }

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    @PostConstruct
    public void initShipper() {
        System.out.println("DANGER DANGER BROOOOOOOOOOOO");
        ship = new Shippickup();
        caller = new Caller();
    }

    public void fetchShipper(AjaxBehaviorEvent event) {
        ship.setShipperid(shipEjb.execute(1));
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void initConversation() {
        System.out.println("yo");
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {
            System.out.println("init");
            conversation.begin();
        }
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "shipperInfoEntryScreen?faces-redirect=true";
    }
    
    public String nextPage() {
        initConversation();
        System.out.println(";/");
        return "mock?faces-redirect=true";
    }
}
