
package nave3000;

public class Enemy extends Entity 
{
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
    

    
    Enemy (Point origin)
    {
        // Assign origen
        super (origin);
        
        // Assign vertex
        this.left = new Point();
        this.left.setX(super.getX() - this.SIZE);
        this.left.setY(super.getY() - this.SIZE);
        
        this.right = new Point();
        this.right.setX(super.getX() + this.SIZE);
        this.right.setY(super.getY() - this.SIZE);
        
        this.down = new Point();
        this.down.setX(super.getX());
        this.down.setY(super.getY() + this.SIZE);
        
        // Default without movement
        this.begin = new Point ();
        this.end = new Point ();
    }
 
    public void move ()
    {
        // Right movement
        if (this.movementState == 1) {
            moveRight ();
            
            if (super.getX() >= this.end.getX())
                this.movementState = 2; // Left
        }
        
        // Left movement
        if (this.movementState == 2) {
            moveLeft ();
            
            if (super.getX() <= this.begin.getX())
                this.movementState = 1; // Right
        }
    }
    
    public void setBegin (Point begin)
    {
        this.begin.setX(begin.getX());
        this.begin.setY(begin.getY());
    }
    
    public void setEnd (Point end)
    {
        this.end.setX(end.getX());
        this.end.setY(end.getY());
    }
    
    public Point getLeft()
    {
        return this.left;
    }
    
    public Point getRight()
    {
        return this.right;
    }  
    
    public Point getDown()
    {
        return this.down;
    }
    
    private void moveLeft ()
    {
        // Move vertex
        super.setX(super.getX() - MOVEMENT);
        this.left.setX(this.left.getX() - this.MOVEMENT);
        this.right.setX(this.right.getX() - this.MOVEMENT);
        this.down.setX(this.down.getX() - this.MOVEMENT);
    }
    
    private void moveRight ()
    {
        // Move vertex
        super.setX(super.getX() + MOVEMENT);
        this.left.setX(this.left.getX() + this.MOVEMENT);
        this.right.setX(this.right.getX() + this.MOVEMENT);
        this.down.setX(this.down.getX() + this.MOVEMENT);
    }

    boolean isDamanged (int x, int y)
    {
       boolean collisionDetection = (super.getX() - this.SIZE_IN_X <= x 
               && super.getX() + this.SIZE_IN_X >= x
               && super.getY() + this.SIZE  >= y);
       
       return (collisionDetection) ? true : false;
    }
}
