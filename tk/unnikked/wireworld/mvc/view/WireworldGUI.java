package tk.unnikked.wireworld.mvc.view;

import tk.unnikked.wireworld.mvc.model.Wireworld;
import tk.unnikked.wireworld.utils.GridExporter;
import tk.unnikked.wireworld.utils.GridImporter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WireworldGUI extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem imp, exp;

	public WireworldGUI() {
		setTitle("Wireworld");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// menu
		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		file = new JMenu("File");
		menuBar.add(file);

		imp = new JMenuItem("Import");
		imp.addActionListener(this);
		file.add(imp);

		exp = new JMenuItem("Export");
		exp.addActionListener(this);
		file.add(exp);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {

			public String getDescription() {
				return "Wireworld file (*.w)";
			}

			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".w");
				}
			}
		});

		if(source == imp) {
			int status = fileChooser.showOpenDialog(this);
			if(status == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				GridImporter importer = GridImporter.getInstance();
				Wireworld wireworld = Wireworld.getInstance();
				try {
					wireworld.setGrid(importer.gridImport(file));
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (source == exp) {
			int status = fileChooser.showSaveDialog(this);
			if(status == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				GridExporter exporter = GridExporter.getInstance();
				try {
					exporter.gridExport(Wireworld.getInstance(), file);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
