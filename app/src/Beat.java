package app.src;

public class Beat {
    private int time;
    private String noteName;

    public String getNoteName() {
        return noteName;
    }
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public Beat(int time, String noteName){
        super();
        this.time = time;
        this.noteName = noteName;
    }
    
}
