package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import POJO.Flight;
import POJO.Hotel;

public class RouteModel extends AbstractTableModel{
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
			return ((Flight)this.list.get(rowIndex)).getFilghtNum();
		case 1:
			return ((Flight)this.list.get(rowIndex)).getFromCity();
		case 2:
			return ((Flight)this.list.get(rowIndex)).getAvrivCity();
		default:
			return "";
		}
	}
	public String getColumnName(int column) {  
        switch (column) {  
        case 0:  
            return "航班号";  
        case 1:  
            return "始发地";  
        case 2:  
            return "目的地";  
        default:
        	return ""; 
        }  
    }

}
