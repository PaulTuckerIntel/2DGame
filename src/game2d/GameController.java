package game2d;

import java.awt.event.*;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class GameController implements KeyListener {

    public boolean up, down, left, right, action_1;

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        
        //we have included x as well to map an action to the x key
        if (key == KeyEvent.VK_X) {
            action_1 = true;
        }

        }catch(Exception e){
            System.out.println("Not a valid key");

        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try{
            int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_X) {
            action_1 = false;
        }

        }catch(Exception e){
            System.out.println("");
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
