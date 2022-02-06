/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author tugoflaherty
 */
public class EventManager implements Serializable {

    private static EventManager INSTANCE = new EventManager();
    private List<Event> events = new ArrayList();
    private List<Item> items = new ArrayList();
    private List<Organiser> organisers = new ArrayList();
    
    /**
     * This method is a getter to return the events attribute as type List of Event objects
     * It takes in no parameters
     * @return This returns the events of type List of Event objects
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * This method is a setter to set the value of the events attribute using a value of type List of Event objects
     * It does not return a value
     * @param events This is the value of the events attribute to be set of type List of Event objects
     */
    public void setEvents(List<Event> events) {
        this.events = events;
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
     * This method is a getter to return the organisers attribute as type List of Organiser objects
     * It takes in no parameters
     * @return This returns the organisers of type List of Organiser objects
     */
    public List<Organiser> getOrganisers() {
        return organisers;
    }

    /**
     * This method is a setter to set the value of the organisers attribute using a value of type List of Organiser objects
     * It does not return a value
     * @param organisers This is the value of the organisers attribute to be set of type List of Organiser objects
     */
    public void setOrganisers(List<Organiser> organisers) {
        this.organisers = organisers;
    }
    
    private EventManager() {
        //insert observer thingy
        //inset initialisation for events, organisers, and put in relevant arraylist
    }
    
    public static EventManager getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new EventManager();
            //System.out.println("New EventManager instance created");
        }
        //System.out.println("Using the first EventManager instance created");
        return INSTANCE;
    }
    
    public static void main(String[] args) {
        EventManager eventManager = EventManager.getInstance();
        
    }
}
