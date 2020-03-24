package java.kursovaya.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.kursovaya.app.CenterPanel;
import java.kursovaya.app.LeftPanel;

public class ButtonEvent implements ActionListener {

    private LeftPanel leftPanel;
    private CenterPanel centerPanel;

    public ButtonEvent(CenterPanel centerPanel, LeftPanel leftPanel) {
        this.centerPanel = centerPanel;
        this.leftPanel = leftPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //установка параметров
        centerPanel.setParams(leftPanel.getParams());
        centerPanel.setBorders(leftPanel.getBorders());
        //пересчет с выбранными параметрами
        //centerPanel.getChart().getXYPlot().setDataset(centerPanel.makeDataSet());
        //обновление отображаемой формулы
        leftPanel.setFormulaLabel(centerPanel.getFunctionName(), centerPanel.getCoefA(), centerPanel.getCoefB(), centerPanel.getCoefC());
    }
}
