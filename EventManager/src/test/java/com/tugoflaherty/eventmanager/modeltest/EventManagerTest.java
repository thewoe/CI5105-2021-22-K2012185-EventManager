/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Event;
import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.model.Item;
import com.tugoflaherty.eventmanager.model.Organiser;
import java.util.List;

/**
 *
 * @author tugoflaherty
 */
public class EventManagerTest {
    
    public static boolean testSingletonEventManagerCreation() {
        EventManager eventManager = EventManager.getInstance();
        EventManager eventManager2 = EventManager.getInstance();
        return (eventManager==eventManager2);
    }
    
    public static boolean testEmptyEventManagerEventList() {
        EventManager eventManager = EventManager.getInstance();
        List<Event> eventManagerEventsList = eventManager.getEvents();
        return eventManagerEventsList.isEmpty();
    }
    
    public static boolean testEmptyEventManagerItemList() {
        EventManager eventManager = EventManager.getInstance();
        List<Item> eventManagerItemsList = eventManager.getItems();
        return eventManagerItemsList.isEmpty();
    }
    
    public static boolean testEmptyEventManagerOrganiserList() {
        EventManager eventManager = EventManager.getInstance();
        List<Organiser> eventManagerOrganisersList = eventManager.getOrganisers();
        return eventManagerOrganisersList.isEmpty();
    }
    
        //create series of events, add them to eventmanager events arraylist
        //create series of items, add them to eventmanager items arraylist
        //create series of organisers, add them to eventmanager organisers arraylist
        //check further tests that can be run and implement these
        //update the functional test plan and UML class diagram
        //implement second requirement
    
}
