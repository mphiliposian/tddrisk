package code.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TerritoryReader {

	public Territory parseTerritory(String string) {
		String[] territoryInfo = string.split(" \\| ");
		String coordinates = territoryInfo[2].replace("(", "").replace(")", "").replace(" ", "");
		Double xScale = Double.parseDouble(coordinates.substring(0, coordinates.indexOf(",")));
		Double yScale = Double.parseDouble(coordinates.substring(coordinates.indexOf(",") + 1, coordinates.length()));
		return new Territory(territoryInfo[0],
			Messages.getTerritoryString("Game."+territoryInfo[0]),
			new ArrayList <String> (Arrays.asList(territoryInfo[1]
				.replace("[", "")
				.replace("]", "")
				.split(","))),
			xScale, yScale);
	}

	public Map <String, Set <Territory>> readTerritories(String fileName) {
		Set <Territory> territories = new HashSet <> ();
		Map <String, Set <Territory>> continents = new HashMap <> ();
		String currContinent = "NA";
		String line = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (((line = reader.readLine()) != null)) {
				if (!line.isEmpty()) {
					Territory territory = this.parseTerritory(line);
					if (territory.getTerritoryID().contains(currContinent)) {
						territories.add(territory);
					} else {
						continents.put(currContinent, territories);
						territories = new HashSet <> ();
						currContinent = territory.getTerritoryID().substring(0, 2);
						territories.add(territory);
					}
				}
			}
		} catch (FileNotFoundException ex1) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		continents.put(currContinent, territories);
		return continents;
	}
}
