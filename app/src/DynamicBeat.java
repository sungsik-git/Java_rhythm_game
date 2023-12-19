package app.src;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class DynamicBeat extends JFrame {

    private Image introBackground;
    private JPanel img;

    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get background image
        ImageIcon icon = new ImageIcon(Main.class.getResource("../images/background(title).jpg"));
        Image originalImage = icon.getImage();
        // Resizing to original image
        introBackground = originalImage.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);

        // IntroBGM play
        Music introMusic = new Music("introBGM.mp3", true);
        introMusic.start();

        
        img = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(introBackground, 0, 0, this);
            }
        };
        img.setLayout(null);
        img.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        add(img);

        setVisible(true);
    }
}

