package CLMS;

import java.io.IOException;

public class CLMS {

	DataLoader dataLoader = new DataLoader();
	static CruiseShip[] cruiseShip = new CruiseShip[60];

	public static void loadExcel(String filename) {
		for(int i = 0; i < cruiseShip.length; i++) 
		{
			try {
				cruiseShip[i] = DataLoader.loadShip(filename, i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
