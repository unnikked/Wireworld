package tk.unnikked.wireworld.mvc.model;

import tk.unnikked.wireworld.core.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nicola on 29/08/14.
 */
public class WorldCell extends JLabel {
	private int x, y;
	private Cell.State state;

	public WorldCell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		setState(Cell.State.EMPTY);
	}

	public int getRow() {
		return x;
	}

	public int getCol() {
		return y;
	}

	public void setState(Cell.State state) {
		this.state = state;
		switch (this.state) {
			case ELECTRON_HEAD: setBackground(Color.BLUE); break;
			case ELECTRON_TAIL: setBackground(Color.RED); break;
			case CONDUCTOR: setBackground(Color.YELLOW); break;
			default: setBackground(Color.BLACK);
		}
	}

	public Cell.State getState() {
		return state;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj == null) return false;
//		if(this == obj) return true;
//		if(!(obj instanceof WorldCell)) return false;
//		WorldCell wc = (WorldCell) obj;
//		return this.x == wc.x && this.y == wc.y && this.state == wc.state;
//	}
}
