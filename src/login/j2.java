package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;


import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;

public class j2 extends JFrame {

	private JPanel contentPane;
	//protected String String;
	static private String a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					j2 frame = new j2();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					//center(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void center(j2 frame) {
				// TODO Auto-generated method stub
				
				
				Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
				int w=frame.getSize().width;
				int h=frame.getSize().height;
				
				int x=(dim.width-w)/2;
				int y=(dim.height-h)/2;
				
				frame.setLocation(x,y);
			
			
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public j2() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 679, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 195, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\manager.png"));
		lblNewLabel_1.setBounds(34, 25, 121, 128);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(77, 164, 46, 14);
		panel.add(lblNewLabel_2);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(194, 0, 469, 401);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Import Car");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				input in=new input();
				dispose();
				in.setVisible(true);
				
			}
			
		});
		
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				*/
				
				
	/*			

				Connection con=null;
		        Statement stmt=null;

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

				
		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();

		           

		            String sql = "INSERT INTO Registration " +
		                    "VALUES (1000, 'Dinesh')";
		            stmt.executeUpdate(sql);


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
		});*/
		
		
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.RED);
		//btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(165, 90, 127, 50);
		panel_1.add(btnNewButton);
		
		JButton btnPurchaseOrder = new JButton("Export Car");
		btnPurchaseOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				output o=new output();
				dispose();
				o.setVisible(true);
				
			}
		});
		btnPurchaseOrder.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.PINK));
		btnPurchaseOrder.setBackground(Color.PINK);
		btnPurchaseOrder.setBounds(165, 235, 127, 50);
		panel_1.add(btnPurchaseOrder);
		
		JButton btnItemRegistry = new JButton("Car's In Inventory");
		btnItemRegistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table t=new table();
				dispose();
				t.setVisible(true);
				
			}
		});
		btnItemRegistry.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.YELLOW));
		btnItemRegistry.setBackground(Color.YELLOW);
		btnItemRegistry.setBounds(165, 162, 127, 50);
		panel_1.add(btnItemRegistry);
		
		JLabel lblNewLabel = new JLabel("Inventory Management");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(130, 26, 243, 32);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(177, 315, 89, 23);
		panel_1.add(btnNewButton_1);
	}
}
