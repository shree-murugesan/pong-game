import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle {
	int y = 300, x = 650;
	int moveX = 3;
    int moveY = 2;
    String img;
    boolean quit = false;
	
	public Paddle (int p) {
		if (p == 1) {
			img = "G:/Downloads/player1.jpg";
			x = 10;
		}
		else if (p == 2) {
			img = "G:/Downloads/player2.jpg";
			x = 1290;
		}
	}
	
	public void draw (Graphics2D g2d) {
        g2d.drawImage(getPaddleImg(), x, y, null);
    }
	
	public Image getPaddleImg() {
        ImageIcon ic = new ImageIcon(img);
        return ic.getImage();
    }
	
	public Rectangle getBounds() {
        return new Rectangle (x, y, getPaddleImg().getWidth(null), getPaddleImg().getHeight(null));
    }
    
    public void update () {
        
    }
    
    public void keyPressed (KeyEvent e) {
    	int key = e.getKeyCode();
    	if (key == KeyEvent.VK_ENTER){
    		GameFrame.quit = true;
    	}
    	else if (img.equals("G:/Downloads/player1.jpg")) {
	    	if (key == KeyEvent.VK_W && y > 19){  
	    		y -= 50;
	    	}
	    	else if (key == KeyEvent.VK_S && y+getPaddleImg().getHeight(null) < 631){
	    		y += 50;
	    	}
    	}
    	else {
    		if (key == KeyEvent.VK_UP && y > 49){  
	    		y -= 50;
	    	}
	    	else if (key == KeyEvent.VK_DOWN && y+getPaddleImg().getHeight(null)< 631){
	    		y += 50;
	    	}
    	}
    	
    }

}
