package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));
				Item item;
				switch(category){
					case BOOKS:
						item = readBookParams(dataLine, reader, name, price, quantity, category);
						break;
					case ELECTRONICS:
						item = readElectronicParams(dataLine, reader, name, price, quantity,  category);
						break;
					case FOOD:
						item = readFoodParams(dataLine, reader, name, price, quantity, category);
						break;
					case MUSIC:
						item = readMusicParams(dataLine, reader, name, price, quantity, category);
						break;
					default:
						item = new Item(name, category, price, quantity);
						break;
				}
				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);

				items.add(item);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

	private static Book readBookParams(String[] dataLine, CSVReader reader, String name, int price, int quantity, Category category){
		int numberOfPages = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
		boolean hardcover = Boolean.parseBoolean(reader.getValue(dataLine, "Twarda oprawa"));
		Book book = new Book(name, category, price, quantity, numberOfPages, hardcover);
		return book;
	}

	private static Electronics readElectronicParams(String[] dataLine, CSVReader reader, String name, int price, int quantity, Category category){
		boolean mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobilny"));
		boolean guarantee = Boolean.parseBoolean(reader.getValue(dataLine, "Gwarancja"));
		Electronics electronics = new Electronics(name, category, price, quantity, mobile, guarantee);
		return electronics;
	}

	private static Food readFoodParams(String[] dataLine, CSVReader reader, String name, int price, int quantity, Category category){
		String dateString = reader.getValue(dataLine, "Data przydatności");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date;
		try{
			date = df.parse(dateString);
		} catch(ParseException e){
			date = new Date(2020, 5, 20);
		}
		Food food = new Food(name, category, price, quantity, date);
		return food;
	}

	private static Music readMusicParams(String[] dataLine, CSVReader reader, String name, int price, int quantity, Category category){
		String stringGenre = reader.getValue(dataLine, "Gatunek muzyczny");
		MusicGenre genre;
		switch(stringGenre){
			case "POP":
				genre = MusicGenre.POP;
				break;
			case "Hip-Hop":
				genre = MusicGenre.HIP_HOP;
				break;
			case "Jazz":
				genre = MusicGenre.JAZZ;
				break;
			default:
				genre = MusicGenre.POP;
				break;
		}
		boolean video = Boolean.parseBoolean(reader.getValue(dataLine, "Dołączone video"));
		Music music = new Music(name, category,price, quantity, genre, video);
		return music;

	}

}
