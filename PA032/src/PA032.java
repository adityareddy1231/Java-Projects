//*******************************************************************
//* 																*
//* CIS611 			Fall 2018 			Aditya Reddy 				*
//* 																*
//* 		Program Assignment PA032					 			*
//* 																*
//* 			Class Description 								 	*
//*	This is the PA032 class and is used to submit a part of 	 	*
//* an assignment. It is a program that simulates the popular		*
//* rock-paper-scissors game.										*
//* 																*
//* 		    Date Created : 9/19/2018						 	*
//* 																*
//* 			Saved in: PA032.java 								*
//* 																*
//*******************************************************************

import javax.swing.JOptionPane;

public class PA032 {

	public static void main(String[] args) {
		
		//declaring user input string
		String strUserInput= "";
		int userInput = -1;

		//start the loop 
		start:
	do{	
		// get the user input from rock, paper or scissor.
		strUserInput = JOptionPane.showInputDialog("Welcome to the popular Rock-Paper-Scissors. \nEnter just a single digit corresponding to your choice of play.\n0 - Scissors\n1 - Rock\n2 - Paper ");
		
		//if user hits cancel or close button in joption pane
		if ( strUserInput == null) {
			JOptionPane.showMessageDialog(null, "User wants to quit, application shutting down!");
			break;
		}
		
		//if user enters more than 9 characters in joption pane
		else if(strUserInput !=null) {
			
			//converting user input to integer
			try {
				userInput = Integer.parseInt(strUserInput);
			}
			catch (Exception ex) {
				//Invalid input message
				JOptionPane.showMessageDialog(null, "Invalid Input.  Please try again. \nEnter the number corresponding to your choice of play.\n0 - Scissors\n1 - Rock\n2 - Paper");
				continue start;
			}
			
			//Generating random number from 0 to 2 for computer input
			int compInput = (int)(Math.random()*3);
			
			//writing various scenarios based on random number generated for computer and user input
			if(userInput == 0) {
				if(compInput == 0) {
					JOptionPane.showMessageDialog(null, "You drew Scissors, computer drew Scissors. Draw match.");
				}
				else if(compInput == 1) {
					JOptionPane.showMessageDialog(null, "You drew Scissors, computer drew Rock. Computer wins.");
				}
				else {
					JOptionPane.showMessageDialog(null, "You drew Scissors, computer drew Paper. You win.");
				}
				
				//asking for rematch and responding accordingly
				int response = JOptionPane.showConfirmDialog(null, "Rematch?");
				if(response == 0) {
					continue start;
				}
				else {
					JOptionPane.showMessageDialog(null, "User wants to quit, application is shutting down!");
					break;
				}
			}
			else if(userInput == 1) {
				if(compInput == 0) {
					JOptionPane.showMessageDialog(null, "You drew Rock, computer drew Scissors. You win.");
				}
				else if(compInput == 1) {
					JOptionPane.showMessageDialog(null, "You drew Rock, computer drew Rock. Draw match.");
				}
				else {
					JOptionPane.showMessageDialog(null, "You drew Rock, computer drew Paper. Computer wins.");
				}
				
				//asking for rematch and responding accordingly
				int response = JOptionPane.showConfirmDialog(null, "Rematch?");
				if(response == 0) {
					continue start;
				}
				else {
					JOptionPane.showMessageDialog(null, "User wants to quit, application is shutting down!");
					break;
				}
			}
			else if(userInput == 2) {
				if(compInput == 0) {
					JOptionPane.showMessageDialog(null, "You drew Paper, computer drew Scissors. Computer wins.");
				}
				else if(compInput == 1) {
					JOptionPane.showMessageDialog(null, "You drew Paper, computer drew Rock. You win.");
				}
				else {
					JOptionPane.showMessageDialog(null, "You drew Paper, computer drew Paper. Draw match.");
				}
				
				//asking for rematch and responding accordingly
				int response = JOptionPane.showConfirmDialog(null, "Rematch?");
				if(response == 0) {
					continue start;
				}
				else {
					JOptionPane.showMessageDialog(null, "User wants to quit, application is shutting down!");
					break;
				}
			}
			else {
				//Invalid input message
				JOptionPane.showMessageDialog(null, "Invalid Input. Please try again. \nEnter the number corresponding to your choice of play.\n0 - Scissors\n1 - Rock\n2 - Paper");
				continue start;
			}
		}
	  }
		// end main do-while 
		while(true);
	} //end main method
}// end class