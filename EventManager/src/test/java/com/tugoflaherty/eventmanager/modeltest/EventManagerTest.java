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
import java.util.ArrayList;
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
    
    public static boolean testAddEventToEventManagerEventListAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        return eventManager.getEvents().add(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListNoItems() {
        EventManager eventManager = EventManager.getInstance();
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        return eventManager.getEvents().add(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        Event testEvent = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        return eventManager.getEvents().add(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListNotEmptyAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        return !eventManager.getEvents().isEmpty();
    }
    
    public static boolean testAddEventToEventManagerEventListNotEmptyNoItems() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        return !eventManager.getEvents().isEmpty();
    }
    
    public static boolean testAddEventToEventManagerEventListNotEmptyNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        return !eventManager.getEvents().isEmpty();
    }
    
    public static boolean testAddEventToEventManagerEventListContainsAllAttributes() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListContainsNoItems() {
        EventManager eventManager = EventManager.getInstance();
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListContainsNoItemsAndOrganiser() {
        EventManager eventManager = EventManager.getInstance();
        Event testEvent = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        eventManager.getEvents().add(testEvent);
        return eventManager.getEvents().contains(testEvent);
    }
    
    public static boolean testAddEventToEventManagerEventListSize() {
        EventManager eventManager = EventManager.getInstance();
        int currentEventListSize = eventManager.getEvents().size();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        if (eventManager.getEvents().size() == currentEventListSize + 3) {
            return true;
        }
        return false;
    }
    
    public static boolean testDeleteEventFromEventManagerEventListDoesNotContain() {
        EventManager eventManager = EventManager.getInstance();
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        List<Item> items = new ArrayList();
        items.add(new Item("09:00","Wake up"));
        items.add(new Item("10:00","Catch the bus"));
        items.add(new Item("11:00","Arrive at Kingston University"));
        items.add(new Item("12:00","Teach Programming"));
        items.add(new Item("17:00","Go home"));
        Event testEvent0 = new Event("Dave's Standard University Day",davidLivingstone,"2021-02-06T09:00","Kingston",items);
        eventManager.getEvents().add(testEvent0);
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Event testEvent1 = new Event("James' Vaccination Booster",jamesDenholmPrice,"2020-05-12T15:00","Lewisham");
        eventManager.getEvents().add(testEvent1);
        Event testEvent2 = new Event("Ahmed's Algorithm Workshop","2022-01-10T11:00","Manchester");
        eventManager.getEvents().add(testEvent2);
        eventManager.deleteEvent(1);
        return !eventManager.getEvents().contains(testEvent1);
    }
    
    public static boolean testDeleteEventFromEventManagerEventListSize() {
        EventManager eventManager = EventManager.getInstance();
        EventManagerTest.testAddEventToEventManagerEventListAllAttributes();
        EventManagerTest.testAddEventToEventManagerEventListNoItems();
        EventManagerTest.testAddEventToEventManagerEventListNoItemsAndOrganiser();
        int currentEventListSize = eventManager.getEvents().size();
        eventManager.deleteEvent(2);
        if (eventManager.getEvents().size() == currentEventListSize -1) {
            return true;
        }
        return false;
    }
    
    public static boolean testAddItemToEventManagerItemList() {
        EventManager eventManager = EventManager.getInstance();
        return eventManager.addItem("15:00","Presentation by guest Professor Graeme Jones");
    }
    
    public static boolean testAddItemToEventManagerItemListContains() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Welcome audience to conference");
        if (eventManager.getItems().get(eventManager.getItems().size()-1).getItemTitle().equals("Welcome audience to conference")) {
            return true;
        }
        return false;
    }
    
    public static boolean testAddItemToEventManagerItemListSize() {
        EventManager eventManager = EventManager.getInstance();
        int currentItemListSize = eventManager.getItems().size();
        EventManagerTest.testAddItemToEventManagerItemList();
        if (eventManager.getItems().size() == currentItemListSize + 1) {
            return true;
        }
        return false;
    }
    
    public static boolean testDeleteItemFromEventManagerItemListDoesNotContain() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Wake up");
        eventManager.addItem("10:00","Catch the bus");
        eventManager.addItem("11:00","Arrive at Kingston University");
        eventManager.deleteItem(1);
        return !eventManager.getItems().get(1).getItemTitle().equals("Catch the bus");
    }
    
    public static boolean testDeleteEventToEventManagerItemListSize() {
        EventManager eventManager = EventManager.getInstance();
        eventManager.addItem("09:00","Wake up");
        eventManager.addItem("10:00","Catch the bus");
        eventManager.addItem("11:00","Arrive at Kingston University");
        int currentItemListSize = eventManager.getItems().size();
        eventManager.deleteItem(1);
        if (eventManager.getItems().size() == currentItemListSize -1) {
            return true;
        }
        return false;
    }
}
