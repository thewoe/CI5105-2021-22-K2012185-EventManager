/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.model.EventManager;
import com.tugoflaherty.eventmanager.view.EventViewer;

/**
 *
 * @author tugso
 */
public class EventManagerController {
    public static void main(String[] args) {
        EventManager eventManager = EventManager.getInstance();
        eventManager.initialiseModelDeleteOrganisers();
        eventManager.loadState();
        EventViewer eventViewer = EventViewer.getInstance();
        eventManager.modelModified();
        //eventViewer.getTabPanel().getTextAreaPanel().getTextAreaPanel().setText(eventManager.textViewData());
        //eventViewer.getTabPanel().getHierarchalPanel().getTextAreaPanel().setText(eventManager.hierarchalViewData());
    }
}
