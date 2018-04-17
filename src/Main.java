import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
					Register reg = new Register();
					reg.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
