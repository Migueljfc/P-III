package aula8.ex1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class graficStuff implements ActionListener{
	
	Game galo = new Game('X','O');
	static JToggleButton[] buttons = new JToggleButton[9]; 
	
	public graficStuff() {
		JFrame frame = new JFrame("Jogo do Galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		
		JPanel content = (JPanel)frame.getContentPane();
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(3,3));

		JPanel statContainer = new JPanel();
		statContainer.setBackground(Color.WHITE);
		statContainer.setLayout(new FlowLayout());
		
		//Creates the Buttons
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JToggleButton();
			buttons[i].setFont(new Font("Courier New",Font.CENTER_BASELINE,70));
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.BLACK);
			content.add(buttons[i]);
		}
		frame.setContentPane(content);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JToggleButton button = (JToggleButton) event.getSource();
		button.setBackground(Color.RED);
		button.setEnabled(false);
		if(button == buttons[0]) {
			galo.play(1,1);
		}else if(button == buttons[1]) {
			galo.play(2,1);
		}else if(button == buttons[2]) {
			galo.play(3,1);
		}else if(button == buttons[3]) {
			galo.play(1,2);
		}else if(button == buttons[4]) {
			galo.play(2,2);
		}else if(button == buttons[5]) {
			galo.play(3,2);
		}else if(button == buttons[6]) {
			galo.play(1,3);
		}else if(button == buttons[7]) {
			galo.play(2,3);
		}else if(button == buttons[8]) {
			galo.play(3,3);
		}
		button.setText(String.valueOf(galo.getLastPlayer()));
		if(galo.finished()) {
			if(galo.lastPlayerWon()) {
				JOptionPane.showMessageDialog(null,"Jogador " + galo.getLastPlayer()+ " ganhou");
			}
			else {	
				JOptionPane.showMessageDialog(null, "Empate");
			}
			System.exit(0);
		}
	}
	
	
}
