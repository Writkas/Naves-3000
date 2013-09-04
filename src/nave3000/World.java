
package nave3000;

public class World extends Entity {
   
    private  Point upperLeft, bottomLeft, upperRight,  bottomRight;
  
    World (Point origin) {
        super (origin);
        
        this.upperLeft = new Point();
        this.upperLeft.x = super.getX() - 350;
        this.upperLeft.y = super.getY() - 250; 
        
        this.upperRight = new Point();
        this.upperRight.x = super.getX() + 350;
        this.upperRight.y = super.getY() - 250;
        
        this.bottomRight = new Point();
        this.bottomRight.x = super.getX() + 350;
        this.bottomRight.y = super.getY() + 250;
        
        this.bottomLeft = new Point();
        this.bottomLeft.x = super.getX() - 350;
        this.bottomLeft.y = super.getY() + 250;
        
        this.bottomLeft = new Point();
        this.bottomLeft.x = super.getX() - 350;
        this.bottomLeft.y = super.getY() + 250; 
    }
   
    public Point getupperLeft () {
        return this.upperLeft;
    }
    
    public Point getupperRight () {
        return this.upperRight;
    }
    
    public Point getbottomRight () {
        return this.bottomRight;
    }
    
    public Point getbottomLeft () {
        return this.bottomLeft;    
    } 
}
