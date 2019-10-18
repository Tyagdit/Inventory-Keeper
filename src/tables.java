import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class tables extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tables frame = new tables();
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
	public tables() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("LOAD DATA");
		btnNewButton.setBounds(297, 11, 121, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
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
                model.addColumn("Model Name");
                model.addColumn("Date of Arrival");
                model.addColumn("Place");
                model.addColumn("Price (In lakhs)");
                model.addColumn("Color");
                model.addColumn("Quantity");
                
                
                String query="select * from store";
                
                stmt=con.createStatement();
                rs=stmt.executeQuery(query);
                
               while(rs.next())
               {
            	   model.addRow(new Object[]
            	   {
            		   rs.getString("id"),
            		   rs.getString("model"),
            		   rs.getString("date"),
            		   rs.getString("place"),
            		   rs.getString("price"),
            		   rs.getString("color"),   
            			rs.getString("quantity"),    
            	   });
               }
               
               rs.close();
               stmt.close();
               con.close();
                
               table.setModel(model);
               table.setAutoResizeMode(0);
               table.getColumnModel().getColumn(0).setPreferredWidth(40);
               table.getColumnModel().getColumn(1).setPreferredWidth(150);
               table.getColumnModel().getColumn(2).setPreferredWidth(120);
               table.getColumnModel().getColumn(3).setPreferredWidth(120);
               table.getColumnModel().getColumn(4).setPreferredWidth(150);
               table.getColumnModel().getColumn(5).setPreferredWidth(125);
               table.getColumnModel().getColumn(6).setPreferredWidth(125);
            }
     

            catch(Exception e1)
            {
            	JOptionPane.showMessageDialog(null, e1);
            }

				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 662, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashori d =new dashori();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
			}
			
			
		});
		btnHome.setBounds(297, 417, 89, 23);
		contentPane.add(btnHome);
	}
}
