package Lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int GAME_MODE_HVAI = 0;
    public static final int GAME_MODE_HVH = 1;

    Map () {

        setBackground(Color.BLACK);
    }
    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("game mode: %d\nfieldSize: %dnwinLength^ %d",
                gameMode, fieldSizeX, winLength);

    }

}
