/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author tugso
 */
public class TabPanel extends JPanel {
    
    private JTabbedPane tabPane = new JTabbedPane();
    private TextAreaPanel textAreaPanel0 = new TextAreaPanel();
    private TextAreaPanel textAreaPanel1 = new TextAreaPanel();
    private TextAreaPanel textAreaPanel2 = new TextAreaPanel();
    
    public TabPanel() {
        this.setLayout(new BorderLayout());
        tabPane.add("Text View",textAreaPanel0);
        tabPane.add("Hierarchal View",textAreaPanel1);
        tabPane.add("Table View",textAreaPanel2);
        this.add(tabPane,BorderLayout.NORTH);
    }
    
}
