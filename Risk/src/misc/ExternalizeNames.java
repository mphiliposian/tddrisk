package misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import code.game.Territory;

public class ExternalizeNames {

	public static void main(String[] args) {
		String fileName = "TerritoryTestMap.txt";
		String mapName = "Testmap.txt";
		String names = "Testnames.properties";
		String line = null;
		String[] ps = null;
		String territoryName;
		String territoryID;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
				BufferedWriter mapWriter = new BufferedWriter(new FileWriter(mapName));
				BufferedWriter nameWriter = new BufferedWriter(new FileWriter(names));
				) {
			while (((line = reader.readLine()) != null)) {
				if (!line.isEmpty()) {
					ps = line.split("\\|");
					territoryName = ps[1].trim();
					territoryID = ps[0].trim();
					mapWriter.write(territoryID + " |" + ps[2] + "|" + ps[3] + '\n');
					nameWriter.write("Game." + territoryID + "=" + territoryName + '\n');
				}
			}
		} catch (FileNotFoundException ex1) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}

