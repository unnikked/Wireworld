package tk.unnikked.wireworld.utils;

import tk.unnikked.wireworld.core.Cell;
import tk.unnikked.wireworld.core.Coordinate;

/**
 * Created by nicola on 23/11/14.
 */
public class Pair {
	private Coordinate coordinate;
	private Cell cell;

	public Pair(Coordinate coordinate, Cell cell) {
		this.coordinate = coordinate;
		this.cell = cell;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	public Cell getCell() {
		return this.cell;
	}
}
