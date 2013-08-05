
package nave3000;

public abstract class Entity 
{
    private Point point;
    
    protected void setX (int x) {
        this.point.x = x;
    }
    
    protected void setY (int y) {
        this.point.y = y;
    }
    
    protected int getX () {
        return this.point.x;
    }
    
    protected int getY () {
        return this.point.y;
    }
}
