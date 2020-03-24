package pack.kursovaya.logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pack.kursovaya.app.CenterPanel;

public class RadioButtonEvent implements ActionListener {

    private CenterPanel centerPanel;

    private String gifName = "Walking";

    public RadioButtonEvent(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    @Override
    public void actionPerformed(ActionEvent arg) {

        AbstractButton aButton = (AbstractButton) arg.getSource();
        //получаем название радиокнопки, это название нашей функции
        this.gifName = aButton.getText();

        //объект класса ChangeFunc для смены функции
        //ChangeFunc changeFunc = new ChangeFunc();
        //this.function = changeFunc.compare(this.functionName);

        //применяем полученые значения к функции и названию
        //centerPanel.setFunction(this.function);
        centerPanel.setGifName(this.gifName);

        //пересчет данных с новой функцией
        //centerPanel.getChart().getXYPlot().setDataset(centerPanel.makeDataSet());

        //отображение формулы
        //leftPanel.setFormulaLabel(centerPanel.getFunctionName(), centerPanel.getCoefA(), centerPanel.getCoefB(), centerPanel.getCoefC());

    }


}
