import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage implements ActionListener{
	
	
	//==========set Attributes================
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	//===========set system of Attributes ===================
	
	LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);  // Size space user ID
		userPasswordLabel.setBounds(50,150,75,25); // Size space Password ID
		
		messageLabel.setBounds(125,250,250,35); // Size space message 
		messageLabel.setFont(new Font(null,Font.ITALIC,25));  // Font
		
		userIDField.setBounds(125,100,200,25);  // Size space user ID Field
		userPasswordField.setBounds(125,150,200,25); // Size space Password ID
		
		loginButton.setBounds(125,200,100,25); // Size layout login button
		loginButton.setFocusable(false); 
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);  // Size layout reset button
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		
		//==========frontend system ID and Password================
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	
	//=================Logic of System Login===========================
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//reset logic
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		//login logic
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID); //Masuk new page lepas login.
					
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Anda salah masuk password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username tidak wujud");
			}
		}
	}	
}