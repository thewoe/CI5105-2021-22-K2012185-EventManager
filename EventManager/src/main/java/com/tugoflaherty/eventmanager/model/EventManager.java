/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.model;

import com.tugoflaherty.eventmanager.view.EventViewer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author tugoflaherty
 */
public class EventManager implements Serializable {

    private static EventManager INSTANCE = new EventManager();
    private List<Event> events = new ArrayList();
    private List<Item> items = new ArrayList();
    private List<Organiser> organisers = new ArrayList();
    
    /**
     * This method is a getter to return the events attribute as type List of Event objects
     * It takes in no parameters
     * @return This returns the events of type List of Event objects
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * This method is a setter to set the value of the events attribute using a value of type List of Event objects
     * It does not return a value
     * @param events This is the value of the events attribute to be set of type List of Event objects
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * This method is a getter to return the items attribute as type List of Item objects
     * It takes in no parameters
     * @return This returns the items of type List of Item objects
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * This method is a setter to set the value of the items attribute using a value of type List of Item objects
     * It does not return a value
     * @param items This is the value of the items attribute to be set of type List of Item objects
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * This method is a getter to return the organisers attribute as type List of Organiser objects
     * It takes in no parameters
     * @return This returns the organisers of type List of Organiser objects
     */
    public List<Organiser> getOrganisers() {
        return organisers;
    }

    /**
     * This method is a setter to set the value of the organisers attribute using a value of type List of Organiser objects
     * It does not return a value
     * @param organisers This is the value of the organisers attribute to be set of type List of Organiser objects
     */
    public void setOrganisers(List<Organiser> organisers) {
        this.organisers = organisers;
    }
    
    private EventManager() {
        //insert observer thingy
        //inset initialisation for events, organisers, and put in relevant arraylist
    }
    
