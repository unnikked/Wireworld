package tk.unnikked.wireworld.core;

public class Grid {
	private Cell[][] grid;

	public Grid() {
		this(32);
	}

	public Grid(int dimension) {
		this(dimension, dimension);
	}

	public Grid(int dimensionX, int dimensionY) {
		this.grid = new Cell[dimensionX][dimensionY];
		init(dimensionX, dimensionY);
	}

	public Grid(Grid grid) {
		this.grid = grid.grid;
	}

	private void init(int x, int y) {
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++)
				grid[i][j] = new Cell();
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setCellState(int x, int y, Cell.State state) {
		grid[x][y].setState(state);
	}

	public Cell.State getCellState(int x, int y) {
		return grid[x][y].getState();
	}

	public Cell getCell(int x, int y) {
		return grid[x][y];
	}

	public void countNeighbourgs() {
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j].setNeighbourgs(0); // resets counter
				/* since only a conduction can become an electron head
				   i count only neighbourgs for conductor */
				if(grid[i][j].getState() == Cell.State.CONDUCTOR) {
					int c = 0; // count variable
					if(i - 1 > 0               && j - 1 > 0                  && grid[i - 1][j - 1].getState()   == Cell.State.ELECTRON_HEAD) c++;
					if(i - 1 > 0                                             && grid[i - 1][j].getState()       == Cell.State.ELECTRON_HEAD) c++;
					if(i - 1 > 0               && j + 1 < grid[0].length - 1 && grid[i - 1][j + 1].getState()   == Cell.State.ELECTRON_HEAD) c++;
					if(                           j + 1 < grid[0].length - 1 && grid[i][j + 1].getState()       == Cell.State.ELECTRON_HEAD) c++;
					if(i + 1 < grid.length - 1 && j + 1 < grid[0].length - 1 && grid[i + 1][j + 1].getState()   == Cell.State.ELECTRON_HEAD) c++;
					if(i + 1 < grid.length - 1                               && grid[i + 1][j].getState()       == Cell.State.ELECTRON_HEAD) c++;
					if(i + 1 < grid.length - 1 && j - 1 > 0                  && grid[i + 1][j - 1].getState()   == Cell.State.ELECTRON_HEAD) c++;
					if(                           j - 1 > 0                  && grid[i][j - 1].getState()       == Cell.State.ELECTRON_HEAD) c++;
					grid[i][j].setNeighbourgs(c);
				}
			}
	}

	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Grid)) return false;
		if(this == obj) return true;
		Grid grid = (Grid) obj;
		if(this.grid.length != grid.grid.length) return false;
		if(this.grid[0].length != grid.grid[0].length) return false;
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[0].length; j++) {
				if(!this.grid[i][j].equals(grid.grid[i][j])) return false;
			}
		}
		return true;
	}

	public int hashCode() {
		final int PRIME = 11;
		int hashCode = 0;
		for(Cell[] aRow : grid)
			for(Cell cell : aRow)
				hashCode += cell.hashCode() * PRIME;
		return hashCode;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Cell[] aRow : grid) {
			for (Cell cell : aRow) {
				switch (cell.getState()) {
					case EMPTY: sb.append('E'); break;
					case ELECTRON_HEAD: sb.append('H'); break;
					case ELECTRON_TAIL: sb.append('t'); break;
					case CONDUCTOR: sb.append('C'); break;
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}
