package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class input extends JFrame {

	private JPanel contentPane;
	private JTextField car;
	private JTextField plate;
	private JTextField lisense;
	public  String selectedBook;
	public String x;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input frame = new input();
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
	public input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 679, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 663, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(393, 177, -88, -108);
		panel.add(list);
		
		String []compname=new String[] {"Select Company","Audi","Toyota","BMW","Ferrari"};
		
		
		DefaultComboBoxModel<String> comboModel=new DefaultComboBoxModel<String>(compname);
		JComboBox comboBox = new JComboBox(compname);
		comboBox.setBackground(SystemColor.window);
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		panel.add(comboBox);
		comboBox.setBounds(248, 101, 205, 42);
		
		JLabel lblNewLabel = new JLabel("\t                        Enter Your Car Details");
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 18));
		lblNewLabel.setBounds(127, 26, 398, 43);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Car Model");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(103, 177, 159, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\car.png"));
		lblNewLabel_2.setBounds(31, 17, 135, 64);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\car.png"));
		label.setBounds(518, 17, 135, 64);
		panel.add(label);
		
		car = new JTextField();
		car.setBounds(248, 177, 212, 28);
		panel.add(car);
		car.setColumns(10);
		
		JLabel lblNumberPlate = new JLabel("Number Plate");
		lblNumberPlate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNumberPlate.setBounds(103, 236, 159, 28);
		panel.add(lblNumberPlate);
		
		plate = new JTextField();
		plate.setColumns(10);
		plate.setBounds(248, 236, 212, 28);
		panel.add(plate);
		
		JLabel lblLisenseNumber = new JLabel("Lisense Number");
		lblLisenseNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblLisenseNumber.setBounds(103, 298, 159, 28);
		panel.add(lblLisenseNumber);
		
		lisense = new JTextField();
		lisense.setColumns(10);
		lisense.setBounds(248, 298, 212, 28);
		panel.add(lisense);
		

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selectedBook=(String) comboBox.getSelectedItem();
				
				System.out.println("You selected "+selectedBook);
				x=selectedBook;
		
			}
		});

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				System.out.println("You selected "+x);
				//String selectedBook=(String) comboBox.getSelectedItem();
				Connection con=null;
		        Statement stmt=null;
		        
		    

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();
		            String s1=car.getText();
		            String s2=plate.getText();
		            String s3=lisense.getText();
		           String query=("INSERT INTO Registration (name,car,plate,lisense)" +" values ('"+x+"','"+s1+"','"+s2+"','"+s3+"')");
		           
		           stmt.executeUpdate(query);
		           
		           JOptionPane.showMessageDialog(null, "Insertion Successfull");
		           
		           j2 second=new j2();
					dispose();
				second.setVisible(true);
		            con.close();
		            
		        }
		        catch(ClassNotFoundException e)
		        {
		            System.out.print("Exception "+e.getMessage());
		        }
		        
		        
		        catch(SQLException se){
		            //Handle errors for JDBC
		            se.printStackTrace();
		        }
				
				
				
			}
		});
		

		btnNewButton.setBounds(297, 367, 89, 23);
		panel.add(btnNewButton);

		
	}
}
