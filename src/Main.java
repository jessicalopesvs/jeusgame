import com.jeusgame.game.Game;

import javax.swing.*;

public class Main {

    public static final String TITLE = "Jéusga";

    public static void main(String[] args) {

        Game game = new Game();
        JFrame frame = new JFrame(TITLE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//set frame in the middle of the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting the close button
        frame.setVisible(true);
        game.start();
    }

}