package CLMS;

public class PremiumCabin extends Cabin {
	private static int cabinType = 2;
	
	public PremiumCabin(String[][] cabinPassenger) {
		super("Balcony, Bath, Toilet", cabinType, cabinPassenger);
	}

}
