package tk.unnikked.wireworld.core;

import java.io.Serializable;

/**
 * A wireworld Cell can assume one of four state in
 * a generation: EMPTY, ELECTRON_HEAD, ELECTRON_TAIL
 * and CONDUCTOR
 */
public class Cell implements Serializable {
	public static enum State {
		EMPTY,
		ELECTRON_HEAD,
		ELECTRON_TAIL,
		CONDUCTOR
	}

	private int x, y;
	private State state;
	private int neighbourgs;

	public Cell() {
		this.state = State.EMPTY;
	}

	public Cell(State initialState) {
		this.state = initialState;
	}

	public Cell(Cell cell) {
		this.state = cell.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

	public void setNeighbourgs(int neighbourgs) {
		this.neighbourgs = neighbourgs;
	}

	public int getNeighbourgs() {
		return this.neighbourgs;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Cell)) return false;
		if (this == obj) return true;
		Cell cell = (Cell) obj;
		return this.state.equals(cell.state);
	}

	public int hashCode() {
		return this.state.hashCode();
	}

	public String toString() {
		return this.state.toString();
	}
}
