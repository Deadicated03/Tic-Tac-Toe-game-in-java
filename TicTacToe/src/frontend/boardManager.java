package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import backend.GameManager;

public class boardManager implements ActionListener {
	
	private JFrame frame;
	private JPanel button_panel;
	private JPanel title_panel;
	private JButton[] buttons;
	private JButton pvp;
	private JButton computer;
	private JLabel text;
	private int counter;
	private boolean turn;
	private int gamemode;
	private JButton reset;
	private JButton exit;

	
	public void setText(String text) {
		this.text.setText(text);
	
	}
	public JLabel getText() {
		
		return text;
	}
	
	public void setTurn(Boolean turn) {
		
		this.turn = turn;
	}
	
	public Boolean getTurn() {
		
		return this.turn;
	}
	public JButton[] getButtons() {
		
		return buttons;
	}
	
	public void createTable() {	
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		text = new JLabel();
		text.setText("Tic Tac Toe game!");
		text.setBackground(Color.white);
		text.setForeground(new Color(0,0,0));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setOpaque(true);
		text.setFont(new Font("MV BOLI",Font.BOLD,45));
		
		title_panel = new JPanel();
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,500,50);
		title_panel.add(text);
		frame.add(title_panel);

		
	}
	
	public void createMenu() {
		
		pvp = new JButton();
		pvp.setBounds(120,120,250,50);
		frame.add(pvp);
		pvp.addActionListener(this);
		pvp.setText("Player vs Player");
		pvp.setFocusable(false);
		pvp.setBackground(Color.lightGray);
		pvp.setBorder(BorderFactory.createLineBorder(null));
		
		
		computer = new JButton();
		computer.setBounds(120,220,250,50);
		frame.add(computer);
		computer.addActionListener(this);
		computer.setText("Player vs Computer");
		computer.setFocusable(false);
		computer.setBackground(Color.lightGray);
		computer.setBorder(BorderFactory.createLineBorder(null));
		
		reset = new JButton();
		reset.setVisible(false);
		reset.setBounds(120,120,250,50);
		reset.addActionListener(this);
		reset.setText("Play again?");
		reset.setFocusable(false);
		reset.setBackground(Color.lightGray);
		reset.setBorder(BorderFactory.createLineBorder(null));
		
		
		exit = new JButton();
		exit.setVisible(true);	
		exit.setBounds(120,320,250,50);
		exit.addActionListener(this);
		exit.setText("Exit");
		exit.setFocusable(false);
		exit.setBackground(Color.lightGray);
		exit.setBorder(BorderFactory.createLineBorder(null));
		
	
	}

	public void createGame() {
		
		button_panel =  new JPanel();	
		buttons = new JButton[9];
	
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(0,0,0));
		
		button_panel.setBounds(-1,50,500,411);
		
		for(int i=0; i < 9; i++) {
		
		
		buttons[i] = new JButton();
		button_panel.add(buttons[i]);
		buttons[i].setFont(new Font("",Font.BOLD,95));
		buttons[i].setFocusable(false);
		buttons[i].addActionListener(this);
	
		}
	
		frame.add(button_panel);

	}

	public void gameRestart() {
		
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
			
		}
		
		if(counter == 9) {
			text.setText("No winner");
		}
	
		
		pvp.setVisible(true);
		computer.setVisible(true);
		exit.setVisible(true);
		button_panel.setVisible(false);
		text.setText("Tic Tac Toe game!");
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("MV BOLI",Font.BOLD,45));
		for(int i = 0; i < 9; i++) {
			buttons[i].setVisible(false);
			
		}
		counter = 0;
		reset.setVisible(false);
	
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		GameManager manager = new GameManager();
		if(e.getSource() == pvp) {
			
			pvp.setVisible(false);	
			computer.setVisible(false);
			exit.setVisible(false);
			createGame();
			manager.firstTurn(this);
			gamemode = 0;
			
			
		}
		else if(e.getSource() == computer) {
			
			pvp.setVisible(false);	
			computer.setVisible(false);
			exit.setVisible(false);
			System.out.println("computer");
			gamemode = 1;
			
		}
		
		if(gamemode == 0) {		
			for(int i = 0; i < 9; i++) {
				if(e.getSource() == buttons[i]) {
					if(turn) {
						if(buttons[i].getText()=="") {					
							buttons[i].setText("X");
							counter++;
							manager.turn(this);
							manager.winCondition(this);
						}
					}
					else {
						if(buttons[i].getText()=="") {							
							buttons[i].setText("O");
							counter++;
							manager.turn(this);
							manager.winCondition(this);
							
						}	
					}	
				}
			}
		}
		if(manager.getFinished() == 1 || counter == 9) {
			
			if(counter == 9 && manager.getFinished() != 1) {
				setText("No winner");
			}
			
		
			for(int i = 0; i < 9; i++) {
				
				buttons[i].setEnabled(false);
			}
			
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(0,0,500,500);
			frame.add(layeredPane);
			layeredPane.add(reset, JLayeredPane.DRAG_LAYER);
			layeredPane.add(exit, JLayeredPane.DRAG_LAYER);
			layeredPane.add(button_panel, JLayeredPane.DEFAULT_LAYER);
			reset.setVisible(true);		
			exit.setVisible(true);
			
		}
		if(e.getSource() == reset) {
			gameRestart();
		}
		if(e.getSource() == exit) {
			
			 System.exit(0);
		}
	}
}
