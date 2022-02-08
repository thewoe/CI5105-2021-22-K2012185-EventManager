/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tugoflaherty
 */
public class Event {
    
    private String title;
    private Organiser organiser;
    private LocalDateTime dateTime;
    private String location;
    private List<Item> items = new ArrayList();

    /**
     * This method is a getter to return the title attribute as type String
     * It takes in no parameters
     * @return This returns the title of type String
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method is a setter to set the value of the title attribute using a value of type String
     * It does not return a value
     * @param title This is the value of the title attribute to be set of type String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method is a getter to return the organiser attribute as type Organiser
     * It takes in no parameters
     * @return This returns the organiser of type Organiser
     */
    public Organiser getOrganiser() {
        return organiser;
    }

    /**
     * This method is a setter to set the value of the organiser attribute using a value of type Organiser
     * It does not return a value
     * @param organiser This is the value of the organiser attribute to be set of type Organiser
     */
    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    /**
     * This method is a getter to return the dateTime attribute as type LocalDateTime
     * It takes in no parameters
     * @return This returns the dateTime of type LocalDateTime
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * This method is a setter to set the value of the dateTime attribute using a value of type LocalDateTime
     * It does not return a value
     * @param dateTime This is the value of the dateTime attribute to be set of type LocalDateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    /**
     * This method is a setter to set the value of the dateTime attribute using a value of type String
     * It does not return a value
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @throws DateTimeParseException This Exception is thrown if the String value cannot be converted to type LocalDateTime
     */
    public void setDateTime(String dateTime) throws DateTimeParseException {	  		 	  	 	        	     	
        this.dateTime = LocalDateTime.parse(dateTime);	  		 	  	 	        	     	
    }

    /**
     * This method is a getter to return the location attribute as type String
     * It takes in no parameters
     * @return This returns the location of type String
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method is a setter to set the value of the location attribute using a value of type String
     * It does not return a value
     * @param location This is the value of the location attribute to be set of type String
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * This method is a getter to return the items attribute as type List of Item objects
     * It takes in no parameters
     * @return This returns the items of type List of Item objects
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * This method is a setter to set the value of the items attribute using a value of type List of Item objects
     * It does not return a value
     * @param items This is the value of the items attribute to be set of type List of Item objects
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, Organiser for organiser, LocalDateTime for dateTime, String for location and List of Item objects for items
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser object
     * @param dateTime This is the value of the dateTime attribute to be set of type LocalDateTime
     * @param location This is the value of the location attribute to be set of type String
     * @param items This is the value of the items attribute to be set of type List of Item objects
     */
    public Event(String title, Organiser organiser, LocalDateTime dateTime, String location, List<Item> items) {
        this.setTitle(title);
        this.setOrganiser(organiser);
        this.setDateTime(dateTime);
        this.setLocation(location);
        this.setItems(items);
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, Organiser for organiser, LocalDateTime for dateTime and String for location
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser object
     * @param dateTime This is the value of the dateTime attribute to be set of type LocalDateTime
     * @param location This is the value of the location attribute to be set of type String
     */
    public Event(String title, Organiser organiser, LocalDateTime dateTime, String location) {
        this.setTitle(title);
        this.setOrganiser(organiser);
        this.setDateTime(dateTime);
        this.setLocation(location);
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, LocalDateTime for dateTime and String for location
     * @param title This is the value of the title attribute to be set of type String
     * @param dateTime This is the value of the dateTime attribute to be set of type LocalDateTime
     * @param location This is the value of the location attribute to be set of type String
     */
    public Event(String title, LocalDateTime dateTime, String location) {
        this.setTitle(title);
        this.setDateTime(dateTime);
        this.setLocation(location);
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, Organiser for organiser, String for dateTime, String for location and List of Item objects for items
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser object
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     * @param items This is the value of the items attribute to be set of type List of Item objects
     */
    public Event(String title, Organiser organiser, String dateTime, String location, List<Item> items) {
        this.setTitle(title);
        this.setOrganiser(organiser);
        this.setDateTime(dateTime);
        this.setLocation(location);
        this.setItems(items);
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, Organiser for organiser, String for dateTime and String for location
     * @param title This is the value of the title attribute to be set of type String
     * @param organiser This is the value of the organiser attribute to be set of type Organiser object
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     */
    public Event(String title, Organiser organiser, String dateTime, String location) {
        this.setTitle(title);
        this.setOrganiser(organiser);
        this.setDateTime(dateTime);
        this.setLocation(location);
    }
    
    /**
     * Constructor to construct new Event object with a value of type String for title, String for dateTime and String for location
     * @param title This is the value of the title attribute to be set of type String
     * @param dateTime This is the value of the dateTime attribute to be set of type String
     * @param location This is the value of the location attribute to be set of type String
     */
    public Event(String title, String dateTime, String location) {
        this.setTitle(title);
        this.setDateTime(dateTime);
        this.setLocation(location);
    }
    
    public void addItem(Item item) {
        this.getItems().add(item);
    }
    
    @Override
    public String toString() {
        if (this.getOrganiser() != null) {
            return "Event{" + "title=" + this.getTitle() + "organiser=" + this.getOrganiser().toString() + "time=" + this.getDateTime().toString() + "location=" + this.getLocation() + "}";
        }
        return "Event{" + "title=" + this.getTitle() + "organiser=null" + "time=" + this.getDateTime().toString() + "location=" + this.getLocation() + "}";

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.organiser);
        hash = 29 * hash + Objects.hashCode(this.dateTime);
        hash = 29 * hash + Objects.hashCode(this.location);
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.organiser, other.organiser)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        return true;
    }
    
}
