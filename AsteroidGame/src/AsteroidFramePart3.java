import java.awt.event.*; //import event methods
import javax.swing.*; //extension to old java. Swing is marketing name. Import visuals

//Asteroid Frame --> Getting background
//Create frame and implement an action listener (listens to our code)
@SuppressWarnings("serial")
public class AsteroidFramePart3 extends JFrame implements ActionListener, MouseMotionListener {
	
	// Add images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	JLabel saucer = new JLabel(new ImageIcon("images/saucer.gif"));

	// Make asteroid move based on timer
	Timer gameTimer = new Timer((int) 1, this);

	// How much we are changing the object by (vector components)
	int dX = 5;
	int dY = 5;

	// constructor method
	public AsteroidFramePart3() {

		// setup frame
		setSize(500, 500);
		setResizable(false);
		setTitle("Asteroid Game");

		// set background layout --> allow us to manually input assets
		// without this line, by default it will go to top left corner
		background.setLayout(null);

		// add asteroid to background
		asteroid.setBounds(200, 100, 50, 50);
		background.add(asteroid);

		// add saucer to background
		saucer.setBounds(200, 300, 60, 55);
		background.add(saucer);

		// add background
		add(background);

		// start the timer
		gameTimer.start();

		// add mouse listener to the frame
		addMouseMotionListener(this);

		// make frame appear
		setVisible(true);
	}

	// this method responds to any actions in the frame
	@Override
	public void actionPerformed(ActionEvent e) {

		// move the asteroids
		asteroid.setBounds(asteroid.getX() + dX, asteroid.getY() + dY, 50, 50);

		// top wall
		if (asteroid.getY() < 0)
			dY *= -1;

		// left wall
		if (asteroid.getX() < 0)
			dX *= -1;

		// bottom wall
		if (asteroid.getY() > 420)
			dY *= -1;

		// right wall
		if (asteroid.getX() > 450)
			dX *= -1;
		
		// if the saucer collides with the asteroid
		// then the asteroid will go upwards
		if (saucer.getBounds().intersects(asteroid.getBounds())) {
			dY = -1 * Math.abs(dY);
		}

	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		// MUST BE KEPT FOR THE INTERACE

	}
	
	// read mouse motion --> have to leave unused methods
	@Override
	public void mouseMoved(MouseEvent mouse) {
		
		// the coordinates for the saucer
		// will match the coordinate for the mouse
		// bound mouse to saucer
		saucer.setBounds(mouse.getX(), mouse.getY(), 60, 55);

	}

}
