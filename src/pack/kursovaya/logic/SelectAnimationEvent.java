package pack.kursovaya.logic;

import pack.kursovaya.app.CenterPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectAnimationEvent implements ListSelectionListener {

    private CenterPanel centerPanel;

    private String gifName = "Walking";

    public SelectAnimationEvent(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }


    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

        this.gifName = (String) ((JList<?>)listSelectionEvent.getSource()).getSelectedValue();

        this.centerPanel.setGifName(this.gifName);

    }
}
