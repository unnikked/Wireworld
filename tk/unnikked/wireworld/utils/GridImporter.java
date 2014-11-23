package tk.unnikked.wireworld.utils;


import tk.unnikked.wireworld.core.Grid;

import java.io.*;

public class GridImporter {
	private static GridImporter instance;

	private  GridImporter() {}

	public static GridImporter getInstance() {
		if(instance == null) {
			synchronized (GridImporter.class) {
				instance = new GridImporter();
			}
		}
		return instance;
	}

	public Grid gridImport(File file) throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = null;
		try {
			inputStream =
					new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream(file)));
			return (Grid) inputStream.readObject();
		} finally {
			if(inputStream != null)	inputStream.close();
		}

	}
}
