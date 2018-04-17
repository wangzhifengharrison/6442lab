import javax.swing.*;
import java.awt.*;

public class DialGUI implements Runnable,MyObserver{

	private static final Dimension COLORDIM = new Dimension(
			Dial.dim.height * 3, Dial.dim.height * 3);
	/**
	 * DialGUI - this application enables the users to change the color of a
	 * rectangle by altering 3 dials. The dial alter the RGB components of the
	 * color. Eric McCreath 2015,2017 - GPL
	 */

	JFrame jframe;
	JComponent colorComp;
	Dial dialr;
	Dial dialg;
	Dial dialb;

	Dial dial;

	public DialGUI() {
		SwingUtilities.invokeLater(this);
		dial = new Dial();
		dial.registerDialObserver(this);
		dial.notifyObservers();
	}

	public static void main(String[] args) {
		new DialGUI();
	}

	// start up the JFrame add the dials and components 
	public void run() {
		jframe = new JFrame("DialGUI");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		dialr = new Dial(this);
		dialg = new Dial(this);
		dialb = new Dial(this);

		//加了一个颜色的控制器
		dialr.graph_color=Color.red;
		dialg.graph_color=Color.green;
		dialb.graph_color=Color.blue;

		colorComp = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(this.getForeground());
				g.fillRect(0, 0, COLORDIM.width, COLORDIM.height);
			}
		};
		colorComp.setPreferredSize(COLORDIM);
		JPanel dialpanel = new JPanel();
		dialpanel.setLayout(new GridLayout(3, 1));
		dialpanel.add(dialr);
		dialpanel.add(dialg);
		dialpanel.add(dialb);
		jframe.getContentPane().add(dialpanel, BorderLayout.EAST);
		jframe.getContentPane().add(colorComp, BorderLayout.CENTER);

		update();
		jframe.setVisible(true);
		jframe.pack();
	}

	// update - get the values from the dials and set the color of 
	//          the panel based on these values.   
	public void update() {
		float r = (float) dialr.value();
		float g = (float) dialg.value();
		float b = (float) dialb.value();
		colorComp.setForeground(new Color(r, g, b));
		colorComp.repaint();

	}
}
