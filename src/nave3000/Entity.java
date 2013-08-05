
package nave3000;

public abstract class Entity 
{
    private Point originPoint;
    
    protected void setX (int x) {
        this.originPoint.x = x;
    }
    
    protected void setY (int y) {
        this.originPoint.y = y;
    }
    
    protected int getX () {
        return this.originPoint.x;
    }
    
    protected int getY () {
        return this.originPoint.y;
    }
}
