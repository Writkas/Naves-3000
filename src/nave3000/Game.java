/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Patricio René Sáez
 * @author Matías Muñoz Espinoza
 */
public class Game {
    
    /*
     *  Constant
     */
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private String WINDOW_TITLE = "Nave3000";
    private final int TOTAL_ENEMYS = 6;
     
    /*
     *  Atributes
     */
    
    private Enemy [] enemy = new Enemy [TOTAL_ENEMYS]; 
    private boolean isRuning = true;
    private int fps;
    private Point originAux;
    
    Game () {
        
        this.configDisplay();
        this.configOpenGL();
        
        
        // Game Loop 
        
        while (isRuning) {
            this.render ();
            this.initEntities();
            
            Display.update();
            Display.sync(50);
            
            if (Display.isCloseRequested()) {
                isRuning = false;
            }
        }
        
        Display.destroy();
    }
    
    private void render () {
        glClear(GL_COLOR_BUFFER_BIT);
    }
    
    private void configOpenGL () {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
    }
    
    private void configDisplay () {
        try {
            Display.setDisplayMode (new DisplayMode(this.WIDTH, this.HEIGHT));
            Display.create ();
            Display.setTitle(this.WINDOW_TITLE);
        } catch (LWJGLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initEntities () {
        Point vertexAux;
        originAux = new Point(80, 70);
        
        for (int i = 0; i < enemy.length; i++) {
            this.enemy[i] = new Enemy (originAux);
             
            glBegin(GL_TRIANGLES);
                vertexAux = enemy[i].getLeft();
                glVertex2i(vertexAux.x, vertexAux.y);
                vertexAux = enemy[i].getRight();
                glVertex2i(vertexAux.x, vertexAux.y);
                vertexAux = enemy[i].getDown();
                glVertex2i(vertexAux.x, vertexAux.y);
            glEnd();
            
            this.originAux.x += 70;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }
}
