
package nave3000;

public class Missile extends Entity{
      private Point up,down;
      Missile (Point origin){
       // Asignar Origen
        super (origin);
        
        this.up = new Point();
        this.up.x = super.getX();
        this.up.y = super.getY()-20;
        
        this.down = new Point();
        this.down.x = super.getX()+20;
        this.down.y = super.getY()+20;
      }
      public Point getup(){
      return this.up;
      }
      public Point getdown(){
      return this.down;
      }
}

