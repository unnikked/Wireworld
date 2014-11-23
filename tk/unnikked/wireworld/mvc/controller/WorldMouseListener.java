package tk.unnikked.wireworld.mvc.controller;

import tk.unnikked.wireworld.core.Cell;
import tk.unnikked.wireworld.mvc.model.WorldCell;
import tk.unnikked.wireworld.mvc.view.WorldGrid;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by nicola on 29/08/14.
 */
public class WorldMouseListener extends MouseAdapter {
	private WorldGrid worldGrid;

	public WorldMouseListener(WorldGrid worldGrid) {
		this.worldGrid = worldGrid;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		WorldCell worldCell = (WorldCell) e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(worldCell.getState() == Cell.State.CONDUCTOR) {
				worldGrid.labelPressed(worldCell, Cell.State.EMPTY);
			} else worldGrid.labelPressed(worldCell, Cell.State.CONDUCTOR);
		} else if(e.getButton() == MouseEvent.BUTTON3) {
			if(worldCell.getState() == Cell.State.CONDUCTOR) {
				worldGrid.labelPressed(worldCell, Cell.State.ELECTRON_HEAD);
			} else if (worldCell.getState() == Cell.State.ELECTRON_HEAD) {
				worldGrid.labelPressed(worldCell, Cell.State.ELECTRON_TAIL);
			} else {
				worldGrid.labelPressed(worldCell, Cell.State.CONDUCTOR);
			}
		}
	}
}
