
package nave3000;

public class Missile extends Entity {
    
    /*
     * Constants
     */
    
    private final int SIZE = 1; // Size of the Missile
    private final int MOVEMENT = 10;
    
    /*
     * Variables
     */
    
    private Point up, down;
    private Point end;
    private boolean onScreen = false;
    
    Missile (Point origin) {    
        // Assign origin
        super (origin);
        
        this.up = new Point();
        this.up.setX(super.getX());
        this.up.setY(super.getY() - this.SIZE);
       
        this.down = new Point();
        this.down.setX(super.getX());
        this.down.setY(super.getY() + this.SIZE);
        
        // Missile end
        this.end = new Point (super.getX(), 90);

        // This on screen ?
        onScreen = true;
    }
    
    public int getUpY () {
        return this.up.getY();
    }
    
    public int getDownY () {
        return this.down.getY();
    }
    
    public int getUpX () {
        return this.up.getX();
    }
    
    public int getDownX () {
        return this.down.getX();
    }
    
    public boolean endCollided () {
        return (this.up.getY() <= this.end.getY()) ? true : false;
    }
    
    public void moveUp () {
        if (super.getY() >= this.end.getY()) {
            // Move vertex of Missile
            this.up.setY(this.up.getY() - this.MOVEMENT);
            this.down.setY(this.up.getY() - this.MOVEMENT);
            // Move origin of Missile
            super.setY(super.getY() - this.MOVEMENT);
        }
    }
    
    public void moveDown () {
        
    }
}
