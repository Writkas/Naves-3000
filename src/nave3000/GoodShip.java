
package nave3000;

public class GoodShip extends Entity
{
    /*
     * Constant
     */
    
    private final int MOVEMENT = 5;
    private final int SIZE = 20;
    
    /*
     * Variables
     */
    
    private Point left, right, up;
    private Point begin, end;
    
    GoodShip (Point origin)
    {
        // Asignar Origen
        super (origin);
        
        // Asignar vertices
        this.left = new Point();
        this.left.setX(super.getX());
        this.left.setY(super.getY() - this.SIZE);
        
        this.right = new Point();
        this.right.setX(super.getX() + this.SIZE);
        this.right.setY(super.getY() + this.SIZE);
        
        this.up = new Point();
        this.up.setX(super.getX() - this.SIZE);
        this.up.setY(super.getY() + this.SIZE);
        
        this.begin = new Point (85,0);
        this.end = new Point (715,0);
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
        return this.up;
    }
    
    public void moveRight()
    {
        if (super.getX() <= this.end.getX()) {
            this.left.setX(this.left.getX() + this.MOVEMENT);
            this.right.setX(this.right.getX() + this.MOVEMENT);
            this.up.setX(this.up.getX() + this.MOVEMENT);
            super.setX(super.getX() + this.MOVEMENT);
        }
    }
    
    public void moveLeft()
    {
        if (super.getX() >= this.begin.getX()) {
            this.left.setX(this.left.getX() - this.MOVEMENT);
            this.right.setX(this.right.getX() - this.MOVEMENT);
            this.up.setX(this.up.getX() - this.MOVEMENT);
            super.setX(super.getX() - this.MOVEMENT);
        }
    }
}