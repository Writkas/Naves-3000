
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
    
    private Point left, right, down;
    private Point begin,end;
    
    GoodShip (Point origin)
    {
        // Asignar Origen
        super (origin);
        
        // Asignar vertices
        this.left = new Point();
        this.left.setX(super.getX());
        this.left.y = super.getY() - this.SIZE;
        
        this.right = new Point();
        this.right.x = super.getX() + this.SIZE;
        this.right.y = super.getY() + this.SIZE;
        
        this.down = new Point();
        this.down.x = super.getX() - this.SIZE;
        this.down.y = super.getY() + this.SIZE;
        
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
        return this.down;
    }
    
    public void moveRight()
    {
        if (super.getX() <= this.end.x) {
            this.left.x += this.MOVEMENT ;
            this.right.x += this.MOVEMENT;
            this.down.x += this.MOVEMENT;
            super.setX(super.getX() + this.MOVEMENT);
        }
    }
    
    public void moveLeft()
    {
        if (super.getX() >= this.begin.x) {
            this.left.x -= this.MOVEMENT;
            this.right.x -= this.MOVEMENT;
            this.down.x -= this.MOVEMENT;
            super.setX(super.getX() - this.MOVEMENT);
        }
    }
}