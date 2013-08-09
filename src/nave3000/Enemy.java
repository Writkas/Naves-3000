
package nave3000;

public class Enemy extends Entity {
   
    /*
     * Attributes
     */
    
    private Point left, right, down;
    // Movement respect of origin
    private Point begin, end;
    // Movement state 1: right, 2: left
    private int movementState = 1;
    
    /*
     * Constant
     */
    
    private final int MOVEMENT = 1; // 1px
    
    Enemy (Point origin) {
        // Assign origen
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
        
        // Por defecto sin movimiento
        this.begin = new Point (0, 0);
        this.end = new Point (0, 0);
    }
 
    public void move () {
        System.out.println("Move!");
        
        // Right movement
        if (movementState == 1) {
            moveRight ();
            
            if (super.getX() >= this.end.x) {
                System.out.println("Hola1!");
                movementState = 2; // Left
            }
        }
        
        // Left movement
        if (movementState == 2) {
            moveLeft ();
            
            if (super.getX() <= this.begin.x) {
                System.out.println("Hola2!");
                movementState = 1; // Right
            }
        }
        
        System.out.println (movementState);
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
}
