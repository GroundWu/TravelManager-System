package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Customer;
import POJO.Flight;
import POJO.Reservation;
import utils.dbUtils;

public class CustomersDao implements Dao{
	 Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs=null;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
				String sql="insert into customers value(?)";
				try{
					conn =dbUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, ((Customer) o).getCustName());
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
		String sql="delete from customers where custName=?";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Customer) o).getCustName());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
		}
	}

	public void update(Object old,Object newcust) {
		// TODO Auto-generated method stub
		//修改customer表里的custname
		delete(old);
		add(newcust);
		//修改reservations表里的custname
		String sql="update Reservations set custName=? where custName=?";
		try{
			conn =dbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ((Customer)newcust).getCustName());
			pstmt.setString(2, ((Customer)old).getCustName());
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
		String sql ="select * from Customers";
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setCustName(rs.getString(1));
				list.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
			
		}
		return list;
	}
	
	@SuppressWarnings("finally")
	public boolean getCustomer(Customer c){
		String sql = "select * from Customers where custName=?";
		String custName = c.getCustName();
		boolean result = false;
		try{
			conn =dbUtils.getConnection();;
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, custName);
			rs=pstmt.executeQuery();
			if(rs.next())
				result=true;
			else
				result=false;
		}catch(SQLException e){
			e.printStackTrace();	
		}finally{
			dbUtils.closeAll(rs, pstmt, conn);
			return result;
		}
		
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
	}

}
