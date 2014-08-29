package tk.unnikked.wireworld.gui;

import tk.unnikked.wireworld.core.Cell;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by nicola on 29/08/14.
 */
public class WorldMouseMotionListener extends MouseMotionAdapter {

	private WorldGrid worldGrid;

	public WorldMouseMotionListener(WorldGrid worldGrid) {
		this.worldGrid = worldGrid;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
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
