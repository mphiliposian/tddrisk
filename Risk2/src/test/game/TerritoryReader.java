package test.game;

import java.util.ArrayList;
import java.util.Arrays;

import code.game.Territory;

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

}
