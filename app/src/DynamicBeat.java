package app.src;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;


public class DynamicBeat extends JFrame{
    
    private Image ScreenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public DynamicBeat(){
        setTitle("Dynamic Beat");

        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        //Do not resizing by user
        setResizable(false);
        //Exactly center position when running
        setLocationRelativeTo(null);
        //Close both Jfram and program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Get background image
        ImageIcon icon = new ImageIcon(Main.class.getResource("../images/background(title).jpg"));
        Image originalImage = icon.getImage();
        //Resizing to original image
        introBackground = originalImage.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);

    }
    

    //JFrame Screen Layout
    public void paint(Graphics g){
        ScreenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = ScreenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(ScreenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
}
