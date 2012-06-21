package org.coode.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7368088032198424251L;

	public ProgressPanel() {
		this.initGUI();
	}

	private void initGUI() {
		this.setLayout(new GridBagLayout());
		JProgressBar pb = new JProgressBar();
		pb.setIndeterminate(true);
		this.setBackground(Color.WHITE);
		this.add(pb, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new ProgressPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
