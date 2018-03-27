package code.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import code.game.Territory;

public class MapPanel {
	
	private int width;
	private int height;
	private Map<Territory, LabeledButton> territoryMap;
	
	private JPanel mapPanel;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("hello, world!");
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenResolution.getWidth();
		double height = screenResolution.getHeight();
		
		Double scaledWidth = width * 0.9;
		Double scaledHeight = height * 0.9;
		int windowWidth = scaledWidth.intValue();
		int windowHeight = scaledHeight.intValue();
		
		Double centerxd = ((width - scaledWidth) / 2);
		Double centeryd = ((height - scaledHeight) / 2);
		int centerX = centerxd.intValue();
		int centerY = centeryd.intValue();
		
		ArrayList<Territory> nt = new ArrayList<>();
		//nt.add(new Territory());
		
		MapPanel mp = new MapPanel(windowWidth, windowHeight, nt);
		frame.add(mp.getPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MapPanel(int width, int height, List<Territory> territories) {
		this.width = width;
		this.height = height;
		this.mapPanel = new JPanel();
		this.mapPanel.setBounds(0, 0, width, height);
		this.mapPanel.setPreferredSize(new Dimension(width, height));
		
		this.territoryMap = new HashMap<>();
		for (Territory t : territories) {
			this.territoryMap.put(t, new LabeledButton(this.mapPanel, t.getName(), "0"));
		}
	}
	
	public JPanel getPanel() {
		return this.mapPanel;
	}
}
