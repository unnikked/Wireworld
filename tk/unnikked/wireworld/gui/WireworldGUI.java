package tk.unnikked.wireworld.gui;

import javax.swing.*;
import java.awt.*;

public class WireworldGUI {
	private static void show() {
		int rows = 64;
		int cols = 128;
		int cellSize = 10;
		WorldGrid worldGrid = new WorldGrid(rows, cols, cellSize);

		JFrame frame = new JFrame("WireWorld");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(worldGrid, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth())/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight())/2);
		frame.setVisible(true);

		WorldKeyListener keyListener = new WorldKeyListener(worldGrid);
		frame.addKeyListener(keyListener);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				show();
			}
		});
	}
}