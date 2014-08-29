package tk.unnikked.wireworld.gui;

import tk.unnikked.wireworld.core.Cell;
import tk.unnikked.wireworld.core.Grid;
import tk.unnikked.wireworld.core.Wireworld;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class WorldGrid extends JPanel {
	private WorldCell[][] worldGrid;
	private Wireworld wireworld;

	public WorldGrid(int row, int col, int cellWidth) {
		worldGrid = new WorldCell[row][col];
		wireworld = new Wireworld(row, col);

		WorldMouseListener mouseListener = new WorldMouseListener(this);

		Dimension cellSize = new Dimension(cellWidth, cellWidth);

		setLayout(new GridLayout(row, col));

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				worldGrid[i][j] = new WorldCell(i, j);
				worldGrid[i][j].setOpaque(true);
				worldGrid[i][j].addMouseListener(mouseListener);
				worldGrid[i][j].setPreferredSize(cellSize);
				add(worldGrid[i][j]);
			}
		}
	}

	public void labelPressed(WorldCell worldCell, Cell.State state) {
		worldCell.setState(state);
		wireworld.setCell(worldCell.getRow(), worldCell.getCol(), state);
	}

	public void update() {
		Grid grid = wireworld.getGrid();
		for(int i = 0; i < worldGrid.length; i++) {
			for(int j = 0; j < worldGrid[0].length; j++) {
				labelPressed(worldGrid[i][j], grid.getCellState(i, j));
			}
		}
	}

	public void tick() {
		wireworld.tick();
		update();
	}
}
