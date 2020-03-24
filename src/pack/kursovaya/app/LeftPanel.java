package pack.kursovaya.app;

import pack.kursovaya.logic.SelectAnimationEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LeftPanel extends JPanel {

    List<String> gifFolders;
    JList<String> animationList;

    SelectAnimationEvent event;

    private List<String> loadGifFolders() {

        List<String> answer = new ArrayList<>();
        File[] folders = new File[0];

        try {
            folders = new File("pics").listFiles();
        } catch (Exception ex) {
            //no pics folder
            System.out.println("No folder with name pics");
            System.exit(1);
        }

        for (File gifDir : folders) {
            if (gifDir.isDirectory()) {
                answer.add(gifDir.getName());
            }
        }

        return answer;
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

        this.gifFolders = loadGifFolders();



        layConstraints = getGridBagConstraints(0);
        add(new JLabel("Animations:"), layConstraints);

        this.animationList = new JList<>();

        String[] stringArray = new String[this.gifFolders.size()];
        this.gifFolders.toArray(stringArray);

        animationList.setListData(stringArray);
        layConstraints = getGridBagConstraints(2);


        add(animationList, layConstraints);

    }

    public void setEvent(SelectAnimationEvent event) {
        this.event = event;
    }

    private static final long serialVersionUID = 1L;

}
