/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;     
import java.awt.event.ActionListener;  
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author 645714
 */
@SuppressWarnings("serial")
public class GameFrame extends JPanel implements ActionListener{
    Timer mainTimer;
    static Paddle p1;
    static Paddle p2;
    Ball ball;
    static boolean quit = false;
    int player1 = 0, player2 = 0;
    String scores = "";
    
    public GameFrame() {
        setFocusable(true);
        p1 = new Paddle(1);
        p2 = new Paddle(2);
        ball = new Ball(650, 350);
        mainTimer = new Timer(10, this);
        mainTimer.start();
        addKeyListener(new KeyAdapt(p1));
        addKeyListener(new KeyAdapt(p2));
    }
    
   public void actionPerformed (ActionEvent arg0) {
	   ball.update();
	   checkEnd();
       repaint();
    }
    
    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        ball.draw(g2d);
        p1.draw(g2d);
        p2.draw(g2d);
    }
    
    public void checkEnd() {
        if ((ball.x+ball.getBallImg().getWidth(null))>1370 || (ball.x < -10)) {
        	if (ball.x+ball.getBallImg().getWidth(null)>1370 ) {
        		player1 += 20;
        	}
        	else if (ball.x < -10) {
        		player2 += 20;
        	}
        	scores = "PLAYER 1                                  PLAYER 2 \n" +  player1 + "                                                               " + player2;
        	JOptionPane.showMessageDialog(null, scores);
        	reset();
        }
        if (quit == true) {
        	System.exit(0);
        }
    }
    
    
    public static Paddle getpaddle1() {
    	return p1;
    }
    
    public static Paddle getpaddle2() {
    	return p2;
    }
    
    public void reset() {
    	ball.x = 650;
    	ball.y = 350;
    	p1.y = 300;
    	p2.y = 300;
    }

    

}
