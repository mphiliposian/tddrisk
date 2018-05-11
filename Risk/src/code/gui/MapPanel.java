package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import code.game.Territory;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 3214096693616901520L;
	private int width;
	private int height;
	private Map < Territory, LabeledButton > territoryMap;
	private Image mapImage;

	public MapPanel(int width, int height, List < Territory > territories) {
		this.width = width;
		this.height = height;
		this.setBounds(0, 0, width, height);
		this.territoryMap = new HashMap < > ();
		LabeledButton lButton;
		for (Territory t: territories) {
			lButton = new LabeledButton(this, t.getName(), "0");
			this.territoryMap.put(t, lButton);
			lButton.setBounds(new Double(t.getX() * width).intValue(),
				new Double(t.getY() * height).intValue(), 55, 20);
		}
		this.setBackground(Color.black);
		this.setLayout(null);
		mapImage = new ImageIcon("map.png").getImage();
	}

	public void updateTerritory(Territory territory, Color color) {
		LabeledButton lButton = this.territoryMap.get(territory);
		lButton.setText(territory.getYield());
		lButton.setColor(color);
	}
	
	public void addSelectionListeners(RiskGUI ui) {
		for (Territory t: territoryMap.keySet()) {
			territoryMap.get(t).addActionListener(new TerritorySelectionListener(ui, t));
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension size = new Dimension(width, height);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		this.setLayout(null);
		g.drawImage(mapImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
}
