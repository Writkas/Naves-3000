
package nave3000;

public class Enemy extends Entity {
    
    /*
     * Constants
     */
    
    private final int MOVEMENT = 1; // 1px
    private final int SIZE = 20;
    private final int SIZE_IN_X = this.SIZE / 2;
    
    /*
     * Variables
     */
    
    private Point left, right, down;
    // Movement respect of origin
    private Point begin, end;
    // Movement state 1: right, 2: left
    private int movementState = 1;
    

    
    Enemy (Point origin) {
        // Assign origen
        super (origin);
        
        // Asignar vertices
        this.left = new Point();
        this.left.x = super.getX() - this.SIZE;
        this.left.y = super.getY() - this.SIZE;
        
        this.right = new Point();
        this.right.x = super.getX() + this.SIZE;
        this.right.y = super.getY() - this.SIZE;
        
        this.down = new Point();
        this.down.x = super.getX();
        this.down.y = super.getY() + this.SIZE;
        
        // Por defecto sin movimiento
        this.begin = new Point (0, 0);
        this.end = new Point (0, 0);
    }
 
    public void move () {
        
        // Right movement
        if (movementState == 1) {
            moveRight ();
            
            if (super.getX() >= this.end.x)
                movementState = 2; // Left
        }
        
        // Left movement
        if (movementState == 2) {
            moveLeft ();
            
            if (super.getX() <= this.begin.x)
                movementState = 1; // Right
        }
    }
    
    public void setBegin (Point begin) {
        this.begin.x = begin.x;
        this.begin.y = begin.y;
    }
    
    public void setEnd (Point end) {
        this.end.x = end.x;
        this.end.y = end.y;
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
    
    private void moveLeft () {
        // Move vertex
        super.setX(super.getX() - MOVEMENT);
        this.left.x -= MOVEMENT;
        this.right.x -= MOVEMENT;
        this.down.x -= MOVEMENT; 
    }
    
    private void moveRight () {
        // Move vertex
        super.setX(super.getX() + MOVEMENT);
        this.left.x += MOVEMENT;
        this.right.x += MOVEMENT;
        this.down.x += MOVEMENT; 
    }

    boolean isDamanged (int x, int y) {
       boolean result = false;
       boolean collisionDetection = (super.getX() - this.SIZE_IN_X <= x 
               && super.getX() + this.SIZE_IN_X >= x
               && super.getY() + this.SIZE  >= y);
       
       if (collisionDetection) {
           result = true;
           System.out.println ("OMG!! is " + result);
       }
       
       return result;
    }
}
