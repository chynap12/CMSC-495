package CLMS;

public class SpaCabin extends Cabin{
	private static int cabinType = 3;

	public SpaCabin(String[][] cabinPassenger) {
		super("Balcony, Bath, Toilet, Storage Closet", cabinType, cabinPassenger);
	}

}
