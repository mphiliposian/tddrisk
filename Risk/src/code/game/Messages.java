package code.game;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

	private static final String BUNDLE_NAME = "code.game.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private static final String BUNDLE_NAME_TERRITORY = "code.game.names"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE_TERRITORY = ResourceBundle.getBundle(BUNDLE_NAME_TERRITORY);

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getTerritoryString(String key) {
		try {
			return RESOURCE_BUNDLE_TERRITORY.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}