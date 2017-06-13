package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import Dao.*;
import POJO.*;
import utils.dbUtils;

public class CheckService {
	
	public static List<Object> getAllFlight(){
		return new FlightDao().getAll();
	}
	
	public static List<Object> getAllHotels(){
		return new HotelsDao().getAll();
	}
	
	public static List<Object> getAllCars(){
		return new CarsDao().getAll();
	}
	
	public static List<Object> getAllCustomers(){
		return new CustomersDao().getAll();
	}
	
	public static List<Object> checkResvByCust(Customer c,int type){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Object> list = new ArrayList<Object>();
		
		CustomersDao cd =new CustomersDao();
		if(!cd.getCustomer(c))
		 return list;
		
		String sql="select * from Reservations where custName=? and resvType=?";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCustName());
			pstmt.setInt(2, type);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reservation r  =new Reservation();
				r.setCustName(rs.getString(1));
				r.setResvType(rs.getInt(2));
				r.setDetail(rs.getString(4));
				r.setResvKey(rs.getInt(3));
				list.add(r);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	public static List<Object> getRoute(Customer c){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Object> list = new ArrayList<Object>();
		
		CustomersDao cd =new CustomersDao();
		if(!cd.getCustomer(c))
		 return list;
		String sql="select flightNum,FromCity,AvrivCity from Flights where flightNum IN "
				+ "(select detail from Reservations where custName=? AND resvType=1)";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCustName());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Flight f = new Flight();
				f.setFilghtNum(rs.getString(1));
				f.setFromCity(rs.getString(2));
				f.setAvrivCity(rs.getString(3));
				list.add(f);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public static List<Object> getResvByResvKey(int i) {
		// TODO Auto-generated method stub
		ReservationDao rd  = new ReservationDao();
		return rd.getResvByResvKey(i);
	}
	
	public static boolean checkroute(List<Object>l){
		String head,tail;
		List<Object> list =new ArrayList(l);
		int size =list.size();
		int cur=0;
		head = ((Flight)list.get(cur)).getFromCity();
		tail=((Flight)list.get(cur)).getAvrivCity();
		list.remove(0);
		size--;
		System.out.println(size);
		while(size>0){
			int temp =0;
			boolean flag=false;
			while(temp<list.size()){	
				String arrcity=((Flight)list.get(temp)).getAvrivCity();
				if(arrcity.equals(head)){
					head=((Flight)list.get(temp)).getFromCity();
					list.remove(temp);
					flag=true;
					break;
				}else if(((Flight)list.get(temp)).getFromCity().equals(tail)){
					tail=((Flight)list.get(temp)).getAvrivCity();
					list.remove(temp);
					flag=true;
					break;
				}
				temp++;
				
			}
			if(!flag)
				return false;
			size--;
		}
		return true;
	}
}
