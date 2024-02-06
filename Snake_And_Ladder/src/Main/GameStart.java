package Main;

import java.awt.*;

public class GameStart {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                GameMenu menu = new GameMenu();
                menu.GameMenu();
            }
        });
    }

}
