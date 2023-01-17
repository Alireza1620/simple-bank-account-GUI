import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

//This class should extend JFrame and implement the ActionListener Interface
public class BankAccountGUI extends JFrame implements ActionListener
{
	//complete the implementation of the different user interface components  
	private JLabel amountLabel = new JLabel("Amount");
	private JTextField amountField = new JTextField(5);
	private JButton deposit = new JButton("DEPOSIT");
	private JButton withdraw = new JButton("WITHDRAW");
	private JLabel startBalance = new JLabel("Starting Balance = 0");

	//create the three panels topPanel, middlePanel and bottomPanel 
	private JPanel topPanel = new JPanel();
	private JPanel middlePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	
	// declare a new BankAccount object (myAccount) with account number and name of your choice here
	BankAccount myAccount = new BankAccount("1234", "Miahi");
	
	public BankAccountGUI()
	{
		
		//set the title for the frame
		setTitle("BankAccount GUI");
		//exists the application when frame is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the frame size and location
		setSize(400, 200);
		setLocationRelativeTo(null);
		//add the action listeners for your buttons 
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		
		
		//add the Label to the Top here
		topPanel.add(amountLabel);
		topPanel.add(amountField);
		//add the buttons to the middlePanel here
		middlePanel.add(deposit);
		middlePanel.add(withdraw);
		//add the balanceLabel to the bottom Panel 
		bottomPanel.add(startBalance);
		
		
		add (BorderLayout.NORTH, topPanel);
		// add the middlePanel to the CENTER of the frame here
		add (BorderLayout.CENTER, middlePanel);
		//add the bottomPanel to the bottom of the frame here
		add (BorderLayout.SOUTH,bottomPanel);
			
		// set the fame visibility to true
		setVisible(true);
	}
	
 
	public void actionPerformed(ActionEvent e)
	{
		
		try {
			// write code to get text from amountField and convert to double here
			String amount = amountField.getText();
			Double dAmount = Double.parseDouble(amount);
			if (dAmount<0) {
				JOptionPane.showMessageDialog(null, "Amount can't be negative!", "Inane warning", JOptionPane.ERROR_MESSAGE);
			}
			
			// Creating class for use 
		
			// write event handler for deposit button here
			if (e.getSource() == deposit) {
				myAccount.deposit(dAmount);
				
			// write event handler for withdraw button here
			}else if(e.getSource()==withdraw) {
				if (myAccount.withdraw(dAmount) !=true) {
					JOptionPane.showMessageDialog(null, "Amount you requested is more than your balance!", "Inane warning", JOptionPane.WARNING_MESSAGE);
				}else {
					myAccount.withdraw(dAmount);
				}
			}
			startBalance.setText("New Balance is: "+myAccount.getBalance());
			
			
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "The Amount You Entered isn't Acceppted!", "Inane warning", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "Enter amount first!", "Inane warning", JOptionPane.INFORMATION_MESSAGE);
		}		
	}
}
