
package nave3000;

public abstract class Entity 
{
    private Point originPoint;
    
    Entity (Point origin)
    {
        originPoint = new Point();
        this.originPoint.setX(origin.getX());
        this.originPoint.setY(origin.getY());
    }
    
    protected void setX (int x)
    {
        this.originPoint.setX(x);
    }
    
    protected void setY (int y)
    {
        this.originPoint.setY(y);
    }
    
    protected int getX ()
    {
        return this.originPoint.getX();
    }
    
    protected int getY ()
    {
        return this.originPoint.getY();
    }
    
    protected Point getOrigin ()
    {
        return this.originPoint;
    }
    
    // Temp: getY debería llamarse getOriginY, para hacer referencia al origen.
}
