package app.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRoutePressedImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
    private Image buleFlareImage;

    //note judge image
    private Image judgeImage;
    
    //note route image
    private Image noteRouteSImage = noteRouteImage;
    private Image noteRouteDImage = noteRouteImage;
    private Image noteRouteFImage = noteRouteImage;
    private Image noteRouteSpace1Image = noteRouteImage;
    private Image noteRouteSpace2Image = noteRouteImage;
    private Image noteRouteJImage = noteRouteImage;
    private Image noteRouteKImage = noteRouteImage;
    private Image noteRouteLImage = noteRouteImage;

    //key pad press image
    private Image keyPadPressedImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
    private Image keyPadBasicImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadSImage = keyPadBasicImage;
    private Image keyPadDImage = keyPadBasicImage;
    private Image keyPadFImage = keyPadBasicImage;
    private Image keyPadSpace1Image = keyPadBasicImage;
    private Image keyPadSpace2Image = keyPadBasicImage;
    private Image keyPadJImage = keyPadBasicImage;
    private Image keyPadKImage = keyPadBasicImage;
    private Image keyPadLImage = keyPadBasicImage;
    

    //property
    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<>();

    public Game(String titleName, String difficulty, String musicTitle){
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
    }
    
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

        // show notes
        for(int i = 0 ; i < noteList.size(); i++){
            Note note = noteList.get(i);
            if(note.getY() > 620){
                judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
            }
            if(!note.isProceeded()){
                noteList.remove(i);
                i--;
            }else{
                note.screenDraw(g);
            }
        }

        // draw game infomation
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 740 - g.getFontMetrics().getHeight());
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
        g.drawImage(buleFlareImage, 150, 230, null);
        g.drawImage(judgeImage, 460, 420, null);
        
        g.drawImage(keyPadSImage, 228, 580, null);
        g.drawImage(keyPadDImage, 332, 580, null);
        g.drawImage(keyPadFImage, 436, 580, null);
        g.drawImage(keyPadSpace1Image, 540, 580, null);
        g.drawImage(keyPadSpace2Image, 640, 580, null);
        g.drawImage(keyPadJImage, 744, 580, null);
        g.drawImage(keyPadKImage, 848, 580, null);
        g.drawImage(keyPadLImage, 952, 580, null);
    }

    //press keyboard 
    public void pressS(){
        judge("S");
        noteRouteSImage = noteRoutePressedImage;
        keyPadSImage = keyPadPressedImage;
    }
    public void releaseS(){
        noteRouteSImage = noteRouteImage;
        keyPadSImage = keyPadBasicImage;
    }
    public void pressD(){
        judge("D");
        noteRouteDImage = noteRoutePressedImage;
        keyPadDImage = keyPadPressedImage;
    }
    public void releaseD(){
        noteRouteDImage = noteRouteImage;
        keyPadDImage = keyPadBasicImage;
    }
    public void pressF(){
        judge("F");
        noteRouteFImage = noteRoutePressedImage;
        keyPadFImage = keyPadPressedImage;
    }
    public void releaseF(){
        noteRouteFImage = noteRouteImage;
        keyPadFImage = keyPadBasicImage;
    }
    public void pressSpace(){
        judge("Space");
        noteRouteSpace1Image = noteRoutePressedImage;
        noteRouteSpace2Image = noteRoutePressedImage;
        keyPadSpace1Image = keyPadPressedImage;
        keyPadSpace2Image = keyPadPressedImage;
    }
    public void releaseSpace(){
        noteRouteSpace1Image = noteRouteImage;
        noteRouteSpace2Image = noteRouteImage;
        keyPadSpace1Image = keyPadBasicImage;
        keyPadSpace2Image = keyPadBasicImage;
    }
    public void pressJ(){
        judge("J");
        noteRouteJImage = noteRoutePressedImage;
        keyPadJImage = keyPadPressedImage;
    }
    public void releaseJ(){
        noteRouteJImage = noteRouteImage;
        keyPadJImage = keyPadBasicImage;
    }
    public void pressK(){
        judge("K");
        noteRouteKImage = noteRoutePressedImage;
        keyPadKImage = keyPadPressedImage;
    }
    public void releaseK(){
        noteRouteKImage = noteRouteImage;
        keyPadKImage = keyPadBasicImage;
    }
    public void pressL(){
        judge("L");
        noteRouteLImage = noteRoutePressedImage;
        keyPadLImage = keyPadPressedImage;
    }
    public void releaseL(){
        noteRouteLImage = noteRouteImage;
        keyPadLImage = keyPadBasicImage;
    }

    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close(){
        gameMusic.close();
        this.interrupt();
    }
    
    public void dropNotes(String titleName){
        Beat[] beats = null;

        // easy mode beats
        if(titleName.equals("game1") && difficulty.equals("Easy")){
            int startTime = 1000 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime + gap * 1,"S"),
                new Beat(startTime + gap * 3,"D"),
                new Beat(startTime + gap * 5,"F"),
                new Beat(startTime + gap * 7,"Space"),
                new Beat(startTime + gap * 9,"J"),
                new Beat(startTime + gap * 11,"L"),
                new Beat(startTime + gap * 13,"S"),
                new Beat(startTime + gap * 15,"J"),
                new Beat(startTime + gap * 17,"S"),
                new Beat(startTime + gap * 19,"D"),
                new Beat(startTime + gap * 21,"L"),
                new Beat(startTime + gap * 23,"J"),
                new Beat(startTime + gap * 25,"Space"),
                new Beat(startTime + gap * 27,"K"),
                new Beat(startTime + gap * 29,"J"),
                new Beat(startTime + gap * 31,"D"),
                new Beat(startTime + gap * 33,"D"),
                new Beat(startTime + gap * 35,"L"),
                new Beat(startTime + gap * 37,"K"),
                new Beat(startTime + gap * 39,"J"),
                new Beat(startTime + gap * 41,"Space"),
                new Beat(startTime + gap * 43,"S"),
                new Beat(startTime + gap * 45,"D"),
                new Beat(startTime + gap * 47,"K"),
                new Beat(startTime + gap * 49,"L"),
                new Beat(startTime + gap * 51,"J"),
                new Beat(startTime + gap * 53,"D"),
                new Beat(startTime + gap * 55,"K"),
                
            };
        }

        // hard mode beats
        if(titleName.equals("game1") && difficulty.equals("Hard")){
            int startTime = 1000 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime + gap * 1,"S"),
                new Beat(startTime + gap * 3,"D"),
                new Beat(startTime + gap * 5,"F"),
                new Beat(startTime + gap * 7,"Space"),
                new Beat(startTime + gap * 9,"J"),
                new Beat(startTime + gap * 9,"K"),
                new Beat(startTime + gap * 11,"L"),
                new Beat(startTime + gap * 12,"S"),
                new Beat(startTime + gap * 13,"S"),
                new Beat(startTime + gap * 14,"F"),
                new Beat(startTime + gap * 15,"J"),
                new Beat(startTime + gap * 17,"S"),
                new Beat(startTime + gap * 19,"D"),
                new Beat(startTime + gap * 21,"L"),
                new Beat(startTime + gap * 23,"J"),
                new Beat(startTime + gap * 25,"Space"),
                new Beat(startTime + gap * 27,"K"),
                new Beat(startTime + gap * 29,"J"),
                new Beat(startTime + gap * 30,"K"),
                new Beat(startTime + gap * 31,"D"),
                new Beat(startTime + gap * 32,"F"),
                new Beat(startTime + gap * 33,"D"),
                new Beat(startTime + gap * 34,"S"),
                new Beat(startTime + gap * 35,"L"),
                new Beat(startTime + gap * 37,"K"),
                new Beat(startTime + gap * 39,"J"),
                new Beat(startTime + gap * 40,"K"),
                new Beat(startTime + gap * 41,"Space"),
                new Beat(startTime + gap * 43,"S"),
                new Beat(startTime + gap * 45,"D"),
                new Beat(startTime + gap * 47,"K"),
                new Beat(startTime + gap * 49,"L"),
                new Beat(startTime + gap * 51,"J"),
                new Beat(startTime + gap * 52,"Space"),
                new Beat(startTime + gap * 53,"D"),
                new Beat(startTime + gap * 54,"F"),
                new Beat(startTime + gap * 55,"K"),
            };
        }
        int i = 0;
        gameMusic.start();
        while (i < beats.length && !isInterrupted()) {
            boolean dropped = false;
            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if(!dropped){
                try{
                    Thread.sleep(5);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void judge(String input){
    for(int i = 0 ; i < noteList.size() ; i++ ){
            Note note = noteList.get(i);
            if(input.equals(note.getNoteType())){
                judgeEvent(note.judge());
                break;
            }
        }
    }

    public void judgeEvent(String judge){
        if(judge.equals("None")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
        }
        if(judge.equals("Miss")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
        }
        if(judge.equals("Late")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
        }
        if(judge.equals("Good")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
        }
        if(judge.equals("Great")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
        }
        if(judge.equals("Perfect")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
        }
        if(judge.equals("Early")){
            buleFlareImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
        }
    }
}

