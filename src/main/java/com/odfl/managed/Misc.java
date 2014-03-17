/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.odfl.managed;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sam
 */
@Named(value = "misc")
@RequestScoped
public class Misc {

    /**
     * Creates a new instance of Misc
     */
    public Misc() {
    }
    
    private Date date = new Date();

    public Date getDate() {
        return new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
