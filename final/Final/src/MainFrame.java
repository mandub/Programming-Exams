// name : Almandub 
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JFrame myFrame = new JFrame("Game");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add the panel
		MainPanel myPanel = new MainPanel();
				
		myFrame.getContentPane().add(myPanel);
		
		myFrame.pack();
		
		myFrame.setVisible(true);


	}

}
