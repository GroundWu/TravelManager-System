package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import POJO.Hotel;
import POJO.Reservation;

public class ReservationModel extends AbstractTableModel{
	private List<Object> list;
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0:
			return ((Reservation)this.list.get(rowIndex)).getCustName();
		case 1:
			int type=((Reservation)this.list.get(rowIndex)).getResvType();
			if(type==1) return "航班";
			if(type==2) return "酒店";
			if(type==3) return "出租车";
		case 2:
			int type_1=((Reservation)this.list.get(rowIndex)).getResvType();
			if(type_1==1) return "航班号："+((Reservation)this.list.get(rowIndex)).getDetail();
			if(type_1==2) return "酒店地点："+((Reservation)this.list.get(rowIndex)).getDetail();
			if(type_1==3) return "出租车地点："+((Reservation)this.list.get(rowIndex)).getDetail();
		default:
			return "";
		}
	}
	public String getColumnName(int column) {  
        switch (column) {  
        case 0:  
            return "客户";  
        case 1:  
            return "类型";  
        case 2:  
            return "描述";  
        default:
        	return ""; 
        }  
    }
}
