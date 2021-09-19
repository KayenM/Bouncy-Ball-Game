import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Ball extends Entity {
	int speed=5;
	private int moveX;
	private int moveY;
	int x,y;
	
    public Ball (int x, int y){
    	super(x,y);
    	moveX=3;
    	moveY=2;   
    }
    public void update(){    
    	x+=moveX;
    	y+=moveY;
    	checkCollision();
    }
    public void checkCollision(){
    	if (x+getBallImg().getWidth(null) >1360){ 	//1360 is the width of the window
            moveX*=-1;				//changes moveX from 3 to -3
    	}if(x+getBallImg().getWidth(null)<0){
    		moveX*=-1;
    	}if(y+getBallImg().getHeight(null)<0){
    		moveY*=-1;
    	}if(y+getBallImg().getHeight(null)>680){
    		moveY*=-1;
    	}
    	ArrayList<Ufo> ufos = GameFrame.getUfoList();
    	for(int i=0;i<ufos.size();i++){
    		Ufo utemp = ufos.get(i);		//gets the next ufo for checking
        	if (getBounds().intersects(utemp.getBounds())){		//collision check here
                	//collision!  We therefore need to get rid of the offending Ufo…
            	GameFrame.removeUfo(utemp);
    	}
    	}

    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,getBallImg().getWidth(null),getBallImg().getHeight(null));
	}
    public void draw(Graphics2D g2d){
        g2d.drawImage(getBallImg(),x,y,null);
    }
    public Image getBallImg(){
        ImageIcon ic=new ImageIcon("E:/ball.png");
        return ic.getImage();
    }
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	if (key == KeyEvent.VK_W){  //w key, so move up
    		y-=speed;
    	}if(key == KeyEvent.VK_A) {
    		x-=speed;
    	}if(key == KeyEvent.VK_S) {
    		y+=speed;
    	}if(key == KeyEvent.VK_D) {
    		x+=speed;
    	}
    }
}
