import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;

public class OnlineBank {
	
	public static Connection prepareConn() {
		Connection c=null;
		try {
	    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    	c = DriverManager.getConnection("jdbc:odbc:bank","","");
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		return c;
	}
	
	public static void closeConn(Connection c){
		try {
			if(c!=null)
		        c.close();    
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
	}
	
	public static int update(String sql) {
		int update = 0;
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			update = st.executeUpdate(sql);    
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return update;
	}
	
	public static boolean checkUser(String sql) {
		boolean check = false;
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next() == true){
				check = true;
			}else {
				check = false;
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return check;
	}
	
	public static ArrayList getAccountNoByName(String sql) {
		ArrayList a = new ArrayList();
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				a.add(rs.getInt(1)+"");
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return a;
	}

	
	
	public static String getNameByNo(String sql) {
		String name = "";
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				name = rs.getString(1);
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return name;
	}
	
	
	public static ArrayList getAccountByName(String sql) {
		ArrayList a = new ArrayList();
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ArrayList o = new ArrayList();
				o.add(rs.getInt(1)+"");
				o.add(rs.getString(2));
				a.add(o);
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return a;
	}
	public class TransferAmount extends JFrame
             {
                 JLabel sign,Bankname,image,receipientid;
                 JButton exit,back,transferamountbtn;
                 JPanel header;
                 JTextField transferamountbox,receipientbox;
                 int accno1,color;
                 TransferAmount(String title,int accno,int v)
                      {
                        color=v;    
                        accno1=accno;
                        Cursor handpointer=new Cursor(Cursor.HAND_CURSOR);
                        Font formfont=new Font("Bank Account ID",Font.PLAIN,19);
                        Font formfont=new Font("Balance",Font.PLAIN,15);
                        Font formfont=new Font("Account Type",Font.PLAIN,25);
                        Font username=new Font("SansSerif",Font.BOLD,20);
                        header=new JPanel(null);
                        sign=new JLabel("Enter the amount:");
                        sign.setFont(formfont);
                        sign.setForeground(Color.BLACK);
                        receipientid=new JLabel("Enter The Receipient Accno:");
                        receipientbox=new JTextField();
                        receipientid.setFont(formfont);
                        receipientid.setForeground(Color.BLACK);
                        receipientid.setBounds(18,120,300,40); 
                        receipientbox.setBounds(270,120,210,40);
                        transferamountbox=new JTextField(); 
                        transferamountbtn=new JButton("TransferAmount");
                        transferamountbtn.setFont(btnFont);
                        transferamountbtn.setForeground(Color.WHITE);
                        transferamountbox.setBounds(270,60,210,40);
                        sign.setBounds(110,60,300,40); 
                        exit=new JButton("EXIT");
                        back=new JButton("BACK");
                        Bankname.setForeground(Color.WHITE);
                        Bankname.setFont(bankline);
                        exit.setFont(btnFont);
                        exit.setBackground(Color.RED);
                        exit.setForeground(Color.WHITE);
                        exit.setCursor(handpointer);
                        back.setFont(btnFont);
                        back.setCursor(handpointer);
                        back.setForeground(Color.WHITE);
                        this.setLayout(null); 
                        header.setBounds(0,0,500,50);
                        image.setBounds(45,0,100,50);
                        Bankname.setBounds(121,10,400,50);
                        transferamountbtn.setBounds(150,201,200,50);
                        exit.setBounds(300,301,150,40);
                        back.setBounds(50,301,150,40);
                        ChangeColor(color);
                        this.add(header);
                        header.add(image);
                        header.add(Bankname);
                        this.add(sign);
                        this.add(receipientid);
                        this.add(receipientbox);
                        this.add(transferamountbox);
                        this.add(exit);
                        this.add(back);
                        this.add(transferamountbtn);
                        transferamountbtn.addActionListener(new MyEvents());
                        back.addActionListener(new MyEvents());
                        exit.addActionListener(new MyEvents());
                        ImageIcon icon=new ImageIcon("i2.jpg");
                        this.setIconImage(icon.getImage());
                        this.setResizable(false);
                        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.setTitle(title);
                        this.setBounds(520,225,500,400);
                        this.setVisible(true);
           }
	public static ArrayList getAccountDetailsByName(String sql) {
		ArrayList a = new ArrayList();
		Connection c=null;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ArrayList o = new ArrayList();
				o.add(rs.getInt(1)+"");
				o.add(rs.getString(2));
				o.add(rs.getInt(3)+"");
				o.add(rs.getInt(4)+"");
				o.add(rs.getString(5));
				a.add(o);
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return a;
	}
	if(btnop.getSource()==back)
            {
                TransferAmount.this.backaudio();
                UserTransactions obj=new UserTransactions("Transactions",accno1,color);
                TransferAmount.this.hideFrame();
             }
	public static int getBalance(String sql) {
		Connection c=null;
		int balance=0;
		try {
			c = prepareConn();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				balance = rs.getInt(1);
			}
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
		closeConn(c);
		return balance;
	}
	
}
}