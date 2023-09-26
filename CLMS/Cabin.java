package CLMS;

import java.util.Arrays;

public class Cabin{

	Boolean occupied = false;
	String amenities;
	int cabinType;
	String[][] passengers;

	public Cabin(String amenities, int cabinType, String[][] cabinPasengers) {
		this.amenities = amenities;
		this.cabinType = cabinType;
		@SuppressWarnings("unused")
		String[][] passengers = new String[cabinPasengers.length][cabinPasengers[0].length];
	}

	public int findPassenger(String name) {
		for(int i=0; i<passengers.length; i++)
		{
			for(int j=0; j<passengers[i].length; j++)
			{
				if(passengers[i][j] == name) {
					return CruiseShip.getShipID();
				} 
			}
		}
		return -1;
	}

	public void getPassengers() {
		/*test print*/
		System.out.println(Arrays.deepToString(passengers));
	}
	
	public String getAmenities() {return amenities;}

}
