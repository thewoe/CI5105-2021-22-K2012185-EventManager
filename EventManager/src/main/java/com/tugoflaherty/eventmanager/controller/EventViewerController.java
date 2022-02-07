/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.eventmanager.controller;

import com.tugoflaherty.eventmanager.view.EventViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tugso
 */
public class EventViewerController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand()); //(un)comment for testing JButtons/JMenuItems
        EventViewer eventViewer = EventViewer.getInstance();
        switch (ae.getActionCommand()) {
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
