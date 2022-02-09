/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.model.Item;
import com.tugoflaherty.eventmanager.model.Organiser;
import com.tugoflaherty.eventmanager.view.EventViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
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
            case "editEvent":
                String selectedEventToEdit = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedEventToEdit = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedEventToEdit = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int eventIndexToEdit = eventManager.getSelectedEvent(selectedEventToEdit);
                if (eventIndexToEdit != -1) {
                    JTextField editTitleInputField = new JTextField();
                    JTextField editDateInputField = new JTextField();
                    JTextField editTimeInputField = new JTextField();
                    JTextField editLocationInputField = new JTextField();
                    List<String> editOrganiserNames = new ArrayList();
                    editOrganiserNames.add("No Organiser");
                    for (Organiser organiser : eventManager.getOrganisers())
                    {
                        editOrganiserNames.add(organiser.toString());
                    }
                    Object[] editEventInputFields = {"Date and Time must always be entered together", "New Title:", editTitleInputField, "New Date (YYYY-MM-DD):", editDateInputField, "New Time (24Hr HH:MM):", editTimeInputField, "New Location:", editLocationInputField};
                    int editEvent = JOptionPane.showConfirmDialog(eventViewer, editEventInputFields, "Edit Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (editEvent == JOptionPane.OK_OPTION) {
                        String editTitleTextInput = editTitleInputField.getText().trim();
                        String editDateTextInput = editDateInputField.getText().trim();
                        String editTimeTextInput = editTimeInputField.getText().trim();
                        String editDateTimeTextInput = editDateTextInput+"T"+editTimeTextInput;
                        String editLocationTextInput = editLocationInputField.getText().trim();
                        boolean eventEdited = eventManager.editEventDetails(eventIndexToEdit, editTitleTextInput, editDateTimeTextInput, editLocationTextInput);
                        if (eventEdited == false) {
                            int errorEditingEvent = JOptionPane.showConfirmDialog(eventViewer, "Error editing event. Ensure the Event Date and Time are in the correct format, there are no commas in the Event Title and Location fields, and it is not a duplicate Event. Try again", "Error Editing Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                break;
            case "associateEventOrganiser":
                String selectedEventToSetOrganiser = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedEventToSetOrganiser = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedEventToSetOrganiser = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int eventIndexToSetOrganiser = eventManager.getSelectedEvent(selectedEventToSetOrganiser);
                if (eventIndexToSetOrganiser != -1) {
                    List<String> organiserNamesToSet = new ArrayList();
                    organiserNamesToSet.add("No Organiser");
                    for (Organiser organiser : eventManager.getOrganisers())
                    {
                        organiserNamesToSet.add(organiser.toString());
                    }
                    JComboBox setOrganisersComboBox = new JComboBox(organiserNamesToSet.toArray());
                    Object[] setOrganiserInputFields = {"Organiser:", setOrganisersComboBox};
                    int setOrganiser = JOptionPane.showConfirmDialog(eventViewer, setOrganiserInputFields, "Set Event Organiser", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (setOrganiser == JOptionPane.OK_OPTION) {
                        int setOrganiserIndex = setOrganisersComboBox.getSelectedIndex();
                        if (setOrganiserIndex != 0) {
                            eventManager.associateOrganiserToEvent(eventIndexToSetOrganiser, setOrganiserIndex);
                        }
                        else {
                            eventManager.getEvents().get(eventIndexToSetOrganiser).setOrganiser(null);
                        }
                    }
                }
                break;
            case "deleteItem":
                String selectedItemTextToDelete = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedItemTextToDelete = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedItemTextToDelete = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int[] itemToDelete = eventManager.getSelectedItem(selectedItemTextToDelete);
                if (itemToDelete[0] != -1 && itemToDelete[1] != -1) {
                eventManager.getEvents().get(itemToDelete[0]).getItems().remove(itemToDelete[1]);
                }
                break;
            case "deleteOrganiser":
                String selectedOrganiserTextToDelete = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedOrganiserTextToDelete = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedOrganiserTextToDelete = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int organiserIndexToDelete = eventManager.getSelectedOrganiser(selectedOrganiserTextToDelete);
                if (organiserIndexToDelete != -1) {
                eventManager.getOrganisers().remove(organiserIndexToDelete);
                }
                break;
            case "deleteEvent":
                String selectedTextToDelete = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedTextToDelete = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedTextToDelete = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int eventIndexToDelete = eventManager.getSelectedEvent(selectedTextToDelete);
                if (eventIndexToDelete != -1) {
                eventManager.getEvents().remove(eventIndexToDelete);
                }
                break;
            case "addEvent":
                JTextField titleInputField = new JTextField();
                JTextField dateInputField = new JTextField();
                JTextField timeInputField = new JTextField();
                JTextField locationInputField = new JTextField();
                List<String> organiserNames = new ArrayList();
                organiserNames.add("No Organiser");
                for (Organiser organiser : eventManager.getOrganisers())
                {
                    organiserNames.add(organiser.toString());
                }
                JComboBox organisersComboBox = new JComboBox(organiserNames.toArray());
                Object[] eventInputFields = {"Title:", titleInputField, "Organiser:", organisersComboBox, "Date (YYYY-MM-DD):", dateInputField, "Time (24Hr HH:MM):", timeInputField, "Location:", locationInputField};
                int addEvent = JOptionPane.showConfirmDialog(eventViewer, eventInputFields, "Add Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addEvent == JOptionPane.OK_OPTION) {
                    String titleTextInput = titleInputField.getText().trim();
                    int organiserIndex = organisersComboBox.getSelectedIndex();
                    String dateTextInput = dateInputField.getText().trim();
                    String timeTextInput = timeInputField.getText().trim();
                    String dateTimeTextInput = dateTextInput+"T"+timeTextInput;
                    String locationTextInput = locationInputField.getText().trim();
                    if (!titleTextInput.isEmpty() && !dateTextInput.isEmpty() && !timeTextInput.isEmpty() && !locationTextInput.isEmpty()) {
                        if (organiserIndex !=0) {
                            boolean eventAdded = eventManager.addEvent(titleTextInput, eventManager.getOrganisers().get(organiserIndex-1), dateTimeTextInput, locationTextInput);
                            if (eventAdded == false) {
                                int errorAddEvent = JOptionPane.showConfirmDialog(eventViewer, "Error adding event. Ensure the Event Date and Time are in the correct format, there are no commas in the Item's Title and Location fields, and it is not a duplicate Item. Try again", "Error Adding Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            boolean eventAdded = eventManager.addEvent(titleTextInput, dateTimeTextInput, locationTextInput);
                            if (eventAdded == false) {
                                int errorAddEvent = JOptionPane.showConfirmDialog(eventViewer, "Error adding event. Ensure the Event Date and Time are in the correct format, there are no commas in the Item's Title and Location fields, and it is not a duplicate Item. Try again", "Error Adding Event", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else {
                        int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "addItem":
                String selectedText = "";
                if (eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedText = eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().getSelectedText().trim();
                }
                if (eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText() != null) {
                    selectedText = eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().getSelectedText().trim();
                }
                int eventIndex = eventManager.getSelectedEvent(selectedText);
                if (eventIndex != -1) {
                    JTextField startTimeInputField = new JTextField();
                    JTextField itemTitleInputField = new JTextField();
                    Object[] itemInputFields = {"Start Time (24Hr HH:MM):", startTimeInputField, "Item Title:", itemTitleInputField};
                    int addItem = JOptionPane.showConfirmDialog(eventViewer, itemInputFields, "Add Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (addItem == JOptionPane.OK_OPTION) {
                        String startTimeTextInput = startTimeInputField.getText().trim();
                        String itemTitleTextInput = itemTitleInputField.getText().trim();
                        if (!startTimeTextInput.isEmpty() && !itemTitleTextInput.isEmpty()) {
                            boolean itemAdded = eventManager.addItemsToEvent(eventIndex, startTimeTextInput, itemTitleTextInput);
                            if (itemAdded == false) {
                                int errorAddItem = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure the Item Start Date is in the correct format, there are no commas in the Item's Title field, and it is not a duplicate Item. Try again", "Error Adding Item", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            int errorAddOrganiser = JOptionPane.showConfirmDialog(eventViewer, "Error adding item. Ensure no fields are empty. Try again", "Error Adding Organiser", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                break;
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
