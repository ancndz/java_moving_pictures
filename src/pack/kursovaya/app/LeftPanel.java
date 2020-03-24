package pack.kursovaya.app;

import pack.kursovaya.logic.RadioButtonEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class LeftPanel extends JPanel {

    //Lis

    //настройка области с элементами
    private GridBagConstraints getGridBagConstraints(int row) {
        GridBagConstraints layConstraints = new GridBagConstraints();
        layConstraints.fill = GridBagConstraints.BOTH; // заполняет ячейку целиком
        layConstraints.gridwidth = 0;
        layConstraints.gridx = 0; // координаты ячейки,
        layConstraints.gridy = row; // в которую помещается кнопка
        return layConstraints;
    }

    LeftPanel() {

        GridBagConstraints layConstraints;
        setBorder(new EmptyBorder(10, 10, 10, 30)); // отступ внутри панели на 4 пикселя со всех сторон
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23}; // высоты кнопок
        layout.columnWeights = new double[]{1.0};
        layout.rowWeights = new double[25];
        setLayout(layout);

        layConstraints = getGridBagConstraints(0);
        add(new JLabel("Animations:"), layConstraints);



    }
    private static final long serialVersionUID = 1L;

    public void setRadioEvent(RadioButtonEvent radioEvent) {
    }
}
