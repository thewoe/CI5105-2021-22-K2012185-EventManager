/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author tugso
 */
public class TextAreaPanel extends JPanel {
    
    private JTextArea textAreaPanel = new JTextArea();
    private JScrollPane textAreaScrollPane = new JScrollPane(textAreaPanel);
    
    public TextAreaPanel() {
        this.setLayout(new BorderLayout());
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        this.add(textAreaScrollPane);
    }
    
    public TextAreaPanel(String eventText) {
        this.setLayout(new BorderLayout());
        this.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        this.textAreaPanel.setText(eventText);
        this.add(textAreaScrollPane);
    }
    
}
