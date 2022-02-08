/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.view.EventViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author tugso
 */
public class ButtonPanelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand()); //(un)comment for testing JButtons/JMenuItems
        EventManager eventManager = EventManager.getInstance();
        EventViewer eventViewer = EventViewer.getInstance();
        switch (ae.getActionCommand()) {
            case "addItem":
                JTextField startTimeInputField = new JTextField();
                JTextField itemTitleInputField = new JTextField();
                Object[] itemInputFields = {"Start Time (24Hr HH:MM):", startTimeInputField, "Item Title:", itemTitleInputField};
                int addItem = JOptionPane.showConfirmDialog(eventViewer, itemInputFields, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addItem == JOptionPane.OK_OPTION) {
                    String startTimeTextInput = startTimeInputField.getText().trim();
                    String itemTitleTextInput = itemTitleInputField.getText().trim();
                    if (!startTimeTextInput.isEmpty() && !itemTitleTextInput.isEmpty()) {
                        boolean itemAdded = eventManager.addItem(startTimeTextInput, itemTitleTextInput);
                        if (itemAdded == false) {
                            int errorAddItem = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure the Item Start Date is in the correct format, there are no commas in the Item's Title field, and it is not a duplicate Item. Try again", "Error Adding Item", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
        }
    }
}