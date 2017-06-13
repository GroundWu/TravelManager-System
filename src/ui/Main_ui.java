package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import Dao.CarsDao;
import Dao.CustomersDao;
import Dao.FlightDao;
import Dao.HotelsDao;
import Dao.ReservationDao;
import POJO.Car;
import POJO.Customer;
import POJO.Flight;
import POJO.Hotel;
import Service.*;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main_ui {

	private JFrame frame;
	private JTable table;
	int type;
	List<Object> list = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_ui window = new Main_ui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(10, 10));
		
		JPanel panelleft = new JPanel();
		frame.getContentPane().add(panelleft, BorderLayout.WEST);
		panelleft.setLayout(new BoxLayout(panelleft, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelleft.add(verticalStrut_1);
		
		JButton addbtn = new JButton("add");
		addbtn.setMaximumSize(new Dimension(80,40));
		panelleft.add(addbtn);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelleft.add(verticalStrut);
		
		JButton updatebtn = new JButton("update");
		updatebtn.setMaximumSize(new Dimension(80,40));
		panelleft.add(updatebtn);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelleft.add(verticalStrut_2);
		
		JButton bookbtn = new JButton("book");
		bookbtn.setMaximumSize(new Dimension(80,40));
		panelleft.add(bookbtn);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panelleft.add(verticalStrut_3);
		
		JButton findbtn = new JButton("find");
		findbtn.setMaximumSize(new Dimension(80,40));
		panelleft.add(findbtn);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panelleft.add(verticalStrut_4);
		
		JButton routebtn = new JButton("route");
		routebtn.setMaximumSize(new Dimension(80,40));
		panelleft.add(routebtn);
		
		
		
		JPanel panel_right = new JPanel();
		CardLayout card = new CardLayout();
		frame.getContentPane().add(panel_right, BorderLayout.CENTER);
		panel_right.setLayout(card);
		
		JPanel padd=new JPanel();
		JPanel pupdate =new JPanel();
		JPanel pbook =new JPanel();
		JPanel pfind =new JPanel();
		JPanel proute =new JPanel();
		padd.setLayout(new BoxLayout(padd, BoxLayout.Y_AXIS));
		pupdate.setLayout(new BoxLayout(pupdate, BoxLayout.Y_AXIS));
		
		JPanel padd_flight = new JPanel();
		padd_flight.setAlignmentX(Component.RIGHT_ALIGNMENT);
		padd_flight.setBorder(BorderFactory.createTitledBorder("添加航班"));
		padd.add(padd_flight);
		padd_flight.setLayout(new GridLayout(7, 2, 20, 5));
		
		padd_flight.add(new JLabel("航班号"));
		JTextField f_Num = new JTextField();
		padd_flight.add(f_Num);
		JTextField f_Price = new JTextField();
		padd_flight.add(new JLabel("价格"));
		padd_flight.add(f_Price);
		padd_flight.add(new JLabel("座位数"));
		JTextField f_NumSeats = new JTextField();
		padd_flight.add(f_NumSeats);
		padd_flight.add(new JLabel("剩余座位数"));
		JTextField f_NumAvail = new JTextField();
		padd_flight.add(f_NumAvail);
		padd_flight.add(new JLabel("始发地"));
		JTextField f_FromCity = new JTextField();
		padd_flight.add(f_FromCity);		
		padd_flight.add(new JLabel("目的地"));	
		JTextField f_ArrivCity = new JTextField();
		padd_flight.add(f_ArrivCity);
		JButton add_flight_btn =new JButton("添加");
		
		//添加航班触发事件
		add_flight_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flightNum=f_Num.getText();
				String flightPrice =f_Price.getText();
				String flightNumSeats=f_NumSeats.getText();
				String flightNumAvail=f_NumAvail.getText();
				String flightFromCity=f_FromCity.getText();
				String flightArrivCity=f_ArrivCity.getText();
				
				if("".equals(flightNum)||"".equals(flightPrice)||"".equals( flightNumSeats)
						||"".equals(flightNumAvail)||"".equals(flightFromCity)||"".equals(flightArrivCity)){
					JOptionPane.showConfirmDialog(panel_right, "必填项不能为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				int numseats= Integer.valueOf(flightNumSeats);
				int numavail= Integer.valueOf(flightNumAvail);
				if(numseats<numavail){
					JOptionPane.showConfirmDialog(panel_right, "总座位数不能小于空余座位数！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				Flight ft = new FlightDao().getFromFlightNum(flightNum);
				if(ft.getFilghtNum()!=null){
					JOptionPane.showConfirmDialog(panel_right, "该航班已存在","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
					
				Flight f =new Flight(flightNum,Integer.valueOf(flightPrice),numseats,
						numavail,flightFromCity,flightArrivCity);
				ImportOrUpdateService.ImportFlight(f);
				JOptionPane.showConfirmDialog(panel_right, "添加成功！","Info", JOptionPane.CLOSED_OPTION);
				f_Num.setText("");
				f_Price.setText("");
				f_NumSeats.setText("");
				f_NumAvail.setText("");;
				f_FromCity.setText("");
				f_ArrivCity.setText("");
			}
		});
		padd_flight.add(add_flight_btn);
		
		
		JPanel padd_room = new JPanel();
		padd_room.setAlignmentX(Component.RIGHT_ALIGNMENT);
		padd_room.setBorder(BorderFactory.createTitledBorder("添加客房"));
		padd_room.setLayout(new GridLayout(5, 2, 20, 5));
		padd_room.add(new JLabel("位置"));
		JTextField loc_text = new JTextField();
		padd_room.add(loc_text);
		padd_room.add(new JLabel("价格"));
		JTextField price_text = new JTextField();
		padd_room.add(price_text);
		padd_room.add(new JLabel("房间数"));
		JTextField roomnum_text = new JTextField();
		padd_room.add(roomnum_text);
		padd_room.add(new JLabel("剩余房间数"));
		JTextField roomavail_text = new JTextField();
		padd_room.add(roomavail_text);
		JButton add_room_btn =new JButton("添加");
		padd_room.add(add_room_btn);
		
		//添加客房触发事件
				add_room_btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String room_loc = loc_text.getText();
						String room_price=price_text.getText();
						String room_num=roomnum_text.getText();
						String room_avail=roomavail_text.getText();
						if("".equals(room_loc)||"".equals(room_price)||"".equals(room_num)||"".equals(room_avail)){
							JOptionPane.showConfirmDialog(panel_right, "必填项不能为空！","warnings", JOptionPane.CLOSED_OPTION);
							return;
						}
						int numrooms= Integer.valueOf(room_num);
						int numavail= Integer.valueOf(room_avail);
						if(numrooms<numavail){
							JOptionPane.showConfirmDialog(panel_right, "总房间数数不能小于空余房间数！","warnings", JOptionPane.CLOSED_OPTION);
							return;
						}
						
						Hotel h = new HotelsDao().getHotelByLocation(room_loc);
						if(h.getLocation()!=null){
							JOptionPane.showConfirmDialog(panel_right, "该酒店已存在！","warnings", JOptionPane.CLOSED_OPTION);
							return;
						}
						ImportOrUpdateService.ImportHotel(new Hotel(room_loc,Integer.valueOf(room_price),numrooms,numavail));
						JOptionPane.showConfirmDialog(panel_right, "添加成功！","Info", JOptionPane.CLOSED_OPTION);
						loc_text.setText("");
						price_text.setText("");;
						roomnum_text.setText("");;
						roomavail_text.setText("");
					}
				});
				
		padd.add(padd_room);
		
		JPanel padd_car = new JPanel();
		padd_car.setBorder(BorderFactory.createTitledBorder("添加出租车"));
		padd_car.setAlignmentX(Component.RIGHT_ALIGNMENT);
		padd_car.setLayout(new GridLayout(5, 2, 20, 5));
		padd_car.add(new JLabel("位置"));
		JTextField car_loc_text = new JTextField();
		padd_car.add(car_loc_text);
		padd_car.add(new JLabel("价格"));
		JTextField car_price_text = new JTextField();
		padd_car.add(car_price_text);
		padd_car.add(new JLabel("车辆数"));
		JTextField car_num_text = new JTextField();
		padd_car.add(car_num_text);
		padd_car.add(new JLabel("空车数"));
		JTextField car_avail_text = new JTextField();
		padd_car.add(car_avail_text);
		JButton add_car_btn =new JButton("添加");
		padd_car.add(add_car_btn);
		//添加出粗车事件
		add_car_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_loc = car_loc_text.getText();
				String car_price=car_price_text.getText();
				String car_num=car_num_text.getText();
				String car_avail=car_avail_text.getText();
				if("".equals(car_loc)||"".equals(car_price)||"".equals(car_num)||"".equals(car_avail)){
					JOptionPane.showConfirmDialog(panel_right, "必填项不能为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				int numcars =Integer.valueOf(car_num);
				int numavail=Integer.valueOf(car_avail);
				if(numcars<numavail){
					JOptionPane.showConfirmDialog(panel_right, "总车辆数不能小于空闲车辆数！","warnings", JOptionPane.CLOSED_OPTION);
					return ;
				}
				
				Car c =new CarsDao().getCarBylocation(car_loc);
				if(c.getLocation()!=null){
					JOptionPane.showConfirmDialog(panel_right, "该出租车已存在！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				ImportOrUpdateService.ImportCar(new Car(car_loc,Integer.valueOf(car_price),numcars,numavail));
				JOptionPane.showConfirmDialog(panel_right, "添加成功！","Info", JOptionPane.CLOSED_OPTION);
				
				car_loc_text.setText("");
				car_price_text.setText("");
				car_num_text.setText("");
				car_avail_text.setText("");
			}
		});
		
		padd.add(padd_car);
		
		JPanel padd_cust = new JPanel();
		padd_cust.setBorder(BorderFactory.createTitledBorder("添加客户"));
		padd_cust.setAlignmentX(Component.RIGHT_ALIGNMENT);
		padd_cust.setLayout(new GridLayout(2, 2, 20, 5));
		padd_cust.add(new JLabel("姓名"));
		JTextField custname_text = new JTextField();
		padd_cust.add(custname_text);
		JButton add_cust_btn =new JButton("添加");
		padd_cust.add(add_cust_btn);
		
		add_cust_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String custname= custname_text.getText();
				if("".equals(custname)){
					JOptionPane.showConfirmDialog(panel_right, "必填项不能为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				Customer c=new Customer(custname);
				boolean result =new CustomersDao().getCustomer(c);
				if(result){
					JOptionPane.showConfirmDialog(panel_right, "该客户已存在！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				ImportOrUpdateService.ImportCustomer(c);
				JOptionPane.showConfirmDialog(panel_right, "添加成功！","Info", JOptionPane.CLOSED_OPTION);
				custname_text.setText("");
			}
		});
		padd.add(padd_cust);
		
		
		JPanel pupdate_flight = new JPanel();
		pupdate_flight.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pupdate_flight.setBorder(BorderFactory.createTitledBorder("更新航班"));
		pupdate.add(pupdate_flight);
		pupdate_flight.setLayout(new GridLayout(7, 2, 20, 5));
		
		pupdate_flight.add(new JLabel("航班号"));
		JTextField u_f_Num = new JTextField();
		pupdate_flight.add(u_f_Num);
		JTextField u_f_Price = new JTextField();
		pupdate_flight.add(new JLabel("价格"));
		pupdate_flight.add(u_f_Price);
		pupdate_flight.add(new JLabel("座位数"));
		JTextField u_f_NumSeats = new JTextField();
		pupdate_flight.add(u_f_NumSeats);
		pupdate_flight.add(new JLabel("剩余座位数"));
		JTextField u_f_NumAvail = new JTextField();
		pupdate_flight.add(u_f_NumAvail);
		pupdate_flight.add(new JLabel("始发地"));
		JTextField u_f_FromCity = new JTextField();
		pupdate_flight.add(u_f_FromCity);		
		pupdate_flight.add(new JLabel("目的地"));	
		JTextField u_f_ArrivCity = new JTextField();
		pupdate_flight.add(u_f_ArrivCity);
		JButton update_flight_btn =new JButton("查询");
		pupdate_flight.add(update_flight_btn);
		
		u_f_Price.setEnabled(false);
		u_f_NumSeats.setEnabled(false);
		u_f_NumAvail.setEnabled(false);
		u_f_FromCity.setEnabled(false);
		u_f_ArrivCity.setEnabled(false);
		
		JButton button = new JButton("更新");
		button.setEnabled(false);
		pupdate_flight.add(button);
		
		update_flight_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flight_num =u_f_Num.getText();
				if("".equals(flight_num)){
					JOptionPane.showConfirmDialog(panel_right, "航班号为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				FlightDao fd =new FlightDao();
				Flight f=fd.getFromFlightNum(flight_num);
				if(f.getFilghtNum()==null){
					JOptionPane.showConfirmDialog(panel_right, "无此航班！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				u_f_Num.setText(f.getFilghtNum());
				u_f_Num.setEditable(false);
				u_f_Price.setEnabled(true);
				u_f_NumSeats.setEnabled(true);
				u_f_NumAvail.setEnabled(true);
				u_f_FromCity.setEnabled(true);
				u_f_ArrivCity.setEnabled(true);
				
				u_f_Price.setText(String.valueOf(f.getPrice()));
				u_f_NumSeats.setText(String.valueOf(f.getNumSeats()));
				u_f_NumAvail.setText(String.valueOf(f.getNumAvail()));
				u_f_FromCity.setText(f.getFromCity());
				u_f_ArrivCity.setText(f.getAvrivCity());
				button.setEnabled(true);
				
			}
		});
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String u_price = u_f_Price.getText();
				String u_NumSeats = u_f_NumSeats.getText();
				String u_NumAvail = u_f_NumAvail.getText();
				String u_FromCity = u_f_FromCity.getText();
				String u_ArrivCity = u_f_ArrivCity.getText();
				FlightDao fd =new FlightDao();
				Flight f=fd.getFromFlightNum(u_f_Num.getText());
				if(!"".equals(u_price))
					f.setPrice(Integer.valueOf(u_price));
				if(!"".equals(u_NumSeats))
					f.setNumSeats(Integer.valueOf(u_NumSeats));
				if(!"".equals(u_NumAvail))
					f.setNumAvail(Integer.valueOf(u_NumAvail));
				if(f.getNumAvail()>f.getNumSeats()){
					JOptionPane.showConfirmDialog(panel_right, "航班总座位数不得小于空余座位数！","Info", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(!"".equals(u_FromCity))
					f.setFromCity(u_FromCity);
				if(!"".equals(u_ArrivCity))
					f.setAvrivCity(u_ArrivCity);
				fd.update(f);
				JOptionPane.showConfirmDialog(panel_right, "更新成功！","Info", JOptionPane.CLOSED_OPTION);
				u_f_Num.setEditable(true);
				u_f_Num.setText("");
				u_f_Price.setEnabled(false);
				u_f_Price.setText("");
				u_f_NumSeats.setEnabled(false);
				u_f_NumSeats.setText("");
				u_f_NumAvail.setEnabled(false);
				u_f_NumAvail.setText("");
				u_f_FromCity.setEnabled(false);
				u_f_FromCity.setText("");
				u_f_ArrivCity.setEnabled(false);
				u_f_ArrivCity.setText("");
				button.setEnabled(false);
			}
			
		});
		
		
	
		
		
		JPanel pupdate_room = new JPanel();
		pupdate_room.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pupdate_room.setBorder(BorderFactory.createTitledBorder("更新客房"));
		pupdate_room.setLayout(new GridLayout(5, 2, 20, 5));
		pupdate_room.add(new JLabel("位置"));
		JTextField u_room_loc_text = new JTextField();
		pupdate_room.add(u_room_loc_text);
		pupdate_room.add(new JLabel("价格"));
		JTextField u_room_price_text = new JTextField();
		pupdate_room.add(u_room_price_text);
		pupdate_room.add(new JLabel("房间数"));
		JTextField u_room_num_text = new JTextField();
		pupdate_room.add(u_room_num_text);
		pupdate_room.add(new JLabel("剩余房间数"));
		JTextField u_room_avail_text = new JTextField();
		pupdate_room.add(u_room_avail_text);
		JButton update_room_btn =new JButton("查询");
		pupdate_room.add(update_room_btn);
		
		JButton button_1 = new JButton("更新");
		button_1.setEnabled(false);
		pupdate_room.add(button_1);
		pupdate.add(pupdate_room);
		
		u_room_price_text.setEnabled(false);	
		u_room_num_text.setEnabled(false);	
		u_room_avail_text.setEnabled(false);
		
		update_room_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String room_loc =u_room_loc_text.getText();
				if("".equals(room_loc)){
					JOptionPane.showConfirmDialog(panel_right, "地点为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				HotelsDao hd = new HotelsDao();
				Hotel h =hd.getHotelByLocation(room_loc);
				if(h.getLocation()==null){
					JOptionPane.showConfirmDialog(panel_right, "无此宾馆！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				u_room_loc_text.setText(h.getLocation());
				u_room_loc_text.setEditable(false);
				u_room_price_text.setEnabled(true);	
				u_room_num_text.setEnabled(true);	
				u_room_avail_text.setEnabled(true);
				
				u_room_price_text.setText(String.valueOf(h.getPrice()));;	
				u_room_num_text.setText(String.valueOf(h.getNumRooms()));
				u_room_avail_text.setText(String.valueOf(h.getNumAvail()));
				
				button_1.setEnabled(true);
			}
		});
		
		button_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String u_price = u_room_price_text.getText();
				String u_NumRoom = u_room_num_text.getText();
				String u_NumAvail = u_room_avail_text.getText();
				
				HotelsDao hd =new HotelsDao();
				Hotel h =hd.getHotelByLocation(u_room_loc_text.getText());
				if(!"".equals(u_price))
					h.setPrice(Integer.valueOf(u_price));
				if(!"".equals(u_NumRoom))
					h.setNumRooms(Integer.valueOf(u_NumRoom));
				if(!"".equals(u_NumAvail))
					h.setNumAvail(Integer.valueOf(u_NumAvail));
				if(h.getNumAvail()>h.getNumRooms()){
					JOptionPane.showConfirmDialog(panel_right, "酒店总客房数不得小于空闲客房数！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				hd.update(h);
				JOptionPane.showConfirmDialog(panel_right, "更新成功！","Info", JOptionPane.CLOSED_OPTION);
				u_room_loc_text.setEditable(true);
				u_room_loc_text.setText("");
				u_room_price_text.setText("");;	
				u_room_price_text.setEnabled(false);	
				u_room_num_text.setText("");
				u_room_num_text.setEnabled(false);
				u_room_avail_text.setText("");
				u_room_avail_text.setEnabled(false);
				button_1.setEnabled(false);
			}
		});
		
		
		JPanel pupdate_car = new JPanel();
		pupdate_car.setBorder(BorderFactory.createTitledBorder("添加出租车"));
		pupdate_car.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pupdate_car.setLayout(new GridLayout(5, 2, 20, 5));
		pupdate_car.add(new JLabel("位置"));
		JTextField u_car_loc_text = new JTextField();
		pupdate_car.add(u_car_loc_text);
		pupdate_car.add(new JLabel("价格"));
		JTextField u_car_price_text = new JTextField();
		pupdate_car.add(u_car_price_text);
		pupdate_car.add(new JLabel("车辆数"));
		JTextField u_car_num_text = new JTextField();
		pupdate_car.add(u_car_num_text);
		pupdate_car.add(new JLabel("空车数"));
		JTextField u_car_avail_text = new JTextField();
		pupdate_car.add(u_car_avail_text);
		JButton u_add_car_btn =new JButton("查询");
		pupdate_car.add(u_add_car_btn);
		JButton button_2 = new JButton("更新");
		button_2.setEnabled(false);
		pupdate_car.add(button_2);
		pupdate.add(pupdate_car);
		
		u_car_price_text.setEnabled(false);
		u_car_num_text.setEnabled(false);		
		u_car_avail_text.setEnabled(false);
	
		u_add_car_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_loc =u_car_loc_text.getText();
				if("".equals(car_loc)){
					JOptionPane.showConfirmDialog(panel_right, "地点为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				CarsDao cd =new CarsDao();
				Car c =cd.getCarBylocation(car_loc);
				if(c.getLocation()==null){
					JOptionPane.showConfirmDialog(panel_right, "无此出租车！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				u_car_loc_text.setText(c.getLocation());
				u_car_loc_text.setEditable(false);
				u_car_price_text.setEnabled(true);	
				u_car_num_text.setEnabled(true);	
				u_car_avail_text.setEnabled(true);
				
				u_car_price_text.setText(String.valueOf(c.getPrice()));;	
				u_car_num_text.setText(String.valueOf(c.getNumCars()));
				u_car_avail_text.setText(String.valueOf(c.getNumAvail()));
				
				button_2.setEnabled(true);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u_price = u_car_price_text.getText();
				String u_NumCar = u_car_num_text.getText();
				String u_NumAvail = u_car_avail_text.getText();
				
				CarsDao cd =new CarsDao();
				Car c =cd.getCarBylocation(u_car_loc_text.getText());
				if(!"".equals(u_price))
					c.setPrice(Integer.valueOf(u_price));
				if(!"".equals(u_NumCar))
					c.setNumCars(Integer.valueOf(u_NumCar));
				if(!"".equals(u_NumAvail))
					c.setNumAvail(Integer.valueOf(u_NumAvail));
				if(c.getNumAvail()<c.getNumCars()){
					JOptionPane.showConfirmDialog(panel_right, "出租车总数不得小于空闲数！","warnings", JOptionPane.CLOSED_OPTION);

				}
				cd.update(c);
				JOptionPane.showConfirmDialog(panel_right, "更新成功！","Info", JOptionPane.CLOSED_OPTION);
				u_car_loc_text.setEditable(true);
				u_car_loc_text.setText("");
				u_car_price_text.setText("");;	
				u_car_price_text.setEnabled(false);	
				u_car_num_text.setText("");
				u_car_num_text.setEnabled(false);
				u_car_avail_text.setText("");
				u_car_avail_text.setEnabled(false);
				button_2.setEnabled(false);
			}
		});
		
	
		
		
		pbook.setLayout(new BorderLayout(0, 0));
		JPanel btngroup = new JPanel();
		pbook.add(btngroup, BorderLayout.NORTH);
		JButton book_flight = new JButton("航班");
		btngroup.add(book_flight);
		JButton book_room = new JButton("客房");
		btngroup.add(book_room);
		JButton book_car = new JButton("出租车");
		btngroup.add(book_car);
		JLabel lblNewLabel = new JLabel("客户名称");
		btngroup.add(lblNewLabel);
		JTextField textField_1 = new JTextField();
		btngroup.add(textField_1);
		textField_1.setColumns(10);
		
		table = new JTable();
		table.setRowHeight(30);
		javax.swing.JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		pbook.add(scrollPane, BorderLayout.CENTER);
		book_flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list =CheckService.getAllFlight();
				FlightModel f = new FlightModel();
				f.setFlight(list);
				table.setModel(f);
				type=1;
			}
		});
		
		book_room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = CheckService.getAllHotels();
				HotelsModel hm = new HotelsModel();
				hm.setList(list);
				table.setModel(hm);
				type=2;
			}
		});
		
		book_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = CheckService.getAllCars();
				CarModel cm =new CarModel();
				cm.setList(list);
				table.setModel(cm);
				type=3;
			}
		});
		  
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent evt) {  
				 //判断是否为鼠标的BUTTON3按钮，BUTTON3为鼠标右键  
			       if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {  
			           //通过点击位置找到点击为表格中的行  
			           int focusedRowIndex = table.rowAtPoint(evt.getPoint());  
			           if (focusedRowIndex == -1) {  
			               return;  
			           }  
			           System.out.println(focusedRowIndex);
			           //将表格所选项设为当前右键点击的行  
			           table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);  
			           
			           JPopupMenu popMenu = new JPopupMenu() ;
			           JMenuItem bookitem = new JMenuItem("预定");
			           popMenu.add(bookitem);
			           bookitem.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String custname = textField_1.getText();
							if("".equals(custname)){
								JOptionPane.showConfirmDialog(panel_right, "客户名称不能为空！","warnings", JOptionPane.CLOSED_OPTION);
								return;
							}
								switch(type){
								case 1:
									boolean result_f=BookService.bookFlight(new Customer(custname), ((Flight)list.get(focusedRowIndex)).getFilghtNum());
									if(!result_f){
										JOptionPane.showConfirmDialog(panel_right, "预定失败（航班座位已满或不存在）！","warnings", JOptionPane.CLOSED_OPTION);
										return;
									}
									break;
								case 2:
									boolean result_r =BookService.bookRooms(new Customer(custname), ((Hotel)list.get(focusedRowIndex)).getLocation());
									if(!result_r){
										JOptionPane.showConfirmDialog(panel_right, "预定失败（酒店房间已满或不存在）！","warnings", JOptionPane.CLOSED_OPTION);
										return;
									}
									break;
								case 3:
									boolean result_c=BookService.bookCar(new Customer(custname), ((Car)list.get(focusedRowIndex)).getLocation());
									if(!result_c){
										JOptionPane.showConfirmDialog(panel_right, "预定失败（出租车已满或不存在）！","warnings", JOptionPane.CLOSED_OPTION);
										return;
									}
									break;
								}
							JOptionPane.showConfirmDialog(panel_right, "预订成功！","Info", JOptionPane.CLOSED_OPTION);

							}
			
						});
						//弹出菜单  
			           popMenu.show(table, evt.getX(), evt.getY());  
            } 
		}
	});
		
		pfind.setLayout(new BorderLayout(0, 0));
		JPanel find_btngroup = new JPanel();
		pfind.add(find_btngroup, BorderLayout.NORTH);
		JCheckBox chckbx_flight = new JCheckBox("航班");
		find_btngroup.add(chckbx_flight);
		JCheckBox chckbx_room = new JCheckBox("客房");
		find_btngroup.add(chckbx_room);
		JCheckBox chckbx_car = new JCheckBox("出租车");
		find_btngroup.add(chckbx_car);
		Component horizontalStrut = Box.createHorizontalStrut(20);
		find_btngroup.add(horizontalStrut);
		JLabel lblFind = new JLabel("客户名");
		find_btngroup.add(lblFind);	
		JTextField textField = new JTextField();
		find_btngroup.add(textField);
		textField.setColumns(10);
		
		JButton find = new JButton("查找");
		find_btngroup.add(find);
		JTable table_1 = new JTable();
		table_1.setRowHeight(30);
	    javax.swing.JScrollPane scrollPane_1 = new JScrollPane(table_1);
	    scrollPane_1.setAutoscrolls(true);
		pfind.add(scrollPane_1, BorderLayout.CENTER);
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Object> list = new ArrayList<Object>();
				String custname =textField.getText();
					if("".equals(custname)){
						if(chckbx_flight.isSelected()){list.addAll(CheckService.getResvByResvKey(1));}
						if(chckbx_room.isSelected()){list.addAll(CheckService.getResvByResvKey(2));}
						if(chckbx_car.isSelected()){list.addAll(CheckService.getResvByResvKey(3));}
					}else{
						Customer c =new Customer(custname);
						if(chckbx_flight.isSelected()){list.addAll(CheckService.checkResvByCust(c, 1));}
						if(chckbx_room.isSelected()){list.addAll(CheckService.checkResvByCust(c, 2));}
						if(chckbx_car.isSelected()){list.addAll(CheckService.checkResvByCust(c, 3));}
					}
					ReservationModel rm =new ReservationModel();
					rm.setList(list);
					table_1.setModel(rm);
			}
		});
		
		panel_right.add(proute,"proute");
		proute.setLayout(new BorderLayout(0, 0));
		   
		JPanel panel = new JPanel();
		proute.add(panel, BorderLayout.SOUTH);
		JLabel lblNewLabel_1 = new JLabel("客户名称");
		panel.add(lblNewLabel_1);
		JTextField textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
			   
		JTable table_2 = new JTable();
		table_2.setRowHeight(30);
	    javax.swing.JScrollPane scrollPane_2 = new JScrollPane(table_2);
	    scrollPane_2.setAutoscrolls(true);
		proute.add(scrollPane_2);
		proute.add(scrollPane_2, BorderLayout.CENTER);
		JButton check = new JButton("完整性检查");
		panel.add(check);
		check.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String custname =textField_2.getText();
				if("".equals(custname)){
					JOptionPane.showConfirmDialog(panel_right, "客户名称不能为空！","warnings", JOptionPane.CLOSED_OPTION);
					return;
				}
				List<Object> list =CheckService.getRoute(new Customer(custname));
				RouteModel rm =new RouteModel();
				rm.setList(list);
				table_2.setModel(rm);
				if(CheckService.checkroute(list)){
					JOptionPane.showConfirmDialog(panel_right, "路线完整！","warnings", JOptionPane.CLOSED_OPTION);

				}else{
					JOptionPane.showConfirmDialog(panel_right, "路线不完整！","warnings", JOptionPane.CLOSED_OPTION);

				}
				
			}
			
		});
		   
		
		panel_right.add(padd, "padd");
		panel_right.add(pupdate, "pupdate");
		panel_right.add(pbook, "pbook");
		panel_right.add(pfind, "pfind");
        panel_right.add(proute,"proute");
		
		addbtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_right,"padd" );
			}
		});
		
		updatebtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_right,"pupdate");
			}
			
		});
		
		
		bookbtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_right,"pbook");
			}
			
		});
		
		findbtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_right,"pfind");
			}
			
		});
		
		routebtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(panel_right,"proute");
			}
			
		});
	}

}

