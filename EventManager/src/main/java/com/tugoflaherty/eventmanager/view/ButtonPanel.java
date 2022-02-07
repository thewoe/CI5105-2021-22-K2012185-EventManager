/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tugso
 */
public class ButtonPanel extends JPanel {
    
    private JButton addEvent = new JButton("New Event");
    private JButton addItem = new JButton("New Event Item");
    private JButton deleteEvent = new JButton("Delete Event");
    
    public ButtonPanel() {
        this.setLayout(new FlowLayout());
        addEvent.setPreferredSize(new Dimension(150, 25));
        addItem.setPreferredSize(new Dimension(150, 25));
        deleteEvent.setPreferredSize(new Dimension(150, 25));
        this.add(addEvent);
        this.add(addItem);
        this.add(deleteEvent);
    }
    
}