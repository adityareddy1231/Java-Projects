// This class must have the code in the run() method, sub-program/routain to slove the maze;
//   seraches for the Java logo based on the provided path/direction algorithm

public class Direction extends Thread{
	Maze maze;
	Position location;
	
	Direction(Maze maze, Position location) {
		
		this.maze = maze;
		this.location = location;
	}
	
//	void afterMove() {
//		location.textArea.append("Success\n");
//		location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
//		if (maze.isDone()) {
//			location.textArea.append(" Java logo has been found\n");
//			JOptionPane.showMessageDialog(null, " Java logo has been found \\n", "Congratulations!", JOptionPane. PLAIN_MESSAGE);
//			break; 
//			{Cannot use break outside loop, need to ask doubt}
//			}
//	}
	
	// this is the code part that needs to be programmed by students to solve the maze 
	// using the provided path/direction algorithm
	public void run(){

		// this is a SAMPLE code of moving the student image in the maze,
		// and updates the information in Position.jav GUI class, append text into the JTextArea object
		// you should delete this code and start your solution, you may just keep the part of updating the information
		// in the Position.java class, appending information into the JTextArea object
		
		
		while(!maze.isDone()) {
			
			
			location.textArea.append("Start row 0, column 0\n");
			// checking for even or odd
			if (maze.getCurrRow() % 2 == 0) {
				// moving right and checking for logo
				if (maze.moveRight()) {
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					if (maze.isDone()) {
						location.textArea.append(" Java logo has been found\n");
						break; 
					}
				}
				//moving down on reaching last column
				else if (maze.getCurrCol() == (maze.getWidth()-1)) {
					if (maze.moveDown()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					}
				}
				//Printing failure if can't move
				else {
					if (maze.moveDown()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					if (maze.moveRight()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					if (maze.moveRight()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					if (maze.moveUp()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
				}
			}
			//checking if odd
			else if (maze.getCurrRow() % 2 == 1) {
				//moving left and checking for logo
				if (maze.moveLeft()) {
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					if (maze.isDone()) {
						location.textArea.append(" Java logo has been found\n");
						break; 
					}
				}
				//checking if first column was reached
				else if (maze.getCurrCol() == 0) {
					if (maze.moveDown()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					}
					//Printing failure if can't move
				}
				else {
					if(maze.moveUp()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					
					if (maze.moveLeft()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					
					if (maze.moveLeft()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					
					if (maze.moveDown()) {
						location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if (maze.isDone()) {
							location.textArea.append(" Java logo has been found\n");
							break; 
						}
					};
					
				}
			}
				
		
//		if (maze.moveDown()) {
//			location.textArea.append("Success\n");
//			location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
//			if (maze.isDone()) {
//				location.textArea.append("Logo Found \n");
//			}
//			else {
//				location.textArea.append("Logo Missing \n");
//			}
//		}
//		else {
//			location.textArea.append("Failure\n");
//		}
//		
//		if (maze.moveRight()) {
//			location.textArea.append("Success\n");
//			location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
//			if (maze.isDone()) {
//				location.textArea.append("Logo Found \n");
//			}
//			else {
//				location.textArea.append("Logo Missing \n");
//			}
//		}
//		else {
//			location.textArea.append("Failure\n");
//		}
//		
		
				
		}	
		
	}
   
	}
