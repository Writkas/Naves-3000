
package nave3000;

public class Enemy extends Entity {
   
    private Point up, right, left;
    
    Enemy (Point origin) {
        // Asignar Origen
        super (origin);
        
        // Asignar vertices
        this.up.x = super.getX();
        this.up.y = super.getY() - 20;
        
        this.right.x = super.getX() + 20;
        this.right.y = super.getY() + 20;
        
        this.left.x = super.getX() - 20;
        this.left.y = super.getY() + 20; 
    }
    
    public void shoot () {
        
    }
    
    public void move () {
        
    }
    
    public void draw () {
        // Temp: Sólo dibuja
    }
}
