package game2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

/*

  Expansion ideas:
- Let user change spritesheet and change size of sprites
- Move enemies towards player (at the moment they move randomly)
- Make items to pick up
- add collisions for edges of screen
- Map an action to the x key

 */

public class Game2D extends JFrame {

    private Random rand = new Random();
    protected Scene scene;
    
    protected SpriteSheet playerSpritesheet;
    protected Sprite player;

    protected List<SpriteSheet> enemySpriteSheets = new ArrayList<>();
    protected List<Sprite> enemies = new ArrayList<>();

    protected GameController controller;

    private static final int tileSizeOfSprites = 80; // Change the number if sprite is a different size, mine is 80 * 80 pixels

    public Game2D() {
        setTitle("2D Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scene = new Scene();
        add(scene);
        pack();

        setSize(tileSizeOfSprites * 8, tileSizeOfSprites * 8);//Sets the size of the screen, based on sprite size
        setVisible(true);

        init();
    }

    private void init() {
        controller = new GameController();
        addKeyListener(controller);

        setUpSprites(); //creates enemies and player sprites

        //Adds player to the screen
        scene.addSprite(player);
        
        //Adds enemies to screen
        for (int i = 0; i < enemies.size(); i++) {
            scene.addSprite(enemies.get(i));
        }
        
        scene.repaint();
    }

    //Chreates sprites from image sheets and creates objects for player and enemies
    public void setUpSprites() {
        //Player sprite
        playerSpritesheet = new SpriteSheet("/gameImages/PixelCharactersYou.png", tileSizeOfSprites);
        player = new Sprite(playerSpritesheet.getTile(1)); //Tile 1 is the player facing down towards screen
        player.setPosition(0 , 0); //Puts the player top left

        //Enemy Sprites
        SpriteSheet enemySpriteSheet = new SpriteSheet("/gameImages/PixelCharacters - enemy 0.png", tileSizeOfSprites); // File for enemy 0
        enemySpriteSheets.add(enemySpriteSheet);
        Sprite enemy = new Sprite(enemySpriteSheet.getTile(1)); //Tile 1 is the enemy facing down 
        enemy.setPosition(200, 200); //Start position of this enemy
        enemies.add(enemy);
        
        enemySpriteSheet = new SpriteSheet("/gameImages/PixelCharacters - enemy 1.png", tileSizeOfSprites); // File for enemy 1
        enemySpriteSheets.add(enemySpriteSheet);
        enemy = new Sprite(enemySpriteSheet.getTile(1)); //Tile 1 is the enemy facing down 
        enemy.setPosition(400, 400);  //Start position of this enemy
        enemies.add(enemy);
        
        
    }

    public static void main(String[] args) {
        Game2D game = new Game2D();
        game.gameLoop();
    }

    //Deals with moving charachters about
    public void gameLoop() {
        long timer;

        long update_timer = 60;

        while (true) {
            timer = System.currentTimeMillis();

            //Move character and sets different icons based on direction of movement
            if (controller.up) {
                player.setImage(playerSpritesheet.getTile(10));
                player.move(0, -1);
            }
            if (controller.down) {
                player.setImage(playerSpritesheet.getTile(1));
                player.move(0, +1);
            }
            if (controller.left) {
                player.setImage(playerSpritesheet.getTile(4));
                player.move(-1, 0);
            }
            if (controller.right) {
                player.setImage(playerSpritesheet.getTile(7));
                player.move(+1, 0);
            }

            update_timer -= 1;
            
            //Only move characters every 60 milliseconds
            if (update_timer == 0) {      
                //Moves the enemies a random number of pixels between 10 and -10 pixels
                enemies.forEach((s) -> s.move((rand.nextInt(10-(-10))-10), (rand.nextInt(10-(-10))-10)));
                update_timer = 60;
            }

            scene.repaint();

            //counts 60 milliseconds, gives us 60fps
            timer = (1000 / 60) - (System.currentTimeMillis() - timer);

            if (timer > 0) {
                try {
                    Thread.sleep(timer);
                } catch (Exception e) {

                }
            }
        }
    }

    public static int getTileSizeOfSprite() {
        return tileSizeOfSprites;
    }
}
