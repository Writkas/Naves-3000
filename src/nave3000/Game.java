
package nave3000;

// Core Java Imports
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

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
    private static String WINDOW_TITLE = "Nave3000";
    private static final int TOTAL_ENEMYS = 6;
     
    /*
     *  Atributes
     */
    
    private ArrayList <Enemy> enemies;
    private Enemy enemyAux;
    private boolean isRuning = true;
    private World world;
    private Point worldOrigin;
    private GoodShip goodShip;
    private Point goodShipOrigin;
    // Varialbe temporal para asignar el origen de una figura
    private Point originAux;
    private Missile missile;
    private Point missileOrigin;
    
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
            Display.setTitle(Game.WINDOW_TITLE);
        } catch (LWJGLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initEntities () {
        enemies = new ArrayList <> ();

        // World
        
        worldOrigin = new Point(400, 320);
        world = new World (worldOrigin);
        originAux = new Point();
        
        // Goodship
       
        goodShipOrigin = new Point(400, 540);
        goodShip = new GoodShip (goodShipOrigin);
        
        // Missile
        missileOrigin = new Point(400,500);
        missile = new Missile(missileOrigin);
        
        // Punto inicial de los enemigos
        originAux.x = 130;
        originAux.y = 100;
        
        // Crea los enemigos y asigno el origen de los enemigos
        for (int i = 0; i < Game.TOTAL_ENEMYS; i++) {
            this.originAux.x += 75;
            this.enemies.add(new Enemy (originAux));
        }
        
        // Asignando el inicio y fin de los movimientos de los enemigos
        for (int i = 0; i < Game.TOTAL_ENEMYS; i++) {
            enemyAux = this.enemies.get(i);
            this.enemies.get(i).setBegin(new Point (75 + 75 * i, 0));
            this.enemies.get(i).setEnd(new Point (350 + 75 * i, 0));
        }
    }
    
    public void gameLoop () {
        while (isRuning) {
            this.render();            
            this.frameRendering();
        }
    }
    
    public void frameRendering () {
        
        // GoodShip
        
        glColor3f(0, 0.5f, 0.5f);
        
        glBegin(GL_TRIANGLES);
            glVertex2i(this.goodShip.getLeft().getX(), 
                    this.goodShip.getLeft().getY());
            glVertex2i(this.goodShip.getRight().getX(), 
                    this.goodShip.getRight().getY());
            glVertex2i(this.goodShip.getDown().getX(), 
                    this.goodShip.getDown().getY());
        glEnd();
        
        // GoodShip (Life)
        
        glBegin(GL_TRIANGLES);
            glVertex2i(30, 10);
            glVertex2i(50, 50);
            glVertex2i(10, 50);
        glEnd();
        
        // Word

        glColor3f(0, 0, 1);
        glLineWidth(3);

        glBegin(GL_LINE_LOOP);
            glVertex2i(world.getupperLeft().getX(), 
                    world.getupperLeft().getY());         
            glVertex2i(world.getupperRight().getX(), 
                    world.getupperRight().getY());
            glVertex2i(world.getbottomRight().getX(), 
                    world.getbottomRight().getY());
            glVertex2i(world.getbottomLeft().getX(), 
                    world.getbottomLeft().getY());
        glEnd();

        // Enemys
        
        glColor3f(1, 0, 0); // Red
        
        // Place enemies on the screen, also moves
        for (int i = 0; i < Game.TOTAL_ENEMYS; i++) {
            glBegin(GL_TRIANGLES);
                glVertex2i(this.enemies.get(i).getLeft().getX(), 
                        this.enemies.get(i).getLeft().getY());
                glVertex2i(this.enemies.get(i).getRight().getX(), 
                        this.enemies.get(i).getRight().getY());
                glVertex2i(this.enemies.get(i).getDown().getX(), 
                        this.enemies.get(i).getDown().getY());
            glEnd();
            
            this.enemies.get(i).move();
        }
        
        // Missile
        
        glBegin(GL_LINES);
            missileOrigin = missile.getup();
            glVertex2i(missileOrigin.x, missileOrigin.y); 
            missileOrigin= missile.getdown();
            glVertex2i(missileOrigin.x, missileOrigin.y); 
        glEnd();
        
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            Display.destroy();
            System.exit(0);
        }
        
        else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            goodShip.moveLeft();
        }
          
        else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            goodShip.moveRight();
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            missile.Shoot();

        }         
        else if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            goodShip.moveRight();
        }
        Display.update();
        Display.sync(60);
    
        if (Display.isCloseRequested()) {
            isRuning = false;
        }}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game();
    }
}
