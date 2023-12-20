package app.src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
  private JPanel img;
  private Music introMusic = new Music("introBGM.mp3", true);
  private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar1280.jpg")));

  
  // Get image property
  private Image background = new ImageIcon(Main.class.getResource("../images/background(title).png")).getImage();

  // Get image icon property
  private ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../images/easyButton.png"));
  private ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../images/hardButton.png"));
  private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/backButton.png"));

  private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
  private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
  private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
  private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
  private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();

  // Set Button on JButton
  private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")));
  private JButton startButton = new JButton(new ImageIcon(Main.class.getResource("../images/button_img.png")));
  private JButton easyButton = new JButton(easyButtonImage);
  private JButton hardButton = new JButton(hardButtonImage);
  private JButton backButton = new JButton(backButtonImage);

  //mouse position 
  private int mouseX, mouseY;
  private boolean isMainScreen = false;

  //selected music infomation in main screen
  ArrayList<Track> trackList = new ArrayList<Track>();
  private Image selectedImage;
  private Image titleImage;
  private Music selectedMusic;
  private int nowSelected = 0;

  //check either GameScreen or Not
  private boolean isGameScreen = false;

  public DynamicBeat() {
    setUndecorated(true);

    setTitle("Dynamic Beat");
    setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    // IntroBGM play
    
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
        enterMain();
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

    //Setting easy button
    easyButton.setBounds(355, 450, 250, 67);
    easyButton.setVisible(false);
    easyButton.setBorderPainted(false);
    easyButton.setContentAreaFilled(false);
    easyButton.setFocusPainted(false);
    easyButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
      @Override
      public void mousePressed(MouseEvent e){
          gameStart(nowSelected, "hard");
      }
    });
    add(easyButton);

    //Setting hard button
    hardButton.setBounds(635, 450, 250, 67);
    hardButton.setVisible(false);
    hardButton.setBorderPainted(false);
    hardButton.setContentAreaFilled(false);
    hardButton.setFocusPainted(false);
    hardButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
      @Override
      public void mousePressed(MouseEvent e){
        gameStart(nowSelected, "easy");
      }
    });
    add(hardButton);

    //Setting back button
    backButton.setBounds(20, 50, 80, 80);
    backButton.setVisible(false);
    backButton.setBorderPainted(false);
    backButton.setContentAreaFilled(false);
    backButton.setFocusPainted(false);
    backButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
      @Override
      public void mousePressed(MouseEvent e){
        backMain();
      }
    });
    add(backButton);

  img = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        if (isMainScreen) {
            g.drawImage(selectedImage, 320, 120, null);
            g.drawImage(titleImage, 700, 560, null);
        }
        if ( isGameScreen ){
          for(int i = 0; i<8 ; i++){
            g.drawImage(noteRouteImage, 228 + 104 * i, 30, null);
            if(i != 4){
              g.drawImage(noteRouteLineImage, 224 + 104 * i, 30, null);
            }
          }
          g.drawImage(gameInfoImage, -5, 660, null);
          g.drawImage(judgementLineImage, 0, 580, null);
          //draw note
          g.drawImage(noteBasicImage, 228, 120, null);
          g.drawImage(noteBasicImage, 332, 580, null);
          g.drawImage(noteBasicImage, 436, 500, null);
          g.drawImage(noteBasicImage, 540, 340, null);
          g.drawImage(noteBasicImage, 640, 340, null);
          g.drawImage(noteBasicImage, 744, 325, null);
          g.drawImage(noteBasicImage, 848, 305, null);
          g.drawImage(noteBasicImage, 952, 305, null);
          //draw game infomation
          g.setColor(Color.white);
          g.setFont(new Font("Arial", Font.BOLD, 30));
          g.drawString("Sample Music", 20, 740 - g.getFontMetrics().getHeight());
          g.drawString("Easy", 1190, 740 - g.getFontMetrics().getHeight());
          g.setFont(new Font("Elephant",Font.BOLD,30));
          g.drawString("000000", 565, 740 - g.getFontMetrics().getHeight());
          //draw keypad infomation
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

  public void gameStart(int nowSelected, String difficulty){
    if(selectedMusic != null){
      selectedMusic.close();
      isMainScreen = false;
      hardButton.setVisible(false);
      easyButton.setVisible(false);
      background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
      img.repaint();
      backButton.setVisible(true);
      isGameScreen = true;
    }
  }

  public void backMain(){
    isMainScreen = true;
    easyButton.setVisible(true);
    hardButton.setVisible(true);
    background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
    backButton.setVisible(false);
    selectTrack(nowSelected);
    img.repaint();
    isGameScreen = false;
  }

  public void enterMain(){
    startButton.setVisible(false);
    background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
    img.repaint();
    introMusic.close();
    selectTrack(0);
    easyButton.setVisible(true);
    hardButton.setVisible(true);
    isMainScreen = true;
  }
}

