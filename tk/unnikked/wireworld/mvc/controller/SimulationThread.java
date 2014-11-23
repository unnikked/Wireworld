package tk.unnikked.wireworld.mvc.controller;

public class SimulationThread extends Thread {
	private final int SECOND = 1000;
	private int movesPerSecond = 5;
	private final Object MONITOR = new Object();
	private boolean pauseThreadFlag = false;
	private GameTickSubject observable;

	public SimulationThread() {
		observable = new GameTickSubject();
		start();
		try {
			pauseThread();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void setMovesPerSecond(int movesPerSecond) {
		this.movesPerSecond = movesPerSecond;
	}

	public GameTickSubject getGameTickSubject() {
		return observable;
	}

	public void run() {
		while (true) {
			try {
				checkForPaused();
				Thread.sleep(SECOND / movesPerSecond);
				observable.setChanged();
				observable.notifyObservers();
			} catch (InterruptedException e) { break; }
		}
	}

	private void checkForPaused() {
		synchronized (MONITOR) {
			while (pauseThreadFlag) {
				try {
					MONITOR.wait();
				} catch (Exception ignored) {}
			}
		}
	}

	public void pauseThread() throws InterruptedException {
		pauseThreadFlag = true;
	}

	public void resumeThread() {
		synchronized(MONITOR) {
			pauseThreadFlag = false;
			MONITOR.notify();
		}
	}
}
