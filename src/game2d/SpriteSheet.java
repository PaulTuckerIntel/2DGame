package game2d;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

import javax.imageio.ImageIO;

import java.util.List;
import java.util.ArrayList;

public class SpriteSheet {

    public String filelocation;
    protected BufferedImage image;
    protected List<BufferedImage> tiles = new ArrayList<>();

    public SpriteSheet(String image_file, int tile_size) {
        filelocation = image_file;
        try {
            image = ImageIO.read(getClass().getResource(image_file));
            
            for (int rows = 0; rows < image.getHeight()/ tile_size; rows++) {
                for (int columns = 0; columns < image.getWidth()/ tile_size; columns++) {
                    //This splits the big images (in gameImages) into smaller images and adds smaller images to arraylist
                    BufferedImage img = image.getSubimage(columns*tile_size, rows*tile_size, tile_size, tile_size);
                    tiles.add(img);
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading SpriteSheet : " + e);
            
            //If spritesheet doesnt work use coloured box
            image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();

            g.setColor(new Color(255, 0, 255));
            g.fillRect(0, 0, 32, 32);
        }
    }
    
    public BufferedImage getTile(int tile){
        if(tiles.size() == 0){
            return image;
        }
        else{
            return tiles.get(tile);
        }
    }

}
