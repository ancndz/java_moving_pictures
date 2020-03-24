package pack.kursovaya.app;

import pack.kursovaya.logic.SelectAnimationEvent;

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        //панель с графиком, помещаем ее по центру
        CenterPanel centerPanel = new CenterPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        //панель с кнопками и прочим - помещаем ее слева
        LeftPanel leftPanel = new LeftPanel();
        getContentPane().add(leftPanel, BorderLayout.WEST);

        //событие, которое вызывается при нажатии на радио кнопки (смена функции)
        SelectAnimationEvent selectionEvent = new SelectAnimationEvent(centerPanel);

        leftPanel.setEvent(selectionEvent);

    }


    private static final long serialVersionUID = 1L;
}
