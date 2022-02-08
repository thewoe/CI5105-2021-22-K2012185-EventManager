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

    public TextAreaPanel getHierarchalPanel() {
        return hierarchalPanel;
    }

    public void setHierarchalPanel(TextAreaPanel hierarchalPanel) {
        this.hierarchalPanel = hierarchalPanel;
    }
    
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    public void setTabPane(JTabbedPane tabPane) {
        this.tabPane = tabPane;
    }
    
    public TextAreaPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    public void setTextAreaPanel(TextAreaPanel textAreaPanel) {
        this.textAreaPanel = textAreaPanel;
    }
    
    public TabPanel() {
        this.setLayout(new BorderLayout());
        tabPane.add("Text View",textAreaPanel);
        tabPane.add("Hierarchal View",hierarchalPanel);
        this.add(tabPane,BorderLayout.CENTER);
    }
    
}
