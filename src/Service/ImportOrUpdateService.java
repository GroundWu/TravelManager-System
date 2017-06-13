package Service;

import Dao.*;
import POJO.*;

public class ImportOrUpdateService {
	
	public static void ImportFlight(Flight f){
		FlightDao fd = new FlightDao();
		fd.add(f);
	}
	
	public static void UpdateFlight(Flight f){
		FlightDao fd = new FlightDao();
		fd.update(f);
	}
	
	public static void ImportHotel(Hotel h){
		HotelsDao hd = new HotelsDao();
		hd.add(h);
	}
	
	public static void UpdateHotel(Hotel h){
		HotelsDao hd = new HotelsDao();
		hd.update(h);
	}
	
	public static void ImportCar(Car c){
		CarsDao cd= new CarsDao();
		cd.add(c);
	}
	
	public static void UpdateCar(Car c){
		CarsDao cd =new CarsDao();
		cd.update(c);
	}
	
	public static void ImportCustomer(Customer c){
		CustomersDao cd = new CustomersDao();
		cd.add(c);
	}
	
}
