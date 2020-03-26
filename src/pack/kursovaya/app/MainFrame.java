package pack.kursovaya.app;

import pack.kursovaya.logic.SelectAnimationEvent;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        //панель со всеми анимациями - помещаем ее слева
        LeftPanel leftPanel = new LeftPanel();
        getContentPane().add(leftPanel, BorderLayout.WEST);

        //панель с картинками, помещаем ее по центру
        CenterPanel centerPanel = new CenterPanel(leftPanel.getFirstFolderName());
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        //событие, которое вызывается при выборе другой анимации
        SelectAnimationEvent selectionEvent = new SelectAnimationEvent(centerPanel);

        leftPanel.setSelectAnimationEvent(selectionEvent);
    }


    private static final long serialVersionUID = 1L;
}
