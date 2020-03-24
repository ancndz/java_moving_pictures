package java.kursovaya.app;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.kursovaya.logic.RadioButtonEvent;


public class LeftPanel extends JPanel {

    //поле с формулой
    JLabel formulaLabel;

    //поля с границами
    JTextField leftBorderArea;
    JTextField rightBorderArea;

    //поля, куда вводить коэффициенты
    JTextField coefArea;
    JTextField shiftXArea;
    JTextField shiftYArea;
    //кнопка, что бы применить эти коэффициенты
    JButton okButton;

    //радио кнопки для выбора функции
    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton radio3;
    JRadioButton radio4;

    public JButton getOkButton() {
        return okButton;
    }

    //метод для создания массива параметров из полей (числа вводятся через ТОЧКУ)
    public double[] getParams() {
        return new double[] {
                Double.parseDouble(coefArea.getText()),
                Double.parseDouble(shiftXArea.getText()),
                Double.parseDouble(shiftYArea.getText())
        };
    }

    public double[] getBorders() {
        return new double[] {
                Double.parseDouble(leftBorderArea.getText()),
                Double.parseDouble(rightBorderArea.getText()),
        };
    }

    //метод для отображения выбраной функции с установленными параметрами
    public void setFormulaLabel(String formulaName, double coefA, double coefB, double coefC) {
        switch (formulaName) {
            case "Парабола":
                this.formulaLabel.setText(coefA + " * x^2 + " + coefB + " * x + " + coefC);
                break;
            case "Гипербола":
                this.formulaLabel.setText(coefA + " * x^3 + " + coefB + " * x^2 + " + coefC + " * x");
                break;
            case "Квадратный корень":
                this.formulaLabel.setText(coefA + " * sqrt(" + coefB + " + x) + " + coefC);
                break;
            default:
                this.formulaLabel.setText(coefA + " * x + " + coefB);
                break;
        }
    }

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
        add(new JLabel("Функции:"), layConstraints);

        radio1 = new JRadioButton("Прямая");
        layConstraints = getGridBagConstraints(1);
        radio1.setSelected(true);
        add(radio1, layConstraints);

        radio2 = new JRadioButton("Парабола");
        layConstraints = getGridBagConstraints(2);
        add(radio2, layConstraints);

        radio3 = new JRadioButton("Гипербола");
        layConstraints = getGridBagConstraints(3);
        add(radio3, layConstraints);


        radio4 = new JRadioButton("Квадратный корень");
        layConstraints = getGridBagConstraints(4);
        add(radio4, layConstraints);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        buttonGroup.add(radio4);

        buttonGroup.getElements();

        JLabel coef = new JLabel();
        coef.setText("Введите коэффициент A:");
        layConstraints = getGridBagConstraints(6);
        add(coef, layConstraints);

        coefArea = new JTextField();
        coefArea.setText("1");
        layConstraints = getGridBagConstraints(7);
        add(coefArea, layConstraints);


        JLabel shiftX = new JLabel();
        shiftX.setText("Введите коэффициент B:");
        layConstraints = getGridBagConstraints(9);
        add(shiftX, layConstraints);

        shiftXArea = new JTextField();
        shiftXArea.setText("0");
        layConstraints = getGridBagConstraints(10);
        add(shiftXArea, layConstraints);

        JLabel shiftY = new JLabel();
        shiftY.setText("Введите коэффициент C:");
        layConstraints = getGridBagConstraints(12);
        add(shiftY, layConstraints);

        shiftYArea = new JTextField();
        shiftYArea.setText("0");
        layConstraints = getGridBagConstraints(13);
        add(shiftYArea, layConstraints);

        JLabel leftBorder = new JLabel();
        leftBorder.setText("Введите левую границу:");
        layConstraints = getGridBagConstraints(15);
        add(leftBorder, layConstraints);

        leftBorderArea = new JTextField();
        leftBorderArea.setText("-100");
        layConstraints = getGridBagConstraints(16);
        add(leftBorderArea, layConstraints);

        JLabel rightBorder = new JLabel();
        rightBorder.setText("Введите правую границу:");
        layConstraints = getGridBagConstraints(18);
        add(rightBorder, layConstraints);

        rightBorderArea = new JTextField();
        rightBorderArea.setText("100");
        layConstraints = getGridBagConstraints(19);
        add(rightBorderArea, layConstraints);

        JLabel fLabel = new JLabel();
        layConstraints = getGridBagConstraints(21);
        fLabel.setText("Функция:");
        add(fLabel, layConstraints);

        formulaLabel = new JLabel();
        layConstraints = getGridBagConstraints(22);
        formulaLabel.setText("1.0 * x + 0.0");
        add(formulaLabel, layConstraints);

        okButton = new JButton();
        okButton.setText("Применить");
        layConstraints = getGridBagConstraints(24);
        add(okButton, layConstraints);

    }
    private static final long serialVersionUID = 1L;

    public void setRadioEvent(RadioButtonEvent radioEvent) {
        this.radio1.addActionListener(radioEvent);
        this.radio2.addActionListener(radioEvent);
        this.radio3.addActionListener(radioEvent);
        this.radio4.addActionListener(radioEvent);
    }
}
