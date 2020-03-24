package pack.kursovaya.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CenterPanel extends JPanel {

    //название функции здесь задается для того, что бы было при вхождении в программу
    private String gifName;
    private ArrayList<BufferedImage> image;

    {
        gifName = "Walking";
    }


    public CenterPanel() {
        image = new ArrayList<>();
        File frame = null;
        try {
            frame = new File("pics/".concat(this.gifName).concat("/").concat("0.png"));
        } catch (Exception e) {
            //open error window...
        }

        //assert - это значит "пусть"
        //говорим программе что наша переменная не нулевая
        assert frame != null;
        int i = 0;
        while (frame.exists()) {
            try {
                image.add(ImageIO.read(new File("pics/".concat(this.gifName).concat("/").concat(Integer.toString(i).concat(".png")))));
            } catch (IOException ex) {
                continue;
            }
            i = i + 1;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       // g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

    public void setGifName(String functionName) {
        this.gifName = functionName;
    }

    public String getGifName() {
        return gifName;
    }

    private static final long serialVersionUID = 1L;
}

