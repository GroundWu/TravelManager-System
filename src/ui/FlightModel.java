package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import POJO.*;

public class FlightModel extends AbstractTableModel{
	private List<Object> flight;
	public FlightModel(){
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return flight.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0:
			return ((Flight)this.flight.get(rowIndex)).getFilghtNum();
		case 1:
			return ((Flight)this.flight.get(rowIndex)).getPrice();
		case 2:
			return ((Flight)this.flight.get(rowIndex)).getNumSeats();
		case 3:
			return ((Flight)this.flight.get(rowIndex)).getNumAvail();
		case 4:
			return ((Flight)this.flight.get(rowIndex)).getFromCity();
		case 5:
			return ((Flight)this.flight.get(rowIndex)).getAvrivCity();
		default:
			return "";

		}
		
	}
	public String getColumnName(int column) {  
        switch (column) {  
        case 0:  
            return "航班号";  
        case 1:  
            return "价格";  
        case 2:  
            return "座位数";  
        case 3:  
            return "空位数";  
        case 4:
        	return "始发地";
        case 5:
        	return "目的地";
        default:
        	return ""; 
        }  
    }
	public List<Object> getFlight() {
		return flight;
	}
	public void setFlight(List<Object> flight) {
		this.flight = flight;
	}  
	
}
