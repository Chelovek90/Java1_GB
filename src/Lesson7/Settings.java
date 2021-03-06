package Lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 270;

    private GameWindow gameWindow;
    private JRadioButton jrbHumVsAI;
    private JRadioButton jrbHumVsHum;
    private JSlider jsFieldSize;
    private JSlider jsWinLength;

    public static final String FIELD_SIZE_PREFIX = "Field size is:";
    public static final String WIN_LENGTH_PREFIX = "Win length is:";
    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;
    public static final int MIN_WIN_Length = 3;

    Settings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Choose your rules");
        setLayout(new GridLayout(10, 1));

        addGameModeControls();
        addFieldControls();

        JButton btnStart = new JButton("Start a game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startGame();
            }
        });
        add(btnStart);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode"));
        jrbHumVsAI = new JRadioButton("Human & AI", true);
        jrbHumVsHum = new JRadioButton("Human & Human");
        ButtonGroup mode = new ButtonGroup();
        mode.add(jrbHumVsAI);
        mode.add(jrbHumVsHum);
    }

    private void addFieldControls() {
        JLabel jlFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel jlWinLength = new JLabel(WIN_LENGTH_PREFIX+MIN_WIN_Length);
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jsWinLength = new JSlider(MIN_WIN_Length, MIN_FIELD_SIZE, MIN_WIN_Length);
        jsFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int currentValue = jsFieldSize.getValue();
                jlFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                jsWinLength.setMaximum(currentValue);
            }
        });
        jsWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                jlWinLength.setText(WIN_LENGTH_PREFIX + jsWinLength.getValue());
            }
        });

        add(new JLabel("Choose field size"));
        add(jlFieldSize);
        add(jsFieldSize);
        add(new JLabel("Choose winnig length"));
        add(jlWinLength);
        add(jsWinLength);
    }

    private void startGame() {
        int gameMode;
        if (jrbHumVsAI.isSelected()) {
            gameMode = Map.GAME_MODE_HVAI;
        } else if (jrbHumVsHum.isSelected()) {
            gameMode = Map.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Unknown game mode");
        }

        int fieldSize = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();

        gameWindow.start(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
