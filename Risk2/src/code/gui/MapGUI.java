package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.game.Territory;

public class MapGUI {
	private int windowWidth;
	private int windowHeight;
	private int centerX;
	private int centerY;
	private JFrame frame;
	private JPanel panel;
	private List<Territory> territoryList = new ArrayList<>();
	// private HashMap<Territory, {Label&Button}> territories = new HashMap<>();
	
	public MapGUI(Double width, Double height) {
		Double scaledWidth = width * 0.9;
		Double scaledHeight = height * 0.9;
		this.windowWidth = scaledWidth.intValue();
		this.windowHeight = scaledHeight.intValue();
		
		Double centerxd = ((width - scaledWidth) / 2);
		Double centeryd = ((height - scaledHeight) / 2);
		this.centerX = centerxd.intValue();
		this.centerY = centeryd.intValue();
	}

	public void initializeMap(String mapImage, String territoriesSource) {
		frame = new JFrame("Risk");
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
		        Image img = new ImageIcon(mapImage).getImage();
		        Dimension size = new Dimension(this.getWidth(), this.getHeight());
		        this.setPreferredSize(size);
		        this.setMinimumSize(size);
		        this.setMaximumSize(size);
		        this.setSize(size);
		        this.setLayout(null);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    }
		};
		
		this.addAllTerritories(territoriesSource);
		
		this.frame.setBounds(this.centerX, this.centerY, windowWidth, windowHeight);
		this.panel.setBounds(this.centerX, this.centerY, windowWidth, windowHeight);
		this.panel.setBackground(Color.black);
		this.panel.setLayout(null);
	}
	
	public void drawMap() {
		this.drawTerritories();
		
		this.frame.add(this.panel);
		this.frame.setVisible(true);
		this.frame.repaint();
		this.panel.repaint();
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void drawTerritories() {
		for(int i = 0; i < territoryList.size(); i++) {
			/*
			 * This works, but is a very bad way to keep track of specific territory units.
			 * We should find a way to fix this.
			 */
			Territory curTerritory = territoryList.get(i);
			JLabel l = new JLabel(curTerritory.getName());
			JButton b = new JButton(String.valueOf(curTerritory.getYield()));
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * -Opens JPanel for fortifying.
					 * -User inputs x (number of units to place in territory)
					 * 
					 * if(x < 0)
					 * 		// throw exception
					 * if(x > //maximum units)
					 * 		// throw exception
					 * else
					 * 		curTerritory.setYield(curTerritory.getYield+x);
					 */
				}
			});
			l.setForeground(Color.RED);
			l.setFont(l.getFont().deriveFont(14.0f));
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setBounds(curTerritory.getX().intValue()-50, curTerritory.getY().intValue()-60, 150, 100);
			b.setBounds(curTerritory.getX().intValue(), curTerritory.getY().intValue(), 55, 20);
			panel.add(l);
			panel.add(b);
		}
	}

	private void addAllTerritories(String territoriesSource) {
		String line = null;
		try {
			FileReader fileReader = new FileReader(territoriesSource);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			while (((line = bufferedReader.readLine()) != null)) {
				if(!line.isEmpty()) {
					String[] territoryInfo = line.split(" \\| ");
					String coordinates = territoryInfo[3].replace("(", "").replace(")", "").replace(" ", "");
					Double xScale = Double.parseDouble(coordinates.substring(0, coordinates.indexOf(",")));
					Double yScale = Double.parseDouble(coordinates.substring(coordinates.indexOf(",")+1, coordinates.length()));
					this.territoryList.add(new Territory(territoryInfo[0],
													territoryInfo[1],
													new ArrayList<String>(Arrays.asList(territoryInfo[2]
																			.replace("[","")
																			.replace("]","")
																			.split(","))),
													xScale*this.windowWidth, yScale*this.windowHeight));
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex1) {
			System.out.println("Unable to open file '" + territoriesSource + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + territoriesSource + "'");
		}
	}

}
