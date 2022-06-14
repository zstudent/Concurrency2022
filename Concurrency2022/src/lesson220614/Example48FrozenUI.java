package lesson220614;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Example48FrozenUI {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		
		JFrame frame = new JFrame("Frozen");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(200, 100));
		
		

		JButton button = new JButton("Click me!");
		
//		button.addActionListener(new ReactToClick());

		button.addActionListener(e -> {
			System.out.println(e);
			service.execute(() -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				SwingUtilities.invokeLater(() -> {
					button.setText("Clicked at " + e.getWhen());
				});
			});
		});
		
//		frame.addMouseMotionListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				System.out.println(e);
//			}
//		});

		frame.add(button);
		
		frame.pack();
		
		frame.setVisible(true);
		
	}

}


class ReactToClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(Thread.currentThread());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(e);
	}
	
}


