/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;
/**
 *
 * @author Debora-Pato
 */
public class GoodShip extends Entity {
    
    private Point left, right, down;

    GoodShip (Point origin) {
        // Asignar Origen
        super (origin);
        
        // Asignar vertices
        this.left = new Point();
        this.left.x = super.getX() - 20;
        this.left.y = super.getY() - 20;
        
        this.right = new Point();
        this.right.x = super.getX() + 20;
        this.right.y = super.getY() - 20;
        
        this.down = new Point();
        this.down.x = super.getX();
        this.down.y = super.getY() + 20;
    }
    
    public Point getLeft(){
    return this.left;
    }
    public Point getRight(){
    return this.right;
    }
    public Point getDown(){
    return this.down;
    }
}
