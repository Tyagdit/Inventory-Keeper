package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class login extends JFrame {
	private JTextField username;
	private JTextField password;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();		
					frame.setLocationRelativeTo(null);
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
	public login() {
	/*	initComponents();
		Toolkit toolkit=getToolkit();
		Dimension size =toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);*/
		
		
		
/*
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		int w=frame.getSize().width;
		int h=frame.getSize().height;
		
		int x=(dim.width-w)/2;
		int y=(dim.height-h)/2;
		
		frame.setLocation(x,y);*/
	
	
		
		
		
		setTitle("Inventory System ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(false);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 270, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\icon.png"));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(10, 32, 250, 270);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new LineBorder(Color.CYAN));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(269, 0, 394, 401);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		username = new JTextField();
		username.setForeground(Color.GRAY);
		username.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		username.setBounds(162, 82, 154, 27);
		panel_1.add(username);
		username.setColumns(10);
		
		/*JLabel message=new JLabel();
		panel_1.add(message);
		*/
		
		password = new JTextField();
		password.setForeground(Color.GRAY);
		password.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		password.setBounds(162, 149, 154, 27);
		panel_1.add(password);
		
		JButton btnNewButton = new JButton("Login\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=username.getText();
				String pass=password.getText();
				if(user.trim().equals("dinesh") && pass.trim().equals("pass"))
				{
					System.out.println("Login Successfull");
					JOptionPane.showMessageDialog(null, "Logged in Successfully");
					
					//Second Frame Called
					
					j2 second=new j2();
					dispose();
					second.setVisible(true);
				}
				else
				{
					System.out.println(" Not Login Successfull");
					JOptionPane.showMessageDialog(null, "Invalid Username/Password");
				}
			}

		
		});
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(147, 221, 89, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(66, 87, 89, 27);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(63, 149, 89, 27);
		panel_1.add(lblPassword);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
