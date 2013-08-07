/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;
import static org.lwjgl.opengl.GL11.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.*;
import org.lwjgl.opengl.*;

/**
 *
 * @author writkas
 */
public class World extends Entity {
   
  private  Point upperLeft,bottomLeft,upperRight,bottomRight;
   World (Point origin){
        super (origin);
        this.upperLeft = new Point();
        this.upperLeft.x = super.getX()-50;
        this.upperLeft.y = super.getY()-50; 
        this.upperRight = new Point();
        this.upperRight.x = super.getX()+50;
        this.upperRight.y = super.getY()-50;
        this.bottomRight = new Point();
        this.bottomRight.x = super.getX()+50;
        this.bottomRight.y = super.getY()+50 ;
        this.bottomLeft = new Point();
        this.bottomLeft.x = super.getX()-50;
        this.bottomLeft.y = super.getY()+50; 
   } 
   public Point getupperLeft(){
     return this.upperLeft;
    }
    public Point getupperRight(){
    return this.upperRight;
    }   
    public Point getbottomRight(){
    return this.bottomRight;
   }
    public Point getbottomLeft(){
    return this.bottomLeft;    
    } 
}
