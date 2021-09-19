import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;		//to set random Ufo locations
import java.awt.event.ActionEvent;      //for timer
import java.awt.event.ActionListener;   //for timer
import java.util.ArrayList;		//because we have an ArrayList of Ufos
import javax.swing.JPanel;
import javax.swing.Timer;		//timer import

public class GameFrame extends JPanel implements ActionListener{
		Timer mainTimer;
	   Ball ball;
	   Random rand = new Random();     //seed the random generator
	   static ArrayList<Ufo> ufos = new ArrayList<Ufo>();  //set up ufo group – empty but ready
	   
	public GameFrame(){
        setFocusable(true);
        ball = new Ball(650,350);		//creates ball in center of window
        mainTimer = new Timer(10,this);     //sets Timer object to 10 milliseconds
        mainTimer.start();                  //to start the timer
        setUfos();      //calls the method below for setting up the ufos randomly
        addKeyListener(new KeyAdapt(ball));
	}

	public void setUfos() {
		for(int i=0;i<5;i++){
			ufos.add(new Ufo(rand.nextInt(1300),rand.nextInt(620)));
		}
	}
	public void actionPerformed(ActionEvent arg0){  //this method nec'y for timers
        ball.update();                              
        checkEnd();
        repaint();
    }
	public void checkEnd() {
		if (ufos.size()==0){
			System.exit(0);
		}
		
	}
	public void paint(Graphics g){	//this method paints everything onto the screen
        super.paint(g);
        Graphics2D g2d  = (Graphics2D) g;  //cast g as Graphics2d 
              //type for powerful graphics, and sets g2d as the reference.
        ball.draw(g2d);		//draw the updated ball in its new position
        for (int i=0;i<ufos.size();i++){    //draw the ArrayList of ufos (which is
            Ufo tempUfo = ufos.get(i);   //changing in size as we go)
            tempUfo.draw(g2d);
        }
    }
	 public static ArrayList<Ufo> getUfoList(){	//an ArrayList of Ufo type
	        return ufos;				//gets provided to checkCollisions()
	 }
	 public static void removeUfo(Ufo u){		//the ArrayList remove command is 
	        ufos.remove(u);				// from the Java Summary
	 }  


}
