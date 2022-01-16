/**
 * Yuantian Tan
 * yt2161
 */
import processing.core.PApplet;

public class MainClass extends PApplet{
    private final int X_MAX = 500;//boundary of x
    private final int Y_MAX = 500;//boundary of y
    Snake[] mysnake = new Snake[1];//only 1 instance I used

    @Override
    public void setup(){
        size(X_MAX,Y_MAX);//size
        background(255,255,255);//background color
        mysnake[0] = new Snake(this);//the only instance in my case
    }

    @Override
    public void draw(){
        frameRate(120);//120 hz per second
        background(255,255,255);//refresh the background with white
        for (Snake i : mysnake){
            i.move();
            i.fruit();
            i.eatFruit();
        }


    }
    public static void main(String[] args) {
        PApplet.main("MainClass");
    }
}
