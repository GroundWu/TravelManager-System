package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Car;
import POJO.Reservation;
import utils.dbUtils;

public class ReservationDao implements Dao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		String sql="insert into Reservations value(?,?,null,?)";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Reservation)o).getCustName());
			pstmt.setString(3, ((Reservation)o).getDetail());
			pstmt.setInt(2, ((Reservation)o).getResvType());
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
		String sql = "delete from Reservations where resvKey=?";
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((Reservation)o).getResvKey());
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
		String sql="update Reservations set custName=?,resvType=?,detail=? where resvKey=?";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Reservation)o).getCustName());
			pstmt.setString(3, ((Reservation)o).getDetail());
			pstmt.setInt(2, ((Reservation)o).getResvType());
			pstmt.setInt(4, ((Reservation)o).getResvKey());
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
		String sql ="select * from Reservations";
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
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
	
	public  List<Object> getResvByResvKey(int resvtype){
		String sql = "select * from Reservations where resvType=?";
		
		List<Object> list = new ArrayList<Object>();
		try{
			conn=dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, resvtype);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reservation r = new Reservation();
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

}
