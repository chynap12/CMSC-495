package CLMS;

public class StandardCabin extends Cabin{
	private static int cabinType = 0;
		public StandardCabin(String[][] cabinPassenger) {
		super("Porthole, Toilet,", cabinType, cabinPassenger);
	}

}
