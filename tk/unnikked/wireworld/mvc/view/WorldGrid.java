package tk.unnikked.wireworld.mvc.view;

import tk.unnikked.wireworld.core.Cell;
import tk.unnikked.wireworld.core.Coordinate;
import tk.unnikked.wireworld.core.Grid;
import tk.unnikked.wireworld.mvc.controller.WorldMouseListener;
import tk.unnikked.wireworld.mvc.model.WorldCell;
import tk.unnikked.wireworld.utils.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class WorldGrid extends JPanel implements Observer {
	private WorldCell[][] worldGrid;
	private ChangeGridSubject observable;

	public WorldGrid(int row, int col, int cellWidth) {
		worldGrid = new WorldCell[row][col];
		observable = new ChangeGridSubject();

		WorldMouseListener mouseListener = new WorldMouseListener(this);

		Dimension cellSize = new Dimension(cellWidth, cellWidth);

		setLayout(new GridLayout(row, col));

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				worldGrid[i][j] = new WorldCell(i, j);
				worldGrid[i][j].setOpaque(true);
				worldGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
				worldGrid[i][j].addMouseListener(mouseListener);
				worldGrid[i][j].setPreferredSize(cellSize);
				add(worldGrid[i][j]);
			}
		}
	}

	public ChangeGridSubject getChangeGridObserver() {
		return this.observable;
	}

	public void labelPressed(WorldCell worldCell, Cell.State state) {
		worldCell.setState(state);
		observable.setChanged();
		observable.notifyObservers(new Pair(new Coordinate(worldCell.getRow(), worldCell.getCol()), new Cell(state)));
	}

	public void update(Grid grid) {
		for(int i = 0; i < worldGrid.length; i++) {
			for(int j = 0; j < worldGrid[0].length; j++) {
				labelPressed(worldGrid[i][j], grid.getCellState(i, j));
			}
		}
	}

	@Override
	public void update(Observable observable, Object o) {
		if(o instanceof Grid) {
			update((Grid) o);
		}
	}
}
