import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Style {
	
	
	public void mdPanel(JPanel panel, Color c) {
		panel.setBorder(null);
		panel.setOpaque(true);
		panel.setBackground(c);
	}
	public void mdBtn(JButton btn, Color c) {
		btn.setContentAreaFilled(false);
		btn.setBorder(null);
		btn.setOpaque(true);
		btn.setBackground(c);
		btn.setForeground(Color.WHITE);
	}
	public void btnPointer(JButton btn) {
		btn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		new ImageIcon("views/cursor.png").getImage(),
		new Point(0,0), "custom cursor"));
	}
	
	public void mdTxt(JTextField txt,Color bg,Color fg) {
		txt.setBorder(null);
		txt.setOpaque(true);
		txt.setBackground(bg);
		txt.setForeground(fg);
	}


}