    public static EventManager getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new EventManager();
            //System.out.println("New EventManager instance created");
        }
        //System.out.println("Using the first EventManager instance created");
        return INSTANCE;
    }
    
    public boolean addEvent(String title, Organiser organiser, String dateTime, String location, List<Item> items) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, organiser, dateTime, location, items);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    public boolean addEvent(String title, Organiser organiser, String dateTime, String location) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, organiser, dateTime, location);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    public boolean addEvent(String title, String dateTime, String location) {
        if (!title.contains(",") && !location.contains(",")) {
            Event newEvent = new Event(title, dateTime, location);
            if (!this.getEvents().contains(newEvent)) {
                return this.getEvents().add(newEvent);
            }
        }
        return false;
    }
    
    public boolean deleteEvent(int eventIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().remove(eventIndex);
            return true;
        }
        return false;
    }
    
    public boolean addItem(String startTime, String itemTitle) {
        if (!itemTitle.contains(",")) {
            Item newItem = new Item(startTime, itemTitle);
            if (!this.getItems().contains(newItem)) {
                return this.getItems().add(newItem);
            }
        }
        return false;
    }
    
    public boolean deleteItem(int itemIndex) {
        if (this.getItems().size() > 0 && this.getItems().size() >= itemIndex) {
            this.getItems().remove(itemIndex);
            return true;
        }
        return false;
    }
    
    public boolean addOrganiser(String firstName, String lastName) {
        if (!firstName.contains(",") && !lastName.contains(",")) {
            Organiser newOrganiser = new Organiser(firstName, lastName);
            if (!this.getOrganisers().contains(newOrganiser)) {
                return this.getOrganisers().add(newOrganiser);
            }
        }
        return false;
    }
    
    public boolean deleteOrganiser(int organiserIndex) {
        if (this.getOrganisers().size() > 0 && this.getOrganisers().size() >= organiserIndex) {
            this.getOrganisers().remove(organiserIndex);
            return true;
        }
        return false;
    }
    
    public boolean associateOrganiserToEvent(int eventIndex, int organiserIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex && this.getOrganisers().size() > 0 && this.getOrganisers().size() >= organiserIndex) {
            Event selectedEvent = this.getEvents().get(eventIndex);
            Organiser selectedOrganiser = this.getOrganisers().get(organiserIndex);
            selectedEvent.setOrganiser(selectedOrganiser);
            return true;
        }
        return false;
    }
    
    public boolean addItemsToEvent(int eventIndex) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().get(eventIndex).setItems(new ArrayList<Item>(this.getItems()));
            this.getItems().clear();
            return true;
        }
        return false;
    }
    
    public boolean addItemsToEvent(int eventIndex, String startTime, String itemTitle) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            this.getEvents().get(eventIndex).addItem(new Item(startTime,itemTitle));
            return true;
        }
        return false;
    }
    
    public boolean editEventDetails(int eventIndex, String title, String dateTime, String location) {
        if (this.getEvents().size() > 0 && this.getEvents().size() >= eventIndex) {
            Event selectedEvent = this.getEvents().get(eventIndex);
            if (title.equals("") && dateTime.equals("") && location.equals("")) {
                return false;
            }
            else {
                if (!title.equals("")) {
                    selectedEvent.setTitle(title);
                }
                if (!dateTime.equals("T")) {
                    selectedEvent.setDateTime(dateTime);
                }
                if (!location.equals("")) {
                    selectedEvent.setLocation(location);
                }
                return true;
            }
        }
        return false;
    }
    
    public void readConfigFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String fileList[] = line.trim().split(",");
                this.readOrganisersFile(fileList[0]);
                this.readEventsFile(fileList[1]);
                this.readItemsFile(fileList[2]);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Config file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void readOrganisersFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String organiserList[] = line.trim().split(",");
                this.addOrganiser(organiserList[0],organiserList[1]);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Organisers file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void readEventsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String eventList[] = line.trim().split(",");
                if (eventList[1].equals("null") ) {
                    this.addEvent(eventList[0],eventList[2],eventList[3]);
                }
                else {
                    this.addEvent(eventList[0],this.getOrganisers().get(Integer.parseInt(eventList[1])),eventList[2],eventList[3]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Events file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void readItemsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(filePath))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String itemList[] = line.trim().split(",");
                if (itemList.length !=0 && !itemList[0].equals("")) {
                    this.addItemsToEvent(Integer.parseInt(itemList[0]),itemList[1],itemList[2]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading Items file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void writeConfigFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+".csv"))) {
            String line = filePath+"Organisers.csv,"+filePath+"Events.csv,"+filePath+"Items.csv";
            bWriter.write(line);
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Config file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void writeOrganisersFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Organisers.csv"))) {
            for (int i=0; i<this.getOrganisers().size(); i++) {
                String line = this.getOrganisers().get(i).getFirstName() + "," + this.getOrganisers().get(i).getLastName();
                bWriter.write(line);
                if (i != this.getOrganisers().size() - 1) {
                    bWriter.newLine();
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Organisers file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void writeEventsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Events.csv"))) {
            for (int i=0; i<this.getEvents().size(); i++) {
                if (this.getEvents().get(i).getOrganiser() != null) {
                    String line = this.getEvents().get(i).getTitle() + "," + this.getOrganisers().indexOf(this.getEvents().get(i).getOrganiser()) + "," + this.getEvents().get(i).getDateTime().toString() + "," + this.getEvents().get(i).getLocation();
                    bWriter.write(line);
                }
                else {
                    String line = this.getEvents().get(i).getTitle() + "," + "null" + "," + this.getEvents().get(i).getDateTime().toString() + "," + this.getEvents().get(i).getLocation();
                    bWriter.write(line);
                }
                if (i != this.getEvents().size() - 1) {
                    bWriter.newLine();
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Events file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void writeItemsFile(String filePath) {	  		 	  	 	        	     	
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath+"Items.csv"))) {
            for (int i=0; i<this.getEvents().size(); i++) {
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    if (!this.getEvents().get(i).getItems().isEmpty()) {
                        String line = i + "," + this.getEvents().get(i).getItems().get(j).getStartTime().toString() + "," + this.getEvents().get(i).getItems().get(j).getItemTitle();
                        bWriter.write(line);
                    }
                    //if ((!this.getEvents().get(i).getItems().isEmpty()) && (i != this.getEvents().size()-1) && (j != this.getEvents().get(this.getEvents().size()-1).getItems().size()-1)) {
                        bWriter.newLine();
                    //}
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing Items file");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
    }
    
    public void saveState(String lastSavedPath) {
        try(BufferedWriter bWriter = new BufferedWriter(new FileWriter("_EventManagerLastOpenedState_.csv"))) {
            if (!lastSavedPath.isBlank()) {
                String line = lastSavedPath + ".csv";
                bWriter.write(line);
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error writing State file");	 	  	 	        	     	
        }
        //try write file to "EventManagerState.csv"
        //Write lastSavedPTH to EventManagerState.csv
        //call just before application exit in eventviewercontroller
    }
    
    public void loadState() {
        try(BufferedReader bReader = new BufferedReader(new FileReader("_EventManagerLastOpenedState_.csv"))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String fileList[] = line.trim().split(",");
                if (!fileList[0].isBlank()) {
                    this.readConfigFile(fileList[0]);
                }
            }
        }	  		 	  	 	        	     	
        catch (Exception o) {
            System.out.println("Error reading State file");	 	  	 	        	     	
        }
        //try read file from "EventManagerState.csv"
        //Read "EventMangerState.csv" and put into state variable
        //Call readConfigFile with state variable
        //Call the above method when application is first run, to initialise the model
    }
    
    public String textViewData() {
        String textViewString = "";
        for (int i=0; i<this.getEvents().size(); i++) {
            Event currentEvent = this.getEvents().get(i);
            //System.out.println(currentEvent.toString());
            textViewString = textViewString + (i+1) + " " + currentEvent.getTitle();
            if (currentEvent.getOrganiser() != null) {
                textViewString = textViewString + " organised by " + currentEvent.getOrganiser().getFirstName() + " " + currentEvent.getOrganiser().getLastName();
            }
            String dateTime = currentEvent.getDateTime().toString();
            String[] dateTimeArray = dateTime.split("T");
            textViewString = textViewString + " at " + dateTimeArray[0] + " at " + dateTimeArray[1] + " in " + currentEvent.getLocation();
            if (!currentEvent.getItems().isEmpty()) {
                textViewString = textViewString + " with agenda: ";
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    Item currentItem = this.getEvents().get(i).getItems().get(j);
                    textViewString = textViewString + currentItem.getStartTime().toString() + " - " + currentItem.getItemTitle();
                    if (j != this.getEvents().get(i).getItems().size() - 1) {
                        textViewString = textViewString + ", ";
                    }
                    else if (j == this.getEvents().get(i).getItems().size() - 1) {
                        textViewString = textViewString + System.lineSeparator();
                    }
                }
            }
            else {
                textViewString = textViewString + System.lineSeparator();
            }
        }
        return textViewString;
    }
    
    public String hierarchalViewData() {
        String hierarchalViewString = "";
        for (int i=0; i<this.getEvents().size(); i++) {
            Event currentEvent = this.getEvents().get(i);
            //System.out.println(currentEvent.toString());
            hierarchalViewString = hierarchalViewString + currentEvent.getTitle();
            if (currentEvent.getOrganiser() != null) {
                hierarchalViewString = hierarchalViewString + " organised by " + currentEvent.getOrganiser().getFirstName() + " " + currentEvent.getOrganiser().getLastName();
            }
            String dateTime = currentEvent.getDateTime().toString();
            String[] dateTimeArray = dateTime.split("T");
            hierarchalViewString = hierarchalViewString + " at " + dateTimeArray[0] + " at " + dateTimeArray[1] + " in " + currentEvent.getLocation() + System.lineSeparator();
            if (!currentEvent.getItems().isEmpty()) {
                for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                    Item currentItem = this.getEvents().get(i).getItems().get(j);
                    hierarchalViewString = hierarchalViewString + "    " + currentItem.getStartTime().toString() + " - " + currentItem.getItemTitle() + System.lineSeparator();
                    if (j == this.getEvents().get(i).getItems().size() - 1) {
                        hierarchalViewString = hierarchalViewString + System.lineSeparator();
                    }
                }
            }
            else {
                hierarchalViewString = hierarchalViewString + System.lineSeparator();
            }
        }
        return hierarchalViewString;
    }
    
    public int getSelectedEvent(String selectedText) {
        String searchableText = selectedText.trim();
        int index = -1;
        for (int i=0; i<this.getEvents().size(); i++) {
            if (searchableText.equals(this.getEvents().get(i).getTitle())) {
               index = i;
               break;
            }
        }
        return index;
    }
    
    public int getSelectedOrganiser(String selectedText) {
        int index = -1;
        String searchableText = selectedText.trim();
        String[] organiserDetails = searchableText.split(" ");
        Organiser comparableOrganiser = new Organiser(organiserDetails[0], organiserDetails[1]);
        for (int i=0; i<this.getOrganisers().size(); i++) {
            if (comparableOrganiser.equals(this.getOrganisers().get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int[] getSelectedItem(String selectedText) {
        int[] selectedItemLocation = new int[2];
        selectedItemLocation[0] = -1;
        selectedItemLocation[1] = -1;
        String searchableText = selectedText.trim();
        String[] itemDetails = searchableText.split("-");
        System.out.println(itemDetails[0]+itemDetails[1]);
        Item comparableItem = new Item(itemDetails[0].trim(), itemDetails[1].trim());
        for (int i=0; i<this.getEvents().size(); i++) {
            for (int j=0; j<this.getEvents().get(i).getItems().size(); j++) {
                if (comparableItem.equals(this.getEvents().get(i).getItems().get(j))) {
                    selectedItemLocation[0] = i;
                    selectedItemLocation[1] = j;
                    return selectedItemLocation;
                }
            }
        }
        System.out.println(selectedItemLocation[0] + " " + selectedItemLocation[1]);
        return selectedItemLocation;
    }
    
    public boolean editItem(int eventIndex, int itemIndex, String startTime, String itemTitle) {
        Item itemToEdit = this.getEvents().get(eventIndex).getItems().get(itemIndex);
        if (itemToEdit != null) {
            if (!startTime.equals("")) {
                itemToEdit.setStartTime(startTime);
            }
            if (!itemTitle.equals("")) {
                itemToEdit.setItemTitle(itemTitle);
            }
            return true;
        }
        return false;
    }
    
    public boolean editOrganiser(int organiserIndex, String firstName, String lastName) {
        Organiser organiserToEdit = this.getOrganisers().get(organiserIndex);
        if (organiserToEdit != null) {
            if (!firstName.equals("")) {
                organiserToEdit.setFirstName(firstName);
            }
            if (!lastName.equals("")) {
                organiserToEdit.setLastName(lastName);
            }
            return true;
        }
        return false;
    }
    
    public void sortEventsByEventTitleAscending(){
        Collections.sort(this.getEvents(), Event.BY_EVENTTITLE);
    }
    
    public void sortEventsByEventTitleDescending() {
        Collections.sort(this.getEvents(), Event.BY_EVENTTITLE);
        Collections.reverse(this.getEvents());
    }
    
    public void sortEventsByDateTimeAscending() {
        Collections.sort(this.getEvents(), Event.BY_DATE);
    }
    
    public void sortEventsByDateTimeDescending() {
        Collections.sort(this.getEvents(), Event.BY_DATE);
        Collections.reverse(this.getEvents());
    }
    
    public void sortItemsByStartTime() {
        for (int i=0; i<this.getEvents().size(); i++)
        {
            Collections.sort(this.getEvents().get(i).getItems(), Item.BY_TIME);
        }
    }
    
    public void modelModified() {
        EventViewer eventViewer = EventViewer.getInstance();
        eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().setText(this.textViewData());
        eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().setText(this.hierarchalViewData());
    }
    
    public void initialiseModelKeepOrganisers() {
        this.getEvents().clear();
        this.getItems().clear();
    }
    
    public void initialiseModelDeleteOrganisers() {
        this.getEvents().clear();
        this.getItems().clear();
        this.getOrganisers().clear();
    }
}
