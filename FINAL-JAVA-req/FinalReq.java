
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// this class is the first class that is called.
public class FinalReq extends JFrame {
    // create a new instance of the class 
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPG;
	private JTextField textMG;
	private JTextField textFG;
	private JScrollPane scrollPane; 
	private JTextArea txtrName;
	private static JButton btnEnter;
	private static JButton btnNewRecord;
	private JLabel lblHigh;
	private JLabel lblLow;
	private static double highest, lowest, hilo, graderank;
	private JLabel Font;

// this is the main method that is called.
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Final Requirements for JAVA");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalReq frame = new FinalReq();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// this is the constructor that is called.
	public FinalReq() {
		// this is the title of the frame and the size of the frame.
		setForeground(new Color(51, 153, 255));
		setTitle("BSCS 1-D Grading System");
		setBackground(new Color(51, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// this is the label that is called.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(259, 0, 515, 219);
		contentPane.add(scrollPane);
		// this is the text area that is called.
		JTextArea txtrName = new JTextArea();
		txtrName.setBackground(new Color(255, 248, 220));
		txtrName.setEditable(false);
		txtrName.setEnabled(false);
		txtrName.setText("NAME\tPG\tMG\tFG\tSG\tREMARKS\n");
		scrollPane.setViewportView(txtrName);
		// this is the label that is called.
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(36, 53, 183, 14);
		contentPane.add(lblName);
		// this is the label that is called.
		textName = new JTextField();
		textName.addKeyListener(new KeyAdapter() {
		// this is the key listener that is called.
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// this is the if statement that is called.
				if (Character.isDigit(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, " Please Enter a Name!");
				}
			}
		});
		// this is the text field that is called.
		textName.setBackground(new Color(255, 248, 220));
		textName.setEnabled(false);
		textName.setBounds(36, 73, 183, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		// this is the label that is called lblPG.
		JLabel lblPG = new JLabel("PRELIM GRADE:");
		lblPG.setBounds(36, 104, 183, 14);
		contentPane.add(lblPG);
		// call the text field that is called.
		textPG = new JTextField();
		textPG.addKeyListener(new KeyAdapter() {
			// this is the key listener that is called.
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// this is the if statement that is called.
				if (Character.isLetter(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, " Please Enter your Prelim Grade!");
				}
			}
		});

		// this is the text field that is called.
		textPG.setBackground(new Color(255, 248, 220));
		textPG.setEnabled(false);
		textPG.setColumns(10);
		textPG.setBounds(36, 124, 183, 20);
		contentPane.add(textPG);
		// this is the label that is called.
		JLabel lblMG = new JLabel("MIDTERM GRADE:");
		lblMG.setBounds(36, 155, 183, 14);
		contentPane.add(lblMG);
		// this is the text field that is called.
		textMG = new JTextField();
		textMG.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (Character.isLetter(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, " Please Enter your Midterm Grade!");
				}
			}
		});
		textMG.setBackground(new Color(255, 248, 220));
		textMG.setEnabled(false);
		textMG.setColumns(10);
		textMG.setBounds(36, 174, 183, 20);
		contentPane.add(textMG);
		
		JLabel lblFG = new JLabel("FINAL GRADE:");
		lblFG.setBounds(36, 205, 183, 14);
		contentPane.add(lblFG);
		
		textFG = new JTextField();
		textFG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (Character.isLetter(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, " Please Enter your Final Grade!");
				}
			}
		});
		textFG.setBackground(new Color(255, 248, 220));
		textFG.setEnabled(false);
		textFG.setColumns(10);
		textFG.setBounds(36, 224, 183, 20);
		contentPane.add(textFG);
		
		lblHigh = new JLabel();
		lblHigh.setBounds(259, 230, 515, 14);
		contentPane.add(lblHigh);
		
		lblLow = new JLabel();
		lblLow.setBounds(259, 255, 515, 14);
		contentPane.add(lblLow);
		

		btnNewRecord = new JButton("NEW RECORD");
		btnNewRecord.setBackground(new Color(255, 248, 220));
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setEnabled(true);
				textPG.setEnabled(true);
				textMG.setEnabled(true);
				textFG.setEnabled(true);
				txtrName.setEnabled(true);
				textName.requestFocus();
				btnNewRecord.setEnabled(false);
				btnEnter.setEnabled(true);
			}
		});
		btnNewRecord.setBounds(35, 317, 184, 45);
		contentPane.add(btnNewRecord);
		
		btnEnter = new JButton("SAVE RECORD");
		btnEnter.setBackground(new Color(255, 248, 220));
		btnEnter.setEnabled(false);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				double pg = Double.parseDouble(textPG.getText());
				double mg = Double.parseDouble(textMG.getText());
				double fg = Double.parseDouble(textFG.getText());
				double remarks = ((pg + mg + fg)/3);
						
				double sg = (pg * .30) + (mg * .30) + (fg * .40);
				
				if (remarks >= 59.99) {
					txtrName.append(name + "\t" + pg + "\t" + mg + "\t" + fg + "\t" + sg + "\t" + " Passed\n");
				}
				else {
					txtrName.append(name + "\t" + pg + "\t" + mg + "\t" + fg + "\t" + sg + "\t" + " Failed\n");
				}
				
				
				textName.setText(null);
				textPG.setText(null);
				textMG.setText(null);
				textFG.setText(null);
				btnEnter.setEnabled(false);
				textName.requestFocus();
				textName.setEnabled(false);
				textPG.setEnabled(false);
				textMG.setEnabled(false);
				textFG.setEnabled(false);
				btnNewRecord.setEnabled(true);
				
				hilo = remarks;
				graderank = hilo;
				String highgrade = ("Highest Semestral Grade: " + name + " with " + sg + " computed grade.");
				String lowgrade = ("Lowest Semestral Grade: " + name + " with " + sg + " computed grade."); 
							
				if (graderank >= highest || highest == 0 ) {
					lblHigh.setText(highgrade);
					highest = graderank;
					
				}
				if (graderank <= lowest || lowest == 0) {
					lblLow.setText(lowgrade);
					lowest = graderank;
				}
				
			}
		});
		btnEnter.setBounds(303, 317, 184, 45);
		contentPane.add(btnEnter);
		
		
		JButton btnEnter_1 = new JButton("EXIT");
		btnEnter_1.setBackground(new Color(255, 248, 220));
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnEnter_1.setBounds(578, 317, 184, 45);
		contentPane.add(btnEnter_1);
		

	
		//bold this text
		JLabel lblMade = new JLabel("Created By: Richard Cubero, Sarah Mae Balagulan, Angelina Corvera");
		lblMade.setBounds(200, 370, 500, 20);
		contentPane.add(lblMade);


		

	}


      }