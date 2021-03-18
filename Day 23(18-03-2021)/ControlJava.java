import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

public class ControlJava extends Applet {
	Font f = new Font("TimesRoman", Font.BOLD, 60);
	String Message;

	public void init() {
		Message = new String("Java Test");
	}

	public void SetMessage(String MsgText) {
		Message = MsgText;
		repaint();
	}

	public void paint(Graphics g) {
		g.setFont(f);
		g.drawString(Message, 15, 50);
	}
}