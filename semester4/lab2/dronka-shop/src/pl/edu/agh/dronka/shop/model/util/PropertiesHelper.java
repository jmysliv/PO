package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());
		switch (item.getCategory()){
			case BOOKS:
				addBookProperties((Book) item, propertiesMap);
				break;
			case ELECTRONICS:
				addElectronicsProperties((Electronics) item, propertiesMap);
				break;
			case FOOD:
				addFoodProperties((Food) item, propertiesMap);
				break;
			case MUSIC:
				addMusicProperties((Music) item, propertiesMap);
				break;
			default:
				break;
		}
		
		return propertiesMap;
	}

	private static void addBookProperties(Book book, Map<String, Object> propertiesMap){
		propertiesMap.put("Liczba stron", book.getNumberOfPages());
		propertiesMap.put("Twarda oprawa", book.isHardcover());
	}

	private static void addElectronicsProperties(Electronics electronics, Map<String, Object> propertiesMap){
		propertiesMap.put("Mobilny", electronics.isMobile());
		propertiesMap.put("Gwarancja", electronics.isGuarantee());
	}

	private static void addFoodProperties(Food food, Map<String, Object> propertiesMap){
		propertiesMap.put("Data przydatności", food.getDateToEat());
	}

	private static void addMusicProperties(Music music, Map<String, Object> propertiesMap){
		propertiesMap.put("Gatunek muzyczny", music.getGenre().getDisplayName());
		propertiesMap.put("Dołączone video", music.isVideo());
	}

}
