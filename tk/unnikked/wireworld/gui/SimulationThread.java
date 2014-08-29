package tk.unnikked.wireworld.gui;

import java.util.concurrent.TimeUnit;

public class SimulationThread extends Thread {
	private final int SECOND = 1000;
	private int movesPerSecond;
	private WorldGrid worldGrid;

	public SimulationThread(int movesPerSecond, WorldGrid worldGrid) {
		this.worldGrid = worldGrid;
		this.movesPerSecond = movesPerSecond;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(SECOND/movesPerSecond);
				worldGrid.tick();
			} catch (InterruptedException e) { break; }
		}
	}

	public synchronized void setMovesPerSecond(int movesPerSecond) {
		this.movesPerSecond = movesPerSecond;
	}
}
