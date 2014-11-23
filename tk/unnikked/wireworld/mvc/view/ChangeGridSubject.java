package tk.unnikked.wireworld.mvc.view;

import java.util.Observable;

public class ChangeGridSubject extends Observable {
	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}

	@Override
	protected synchronized void clearChanged() {
		super.clearChanged();
	}
}
