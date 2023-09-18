package CLMS;

public class Cabin{

	Boolean occupied = false;
	String amenities;
	int cabinType;
	
	public Cabin(String amenities, int cabinType) {
		this.amenities = amenities;
		this.cabinType = cabinType;
	}
	
	public String getAmenities() {return amenities;}

}
