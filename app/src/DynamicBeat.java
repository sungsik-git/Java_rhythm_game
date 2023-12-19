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
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
  private JPanel img;

  private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar1280.jpg")));
  private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")));
  private JButton startButton = new JButton(new ImageIcon(Main.class.getResource("../images/button_img.png")));
  
  // Get background image
  private Image background = new ImageIcon(Main.class.getResource("../images/background(title).png")).getImage();
  //mouse position 
  private int mouseX, mouseY;
  private boolean isMainScreen = false;

  //selected music infomation in main screen
  ArrayList<Track> trackList = new ArrayList<Track>();
  private Image selectedImage;
  private Image titleImage;
  private Music selectedMusic;
  private int nowSelected = 0;

  public DynamicBeat() {
    setUndecorated(true);

    setTitle("Dynamic Beat");
    setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    // IntroBGM play
    Music introMusic = new Music("introBGM.mp3", true);
    introMusic.start();

    // Add Game Track
    trackList.add(new Track("title_img.png", "game1_background.png", "game1_start_img.png", "game1_selected.mp3", "game1.mp3"));

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
        introMusic.close();
        selectTrack(0);
        background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
        isMainScreen = true;
      }
    });
    add(startButton);

    //Setting exit Button
    exitButton.setBounds(1250, 30, 30, 30);
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

  

  img = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        if (isMainScreen) {
            g.drawImage(selectedImage, 320, 120, null);
            g.drawImage(titleImage, 700, 560, null);
        }
        
    }
  };
    img.setLayout(null);
    img.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    add(img);

    setVisible(true);
  }

  public void selectTrack(int nowSelected){
    if(selectedMusic != null){
      selectedMusic.close();
    }
    titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
    selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
    selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
    selectedMusic.start();
  }
}

