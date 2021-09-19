import javax.swing.JFrame;
public class BouncyBall {
	public static void main(String[] args) {
        JFrame frame = new JFrame("BouncyBallGame");	//sets up the frame
        frame.setSize(1360,680);				//sizes it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //activates the close icon
        frame.setResizable(false);				//prevents resizing by users
        frame.add(new GameFrame());			//creates the game window itself
        frame.setVisible(true);					//makes it visible
   	}
}
