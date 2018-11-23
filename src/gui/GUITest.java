package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUITest extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private void $(Button b,String path){
		b.addActionListener(e->{
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon(path));
			label.setSize(400, 400);
			Dialog d = new Dialog(this, Dialog.ModalityType.MODELESS);
			d.add(label);
			d.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					d.dispose();
				}
			});
			d.setTitle(b.getLabel());
			d.setSize(400,400);
			d.setVisible(true);
		});
	}
	public GUITest() {
		this.setLayout(new BorderLayout());
		Button center = new Button("Center");
		Button north = new Button("North") ; 
		Button west = new Button("West");
		Button east = new Button("East") ; 
		Button south = new Button("South");
		this.add(center,BorderLayout.CENTER);
		this.add(north,BorderLayout.NORTH);
		this.add(south,BorderLayout.SOUTH);
		this.add(west,BorderLayout.WEST);
		this.add(east,BorderLayout.EAST);
		this.setTitle("GUITest");
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		$(center,"D:\\1.jpg");
		$(north,"D:\\2.jpg");
		$(west,"D:\\3.jpg");
		$(east,"D:\\4.png");
		$(south,"D:\\5.jpg");
		this.pack();
	}
	public static void main(String[] args) {
		new GUITest();
	}
}
