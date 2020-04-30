package game2d;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Scene extends JPanel {

    private int width;
    private int height;

    private List<Sprite> sprites = new ArrayList<>();

    public Scene() {
        super();
        width = Game2D.getTileSizeOfSprite()*8;
        height = Game2D.getTileSizeOfSprite()*8;
    }

    public Dimension getPrefferredSize() {
        return new Dimension(this.width, this.height);
    }

    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      
        sprites.forEach((s) -> s.draw(g));
    }

}
