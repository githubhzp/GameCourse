package thunder;

import java.awt.Container;
import javax.swing.JFrame;

public class PlaneFrame extends JFrame{
	public PlaneFrame(){
		setTitle("Thunder");
		GamePanel panel=new GamePanel();
		Container contentpane=getContentPane();
		contentpane.add(panel);
		pack();
	}
	
	public static void main(String args[]){
		PlaneFrame el=new PlaneFrame();
		el.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		el.setLocation(450, 100);
		el.setVisible(true);
	}
}
