
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.net.*;

import javax.swing.ImageIcon;


public class Ball {
    int moveX, moveY, speed = 100;
    int x, y;
   
    
    public Ball (int x, int y) {
        this.x = x;
        this.y = y;
        moveX = 6;
        moveY = 5;
    }
    
    public void update () {
        x += moveX;
        y += moveY;
        checkCollisions();
    }
    
    public void draw (Graphics2D g2d) {
        g2d.drawImage(getBallImg(), x, y, null);
    }
    
    public Image getBallImg() {
        ImageIcon ic = new ImageIcon("G:/Downloads/bouncysmall.png");
        return ic.getImage();
    }
    
    public Rectangle getBounds() {
        return new Rectangle (x, y, getBallImg().getWidth(null), getBallImg().getHeight(null));
    }
    
    public void checkCollisions() {
        Paddle p1 = GameFrame.getpaddle1();
        Paddle p2 = GameFrame.getpaddle2();
       
        if (y+getBallImg().getHeight(null)> 655){
            moveY*=-1;
            wallHit();
        }
        if (y < 0) {
            moveY*=-1;
            wallHit();
        }
        
       if (getBounds().intersects(p1.getBounds())) {
            moveX *= -1;
            paddleHit();
       }
       
       if (getBounds().intersects(p2.getBounds())) {
           moveX *= -1;
           paddleHit();
      }
   }
   
}
