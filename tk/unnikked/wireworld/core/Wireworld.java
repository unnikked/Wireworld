package tk.unnikked.wireworld.core;

public class Wireworld {
	private Grid gameGrid;

	public Wireworld() {
		this.gameGrid = new Grid();
	}

	public Wireworld(int n) {
		this.gameGrid = new Grid(n);
	}

	public Wireworld(int x, int y) {
		this.gameGrid = new Grid(x, y);
	}

	public Wireworld(Grid gameGrid) {
		this.gameGrid = gameGrid;
	}

	public Wireworld(Wireworld game) {
		this.gameGrid = game.gameGrid;
	}

	public void setCell(int x, int y, Cell.State state) {
		this.gameGrid.setCellState(x, y, state);
	}

	public void setGrid(Grid grid) {
		this.gameGrid = grid;
	}

	public Grid getGrid() {
		return this.gameGrid;
	}

	public void tick() {
		gameGrid.countNeighbourgs();
		//Grid tmp = gameGrid;
		for(Cell[] aRow : gameGrid.getGrid()) {
			for (Cell cell : aRow) {
				switch (cell.getState()) {
					case ELECTRON_HEAD:
						cell.setState(Cell.State.ELECTRON_TAIL);
						break;
					case ELECTRON_TAIL:
						cell.setState(Cell.State.CONDUCTOR);
						break;
					case CONDUCTOR:
						if (cell.getNeighbourgs() == 1 || cell.getNeighbourgs() == 2)
							cell.setState(Cell.State.ELECTRON_HEAD);
						break;
					default:
				}
			}
		}
		//this.gameGrid = tmp;
	}

	public String toString() {
		return gameGrid.toString();
	}

	public static void main(String[] args) throws InterruptedException {
		Grid grid = new Grid(5, 5);
		grid.setCellState(2, 0, Cell.State.ELECTRON_TAIL);
		grid.setCellState(2, 1, Cell.State.ELECTRON_HEAD);
		grid.setCellState(2, 2, Cell.State.CONDUCTOR);
		grid.setCellState(2, 3, Cell.State.CONDUCTOR);
		grid.setCellState(2, 4, Cell.State.CONDUCTOR);
		Wireworld game = new Wireworld(grid);
		System.out.println(game);
		game.tick();
		System.out.println(game);
		game.tick();
		System.out.println(game);
		game.tick();
		System.out.println(game);
		game.tick();
		System.out.println(game);
		game.tick();
		System.out.println(game);
		Thread.currentThread().join();
	}
}
