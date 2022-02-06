/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Event;
import com.tugoflaherty.eventmanager.model.Item;
import com.tugoflaherty.eventmanager.model.Organiser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tugoflaherty
 */
public class EventTest {

    public void createEvents() {
        Organiser jamesDenholmPrice = new Organiser("James", "DenholmPrice");
        Organiser davidLivingstone = new Organiser("David", "Livingstone");
        List<Item> musicConcertItems = new ArrayList();
        List<Item> assessmentCentreItems = new ArrayList();
        musicConcertItems.add(new Item("16:00", "Check in to Wembley Arena"));
        musicConcertItems.add(new Item("17:00", "Watch support act"));
        musicConcertItems.add(new Item("18:00", "Watch main act"));
        musicConcertItems.add(new Item("20:00", "Catch last train home"));
        assessmentCentreItems.add(new Item("10:00", "Attend group interview"));
        assessmentCentreItems.add(new Item("11:00", "Attend individual interview"));
        assessmentCentreItems.add(new Item("12:00", "Present individual presentation on IBM challenges"));
        assessmentCentreItems.add(new Item("13:00", "Lunch break"));
        assessmentCentreItems.add(new Item("14:00", "Review session"));
        Event musicConcert = new Event("Attend Music Concert", jamesDenholmPrice, "16:00", "Wembley", musicConcertItems);
        Event assessmentCentre = new Event("IBM Assessment Centre", davidLivingstone, "10:00", "Epsom", assessmentCentreItems);
        Event scotlandHoliday = new Event("Holiday to Glasgow", jamesDenholmPrice, "09:15", "Glasgow");
        Event websiteDevelopment = new Event("Create website for Wagons Roll", davidLivingstone, "11:30", "Manchester");
        Event vaccinationBooster = new Event("Vaccination Booster", "10:15", "Lewisham");
        Event movieFilming = new Event("Film New Blockbuster Movie", "12:00", "Bristol");
    }

    public void testEventCreation() {
        Organiser jamesDenholmPrice = new Organiser("James", "DenholmPrice");
        Organiser davidLivingstone = new Organiser("David", "Livingstone");
        List<Item> musicConcertItems = new ArrayList();
        List<Item> assessmentCentreItems = new ArrayList();
        musicConcertItems.add(new Item("16:00", "Check in to Wembley Arena"));
        musicConcertItems.add(new Item("17:00", "Watch support act"));
        musicConcertItems.add(new Item("18:00", "Watch main act"));
        musicConcertItems.add(new Item("20:00", "Catch last train home"));
        assessmentCentreItems.add(new Item("10:00", "Attend group interview"));
        assessmentCentreItems.add(new Item("11:00", "Attend individual interview"));
        assessmentCentreItems.add(new Item("12:00", "Present individual presentation on IBM challenges"));
        assessmentCentreItems.add(new Item("13:00", "Lunch break"));
        assessmentCentreItems.add(new Item("14:00", "Review session"));
        Event musicConcert = new Event("Attend Music Concert", jamesDenholmPrice, "2022-10-21T16:00", "Wembley", musicConcertItems);
        Event assessmentCentre = new Event("IBM Assessment Centre", davidLivingstone, "2022-02-12T10:00", "Epsom", assessmentCentreItems);
        Event scotlandHoliday = new Event("Holiday to Glasgow", jamesDenholmPrice, "2022-05-24T09:15", "Glasgow");
        Event websiteDevelopment = new Event("Create website for Wagons Roll", davidLivingstone, "2022-03-04T11:30", "Manchester");
        Event vaccinationBooster = new Event("Vaccination Booster", "2022-06-24T10:15", "Lewisham");
        Event movieFilming = new Event("Film New Blockbuster Movie", "2022-08-23T12:00", "Bristol");
        System.out.println("Event: " + musicConcert.getTitle() + " " + musicConcert.getOrganiser().toString() + "" + musicConcert.getDateTime().toString() + " " + musicConcert.getLocation() + " " + musicConcert.getItems().toString());
        System.out.println("Event: " + assessmentCentre.getTitle() + " " + assessmentCentre.getOrganiser().toString() + "" + assessmentCentre.getDateTime().toString() + " " + assessmentCentre.getLocation() + " " + assessmentCentre.getItems().toString());
        System.out.println("Event: " + scotlandHoliday.getTitle() + " " + scotlandHoliday.getOrganiser().toString() + "" + scotlandHoliday.getDateTime().toString() + " " + scotlandHoliday.getLocation() + " " + scotlandHoliday.getItems().toString());
        System.out.println("Event: " + websiteDevelopment.getTitle() + " " + websiteDevelopment.getOrganiser().toString() + "" + websiteDevelopment.getDateTime().toString() + " " + websiteDevelopment.getLocation() + " " + websiteDevelopment.getItems().toString());
        //System.out.println("Event: " + vaccinationBooster.getTitle() + " " + vaccinationBooster.getOrganiser().toString() + "" + vaccinationBooster.getDateTime().toString() + " " + vaccinationBooster.getLocation() + " " + vaccinationBooster.getItems().toString());
        //System.out.println("Event: " + movieFilming.getTitle() + " " + movieFilming.getOrganiser().toString() + "" + movieFilming.getDateTime().toString() + " " + movieFilming.getLocation() + " " + movieFilming.getItems().toString());
    }
}
