/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Organiser;

/**
 *
 * @author tugoflaherty
 */
public class OrganiserTest {
    
    /**
     * This is a test method to create a series of five hard-coded Organiser objects, testing that Organiser objects can be instantiated
     * Checks appropriate Organiser constructor and attributes are set correctly to allow a new Organiser to be instantiated
     * Takes in no parameters
     * Returns no values
     */
    public static void createOrganisers() {
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        Organiser ahmedShihab = new Organiser("Ahmed","Shihab");
        Organiser tugOflaherty = new Organiser("Tug","O'Flaherty");
        Organiser graemeJones = new Organiser("Graeme","Jones");
    }
    
    /**
     * This is a test method to create a series of five hard-coded Organiser objects, testing that Organiser objects can be instantiated
     * Checks appropriate Organiser constructor and attributes are set correctly to allow a new Organiser to be instantiated
     * Prints out Organiser object attributes to console to show that the Organiser objects have been correctly instantiated
     * Takes in no parameters
     * Returns no values
     */
    public static void testOrganiserCreation() {
        Organiser jamesDenholmPrice = new Organiser("James","Denholm-Price");
        Organiser davidLivingstone = new Organiser("David","Livingstone");
        Organiser ahmedShihab = new Organiser("Ahmed","Shihab");
        Organiser tugOflaherty = new Organiser("Tug","O'Flaherty");
        Organiser graemeJones = new Organiser("Graeme","Jones");
        System.out.println("Organiser: " + jamesDenholmPrice.getFirstName() + " " + jamesDenholmPrice.getLastName());
        System.out.println("Organiser: " + davidLivingstone.getFirstName() + " " + davidLivingstone.getLastName());
        System.out.println("Organiser: " + ahmedShihab.getFirstName() + " " + ahmedShihab.getLastName());
        System.out.println("Organiser: " + tugOflaherty.getFirstName() + " " + tugOflaherty.getLastName());
        System.out.println("Organiser: " + graemeJones.getFirstName() + " " + graemeJones.getLastName());
    }
}
