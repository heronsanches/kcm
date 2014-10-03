import java.awt.*;
import java.awt.event.*;
/** This code was based on the example of this site <http://www.roseindia.net/java/example/java/awt/KeyPress.shtml>,
 * that demonstrate how can I capture a key of keyboard and firing events on a frame.
 * 
 * So I used this approach for moving a mouse cursor through the frame using the Robot class.
 */

public class KeyPress extends Frame {
	
	Robot r;
	int x = 683;
	int y = 384;

	public static void main(String[] args) throws AWTException {
		KeyPress k = new KeyPress();
	}

	public KeyPress() throws AWTException {
		
		super("Key Press Event Frame");
		r = new Robot();
		
		Panel panel = new Panel();
		panel.setSize(1366, 768);
		panel.addKeyListener(new MyKeyListener());
		panel.setVisible(true);
		
		add(panel);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setSize(1366, 768);
		setVisible(true);
		r.mouseMove(x, y);
	}

	public class MyKeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent ke) {
			
			char i = ke.getKeyChar();
			
			if( (i == 'w' || i == 'W') && y > 2){
				r.mouseMove(x, y-=3);
			}else if( (i == 's' || i == 'S') && y < 766){
				r.mouseMove(x, y+=3);
			}else if( (i == 'a' || i == 'A') && x > 2){
				r.mouseMove(x-=3, y);
			}else if( (i == 'd' || i == 'D') && x < 1364){
				r.mouseMove(x+=3, y);
			}
			
		}
		
	}
	
}