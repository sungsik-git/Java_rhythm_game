package app.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Game extends Thread {

    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRoutePressedImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
    //note route image
    private Image noteRouteSImage = noteRouteImage;
    private Image noteRouteDImage = noteRouteImage;
    private Image noteRouteFImage = noteRouteImage;
    private Image noteRouteSpace1Image = noteRouteImage;
    private Image noteRouteSpace2Image = noteRouteImage;
    private Image noteRouteJImage = noteRouteImage;
    private Image noteRouteKImage = noteRouteImage;
    private Image noteRouteLImage = noteRouteImage;
    
    public void screenDraw(Graphics g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 244, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        

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

    public void pressS(){
        noteRouteSImage = noteRoutePressedImage;
    }
    public void releaseS(){
        noteRouteSImage = noteRouteImage;
    }
    public void pressD(){
        noteRouteDImage = noteRoutePressedImage;
    }
    public void releaseD(){
        noteRouteDImage = noteRouteImage;
    }
    public void pressF(){
        noteRouteFImage = noteRoutePressedImage;
    }
    public void releaseF(){
        noteRouteFImage = noteRouteImage;
    }
    public void pressSpace(){
        noteRouteSpace1Image = noteRoutePressedImage;
        noteRouteSpace2Image = noteRoutePressedImage;
    }
    public void releaseSpace(){
        noteRouteSpace1Image = noteRouteImage;
        noteRouteSpace2Image = noteRouteImage;
    }
    public void pressJ(){
        noteRouteJImage = noteRoutePressedImage;
    }
    public void releaseJ(){
        noteRouteJImage = noteRouteImage;
    }
    public void pressK(){
        noteRouteKImage = noteRoutePressedImage;
    }
    public void releaseK(){
        noteRouteKImage = noteRouteImage;
    }
    public void pressL(){
        noteRouteLImage = noteRoutePressedImage;
    }
    public void releaseL(){
        noteRouteLImage = noteRouteImage;
    }
   

    @Override
    public void run() {

    }
}
