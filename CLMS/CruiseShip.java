package CLMS;

public class CruiseShip extends CruiseCompany {

	//variables
	int shipID;
	String name;
	String location;
	String origin;
	String destination;
	String[] itinerary;
	int tripLength; 
	int numCabins;
	int yearOfBuild;
	int maxCapacity;
	
	//array of cabins
	Cabin[] cabins;
	
	public CruiseShip(int shipID, String company, String name, String location, String origin, String destination,
			String[] itinerary,	int tripLength,	int numCabins, int yearOfBuild,	int maxCapacity) {
		super(company);
		this.shipID = shipID;
		this.name = name;
		this.location = location;
		this.origin = origin;
		this.destination = destination;
		this.itinerary = itinerary;
		this.tripLength = tripLength; 
		this.numCabins = numCabins;
		this.yearOfBuild =yearOfBuild;
		this.maxCapacity = maxCapacity;
	}
	
	//getter methods
	public int getShipID(){return shipID;}
	public String getCompany(){return company;}
	public String getName(){return name;}
	public String getLocation(){return location;}
	public String getorigin(){return origin;}
	public String getDestination(){return destination;}
	public String[] getItinerary(){return itinerary;}
	public int getTripLength(){return tripLength;}
	public int getYearOfBuild(){return numCabins;}
	public int getNumCabins(){return yearOfBuild;}
	public int getMaxCapacity(){return maxCapacity;}

}
