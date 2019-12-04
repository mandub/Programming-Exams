import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class MainPanel extends JPanel implements KeyListener {
	GridBagConstraints gbc;
	//private static ArrayList<Words> wordslist = new ArrayList<Words>() ;
	JPanel currentPanel = this;
	ImageIcon player = new ImageIcon("./src/D.jpg");
	ImageIcon enemy = new ImageIcon("./src/S.jpg");
	JLabel TimerLabel;
	JLabel TimerLabel2;
	JLabel nameLabel;
	JTextField nametext;
	JLabel numberLabel;
	JTextField numbertext;
	JLabel emailLabel;
	JTextField emailtext;
	JButton myButton;
	 Logger logger = Logger.getLogger("MyLog");
	 FileHandler fh;  
	int x=100;
	int y=100;
	int x2=600;
	int y2=600;
	{
	 try {  

         // This block configure the logger with handler and formatter  
         fh = new FileHandler("MyLogFile.log");  
         logger.addHandler(fh);
         SimpleFormatter formatter = new SimpleFormatter();  
         fh.setFormatter(formatter);  

         // the following statement is used to log any messages  

     } catch (SecurityException e1) {  
         e1.printStackTrace();  
     } catch (IOException e) {  
         e.printStackTrace();  
     }  

     
	}
	Timer mytimer;
	int seconds=30;
	TimerTask task = new TimerTask (){
		public void run (){
			if (seconds >= 0){
		TimerLabel2.setText(Integer.toString(seconds--));
		x2=((x2+x)/2);
		y2=((y2+y)/2);
			}
		 if (seconds == 0)
		 {
			 //gbc.gridx = 0;
		        //gbc.gridy = 50;
		        gbc.gridx =gbc.gridx-50 ;
		        gbc.gridy =gbc.gridy+50 ;
		        add(nameLabel,gbc);
		        gbc.gridx =gbc.gridx+50 ;
		        add(nametext,gbc);
		        
		        gbc.gridx =gbc.gridx-50 ;
		        gbc.gridy =gbc.gridy+50 ;
		        add(numberLabel,gbc);
		        gbc.gridx =gbc.gridx+50 ;
		        add(numbertext,gbc);
		        
		        gbc.gridx =gbc.gridx-50 ;
		        gbc.gridy =gbc.gridy+50 ;
		        add(emailLabel,gbc);
		        gbc.gridx =gbc.gridx+50 ;
		        add(emailtext,gbc);
		        
		        gbc.gridx =gbc.gridx-50 ;
		        gbc.gridy =gbc.gridy+50 ;
		        add(myButton,gbc);
			 //mytimer.cancel();
			 //mytimer.purge();
	         //return;
		 }
		}
	};


	public MainPanel() throws FileNotFoundException
	{
		setPreferredSize(new Dimension(800,800));
		setBackground(Color.white);
		addKeyListener(this);
		setFocusable(true);
		currentPanel.requestFocusInWindow();
		TimerLabel = new JLabel("The remaining time : ");
		TimerLabel2 = new JLabel("");
		nameLabel = new JLabel("Enter your Name :");
		nametext= new JTextField("");
		nametext.setPreferredSize( new Dimension( 200, 24 ) );
		
		numberLabel = new JLabel("Enter your favorite Entger number :");
		numbertext= new JTextField("");
		numbertext.setPreferredSize( new Dimension( 200, 24 ) );
		
		emailLabel = new JLabel("Enter your email :");
		emailLabel.setFocusable(false);
		emailtext= new JTextField("");
		emailtext.setPreferredSize( new Dimension( 200, 24 ) );
		myButton = new JButton("Send information ");
		myButton.addActionListener(new buttonListener());
		
		 
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
        gbc.gridy = 0;
        add(TimerLabel,gbc);
        gbc.gridx =gbc.gridx+50 ;
        add(TimerLabel2,gbc);
        
        
        
	
        
		mytimer = new Timer();
    	mytimer.scheduleAtFixedRate(task, 1000, 1000);
    	addLabels();
    	
    	
       
		
	}


	private void addLabels() {
		if (seconds < 0){
			System.out.println("ADD");	
		}
		
		
	}


	private class buttonListener implements ActionListener
	{
		
	

		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			
			//System.out.println("kkkkkkkkkkkkk");
	         //  
	         String name=nametext.getText();
	         String number=numbertext.getText();
	         String email=emailtext.getText();
	         if (!name.equals("")){
	        	 if( !number.equals("")){
	        		 
	        		 if (vilednumber(number))
	        		 {
	        			 
	        			 if (!email.equals("")){
	        				 if (viledemail(email)){
	        					 
	        					 JOptionPane.showMessageDialog(null, "Your name: "+name+" your number is : "+number+" your emali is : "+email);
	        					 nametext.setText("");
	        					 numbertext.setText("");
	        					 emailtext.setText("");
	        				 }else
	        				 {
	        					 JOptionPane.showMessageDialog(null, "Your email not viled ");
	        				 }
	        			 
	        			 }
	        			 else{
	        				 JOptionPane.showMessageDialog(null, "Your email can not be empty");
	        			 
	        			 }
	        		 }
	        		 else{
	        			 JOptionPane.showMessageDialog(null, "you enter non viled number");
	        		 }
	        		 
	        		 
	        	 }
	        	 else{
	        		 JOptionPane.showMessageDialog(null, "Your number can not be empty");
	        	 }
	         }
	         else{
	        	 
	        	 JOptionPane.showMessageDialog(null, "Your name can not be empty");
	        	 
	         }

	
		
		
		
		}

		private boolean viledemail(String email) {
			// TODO Auto-generated method stub
			String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	           java.util.regex.Matcher m = p.matcher(email);
	           return m.matches();
		
		}

		private boolean vilednumber(String number) {
			try {
				int n=Integer.parseInt(number) ;
				return true;
			} catch (NumberFormatException e3) {  
				logger.info(e3.toString());  
		     } 
			
			return false;
		}

	
	}







	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.drawImage(player.getImage(),x,y,null);
		page.drawImage(enemy.getImage(),x2,y2,null);
		
		repaint();
	
	}
		
	public void keyPressed(KeyEvent arg0) {
		//System.out.println(arg0);
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			y-=10;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			y+=10;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			x-=10;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			x+=10;
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
}


