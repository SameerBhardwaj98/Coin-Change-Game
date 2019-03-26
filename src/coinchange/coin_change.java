package coinchange;

import java.awt.*;
import java.awt.event.*;

public class coin_change extends Frame implements ActionListener{
	TextField t1,t2,intro;
	TextArea inst;
	Button b1,b2,b3,b4,c;
	Panel buttonpanel,textpanel;
	Frame f1;
	boolean[] dp = new boolean[101];
	
	coin_change()
	{
		dp[0] = false;
		dp[1] = dp[2] = dp[3] = true;
		for(int i=4; i<=100; ++i)
		{
			if(dp[i-1] == false || dp[i-2] == false || dp[i-3] == false)
				dp[i] = true;
			else
				dp[i] = false;
		}
		 f1 = new Frame();
		 f1.addWindowListener(new WindowAdapter() {
			 @Override
	            public void windowClosing(WindowEvent we) {
				 f1.dispose();
	            }
		});
		inst = new TextArea(100,100);
		intro = new TextField(25);
		inst.setText("Instruction for the program : \nThis is "
				+ "a game in which the user has to play against the "
				+ "CPU.\n"
				+ "You will choose some number of coins (less than"
				+ "100) before the start of the game.\n The CPU"
				+ "and the user would be allowed to remove 1 , 2  or 3"
				+ " coins at each"
				+ "step.\n The CPU and user will take alternate turn."
				+ "The player that removes the last set of coins "
				+ "will win!");
		inst.setEditable(false);
		intro.setText("THE COIN CHANGE CHALLENGE");
		intro.setEditable(false);
		f1.add(inst);
		c = new Button("Instructions");
		c.setSize(25, 25);
		c.addActionListener(this);
		buttonpanel = new Panel();
		textpanel = new Panel();
		textpanel.setBounds(300,250,300,80);
		buttonpanel.setBounds(375,360,100,100);
		t1 = new TextField(25);
		t1.addActionListener(this);
		t2 = new TextField(35);
		b1 = new Button("1");
		b1.addActionListener(this);
		b2 = new Button("2");
		b2.addActionListener(this);
		b3 = new Button("3");
		b3.addActionListener(this);
		b4 = new Button("submit");
		b4.addActionListener(this);
		b4.setBounds(600,280,50,25);
		textpanel.add(intro);
		textpanel.add(t1);
		textpanel.add(t2);
		t1.setText("");
		t2.setText("Enter number of coins!(Less than 100)");
		t2.setEditable(false);
		buttonpanel.add(b1);
		buttonpanel.add(b2);
		buttonpanel.add(b3);
		buttonpanel.add(c);
		add(textpanel);
		add(b4);
		add(buttonpanel);
		setSize(1000,1000);
		setLayout(new BorderLayout());
		setVisible(true);
		f1.setSize(400,400);
		f1.setTitle("Instructions");
		setTitle("Coin change game");
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		int x;
		if(str == "Instructions")
		{
			f1.setVisible(true);
			return;
		}
		else {
			try {
				x =  Integer.parseInt(t1.getText());
			}
			catch(Exception e) {
				t1.setText("");
				return;
			}
		}
		if(x > 100 || x <= 0)
		{
			t1.setText("");
			return;
		}
		if(str == "submit")
		{
				t1.setEditable(false);
				b4.setEnabled(false);
		}
		else if(str == "1")
		{
			t2.setText("You removed 1 coin");
			x -= 1;
			t1.setText(Integer.toString(x));
		}
		else if(str == "2")
		{
			t2.setText("You removed 2 coins");
			x -= 2;
			t1.setText(Integer.toString(x));
		}
		else if(str == "3")
		{
			t2.setText("You removed 3 coins");
			x -= 3;
			t1.setText(Integer.toString(x));
		}
		if(x == 0)
		{
			try {
			Thread.sleep(1000);
			}
			catch(Exception a) {
			}
			t2.setText("Congratulations you win the game ! ");
			try {
				Thread.sleep(1000);
				}
				catch(Exception a) {
				}
			System.exit(0);
		}
		try {
			Thread.sleep(1000);
			}
			catch(Exception a) {
			}
			if(dp[x] == false)
			{	x -= 1;
				t1.setText(Integer.toString(x));
				t2.setText("Computer removes 1 coin");
			}
			else {
				if(dp[x-1] == false)
				{
					x -= 1;
					t1.setText(Integer.toString(x));
					t2.setText("Computer removes 1 coin");
				}
				else if(dp[x-2] == false)
				{
					x -= 2;
					t1.setText(Integer.toString(x));
					t2.setText("Computer removes 2 coins");
				}
				else if(dp[x-3] == false)
				{
					x -= 3;
					t1.setText(Integer.toString(x));
					t2.setText("Computer removes 3 coins");
				}
			}
			if(x == 0)
			{
				try {
					Thread.sleep(1000);
					}
					catch(Exception a) {
					}
				t2.setText("Computer wins! ");
				try {
					Thread.sleep(1000);
					}
					catch(Exception a) {
					}
				System.exit(0);
			}
	}
	public static void main(String[] args) {
		coin_change c = new coin_change(); 
		
		c.addWindowListener(new WindowAdapter() {
			 @Override
	            public void windowClosing(WindowEvent we) {

	                System.exit(0);
	            }
		});
		
		
	}
}