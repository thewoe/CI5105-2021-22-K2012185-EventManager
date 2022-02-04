/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.modeltest;

import com.tugoflaherty.eventmanager.model.Item;

/**
 *
 * @author tugoflaherty
 */
public class ItemTest {
    
    /**
     * Test method to create new Item objects
     */
    public void createItems() {
    Item welcomeTalk = new Item("09:00","Welcome and introductions");
    Item keynote = new Item("09:15","Keynote by Wes Streeting MP: Student Health During a Pandemic");
    Item coffeeBreak = new Item("10:15","Coffee break");
    Item markPresentation = new Item("10:30","Presentation by Professor Mark Fielder: Pandemic Lessons");
    Item andreaPresentation = new Item("11:30","Presentation by Professor Andrea Petroczi: Covid and Public Health");
    Item lunch = new Item("12:30","Lunch");
    Item posters = new Item("13:30","Posters and lightning talks with coffee");
    Item closing = new Item("15:00","Keynote and Closing Remarks with Larissa Kennedy, NUS President");
    }

    public void testItemCreation() {
    Item welcomeTalk = new Item("09:00","Welcome and introductions");
    Item keynote = new Item("09:15","Keynote by Wes Streeting MP: Student Health During a Pandemic");
    Item coffeeBreak = new Item("10:15","Coffee break");
    Item markPresentation = new Item("10:30","Presentation by Professor Mark Fielder: Pandemic Lessons");
    Item andreaPresentation = new Item("11:30","Presentation by Professor Andrea Petroczi: Covid and Public Health");
    Item lunch = new Item("12:30","Lunch");
    Item posters = new Item("13:30","Posters and lightning talks with coffee");
    Item closing = new Item("15:00","Keynote and Closing Remarks with Larissa Kennedy, NUS President");
    System.out.println("Item: " + welcomeTalk.getStartTime().toString() + " " + welcomeTalk.getItemTitle());
    System.out.println("Item: " + keynote.getStartTime().toString() + " " + keynote.getItemTitle());
    System.out.println("Item: " + coffeeBreak.getStartTime().toString() + " " + coffeeBreak.getItemTitle());
    System.out.println("Item: " + markPresentation.getStartTime().toString() + " " + markPresentation.getItemTitle());
    System.out.println("Item: " + andreaPresentation.getStartTime().toString() + " " + andreaPresentation.getItemTitle());
    System.out.println("Item: " + lunch.getStartTime().toString() + " " + lunch.getItemTitle());
    System.out.println("Item: " + posters.getStartTime().toString() + " " + posters.getItemTitle());
    System.out.println("Item: " + closing.getStartTime().toString() + " " + closing.getItemTitle());
    }
}
