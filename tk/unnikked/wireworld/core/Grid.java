package tk.unnikked.wireworld.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Grid implements Serializable{
	private HashMap<Coordinate, Cell> grid;

	public Grid() {
		this.grid =  new HashMap<Coordinate, Cell>();
	}

	public Grid(Grid grid) {
		this.grid = grid.grid;
	}

	public HashMap<Coordinate, Cell> getGrid() {
		return grid;
	}

	public void setCellState(int x, int y, Cell.State state) {
		grid.put(new Coordinate(x, y), new Cell(state));
	}

	public Cell.State getCellState(int x, int y) {
		Cell cell = grid.get(new Coordinate(x, y));
		return cell != null ? cell.getState() : Cell.State.EMPTY;
	}

	public Cell getCell(int x, int y) {
		return grid.get(new Coordinate(x, y));
	}

	public void countNeighbourgs() {
		Collection<Coordinate> coordinates = grid.keySet();
		for(Coordinate c : coordinates) {
			Cell cell = grid.get(c); // resets counter
			cell.setNeighbourgs(0);
			// since only a conduction can become an electron head
			//   i count only neighbours for conductor
			if(cell.getState() == Cell.State.CONDUCTOR) {
				int n = 0;
				if(getCellState(c.getX() - 1, c.getY() - 1) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX() - 1, c.getY()) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX() - 1, c.getY() + 1) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX(), c.getY() + 1) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX() + 1, c.getY() + 1) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX() + 1, c.getY()) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX() + 1, c.getY() - 1) == Cell.State.ELECTRON_HEAD) n++;
				if(getCellState(c.getX(), c.getY() - 1) == Cell.State.ELECTRON_HEAD) n++;
				cell.setNeighbourgs(n);
				grid.put(c, cell);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Grid)) return false;

		Grid grid1 = (Grid) o;

		if (!grid.equals(grid1.grid)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return grid.hashCode();
	}

	@Override
	public String toString() {
		return "Grid{" +
				"grid=" + grid +
				'}';
	}
}
