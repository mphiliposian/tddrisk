package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestUI {
	public static JFrame frame;
	public static JPanel panel;
	public static int window_height;
	public static int window_width;
	public static double scalefactor = 0.9;
	public static List<Territory> territoryList = new ArrayList<>();
	static int i = 1;

	public static void main(String[] args) {
		initializeUI();
	}
	
	@SuppressWarnings("serial")
	public static void initializeUI() {
		Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
		Double width = screenResolution.getWidth();
		Double height = screenResolution.getHeight();
		Double heightscaled = height * scalefactor;
		Double widthscaled = width * scalefactor;
		window_width = widthscaled.intValue();
		window_height = heightscaled.intValue();		
		
		frame = new JFrame("Risk");
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
		        Image img = new ImageIcon("map.png").getImage();
		        Dimension size = new Dimension(this.getWidth(), this.getHeight());
		        this.setPreferredSize(size);
		        this.setMinimumSize(size);
		        this.setMaximumSize(size);
		        this.setSize(size);
		        this.setLayout(null);
		        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    }
		};
		
		String fileName = "TerritoryMap.txt";
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			while (((line = bufferedReader.readLine()) != null)) {
				if(!line.isEmpty()) {
					String[] territoryInfo = line.split(" \\| ");
					String coordinates = territoryInfo[3].replace("(", "").replace(")", "").replace(" ", "");
					int x = Integer.parseInt(coordinates.substring(0, coordinates.indexOf(",")));
					int y = Integer.parseInt(coordinates.substring(coordinates.indexOf(",")+1, coordinates.length()));
					territoryList.add(new Territory(territoryInfo[0],
													territoryInfo[1],
													new ArrayList<String>(Arrays.asList(territoryInfo[2]
																			.replace("[","")
																			.replace("]","")
																			.split(","))),
													x, y));
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex1) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		Double centerxd = ((width - widthscaled) / 2);
		Double centeryd = ((height - heightscaled) / 2);
		int centerx = centerxd.intValue();
		int centery = centeryd.intValue();
		
		frame.setBounds(centerx, centery, window_width, window_height);
		panel.setBounds(centerx, centery, window_width, window_height);
		panel.setBackground(Color.black);
		panel.setLayout(null);
		
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
			l.setBounds(curTerritory.getX()-50, curTerritory.getY()-60, 150, 100);
			b.setBounds(curTerritory.getX(), curTerritory.getY(), 55, 20);
			panel.add(l);
			panel.add(b);
		}
		
		/*
		 * Used for measuring coordinates of each territory.
		 */
//		panel.addMouseListener(new MouseListener() {
//		    public void mouseClicked(MouseEvent e) {
//		    	int x=e.getX();
//		        int y=e.getY();
//		        System.out.println("("+x+","+y+")");//these co-ords are relative to the component
//		        i++;
//		    }
//
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//		});
		frame.add(panel);
		frame.setVisible(true);
		
		frame.repaint();
		panel.repaint();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}