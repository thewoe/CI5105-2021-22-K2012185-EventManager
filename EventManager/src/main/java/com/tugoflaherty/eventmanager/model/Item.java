/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 *
 * @author tugoflaherty
 */
public class Item {
    
    private LocalTime startTime;
    private String itemTitle;

    /**
     * This method is a getter to return the startTime attribute as type LocalTime
     * It takes in no parameters
     * @return This returns the startTime of type LocalTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * This method is a setter to set the value of the startTime attribute using a value of type LocalTime
     * It does not return a value
     * @param startTime This is the value of the startTime attribute to be set of type LocalTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    /**
     * This method is a setter to set the value of the startTime attribute using a value of type String
     * It does not return a value
     * @param startTime This is the value of the startTime attribute to be set of type String
     * @throws DateTimeParseException This Exception is thrown if the String value cannot be converted to type LocalTime
     */
    public void setStartTime(String startTime) throws DateTimeParseException {	  		 	  	 	        	     	
        this.startTime = LocalTime.parse(startTime);	  		 	  	 	        	     	
    }

    /**
     * This method is a getter to return the itemTitle attribute as type String
     * It takes in no parameters
     * @return This returns the itemTitle of type String
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * This method is a setter to set the value of the itemTitle attribute using a value of type String
     * It does not return a value
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
    
    /**
     * Constructor to construct new Item object with a value of type LocalTime for startTime and String for itemTitle
     * @param startTime This is the value of the startTime attribute to be set of type LocalTime
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public Item(LocalTime startTime, String itemTitle) {
        this.setStartTime(startTime);
        this.setItemTitle(itemTitle);
    }
    
    /**
     * Constructor to construct new Item object with a value of type String for startTime and String for itemTitle
     * @param startTime This is the value of the startTime attribute to be set of type String
     * @param itemTitle This is the value of the itemTitle attribute to be set of type String
     */
    public Item(String startTime, String itemTitle) {
        this.setStartTime(startTime);
        this.setItemTitle(itemTitle);
    }
    
}
