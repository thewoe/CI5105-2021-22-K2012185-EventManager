/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author tugoflaherty
 */
public class EventViewer extends JFrame {
    
    private static EventViewer INSTANCE = new EventViewer();
    //MIGRATE TO PANEL private JLabel eventViewerTitle = new JLabel("Event Viewer");
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu viewMenu = new JMenu("View");
    private JMenu sortByMenu = new JMenu("Sort By");
    private JMenuItem openFile = new JMenuItem("Open File");
    private JMenuItem saveFile = new JMenuItem("Save File");
    private JMenuItem newEvent = new JMenuItem("New Event");
    private JMenuItem newItem = new JMenuItem("New Event Item");
    private JMenuItem newOrganiser = new JMenuItem("New Organiser");
    private JMenuItem quitApplication = new JMenuItem("Exit");
    private JMenuItem deleteEvent = new JMenuItem("Delete Event");
    private JMenuItem deleteItem = new JMenuItem("Delete Event Item");
    private JMenuItem deleteOrganiser = new JMenuItem("Delete Organiser");
    private JMenuItem associateEventOrganiser = new JMenuItem("Set Event Organiser");
    private JMenuItem addItemsToEvent = new JMenuItem("Add Items To Event");
    private JMenuItem editEvent = new JMenuItem("Edit Event");
    private JMenuItem editItem = new JMenuItem("Edit Item");
    private JMenuItem editOrganiser = new JMenuItem("Edit Organiser");
    private JMenuItem textView = new JMenuItem("Text View");
    private JMenuItem tableView = new JMenuItem("Table View");
    private JMenuItem hierarchalView = new JMenuItem("Hierarchal View");
    private JMenuItem eventDateAscending = new JMenuItem("Event Date (Ascending)");
    private JMenuItem eventDateDescending = new JMenuItem("Event Date (Descending)");
    private JMenuItem organiserSurnameAscending = new JMenuItem("Organiser Surname (Ascending)");
    private JMenuItem organiserSurnameDescending = new JMenuItem("Organiser Surname (Descending)");
    
    public static EventViewer getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new EventViewer();
            //System.out.println("New EventViewer instance created");
        }
        //System.out.println("Using the first EventViewer instance created");
        return INSTANCE;
    }
    
    private EventViewer() {
        this.setTitle("Event Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400,0,575,425);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(newEvent);
        fileMenu.add(newItem);
        fileMenu.add(newOrganiser);
        fileMenu.addSeparator();
        fileMenu.add(quitApplication);
        editMenu.add(editEvent);
        editMenu.add(editItem);
        editMenu.add(editOrganiser);
        editMenu.addSeparator();
        editMenu.add(associateEventOrganiser);
        editMenu.add(addItemsToEvent);
        editMenu.addSeparator();
        editMenu.add(deleteEvent);
        editMenu.add(deleteItem);
        editMenu.add(deleteOrganiser);
        viewMenu.add(textView);
        viewMenu.add(tableView);
        viewMenu.add(hierarchalView);
        viewMenu.addSeparator();
        viewMenu.add(sortByMenu);
        sortByMenu.add(eventDateAscending);
        sortByMenu.add(eventDateDescending);
        sortByMenu.add(organiserSurnameAscending);
        sortByMenu.add(organiserSurnameDescending);
        //MIGRATE TO PANEL this.add(eventViewerTitle, BorderLayout.NORTH);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(new ButtonPanel(), BorderLayout.SOUTH);
        this.add(new TabPanel(), BorderLayout.CENTER);
    }
    
}
