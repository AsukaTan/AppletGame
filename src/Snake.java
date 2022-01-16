/**
 * Yuantian Tan
 * yt2161
 */
import processing.core.PApplet;

public class Snake {
    private float snakeLength = 10;
    private float snakeWidth = 10;
    private float x;
    private float y;
    private float fruit_x;
    private float fruit_y;
    private float xSpeed = 3;
    private float ySpeed = 3;
    private boolean foodEaten = true;
    private float temp = 0;
    private char pointer = ' ';
    int color;
    PApplet canvas;

    /**initi*/
    public Snake(PApplet canvas){
        this.canvas = canvas;
        color = canvas.color(0,0,0);
        x = canvas.random(0, canvas.width);
        y = canvas.random(0, canvas.height);

    }
    /**moving component*/
    public void move(){
        /**using awsd to control*/
        if(canvas.keyPressed){
            if (canvas.key == 'a'){
                x -= xSpeed;
                if (pointer == 'y'){//if change dirction, we need to change the shape
                    temp = snakeLength;
                    snakeLength = snakeWidth;
                    snakeWidth= temp;
                }
                pointer = 'x';
            }
            if (canvas.key == 'd'){
                x += xSpeed;
                if (pointer == 'y'){//if change dirction, we need to change the shape
                    temp = snakeLength;
                    snakeLength = snakeWidth;
                    snakeWidth= temp;
                }
                pointer = 'x';
            }
            if (canvas.key == 'w') {//if change dirction, we need to change the shape
                y -= ySpeed;
                if (pointer == 'x'){
                    temp = snakeLength;
                    snakeLength = snakeWidth;
                    snakeWidth= temp;
                }
                pointer = 'y';
            }
            if (canvas.key == 's') {//if change dirction, we need to change the shape
                y += ySpeed;
                if (pointer == 'x'){
                    temp = snakeLength;
                    snakeLength = snakeWidth;
                    snakeWidth= temp;
                }
                pointer = 'y';
            }
            /** deal with out of boundry*/
            if (x > canvas.width) {
                x = canvas.width;
                xSpeed *= -1;
            }
            if (x < 0) {
                x = 0;
                xSpeed *= -1;
            }
            if (y > canvas.height) {
                y = canvas.height;
                ySpeed *= -1;
            }
            if (y < 0) {
                y = 0;
                ySpeed *= -1;
            }
        }
        canvas.fill(color);
        this.canvas.rect(x,y,snakeLength,snakeWidth);
    }

    /**target we need to eat*/
    public void fruit(){
        if (foodEaten){
            fruit_x = canvas.random(0,  canvas.width);
            fruit_y = canvas.random(0,  canvas.width);
        }
        canvas.rect(fruit_x,fruit_y,10,10);
        canvas.fill(100,100,100);
        foodEaten = false;
    }

    /**determine whether we eat this fruit*/
    public void eatFruit(){
        if (y >= fruit_y - 10 && y<= fruit_y + 10){
            if (x >= fruit_x - 10 && x <= fruit_x + 10 ){
                foodEaten = true;
                snakeLength += 10;
            }
        }
    }

}
