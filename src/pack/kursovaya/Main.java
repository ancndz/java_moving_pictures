package pack.kursovaya;

import pack.kursovaya.app.MainFrame;

//главный класс, вызов происходит отсюда
public class Main {
    public static void main(String[] args) {
        MainFrame app = new MainFrame();
        app.setTitle("Мультфильмы");
        app.setVisible(true);
    }
}
