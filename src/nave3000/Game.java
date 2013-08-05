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

    /*
     *  Atributes
     */
    
    private boolean isRuning = true;
    private int fps;
    
    Game () {
        
        this.configDisplay();
        this.configOpenGL();
        
        // Game Loop 
        
        while (isRuning) {
            this.render ();
            
            
            Display.update();
            Display.sync(60);
            
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
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
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
        // Temp: Acá se inicializan las unidades GoodShip y Enemy, etc.
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }
}
