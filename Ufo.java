import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Ufo extends Entity{
	public Ufo(int x, int y) {
		super(x, y);
	}
	public void update(){	
	}
	public void draw(Graphics2D g2d){
        g2d.drawImage(getUfoImg(),x,y,null);
    }
	 public Image getUfoImg(){
	        ImageIcon ic=new ImageIcon("E:/ufo.png");
	        return ic.getImage();
	   }
	public Rectangle getBounds(){
        return new Rectangle(x,y,getUfoImg().getWidth(null),getUfoImg().getHeight(null));
	}
	
   
}
