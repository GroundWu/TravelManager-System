package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import POJO.*;
import utils.dbUtils;

public class FlightDao implements Dao{
	 Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		String sql="insert into FLIGHTS value(?,?,?,?,?,?)";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Flight) o).getFilghtNum());
			pstmt.setInt(2, ((Flight) o).getPrice());
			pstmt.setInt(3, ((Flight) o).getNumSeats());
			pstmt.setInt(4, ((Flight)o).getNumAvail());
			pstmt.setString(5,((Flight)o).getFromCity() );
			pstmt.setString(6, ((Flight)o).getAvrivCity());
			int x=pstmt.executeUpdate();
			System.out.println(x);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		String sql = "delete from FLIGHTS where flightNum=?";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Flight)o).getFilghtNum());
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
		String sql ="update  FLIGHTS set price=?,numSeats=?,"
				+ "numAvail=?,FromCity=?,AvrivCity=? where flightNum=?";
		try{
			conn=dbUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,((Flight)o).getPrice());
			pstmt.setInt(2,((Flight)o).getNumSeats());
			pstmt.setInt(3, ((Flight)o).getNumAvail());
			pstmt.setString(5, ((Flight)o).getAvrivCity());
			pstmt.setString(4, ((Flight)o).getFromCity());
			pstmt.setString(6, ((Flight)o).getFilghtNum());
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
		String sql ="select * from FLIGHTS";
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Flight f= new Flight();
				f.setFilghtNum(rs.getString(1));
				f.setPrice(rs.getInt(2));
				f.setNumSeats(rs.getInt(3));
				f.setNumAvail(rs.getInt(4));
				f.setFromCity(rs.getString(5));
				f.setAvrivCity(rs.getString(6));
				list.add(f);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
			
		}
		return list;
	}
	
	public Flight getFromFlightNum(String num){
		String sql = "select * from FLIGHTS where flightNum=?";
		Flight f = new Flight();
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				f.setFilghtNum(rs.getString(1));
				f.setPrice(rs.getInt(2));
				f.setNumSeats(rs.getInt(3));
				f.setNumAvail(rs.getInt(4));
				f.setFromCity(rs.getString(5));
				f.setAvrivCity(rs.getString(6));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
		return f;
	}

}
