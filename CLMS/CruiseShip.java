package CLMS;

public class CruiseShip extends CruiseCompany {

	//variables
	private static int shipID;
	private String name;
	private String location;
	private String origin;
	private String destination;
	private String[] itinerary;
	private int tripLength; 
	private int numCabins;
	private int yearOfBuild;
	private int maintenance;
	private int maxCapacity;
	
	//array of cabins
	Cabin[] cabins;
	
	public CruiseShip(int shipID, String company, String name, String location, String origin, String destination,
			String[] itinerary,	int tripLength,	int numCabins, int yearOfBuild, int maintenance, int maxCapacity) {
		super(company);
		this.setShipID(shipID);
		this.name = name;
		this.location = location;
		this.origin = origin;
		this.destination = destination;
		this.itinerary = itinerary;
		this.tripLength = tripLength; 
		this.numCabins = numCabins;
		this.yearOfBuild = yearOfBuild;
		this.setMaintenance(maintenance);
		this.maxCapacity = maxCapacity;
	}
	
	//getter methods
	public void setShipID(int shipID){
		CruiseShip.shipID = shipID;
		}
	public static int getShipID(){
		return shipID;
		}
	public String getCompany(){
		return company;
		}
	public String getName(){
		return name;
		}
	public String getLocation(){
		return location;
		}
	public String getorigin(){
		return origin;
		}
	public String getDestination(){
		return destination;
		}
	public String[] getItinerary(){
		return itinerary;
		}
	public int getTripLength(){
		return tripLength;
		}
	public int getYearOfBuild(){
		return yearOfBuild;
		}
	public int getNumCabins(){
		return numCabins;
		}
	public int getMaintenance() {
		return maintenance;
		}
	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}
	public int getMaxCapacity(){
		return maxCapacity;
		}

	public int getAvailableCabins() {
		return getNumCabins() - cabins.length;	
		}

}
