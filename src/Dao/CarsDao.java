package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Car;
import POJO.Flight;
import utils.dbUtils;

public class CarsDao implements Dao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		String sql="insert into Cars value(?,?,?,?)";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Car) o).getLocation());
			pstmt.setInt(2, ((Car) o).getPrice());
			pstmt.setInt(3, ((Car) o).getNumCars());
			pstmt.setInt(4, ((Car)o).getNumAvail());
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
		String sql = "delete from Cars where location=?";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Car)o).getLocation());
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
		String sql="update CARS set price=?,numCars=?,numAvail=? where location=?";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, ((Car) o).getLocation());
			pstmt.setInt(1, ((Car) o).getPrice());
			pstmt.setInt(2, ((Car) o).getNumCars());
			pstmt.setInt(3, ((Car)o).getNumAvail());
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
		String sql ="select * from CARS";
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Car c = new Car();
				c.setLocation(rs.getString(1));
				c.setPrice(rs.getInt(2));
				c.setNumCars(rs.getInt(3));
				c.setNumAvail(rs.getInt(4));
				list.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
			
		}
		return list;
	}
	
	public Car getCarBylocation(String location){
		String sql = "select * from CARS where location=?";
		Car c =new Car();
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			if(rs.next()){
				c.setLocation(rs.getString(1));
				c.setPrice(rs.getInt(2));
				c.setNumCars(rs.getInt(3));
				c.setNumAvail(rs.getInt(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
		return c;
	}

}
