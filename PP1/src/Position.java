
// This class tracks the current row & column of the student image, 
// to help debuging the code and update the solution

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Position extends JFrame {
	
	JTextArea textArea;
	
	Position() {
		
		super("Position");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lable = new JLabel("Positions:");
        add(lable, BorderLayout.NORTH);
        textArea = new JTextArea(26, 12);
        //textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
        JScrollPane jp = new JScrollPane(textArea);
        add(jp, BorderLayout.CENTER);
        pack();
        // arbitrary size to make vertical scrollbar appear
        setSize(200, 200);
        //setLocationByPlatform(true);
        setVisible(true);
        
        
             
     }
	
	/*public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Location();
            }
        });*/
		
	    
		/*//1. Create the frame.
		JFrame frame = new Location();
		frame.setTitle("Student Movement");

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//3. Create components and put them in the frame.
		//...create emptyLabel...
		JLabel label = new JLabel("The Row and Column of The Student:");
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		textArea = new JTextArea(10, 25);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		
		// Formatting textArea
		//textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		

		//4. Size the frame. This will make it depends on the whatever in the content Pane
		frame.pack();

		//5. Show it.
		frame.setVisible(true);
		
		//6. Add text to text area
		     textArea.append("This is an editable JTextArea. " +
		    		    "A text area is a \"plain\" text component, " +
		    		    "which means that although it can display text " +
		    		    "in any font, all of the text is in the same font.");
		     
		     textArea.append("This is an editable JTextArea. " +
		    		    "A text area is a \"plain\" text component, " +
		    		    "which means that although it can display text " +
		    		    "in any font, all of the text is in the same font.");
		     
		     textArea.append("This is an editable JTextArea. " +
		    		    "A text area is a \"plain\" text component, " +
		    		    "which means that although it can display text " +
		    		    "in any font, all of the text is in the same font.");
		     
		     textArea.append("This is an editable JTextArea. " +
		    		    "A text area is a \"plain\" text component, " +
		    		    "which means that although it can display text " +
		    		    "in any font, all of the text is in the same font.");
		     
		     
		     textArea.append("This is an editable JTextArea. " +
		    		    "A text area is a \"plain\" text component, " +
		    		    "which means that although it can display text " +
		    		    "in any font, all of the text is in the same font.");
		
*/	  
	//}
	


	
}
