/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nave3000;

/**
 *
 * @author writkas
 */
public class World extends Entity {
   
   Point upperLeft, upperRight, bottomRight, bottomLeft;
    
   World (Point upperLeft, Point upperRight, 
          Point bottomRight, Point bottomLeft) {
      this.upperLeft.x = upperLeft.x;
      this.upperLeft.y = upperLeft.y;
      this.upperRight.x= upperRight.x;
      this.upperRight.y= upperRight.y;
      this.bottomRight.x= bottomRight.x;
      this.bottomRight.y= bottomRight.y;
      this.bottomLeft.x= bottomLeft.x;
      this.bottomLeft.y= bottomLeft.y;
      
        
      
   }
}
