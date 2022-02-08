/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

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
    
    @Override
    public String toString() {
        return "Item{" + "title=" + this.getItemTitle() + "time=" + this.getStartTime().toString() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.startTime);
        hash = 97 * hash + Objects.hashCode(this.itemTitle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemTitle, other.itemTitle)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        return true;
    }
    
}
