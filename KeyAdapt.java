
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter{
	Paddle p;
	
	public KeyAdapt (Paddle paddle) {
		p = paddle;
	}
	
	public void keyPressed (KeyEvent e) {
		p.keyPressed(e);
	}
}
