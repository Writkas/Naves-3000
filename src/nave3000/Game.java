
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
public final class Game
{
    /*
     *  Constant
     */
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String WINDOW_TITLE = "Nave 3000";
    private static final int TOTAL_ENEMIES = 6;
    private static final int TOTAL_SHOTS = 1;
    
    /*
     *  Variables
     */
    
    private ArrayList <Enemy> enemies;
    private ArrayList <Missile> missiles;
    private int missilesOnScreen = 0;
    private boolean isRuning = true;
    private World world;
    private GoodShip goodShip;
    // Variable temporal para asignar el origen de una figura
    private Point originAux;
    // Movement
    private int dX = 1, dY = 1; 
    // Time and Frames
    private static long lastFrame;
    private double delta;
    
    Game ()
    {
        this.configDisplay();
        this.configOpenGL();
        this.initEntities();
        this.gameLoop();
        Display.destroy();
    }
    
    private void render ()
    {
        glClear(GL_COLOR_BUFFER_BIT);
    }
    
    private void configOpenGL ()
    {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Game.WIDTH, Game.HEIGHT, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
    }
    
    private void configDisplay ()
    {
        try {
            Display.setDisplayMode (new DisplayMode(Game.WIDTH, Game.HEIGHT));
            Display.create ();
            Display.setTitle(Game.WINDOW_TITLE);
        } 
        
        catch (LWJGLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void initEntities () 
    {    
        // World
        //
        
        world = new World (new Point(400, 320));
        
        // Goodship
        //
        
        goodShip = new GoodShip (new Point(400, 540));
        
        // Missile
        //
        
        // Init ArrayList
        missiles = new ArrayList <> ();
        
        // Enemies
        //
        
        // Init ArrayList
        enemies = new ArrayList <> ();

        // Initial point of the enemies
        originAux = new Point (130, 100);
        
        // Create the enemies and assign origin of enemies
        for (int i = 0; i < Game.TOTAL_ENEMIES; i++) {
            this.originAux.setX(this.originAux.getX() + 75);
            this.enemies.add(new Enemy (originAux));
        }
        
        // Assign the begin and end of the movements of the enemies
        for (int i = 0; i < Game.TOTAL_ENEMIES; i++) {
            this.enemies.get(i).setBegin(new Point (75 + 75 * i, 0));
            this.enemies.get(i).setEnd(new Point (350 + 75 * i, 0));
        }
    }
    
    public void gameLoop ()
    {
        while (isRuning) {
            this.render();            
            this.frameRendering();
        }
    }
    
    public void frameRendering ()
    {
        
        delta = getDelta();
        
        // GoodShip
        //
        
        glColor3f(0f, 0.5f, 0.5f);
        
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
        //

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
        //
        
        glColor3f(1, 0, 0); // Red
        
        // Place enemies on the screen, also moves
        for (int i = 0; i < Game.TOTAL_ENEMIES; i++) {            
            try {
                if (this.enemies.get(i) != null) {
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
            }
            
            catch (java.lang.IndexOutOfBoundsException ioobe) {
                System.out.println (ioobe.getClass());
            }
        }
        
        // Missile
        //

        // Mover los misiles en caso de que hayan alguno/s en pantalla, también
        // detecta colisiones con el final de recorrido del misil.
        if (this.missilesOnScreen > 0) {
            for (int i = 0; i < this.missilesOnScreen; i++) {
                glBegin(GL_LINES);
                    glVertex2i(this.missiles.get(i).getUpX(), 
                            this.missiles.get(i).getUpY()); 
                    glVertex2i(this.missiles.get(i).getDownX(), 
                            this.missiles.get(i).getDownY()); 
                glEnd();
                
                this.missiles.get(i).moveUp();
                
                 // Collides?
                if (this.missiles.get(i).endCollided()) {
                    this.missiles.remove(i);
                    missilesOnScreen--;
                }
            }
        }
        
        // Interactions
        //
        
        // Interactions enemies with missiles       
        for (int i = 0; i < Game.TOTAL_ENEMIES; i++) {
            for (int j = 0; j < this.missilesOnScreen; j++) {
                try {
                    if (this.enemies.get(i).isDamanged(
                            this.missiles.get(j).getUpX(), 
                            this.missiles.get(j).getUpY())) {
                        this.enemies.remove(i);
                    }
                }
                
                catch (java.lang.IndexOutOfBoundsException iofbe) {
                    System.out.println ("test1");
                }
            }
        }
        
        // Keyboard
        //
        
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
        
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            if (missilesOnScreen < Game.TOTAL_SHOTS) {
                this.missiles.add(new Missile(this.goodShip.getOrigin()));
                missilesOnScreen++;
            }
        }
        
        else if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            goodShip.moveRight();
        }
        
        Display.update();
        Display.sync(60);
    
        if (Display.isCloseRequested()) {
            isRuning = false;
        }
    }
    
    private static long getTime()
    {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private static double getDelta()
    {
        long currentTime = getTime();
        double delta = (double) (currentTime - lastFrame);
        lastFrame = getTime();
        
        return delta;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new Game();
    }
}
