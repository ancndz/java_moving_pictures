package pack.kursovaya.app;

import pack.kursovaya.logic.SelectAnimationEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class LeftPanel extends JPanel {

    //в этом списке хранятся названия папок - они отображаются как названия анимаций на левой панели
    //в папке должна быть хотя бы одна картинка 0.png
    private List<String> gifFolders;
    //сам объект "список"
    JList<String> animationList;

    //метод, возвращает список всех названий папок в папке pics
    private List<String> loadGifFolders() {

        List<String> answer = new ArrayList<>();

        File picsFolder = new File("pics");

        //если такой папки нет, появится окно ошибки и программа не запустится
        if (!picsFolder.exists()) {
            //no pics folder
            showMessageDialog(this,
                    "Не найдено папки \"pics\".",
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        File[] folders = picsFolder.listFiles();

        //если внутри ничего нет, программа тоже не запустится
        if (folders == null) {
            showMessageDialog(this,
                    "Папка \"pics\" пустая.",
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        } else {
            for (File gifDir : folders) {
                if (gifDir.isDirectory()) {
                    answer.add(gifDir.getName());
                }
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

        //сканирование папок
        this.gifFolders = loadGifFolders();

        layConstraints = getGridBagConstraints(0);
        add(new JLabel("Animations:"), layConstraints);

        //заполнение и добавление названий анимаций (папок)
        this.animationList = new JList<>();

        String[] stringArray = new String[this.gifFolders.size()];
        this.gifFolders.toArray(stringArray);

        animationList.setListData(stringArray);
        layConstraints = getGridBagConstraints(2);

        add(animationList, layConstraints);


    }

    //добавления списку событие - когда выбираем что-то из списка, оно срабатывает
    public void setSelectAnimationEvent(SelectAnimationEvent event) {
        this.animationList.addListSelectionListener(event);
    }

    public String getFirstFolderName() {
        return this.gifFolders.get(0);
    }

    private static final long serialVersionUID = 1L;

}
