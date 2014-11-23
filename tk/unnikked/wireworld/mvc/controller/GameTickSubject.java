package tk.unnikked.wireworld.mvc.controller;

import java.util.Observable;

public class GameTickSubject extends Observable {
	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}

	@Override
	protected synchronized void clearChanged() {
		super.clearChanged();
	}
}
