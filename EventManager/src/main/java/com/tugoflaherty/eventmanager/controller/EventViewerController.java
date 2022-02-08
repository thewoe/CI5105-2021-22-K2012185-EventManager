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
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tugso
 */
public class EventViewerController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand()); //(un)comment for testing JButtons/JMenuItems
        EventManager eventManager = EventManager.getInstance();
        EventViewer eventViewer = EventViewer.getInstance();
        switch (ae.getActionCommand()) {
            case "addOrganiser":
                JTextField firstNameInputField = new JTextField();
                JTextField surnameInputField = new JTextField();
                Object[] organiserInputFields = {"First Name:", firstNameInputField, "Surname:", surnameInputField};
                int addOrganiser = JOptionPane.showConfirmDialog(eventViewer, organiserInputFields, "Add Organiser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addOrganiser == JOptionPane.OK_OPTION) {
                    String firstNameTextInput = firstNameInputField.getText().trim();
                    String surnameTextInput = surnameInputField.getText().trim();
                    if (!firstNameTextInput.isEmpty() && !surnameTextInput.isEmpty()) {
                        boolean organiserAdded = eventManager.addOrganiser(firstNameTextInput, surnameTextInput);
                        if (organiserAdded == false) {
                            int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding organiser. Ensure there are no commas in the Organiser's First Name and Surname fields and it is not a duplicate organiser. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding organiser. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "saveFile":
                JFileChooser saveFileChooser = new JFileChooser();
                FileNameExtensionFilter saveFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                saveFileChooser.setFileFilter(saveFileFilter);
                int saveFileOption = saveFileChooser.showSaveDialog(eventViewer);
                if (saveFileOption == JFileChooser.APPROVE_OPTION) {
                    File fileToSave;
                    String saveFilePath;
                    fileToSave = saveFileChooser.getSelectedFile();
                    saveFilePath = fileToSave.getAbsolutePath();
                    eventManager.writeConfigFile(saveFilePath);
                    eventManager.writeOrganisersFile(saveFilePath);
                    eventManager.writeEventsFile(saveFilePath);
                    eventManager.writeItemsFile(saveFilePath);
                    eventManager.saveState(saveFilePath);
                    System.out.println("Config File Path: " + saveFilePath);
                }
                break;
            case "openFile":
                int continueOpeningFile = JOptionPane.showConfirmDialog(eventViewer, "Opening a file will erase all Organisers, Events, and Event Items unless they have already been saved. Continue?", "Continue to Open File", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (continueOpeningFile == JOptionPane.YES_OPTION) {
                    eventManager.initialiseManager();
                    JFileChooser openFileChooser = new JFileChooser();
                    FileNameExtensionFilter openFileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                    openFileChooser.setFileFilter(openFileFilter);
                    int openFileOption = openFileChooser.showOpenDialog(eventViewer);
                    if (openFileOption == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = openFileChooser.getSelectedFile();
                        String openFilePath = fileToOpen.getAbsolutePath();
                        eventManager.readConfigFile(openFilePath);
                        System.out.println("Config File Path: " + openFilePath);
                    }
                }
                break;
            case "textView":
                eventViewer.getTabPanel().getTabPane().setSelectedIndex(0);
                break;
            case "hierarchalView":
                eventViewer.getTabPanel().getTabPane().setSelectedIndex(1);
                break;
            case "tableView":
                eventViewer.getTabPanel().getTabPane().setSelectedIndex(2);
                break;
            case "quitApplication":
                System.exit(0);
                break;
            default:
                break;
                
        }
    }
}
