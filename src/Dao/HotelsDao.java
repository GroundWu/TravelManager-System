package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Car;
import POJO.Flight;
import POJO.Hotel;
import utils.dbUtils;

public class HotelsDao implements Dao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		String sql="insert into Hotels value(?,?,?,?)";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Hotel) o).getLocation());
			pstmt.setInt(2, ((Hotel) o).getPrice());
			pstmt.setInt(3, ((Hotel) o).getNumRooms());
			pstmt.setInt(4, ((Hotel)o).getNumAvail());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		String sql = "delete from Hotels where location=?";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Hotel)o).getLocation());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		String sql="update Hotels set price=?,numRooms=?,numAvail=? where location=?";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, ((Hotel) o).getLocation());
			pstmt.setInt(1, ((Hotel) o).getPrice());
			pstmt.setInt(2, ((Hotel) o).getNumRooms());
			pstmt.setInt(3, ((Hotel)o).getNumAvail());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		String sql ="select * from HOTELS";
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Hotel h = new Hotel();
				h.setLocation(rs.getString(1));
				h.setPrice(rs.getInt(2));
				h.setNumRooms(rs.getInt(3));
				h.setNumAvail(rs.getInt(4));
				list.add(h);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
			
		}
		return list;
	}
	
	public Hotel getHotelByLocation(String location){
		String sql = "select * from HOTELS where location=?";
		Hotel h =new Hotel();
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			if(rs.next()){
				h.setLocation(rs.getString(1));
				h.setPrice(rs.getInt(2));
				h.setNumRooms(rs.getInt(3));
				h.setNumAvail(rs.getInt(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
		return h;
	}

}
