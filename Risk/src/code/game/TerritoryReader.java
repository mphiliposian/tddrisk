package code.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerritoryReader {

	public Territory parseTerritory(String string) {
		String[] territoryInfo = string.split(" \\| ");
		String coordinates = territoryInfo[3].replace("(", "").replace(")", "").replace(" ", "");
		Double xScale = Double.parseDouble(coordinates.substring(0, coordinates.indexOf(",")));
		Double yScale = Double.parseDouble(coordinates.substring(coordinates.indexOf(",")+1, coordinates.length()));
		return new Territory(territoryInfo[0],
				territoryInfo[1],
				new ArrayList<String>(Arrays.asList(territoryInfo[2]
						.replace("[","")
						.replace("]","")
						.split(","))),
				xScale, yScale);
	}

	public List<Territory> readTerritories(String fileName) {
		List<Territory> territories = new ArrayList<>();
		String line = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			reader.readLine();
			while (((line = reader.readLine()) != null)) {
				if(!line.isEmpty()) {
					territories.add(this.parseTerritory(line));
				}
			}
		} catch (FileNotFoundException ex1) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return territories;
	}
}
