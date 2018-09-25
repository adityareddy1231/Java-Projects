
// A simple file chooser to open the maze1.txt or maze2.txt file 
// then press Start Maze button, to start the maze

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Solver extends JFrame {
	
	public String filePath = "";	

   public Solver() {
	   
	   
    super("Maze Main");
    setSize(300, 100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    JButton openButton = new JButton("Open File");
    JButton runButton = new JButton("Start Maze");
    //JButton dirButton = new JButton("Pick Dir");
    
    final JLabel statusbar = 
                 new JLabel("Output of your selection will go here");
    
    
    // Create a file chooser that opens up as an Open dialog
    openButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        
        chooser.setMultiSelectionEnabled(true);
        int option = chooser.showOpenDialog(Solver.this);
        
        if (option == JFileChooser.APPROVE_OPTION) {
          File[] sf = chooser.getSelectedFiles();
          String filelist = "nothing";
          if (sf.length > 0) filelist = sf[0].getName();
          for (int i = 1; i < sf.length; i++) {
            filelist += ", " + sf[i].getName();
          }
          statusbar.setText("You chose " + filelist);
          filePath = chooser.getSelectedFile().getPath();
                    
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    // Create a file chooser that opens up as a Save dialog
    runButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if(filePath.length() == 0) {
        	statusbar.setText("You Must Choose Maze File!");
        } else {
        	
        	statusbar.setText("Run Maze Started!"); 
        	startMaze();
        }
      }
    });

   
    c.add(openButton);
    c.add(runButton);
    c.add(statusbar);
  }
   
   void startMaze( ) {
	  
	   this.dispose();
	  
	   
	   // Create maze
			final Maze maze = new Maze(filePath);
			
			// Get dimensions
			int mazeWidth = maze.getWidth();
			int mazeHeight = maze.getHeight();
			
			// display
			Position location = new Position();    
			location.textArea.append("Maze width: " + mazeWidth + "\n");
			location.textArea.append("Maze height: " + mazeHeight + "\n");
			
			// start the maze game
			Direction mst = new Direction(maze,location);
	        mst.start();
			
			/*while (!maze.isDone()){
				maze.moveRight();
			}*/
			
			/*new Timer(3000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            	maze.moveRight();
	            		            	
	            }
	        }).start();*/
			
			
			// -----------------------------------------------------------
			// Test Maze Movement
			
			/*	
			for (int i = 0; i<3; i++ )
			// Right
			if (maze.moveRight()){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
			
					
			// Up
			if (maze.moveUp()){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
			
			
			// Left
			if (maze.moveLeft()){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
			
			
			// Down
			if (maze.moveDown()){
				System.out.println("Success");
			} else {
				System.out.println("Failure");
			}
		   */
			
			
	  
	   
   }

  public static void main(String args[]) {
    Solver testMaze = new Solver();
    testMaze.setVisible(true);
  }
}
