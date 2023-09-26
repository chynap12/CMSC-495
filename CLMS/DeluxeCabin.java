package CLMS;

public class DeluxeCabin extends Cabin{
	private static int cabinType = 1;

	public DeluxeCabin(String[][] cabinPassenger) {
		super("Window, Toilet", cabinType, cabinPassenger);
	}

}
