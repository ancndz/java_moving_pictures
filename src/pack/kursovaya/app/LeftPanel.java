package pack.kursovaya.app;

import pack.kursovaya.logic.RadioButtonEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class LeftPanel extends JPanel {

    //радио кнопки для выбора функции
    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton radio3;
    JRadioButton radio4;


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
        add(new JLabel("Анимации:"), layConstraints);

        radio1 = new JRadioButton("Ходьба");
        layConstraints = getGridBagConstraints(1);
        radio1.setSelected(true);
        add(radio1, layConstraints);

        radio2 = new JRadioButton("Бег");
        layConstraints = getGridBagConstraints(2);
        add(radio2, layConstraints);

        radio3 = new JRadioButton("Приседания");
        layConstraints = getGridBagConstraints(3);
        add(radio3, layConstraints);


        radio4 = new JRadioButton("Сигнал");
        layConstraints = getGridBagConstraints(4);
        add(radio4, layConstraints);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        buttonGroup.add(radio4);

        buttonGroup.getElements();

    }
    private static final long serialVersionUID = 1L;

    public void setRadioEvent(RadioButtonEvent radioEvent) {
        this.radio1.addActionListener(radioEvent);
        this.radio2.addActionListener(radioEvent);
        this.radio3.addActionListener(radioEvent);
        this.radio4.addActionListener(radioEvent);
    }
}
