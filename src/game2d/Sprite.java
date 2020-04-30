package game2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Sprite {

    protected BufferedImage image;
    protected int x;
    protected int y;
    
    public Sprite(){
        x=0;
        y=0;

    }
    
    public Sprite(String image_file){
        try{
            image = ImageIO.read(getClass().getResource(image_file));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public Sprite(BufferedImage img){
        image = img;
    }
    
    public void draw(Graphics g){
        g.drawImage(image, x, y, null);
    }
    
    public void setImage(BufferedImage img){
        image = img;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    //Allows you to add a number to a charachters position and move them by that amount of pixels
    //x is horizontal, y is vertical, positive number is down or right, negative is up or left
    public void move(int x, int y){
        this.x = this.x + x; 
        this.y = this.y + y;
    }
    

}
