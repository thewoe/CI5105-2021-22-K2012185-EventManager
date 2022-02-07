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
    private TextAreaPanel textAreaPanel = new TextAreaPanel();
    private TextAreaPanel hierarchalPanel = new TextAreaPanel();
    private TablePanel tablePanel = new TablePanel();
    
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    public void setTabPane(JTabbedPane tabPane) {
        this.tabPane = tabPane;
    }
    
    public TabPanel() {
        this.setLayout(new BorderLayout());
        tabPane.add("Text View",textAreaPanel);
        tabPane.add("Hierarchal View",hierarchalPanel);
        tabPane.add("Table View",tablePanel);
        this.add(tabPane,BorderLayout.CENTER);
    }
    
}
