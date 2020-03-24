package pack.kursovaya.logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pack.kursovaya.app.CenterPanel;
import pack.kursovaya.app.LeftPanel;

public class RadioButtonEvent implements ActionListener {

    private CenterPanel centerPanel;
    private LeftPanel leftPanel;

    private String functionName = "Прямая";
    //private ChangeFunc.Functions function = ChangeFunc.Functions.LINE;

    public RadioButtonEvent(CenterPanel centerPanel, LeftPanel leftPanel) {
        this.centerPanel = centerPanel;
        this.leftPanel = leftPanel;
    }

    @Override
    public void actionPerformed(ActionEvent arg) {

        //получаем название радиокнопки, это название нашей функции
        AbstractButton aButton = (AbstractButton) arg.getSource();
        this.functionName = aButton.getText();

        //объект класса ChangeFunc для смены функции
        //ChangeFunc changeFunc = new ChangeFunc();
        //this.function = changeFunc.compare(this.functionName);

        //применяем полученые значения к функции и названию
        //centerPanel.setFunction(this.function);
        centerPanel.setFunctionName(this.functionName);

        //пересчет данных с новой функцией
        //centerPanel.getChart().getXYPlot().setDataset(centerPanel.makeDataSet());

        //отображение формулы
        //leftPanel.setFormulaLabel(centerPanel.getFunctionName(), centerPanel.getCoefA(), centerPanel.getCoefB(), centerPanel.getCoefC());

    }


}
