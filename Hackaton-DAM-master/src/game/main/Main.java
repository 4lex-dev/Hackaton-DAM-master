package game.main;

import game.PanelMenu;
import game.component.PanelGame;
import game.obj.sound.BackgroundMusic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Main extends JFrame {
    private PanelMenu menu;

    private BackgroundMusic music=new BackgroundMusic();
    private PanelGame panelGame;


    public Main() {
        music.playMusic("/game/obj/sound/bg_music.wav.wav");
        initMenu();

    }
    private void initMenu() {
         menu = new PanelMenu((ActionEvent e) -> startGame());
        setLayout(new BorderLayout());
        add(menu, BorderLayout.CENTER);

       setupFrame();
    }
    private void startGame() {
        remove(menu);                  // Quitar el menú correctamente
        panelGame = new PanelGame();   // Crear el panel del juego
        add(panelGame, BorderLayout.CENTER);
        revalidate();
        repaint();
        panelGame.requestFocusInWindow();
        panelGame.start();
    }
    private void setupFrame() {
        setTitle("SpaceWars2D Startpage");
        setSize(1366, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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

        SwingUtilities.invokeLater(Main::new);
    }
}
