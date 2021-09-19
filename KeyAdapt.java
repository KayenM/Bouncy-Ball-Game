
import java.awt.event.KeyAdapter;   //note these new key imports
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	Ball b;   //this Class has a variable which will be the Ball so all keypress
                     //handling happens in Ball Class because of the variable’s Ball type
        
	public KeyAdapt(Ball ball){ //the ball is received from GameFrame after Ball is created
		b=ball;   //this sets the sent ball as the one being key controlled
	}
	
	public void keyPressed(KeyEvent e){
		b.keyPressed(e);    //method from Ball Class dictates reaction to keystrokes
	}
	 
}

