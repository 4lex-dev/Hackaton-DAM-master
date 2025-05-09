package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {

    private final Image background;

    public PanelMenu(ActionListener startListener) {
        setLayout(new GridBagLayout());

        // Fondo: imagen o degradado
        background = new ImageIcon(getClass().getResource("/game/image/menu.jpg")).getImage(); // asegúrate que exista

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;

        // Título grande con sombra
        JLabel title = new JLabel("🚀 SPACE WARS 2D");
        title.setFont(new Font("Verdana", Font.BOLD, 40));
        title.setForeground(Color.CYAN);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        add(title, gbc);

        // Botón de jugar estilizado
        JButton playButton = new JButton("INICIAR JUEGO");
        playButton.setFont(new Font("Arial", Font.BOLD, 24));
        playButton.setBackground(new Color(0, 200, 100));
        playButton.setForeground(Color.BLACK);
        playButton.setFocusPainted(false);
        playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playButton.setPreferredSize(new Dimension(250, 50));
        playButton.addActionListener(startListener);
        gbc.gridy = 1;
        add(playButton, gbc);

        // Créditos estéticos
        JLabel credit = new JLabel("Hecho por Alejandro Ruiz • Música 8-Bit Loop");
        credit.setFont(new Font("Arial", Font.ITALIC, 14));
        credit.setForeground(Color.LIGHT_GRAY);
        gbc.gridy = 2;
        add(credit, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo con imagen
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, new Color(10, 10, 50), 0, getHeight(), Color.BLACK);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}

