package pack.kursovaya.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;


public class CenterPanel extends JPanel {

    private String gifName;
    private ArrayList<BufferedImage> images;
    private int lastImageID = 0;

    //событие, которое вызывается каждые timerInterval
    //т.е. увеличение lastImageID на один и перерисовка
    //когда достигается последний элемент - обновление счетчика
    Action paintTimer = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (lastImageID == images.size() - 1) {
                lastImageID = 0;
            }
            lastImageID = lastImageID + 1;
            repaint();
        }
    };

    public CenterPanel(String firstFolderName) {
        //открывается сразу при вхождении в программу (дефолтная первая папка)
        this.gifName = firstFolderName;
        //установка дефолтной анимации, которая в первой папке
        changeGifPack();
        setDoubleBuffered(true);
        //интервал переключения картинок
        int timerInterval = 150;
        //таймер для автоматической смены картинок
        new Timer(timerInterval, paintTimer).start();
    }

    //метод для смены набора картинок
    public void changeGifPack() {
        this.lastImageID = 0;
        this.images = new ArrayList<>();

        File frame = new File("pics/".concat(this.gifName).concat("/").concat("0.png"));

        if (!frame.exists()) {
            showMessageDialog(this,
                    "Не найдено главного элемента (0.png).",
                    "Ошибка!",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(3);
        } else {
            int i = 0;
            while (frame.exists()) {
                try {
                    this.images.add(ImageIO.read(new File("pics/".concat(this.gifName).concat("/").concat(Integer.toString(i).concat(".png")))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i = i + 1;
            }
            revalidate();
            repaint();
        }

    }

    //метод для отрисовки выбранного изображения
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //подгон изображения под окно
        Image scaledImage = this.images.get(this.lastImageID).getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, 0, 0, this); // see javadoc for more info on the parameters
        g.dispose();
    }

    public void setGifName(String gifName) {
        this.gifName = gifName;
    }

    private static final long serialVersionUID = 1L;
}

