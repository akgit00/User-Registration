package swing;

import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;  
import java.sql.*;  
public class UserRegistration extends JFrame implements ActionListener {  
//Initializing Components  
    JLabel lb, lb1, lb2, lb3, lb4, lb5;  
    JTextField tf1, tf2, tf3, tf4, tf5;  
    JButton btn, btn2;  
    //Creating Constructor for initializing JFrame components  
    UserRegistration() {  
        //Providing Title  
        super("Sign Up & Find Student Information");  
        lb5 = new JLabel("Enter Name:");  
        lb5.setBounds(20, 20, 100, 20);  
        tf5 = new JTextField(20);  
        tf5.setBounds(130, 20, 200, 20);  
        btn = new JButton("Submit");  
        btn.setBounds(50, 50, 100, 20);  
        btn.addActionListener(this);
        btn2 = new JButton("Done");  
        btn2.setBounds(20, 250, 100, 20);  
        btn2.addActionListener(this);
        lb = new JLabel("Register");  
        lb.setBounds(30, 80, 450, 30);  
        lb.setForeground(Color.black);  
        lb.setFont(new Font("Serif", Font.BOLD, 20));  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(500, 500);  
        lb1 = new JLabel("Name:");  
        lb1.setBounds(20, 120, 100, 20);  
        tf1 = new JTextField(50);  
        tf1.setBounds(130, 120, 200, 20);  
        lb2 = new JLabel("Mail:");  
        lb2.setBounds(20, 150, 100, 20);  
        tf2 = new JTextField(100);  
        tf2.setBounds(130, 150, 200, 20);  
        lb3 = new JLabel("Password:");  
        lb3.setBounds(20, 180, 100, 20);  
        tf3 = new JTextField(50);  
        tf3.setBounds(130, 180, 200, 20);  
        lb4 = new JLabel("Country:");  
        lb4.setBounds(20, 210, 100, 20);  
        tf4 = new JTextField(50);  
        tf4.setBounds(130, 210, 100, 20);  
        setLayout(null);  
      
        add(lb5);  
        add(tf5);  
        add(btn);
        add(btn2);
        add(lb);  
        add(lb1);  
        add(tf1);  
        add(lb2);  
        add(tf2);  
        add(lb3);  
        add(tf3);  
        add(lb4);  
        add(tf4);  
        
        tf1.setEditable(true);  
        tf2.setEditable(true);  
        tf3.setEditable(true);  
        tf4.setEditable(true);  
    }  
    public void actionPerformed(ActionEvent e) {  
        //Create DataBase connection and getting records  
        try {  
            String str = tf5.getText();  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "Ronaldo!23");  
            PreparedStatement st = con.prepareStatement("select * from student_info where name=?");  
            st.setString(1, str);  
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
            if (rs.next()) {  
                String s = rs.getString(1);  
                String s1 = rs.getString(2);  
                String s2 = rs.getString(3);  
                String s3 = rs.getString(4);  
                //Sets Records in TextFields.  
                tf1.setText(s);  
                tf2.setText(s1);  
                tf3.setText(s2);  
                tf4.setText(s3);  
            } else {  
                JOptionPane.showMessageDialog(null, "Name not Found");  
            }  
            //Create Exception Handler  
        } catch (Exception ex) {  
            System.out.println(ex);  
        }  
    }  
    //Running Constructor  
    public static void main(String args[]) {  
        new UserRegistration();  
    }
	public void connect() {
		// TODO Auto-generated method stub
		
	}
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}  
}  


