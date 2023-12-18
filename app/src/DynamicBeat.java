package app.src;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
    
    public DynamicBeat(){
        setTitle("Dynamic Beat");

        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        //Do not resizing by user
        setResizable(false);
        //Exactly center position when running
        setLocationRelativeTo(null);
        //close both Jfram and program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
