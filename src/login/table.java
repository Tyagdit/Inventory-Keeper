package login;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class table extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table frame = new table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	public void fetch()
	{
		Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("\nDriver loaded");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
            System.out.print("Connection Successful");

		
            System.out.println("\nInserting record....");
            stmt=con.createStatement();

            String query="select * from registration";
            
            PreparedStatement preparedStmt = con.prepareStatement(query);
            rs=preparedStmt.executeQuery(query);


        }
        catch(ClassNotFoundException e)
        {
            System.out.print("Exception "+e.getMessage());
        }
        
        
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }

        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null, e);
        }
		
	}
	
	*/
	
	
	/**
	 * Create the frame.
	 */
	public table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 78, 432, 282);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
        
        
   
      
      JButton btnNewButton = new JButton("Load Details");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		

    		Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("\nDriver loaded");

                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
                System.out.print("Connection Successful");

    		
                System.out.println("\nInserting record....");
               // stmt=con.createStatement();

                DefaultTableModel model=new DefaultTableModel();
                
                model.addColumn("ID");
                model.addColumn("Name");
                model.addColumn("Car");
                model.addColumn("No Plate");
                model.addColumn("Lisense");
                
                
                String query="select * from registration";
                
                stmt=con.createStatement();
                rs=stmt.executeQuery(query);
                
               while(rs.next())
               {
            	   model.addRow(new Object[]
            	   {
            		   rs.getString("id"),
            		   rs.getString("name"),
            		   rs.getString("car"),
            		   rs.getString("plate"),
            		   rs.getString("lisense"),   
            			   
            	   });
               }
               
               rs.close();
               stmt.close();
               con.close();
                
               table.setModel(model);
               table.setAutoResizeMode(0);
               table.getColumnModel().getColumn(0).setPreferredWidth(40);
               table.getColumnModel().getColumn(1).setPreferredWidth(100);
               table.getColumnModel().getColumn(2).setPreferredWidth(100);
               table.getColumnModel().getColumn(3).setPreferredWidth(100);
               table.getColumnModel().getColumn(4).setPreferredWidth(100);
            }
     

            catch(Exception e)
            {
            	JOptionPane.showMessageDialog(null, e);
            }
            
      	}
      });
      btnNewButton.setBounds(244, 27, 119, 23);
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("Home");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	
			j2 second=new j2();
			dispose();
			second.setVisible(true);
      		
      	}
      });
      btnNewButton_1.setBounds(547, 367, 89, 23);
      contentPane.add(btnNewButton_1);
		
		
		
		
        
        
	}
}
