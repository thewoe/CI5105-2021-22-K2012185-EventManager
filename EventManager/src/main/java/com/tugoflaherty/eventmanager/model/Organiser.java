/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

/**
 *
 * @author tugoflaherty
 */
public class Organiser {
    
    private String firstName;
    private String lastName;

    /**
     * This method is a getter to return the firstName attribute as type String
     * It takes in no parameters
     * @return This returns the firstName of type String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is a setter to set the value of the firstName attribute using a value of type String
     * It does not return a value
     * @param firstName This is the value of the firstName attribute to be set of type String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method is a getter to return the lastName attribute as type String
     * It takes in no parameters
     * @return This returns the lastName of type String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is a setter to set the value of the lastName attribute using a value of type String
     * It does not return a value
     * @param lastName This is the value of the lastName attribute to be set of type String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Constructor to construct new Organiser object with a value of type String for firstName and String for lastName
     * @param firstName This is the value of the firstName attribute to be set of type String
     * @param lastName This is the value of the lastName attribute to be set of type String
     */
    public Organiser(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    
}
