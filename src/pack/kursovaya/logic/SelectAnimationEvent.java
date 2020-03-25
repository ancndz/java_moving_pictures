package pack.kursovaya.logic;

import pack.kursovaya.app.CenterPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectAnimationEvent implements ListSelectionListener {

    private CenterPanel centerPanel;

    public SelectAnimationEvent(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    //метод для определения выбраной позиции списка
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

        String gifName = (String) ((JList<?>) listSelectionEvent.getSource()).getSelectedValue();

        this.centerPanel.setGifName(gifName);

        this.centerPanel.changeGifPack();

    }
}
