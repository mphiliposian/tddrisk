package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.game.Territory;
import code.game.TerritoryReader;

public class MapPanel extends JPanel {
	
	private static final long serialVersionUID = 3214096693616901520L;
	private int width;
	private int height;
	private Map<Territory, LabeledButton> territoryMap;
	
	private Image mapImage;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("hello, world!");
		
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenResolution.getWidth();
		double height = screenResolution.getHeight();
		
		Double scaledWidth = width * 0.9;
		Double scaledHeight = height * 0.9;
		int windowWidth = scaledWidth.intValue();
		int windowHeight = scaledHeight.intValue();
		
		TerritoryReader tr = new TerritoryReader();
		List<Territory> nt = tr.readTerritories("TerritoryMap.txt");
		
		frame.setBounds(0, 0, windowWidth, windowHeight);
		MapPanel mp = new MapPanel(windowWidth, windowHeight, nt);
		frame.add(mp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MapPanel(int width, int height, List<Territory> territories) {
		this.width = width;
		this.height = height;
		this.setBounds(0, 0, width, height);
		this.territoryMap = new HashMap<>();
		LabeledButton lButton;
		for (Territory t : territories) {
			lButton = new LabeledButton(this, t.getName(), "0"); 
			lButton.setName(t.getTerritoryID());
			System.out.println(t.getName());
			lButton.addActionListener(new ButtonListener());
			this.territoryMap.put(t, lButton);
			lButton.setBounds(new Double(t.getX()*width).intValue(), new Double(t.getY()*height).intValue(), 55, 20);
		}
		
		this.setBackground(Color.black);
		this.setLayout(null);
		mapImage = new ImageIcon("map.png").getImage();
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
