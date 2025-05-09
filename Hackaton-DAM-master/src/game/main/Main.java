package game.main;

import game.component.PanelGame;
import game.obj.sound.BackgroundMusic;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Main extends JFrame {

    private BackgroundMusic music=new BackgroundMusic();

    public Main() {
        music.playMusic("/game/obj/sound/bg_music.wav.wav");
        init();

    }


    private void init() {

        setTitle("SpaceWars 2D");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        PanelGame panelGame = new PanelGame();
        add(panelGame);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                panelGame.start();
            }
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
