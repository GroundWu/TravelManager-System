package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import POJO.*;

public class CarModel  extends AbstractTableModel{
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
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0:
			return ((Car)this.list.get(rowIndex)).getLocation();
		case 1:
			return ((Car)this.list.get(rowIndex)).getPrice();
		case 2:
			return ((Car)this.list.get(rowIndex)).getNumCars();
		case 3:
			return((Car)this.list.get(rowIndex)).getNumAvail();
		default:
			return "";
		}
	}
	public String getColumnName(int column) {  
        switch (column) {  
        case 0:  
            return "地点";  
        case 1:  
            return "价格";  
        case 2:  
            return "出租车数";  
        case 3:
        	return "空闲车数";
        default:
        	return ""; 
        }  
    }
}
