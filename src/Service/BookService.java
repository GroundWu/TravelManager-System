package Service;

import java.util.List;

import Dao.*;
import POJO.*;

public class BookService {
	
	public static boolean bookFlight(Customer c,String num){
		CustomersDao cd =new CustomersDao();
		if(!cd.getCustomer(c))
			cd.add(c);
		
		FlightDao fd =new FlightDao();
		Flight f =fd.getFromFlightNum(num);
		if(f.getFilghtNum()==null){
			System.out.println("无此航班！");
			return false;
		}
		if(f.getNumAvail()<=0)
			return false;
		f.setNumAvail(f.getNumAvail()-1);
		fd.update(f);
		
		Reservation r = new Reservation();
		r.setCustName(c.getCustName());
		r.setResvType(1);
		r.setDetail(f.getFilghtNum());
		ReservationDao rd =new ReservationDao();
		rd.add(r);
		return true;	
	}
	
	public static boolean bookRooms(Customer c,String location){
		CustomersDao cd =new CustomersDao();
		if(!cd.getCustomer(c))
			cd.add(c);
		
		HotelsDao hd =new HotelsDao();
		Hotel h = hd.getHotelByLocation(location);
		if(h.getLocation()==null){
			System.out.println("无此宾馆！");
			return false;
		}
		if(h.getNumAvail()<=0)
			return false;
		h.setNumAvail(h.getNumAvail()-1);
		hd.update(h);
		
		
		Reservation r = new Reservation();
		r.setCustName(c.getCustName());
		r.setResvType(2);
		r.setDetail(h.getLocation());
		ReservationDao rd =new ReservationDao();
		rd.add(r);
		return true;	
	}
	
	public static boolean bookCar(Customer c,String location){
		CustomersDao cd =new CustomersDao();
		if(!cd.getCustomer(c))
			cd.add(c);
		
		CarsDao card = new CarsDao();
		Car car =card.getCarBylocation(location);
		if(car.getLocation()==null){
			System.out.println("无此出租车！");
			return false;
		}
		if(car.getNumAvail()<=0)
			return false;
		car.setNumAvail(car.getNumAvail()-1);
		card.update(car);
		
		Reservation r = new Reservation();
		r.setCustName(c.getCustName());
		r.setResvType(3);
		r.setDetail(car.getLocation());
		ReservationDao rd =new ReservationDao();
		rd.add(r);
		return true;	
	}
	
	
		
}
