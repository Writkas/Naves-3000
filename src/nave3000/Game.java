/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;

// Core Java Imports
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// LWJGL Imports
import org.lwjgl.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Patricio René Sáez
 * @author Matías Muñoz Espinoza
 */
public final class Game {
    
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
    private World world;
    private Point worldOrigin;
    private GoodShip goodship;
    private Point goodshipOrigin;
    

    Game () {
        this.configDisplay();
        this.configOpenGL();
        this.initEntities();
        this.gameLoop();
        Display.destroy();
    }
    
    private void render () {
        glClear(GL_COLOR_BUFFER_BIT);
    }
    
    private void configOpenGL () {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Game.WIDTH, Game.HEIGHT, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
    }
    
    private void configDisplay () {
        try {
            Display.setDisplayMode (new DisplayMode(Game.WIDTH, Game.HEIGHT));
            Display.create ();
            Display.setTitle(this.WINDOW_TITLE);
        } catch (LWJGLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initEntities () {
        // Temp: Acá se inicializarán las entidades
        
        
    }
    
    public void gameLoop () {
        while (isRuning) {
            this.render();            
            this.frameRendering();
        }
    }
    
    public void frameRendering () {
        // Temp: Acá se dibujaran todo
        
        goodshipOrigin = new Point(400, 320);
        goodship = new GoodShip (goodshipOrigin);

        // GoodShip
        
        glBegin(GL_TRIANGLES);
                goodshipOrigin = goodship.getLeft();
                glVertex2i(goodshipOrigin.x, goodshipOrigin.y);
                goodshipOrigin = goodship.getRight();
                glVertex2i(goodshipOrigin.x, goodshipOrigin.y);
                goodshipOrigin = goodship.getDown();
                glVertex2i(goodshipOrigin.x, goodshipOrigin.y);
        glEnd();
        
        // Word
        
        worldOrigin = new Point();
        worldOrigin.x = 400;
        worldOrigin.y = 320;

        world = new World (worldOrigin);
        originAux = new Point(210, 100);
        glBegin(GL_LINES);
            worldOrigin = world.getupperLeft();
            glVertex2i(worldOrigin.x, worldOrigin.y);         
            worldOrigin = world.getupperRight(); 
            glVertex2i(worldOrigin.x, worldOrigin.y);
           
            glVertex2i(worldOrigin.x, worldOrigin.y);
            worldOrigin = world.getbottomRight();   
            glVertex2i(worldOrigin.x, worldOrigin.y);
            
            glVertex2i(worldOrigin.x, worldOrigin.y);
            worldOrigin = world.getbottomLeft(); 
            glVertex2i(worldOrigin.x, worldOrigin.y);
              
            glVertex2i(worldOrigin.x, worldOrigin.y);
            worldOrigin = world.getupperLeft();
            glVertex2i(worldOrigin.x, worldOrigin.y);
        glEnd();

        // Enemys
        
        Point vertexAux;
        originAux = new Point(210, 100);
        Point movementBeginAux;
        movementBeginAux = new Point (100, 100);
        Point movementEndAux;
        movementEndAux = new Point (400, 100);

        for (int i = 0; i < enemy.length; i++) {
            this.enemy[i] = new Enemy (originAux);
            this.enemy[0].setBegin(movementBeginAux);
            this.enemy[0].setEnd(movementEndAux);
            
            glBegin(GL_TRIANGLES);
                vertexAux = enemy[i].getLeft();
                glVertex2i(vertexAux.x, vertexAux.y);
                vertexAux = enemy[i].getRight();
                glVertex2i(vertexAux.x, vertexAux.y);
                vertexAux = enemy[i].getDown();
                glVertex2i(vertexAux.x, vertexAux.y);
            glEnd();
            
            this.originAux.x += 70;
            this.enemy[0].move();
        }
        
        Display.update();
        Display.sync(60);
            
        if (Display.isCloseRequested()) {
            isRuning = false;
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }
}
