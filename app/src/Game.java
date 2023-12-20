package app.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Game extends Thread {

    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

    public void screenDraw(Graphics g) {
        for (int i = 0; i < 8; i++) {
            g.drawImage(noteRouteImage, 228 + 104 * i, 30, null);
            if (i != 4) {
                g.drawImage(noteRouteLineImage, 224 + 104 * i, 30, null);
            }
        }
        g.drawImage(gameInfoImage, -5, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        // draw note
        g.drawImage(noteBasicImage, 228, 120, null);
        g.drawImage(noteBasicImage, 332, 580, null);
        g.drawImage(noteBasicImage, 436, 500, null);
        g.drawImage(noteBasicImage, 540, 340, null);
        g.drawImage(noteBasicImage, 640, 340, null);
        g.drawImage(noteBasicImage, 744, 325, null);
        g.drawImage(noteBasicImage, 848, 305, null);
        g.drawImage(noteBasicImage, 952, 305, null);
        // draw game infomation
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Sample Music", 20, 740 - g.getFontMetrics().getHeight());
        g.drawString("Easy", 1190, 740 - g.getFontMetrics().getHeight());
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 740 - g.getFontMetrics().getHeight());
        // draw keypad infomation
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.drawString("S", 270, 630);
        g.drawString("D", 374, 630);
        g.drawString("F", 478, 630);
        g.drawString("Space Bar", 580, 630);
        g.drawString("J", 784, 630);
        g.drawString("K", 889, 630);
        g.drawString("L", 993, 630);
    }

    @Override
    public void run() {

    }
}
