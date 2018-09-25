// The maze class has all the methods to move the student image 


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Maze {
    
    // Maze variables
    private char mazeData[][];
    private int mazeHeight, mazeWidth;
    private int finalRow, finalCol;
    private int currRow, currCol;
    private int prevRow = -1;
    private int prevCol = -1;

    // User interface
    private JFrame frame;
    private JPanel panel;
    private Image java, student, success, donotpass;
    private ArrayList<JButton> buttons;
    

    // Maze constructor
    public Maze(String fileName) {

        // Read maze
        readMaze(fileName);
        
        // Graphics setup
        setupGraphics();
        
        
    }

    // Get height
    public int getHeight() {
        return mazeHeight;
    }

    // Get width
    public int getWidth() {
        return mazeWidth;
    }

    // Move right
    public boolean moveRight() {

        // Legal move?
        if (currCol + 1 < mazeWidth) {

            // Do not pass?
            if (mazeData[currRow][currCol + 1] != 'D') 
            {
                currCol++;
                redraw(true);
                return true;
            }
        }
        return false;
    }

    // Move left
    public boolean moveLeft() {

        // Legal move?
        if (currCol - 1 >= 0) {

            // Do not pass?
            if (mazeData[currRow][currCol - 1] != 'D') 
            {
                currCol--;
                redraw(true);
                return true;
            }
        }
        return false;
    }

    // Move up
    public boolean moveUp() {

        // Legal move?
        if (currRow - 1 >= 0) {

            // Do not pass?
            if (mazeData[currRow - 1][currCol] != 'D') 
            {
                currRow--;
                redraw(true);
                return true;
            }
        }
        return false;
    }

    // Move down
    public boolean moveDown() {

        // Legal move?
        if (currRow + 1 < mazeHeight) {

            // Do not pass?
            if (mazeData[currRow + 1][currCol] != 'D') 
            {
                currRow++;
                redraw(true);
                return true;
            }
        }
        return false;
    }

    public boolean isDone() {

        // Maze solved?
        if ((currRow == finalRow) && (currCol == finalCol))
            return true;
        else
            return false;
    }

    private void redraw(boolean print) {

        // Wait for awhile
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        if (print) 
            System.out.println("Moved to row " + currRow + ", column " + currCol);
           
        // Compute index and remove icon
        int index = (prevRow * mazeWidth) + prevCol;
        if ((prevRow >= 0) && (prevCol >= 0)) {
            buttons.get(index).setIcon(null);
        }

        // Compute index and add icon
        index = (currRow * mazeWidth) + currCol;
        if ((currRow == finalRow) && (currCol == finalCol))
            buttons.get(index).setIcon(new ImageIcon(success));
        else
            buttons.get(index).setIcon(new ImageIcon(student));

        // Store previous location
        prevRow = currRow;
        prevCol = currCol;
    }

    // Set button
    private void setButton(JButton button, int row, int col) {

        if (mazeData[row][col] == 'S') {
            button.setIcon(new ImageIcon(student));
            currRow = row;
            currCol = col;
        } else if (mazeData[row][col] == 'J') {
            button.setIcon(new ImageIcon(java));
            finalRow = row;
            finalCol = col;
        } else if (mazeData[row][col] == 'D') {
            button.setIcon(new ImageIcon(donotpass));
        }
    }

    // Read maze
    private void readMaze(String filename) {
        try {

            // Open file
            Scanner scan = new Scanner(new File(filename));

            // Read numbers
            mazeHeight = scan.nextInt();
            mazeWidth = scan.nextInt();

            // Allocate maze
            mazeData = new char[mazeHeight][mazeWidth];

            // Read maze
            for (int row = 0; row < mazeHeight; row++) {

                // Read line
                String line = scan.next();
                for (int col = 0; col < mazeWidth; col++) {
                    mazeData[row][col] = line.charAt(col);
                }
            }

            // Close file
            scan.close();

        } catch (IOException e) {
            System.out.println("Cannot read maze: " + filename);
            System.exit(0);
        }
    }

    // Setup graphics
    void setupGraphics() {

        // Create grid
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridLayout(mazeHeight, mazeWidth, 0, 0));
        frame.add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configure window
        frame.setSize(mazeWidth * 100, mazeHeight * 100);
        frame.setTitle("Maze Solver");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        // Load and scale images
        ImageIcon icon0 = new ImageIcon("Java.jpg");
        Image image0 = icon0.getImage();
        java = image0.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        ImageIcon icon1 = new ImageIcon("Student.jpg");
        Image image1 = icon1.getImage();
        student = image1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        ImageIcon icon2 = new ImageIcon("Success.jpg");
        Image image2 = icon2.getImage();
        success = image2.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        ImageIcon icon3 = new ImageIcon("DoNotPass.jpg");
        Image image3 = icon3.getImage();
        donotpass = image3.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        // Build panel of buttons
        buttons = new ArrayList<JButton>();

        for (int row = 0; row < mazeHeight; row++) {
            for (int col = 0; col < mazeWidth; col++) {

                // Initialize and add button
                JButton button = new JButton();
                Border border = new LineBorder(Color.darkGray, 4);
                button.setOpaque(true);
                button.setBackground(Color.gray);
                button.setBorder(border);
                setButton(button, row, col);
                panel.add(button);
                buttons.add(button);
            }
            
         }
        
        JPanel closePanel = new JPanel();
        frame.add(closePanel, BorderLayout.SOUTH);
        JButton closeButton = new JButton("Close");
        closePanel.add(closeButton, BorderLayout.SOUTH);

        closeButton.addActionListener( new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            System.exit(0);
	            }
	    });
	    

        // Show window
        redraw(false);
        frame.setVisible(true);
    }
    
    public int getCurrRow() {
    	return currRow;
    }
    
    public int getCurrCol() {
    	return currCol;
    }
    
    
    
    
}
