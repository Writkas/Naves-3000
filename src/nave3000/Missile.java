
package nave3000;

public class Missile extends Entity{
      private Point up,down;
      private Point inicio,fin;
      Missile (Point origin){
       // Asignar Origen
        super (origin);
        
        this.up = new Point();
        this.up.x = super.getX();
        this.up.y = super.getY()-20;
        
        this.down = new Point();
        this.down.x = super.getX();
        this.down.y = super.getY()+15;
        this.fin = new Point (0,100);
      }
      public Point getup (){
      return this.up;
      }
      public Point getdown (){
      return this.down;
      }
       public void Shoot(){
     if (super.getY() >= this.fin.y) {
        this.up.y-= 5;
        this.down.y-=5;
        super.setY(getY()-5);
         }  
       } 
     }

        


