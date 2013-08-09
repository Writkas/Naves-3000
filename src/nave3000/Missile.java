/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
/**
 *
 * @author writkas
 */
public class Missile extends Entity{
      private Point up,down;
      private Point inicio,fin;
      Missile (Point origin){
       // Asignar Origen
        super (origin);
        
        this.up = new Point();
        this.up.x = super.getX();
        this.up.y = super.getY()-20;
        
        this.down = new Point();
        this.down.x = super.getX();
        this.down.y = super.getY()+15;
        this.inicio= new Point (0,500);
        this.fin=new Point (0,100);
      }
      public Point getup (){
      return this.up;
      }
      public Point getdown (){
      return this.down;
      }
       public void Shoot(){
     if (super.getY() >= this.fin.y) {
        this.up.y-= 10;
        super.setY(getY()-10);
         }  
       } 
     }

        


