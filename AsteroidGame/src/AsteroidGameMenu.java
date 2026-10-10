import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AsteroidGameMenu extends JFrame implements ActionListener{
	
	// Images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	
	// Button
	JButton quit = new JButton("Quit");
	JButton setting = new JButton("Setting");
	JButton play = new JButton("Play");
	
	public AsteroidGameMenu() {
		
		setSize(500, 500);
		setResizable(false);
		setTitle("Asteroid Game Menu");
		
		// set layout
		background.setLayout(null);
		
		// format buttons
		play.setBounds(205, 175, 90, 30);
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AsteroidFramePart3 AsteroidFramePart3 = new AsteroidFramePart3();
				AsteroidFramePart3.setVisible(true);
				setVisible(false);
			}
		});
		setting.setBounds(205, 225, 90, 30);
		quit.setBounds(205, 275, 90, 30);
		
		// add buttons
		background.add(play);
		background.add(setting);
		background.add(quit);
		
		// add layout
		add(background);
		
		// make it visible
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
