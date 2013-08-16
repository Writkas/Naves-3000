
package nave3000;

public class GoodShip extends Entity {
    
    private Point left, right, down;
    private Point begin,end;
    
    GoodShip (Point origin) {
        // Asignar Origen
        super (origin);
        
        // Asignar vertices
        this.left = new Point();
        this.left.x = super.getX();
        this.left.y = super.getY() - 20;
        
        this.right = new Point();
        this.right.x = super.getX() + 20;
        this.right.y = super.getY() + 20;
        
        this.down = new Point();
        this.down.x = super.getX() - 20;
        this.down.y = super.getY() + 20;
        
        this.begin = new Point (85,0);
        this.end = new Point (715,0);
    }
   
    public Point getLeft() {
        return this.left;
    }
    
    public Point getRight() {
        return this.right;
    }
    
    public Point getDown() {
        return this.down;
    }
    
    public void moveRight() {
        if (super.getX() <= this.end.x) {
            this.left.x +=5 ;
            this.right.x += 5;
            this.down.x += 5;
            super.setX(getX()+5);
        }
        
        System.out.println(super.getX());
    }
    
    public void moveLeft(){
        if (super.getX() >= this.begin.x) {
            this.left.x -=5;
            this.right.x -=5;
            this.down.x -=5;
            super.setX(getX()-5);
        }
        System.out.println(super.getX());
    }
}