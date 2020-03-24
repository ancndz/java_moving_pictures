package pack.kursovaya.app;

import pack.kursovaya.logic.RadioButtonEvent;

import javax.swing.JFrame;
import java.awt.*;
import pack.kursovaya.logic.ButtonEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        //панель с графиком, помещаем ее по центру
        CenterPanel centerPanel = new CenterPanel();
        //getContentPane().add(centerPanel.getChartPanel(), BorderLayout.CENTER);

        //панель с кнопками и прочим - помещаем ее слева
        LeftPanel leftPanel = new LeftPanel();
        getContentPane().add(leftPanel, BorderLayout.WEST);

        //событие, которое вызывается при нажатии на радио кнопки (смена функции)
        RadioButtonEvent radioEvent = new RadioButtonEvent(centerPanel, leftPanel);
        leftPanel.setRadioEvent(radioEvent);

        //событие, котороые вызывается при нажатии нижней кнопки (установка коэффициентов)
        ButtonEvent event = new ButtonEvent(centerPanel, leftPanel);

    }


    private static final long serialVersionUID = 1L;
}
