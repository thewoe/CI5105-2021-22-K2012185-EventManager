/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author tugso
 */
public class TablePanel extends JPanel {
    
    JTable table = new JTable();
    JScrollPane tableScrollPane = new JScrollPane(table);
    
    public TablePanel() {
        this.setLayout(new BorderLayout());
        this.add(tableScrollPane);
    }
    
    
}
