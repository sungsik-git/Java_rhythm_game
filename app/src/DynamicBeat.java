package app.src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {
  private JPanel img;

  private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar1280.jpg")));
  private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButtonBasic.jpeg")));
  private JButton startButton = new JButton(new ImageIcon(Main.class.getResource("../images/button_img.png")));
  
  // Get background image
  Image originalImage = new ImageIcon(Main.class.getResource("../images/background(title).jpg")).getImage();
  // Resizing to original image
  private Image background = originalImage.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);

  //mouse position 
  private int mouseX, mouseY;

  public DynamicBeat() {
    setUndecorated(true);

    setTitle("Dynamic Beat");
    setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setBackground(new Color(0,0,0,0));
    setLayout(null);

    menuBar.setBounds(0,0,1280,30);
    menuBar.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
      }
    });
    menuBar.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e){
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        setLocation(x - mouseX, y - mouseY);
      }
    }); 
    add(menuBar);

    //Setting start Button
    startButton.setBounds(40, 600, 400, 100);
    startButton.setBorderPainted(false);
    startButton.setContentAreaFilled(false);
    startButton.setFocusPainted(false);
    startButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
      @Override
      public void mousePressed(MouseEvent e){
        startButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
      }
    });
    add(startButton);

    //Setting exit Button
    exitButton.setBounds(1200, 50, 30, 30);
    exitButton.setBorderPainted(false);
    exitButton.setContentAreaFilled(false);
    exitButton.setFocusPainted(false);
    exitButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
      @Override
      public void mousePressed(MouseEvent e){
        System.exit(0);
      }
    });
    add(exitButton);

    // IntroBGM play
    // Music introMusic = new Music("introBGM.mp3", true);
    // introMusic.start();

    
    img = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, this);
        }
    };
    img.setLayout(null);
    img.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    add(img);

    setVisible(true);
  }
}

