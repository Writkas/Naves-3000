
package nave3000;

public abstract class Entity 
{
    private Point originPoint;
    
    Entity (Point origin) {
        originPoint = new Point();
        this.originPoint.x = origin.x;
        this.originPoint.y = origin.y;
    }
    
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
    
    protected Point getOrigin () {
        return this.originPoint;
    }
    
    // Temp: getY debería llamarse getOriginY, para hacer referencia al origen.
}
