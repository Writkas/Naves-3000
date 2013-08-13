
package nave3000;

public class Missile extends Entity {
    private Point up, down;
    private Point begin, end;
    
    Missile (Point origin) {
        // Asignar Origen
        super (origin);
        
        this.up = new Point();
        this.up.x = super.getX();
        this.up.y = super.getY() - 20;
        
        this.down = new Point();
        this.down.x = super.getX();
        this.down.y = super.getY() + 15;
        this.begin = new Point (0,500);
        this.end = new Point (0,100);
    }
    
    public Point getup () {
        return this.up;
    }
    
    public Point getdown () {
        return this.down;
    }
    
    public void Shoot() {
        if (super.getY() >= this.end.y) {
            this.up.y-= 10;
            super.setY(getY()-10);
        }  
    } 
}
