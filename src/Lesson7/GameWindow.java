package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    public static final int WIN_WIDTH = 507;
    public static final int WIN_HEIGHT = 555;
    public static final int WIN_POSX = 650;
    public static final int WIN_POSY = 250;

    private Map map;
    private Settings settings;


    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("MegaGame");
        setLocation(WIN_POSX, WIN_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);

        map = new Map();
        settings = new Settings(this);

        add(map, BorderLayout.CENTER);
        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                settings.setVisible(true);
            }
        });

//        add(btnStart);
//        add(btnExit);

        JPanel panel = new JPanel(new GridLayout(1,2));
        add(panel, BorderLayout.NORTH);
        panel.add(btnStart);
        panel.add(btnExit);

    }
    void start (int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame (gameMode,  fieldSizeX,  fieldSizeY,  winLength);

    }

}
