/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

/**
 *
 * @author tugoflaherty
 */
public class MainTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        //instantiation of all test classes
        
        //EventManagerTest eventManagerTest = new EventManagerTest();
        //EventTest eventTest = new EventTest();
        //ItemTest itemTest = new ItemTest();
        //OrganiserTest organiserTest = new OrganiserTest();
        
        //itemTest.testItemCreation();
        //organiserTest.testOrganiserCreation();
        //eventTest.testEventCreation();
        System.out.println(EventManagerTest.testSingletonEventManagerCreation());
        System.out.println(EventManagerTest.testEmptyEventManagerEventList());
        System.out.println(EventManagerTest.testEmptyEventManagerItemList());
        System.out.println(EventManagerTest.testEmptyEventManagerOrganiserList());
        
    }
}
