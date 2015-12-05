import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.JTextArea;


public class TestDrive extends JFrame {

	private JPanel contentPane;
	private JTextField newLanePostion;
	private Car car;
	private Thread drive;
	private JTextArea instructions_textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestDrive frame = new TestDrive();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestDrive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		newLanePostion = new JTextField();
		contentPane.add(newLanePostion, BorderLayout.CENTER);
		newLanePostion.setColumns(10);
		
		car = new Car();
		drive = new Thread(car);

		JButton changePosition = new JButton("Change Lange Position");
		changePosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				car.carPosition = Integer.parseInt(newLanePostion.getText());
			}
		});
		contentPane.add(changePosition, BorderLayout.EAST);
		
		instructions_textArea = new JTextArea();
		instructions_textArea.setLineWrap(true);
		instructions_textArea.setTabSize(0);
		instructions_textArea.setRows(10);
		instructions_textArea.setText("You are the tester.  Position 1 is left side of road - Position 9 is right side of road - Position 5 is middle of the road.  Type in a value between 1-9 to force the car to go to a specific position (simlulating environmental road conditions).  Watch the car self-correct accordingly.  WARNING:  if you tell the car to go outside the boundaries (less than 1 or greater than 9) it assumes you know what you are doing and will possibly cause catasrophic results (like end the game).");
		contentPane.add(instructions_textArea, BorderLayout.NORTH);

		car.prepareToDrive();
		drive.start();
		
	}

}
