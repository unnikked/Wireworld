package tk.unnikked.wireworld.gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WorldKeyListener extends KeyAdapter {
	private final int DEFAULT_MOVES_PER_SECOND = 1;
	private WorldGrid worldGrid;
	private boolean started;
	private SimulationThread simulation;
	public WorldKeyListener(WorldGrid worldGrid) {
		this.worldGrid = worldGrid;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			worldGrid.tick();
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!started) {
				started = true;
				simulation = new SimulationThread(DEFAULT_MOVES_PER_SECOND, worldGrid);
				simulation.start();
			} else {
				started = false;
				simulation.interrupt();
			}
		} else if(e.getKeyCode() == KeyEvent.VK_1) {
			simulation.setMovesPerSecond(1);
		} else if(e.getKeyCode() == KeyEvent.VK_2) {
			simulation.setMovesPerSecond(2);
		} else if(e.getKeyCode() == KeyEvent.VK_3) {
			simulation.setMovesPerSecond(3);
		} else if(e.getKeyCode() == KeyEvent.VK_4) {
			simulation.setMovesPerSecond(4);
		} else if(e.getKeyCode() == KeyEvent.VK_5) {
			simulation.setMovesPerSecond(5);
		} else if(e.getKeyCode() == KeyEvent.VK_6) {
			simulation.setMovesPerSecond(6);
		} else if(e.getKeyCode() == KeyEvent.VK_7) {
			simulation.setMovesPerSecond(7);
		} else if(e.getKeyCode() == KeyEvent.VK_8) {
			simulation.setMovesPerSecond(8);
		} else if(e.getKeyCode() == KeyEvent.VK_9) {
			simulation.setMovesPerSecond(9);
		} else if(e.getKeyCode() == KeyEvent.VK_0) {
			simulation.setMovesPerSecond(10);
		} else if(e.getKeyChar() == '?') {
			JOptionPane.showMessageDialog(worldGrid, "<html>With your mouse you can add Conductors by left-clicking on the grid " +
					"\n" +
					"(click again on a conductor to erase it), by righ-clicking you change the state of the grid respectively to " +
					"\n" +
					"Electron head, Electron tail and Conductor cyclically.\n" +
					"\n" +
					"By pressing enter you will manually compute a tick of the current generation.\n" +
					"\n" +
					"By pressing space you will start to compute next generations manually.\n" +
					"\n" +
					"By pressing numbers from 1 to 0 on your keyboard you can set ten different speed to the simulation.\n" +
					"\n" +
					"By pressing ? you will see instructions.<html>", "About Wireworld ~ by unnikked", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
