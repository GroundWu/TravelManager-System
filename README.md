# TravelManager-
使用java swing以及与SQL（ORACLE）的接口编写一个简单的旅行预订系统。该系统涉及的信息有航班，出租车，宾馆房间和客户的数据信息。他们的关系模式如下：
FLIGHTS (String flightNum, int price, int numSeats, int numAvail, String FromCity, String ArivCity)；
HOTELS(String location, int price, int numRooms, int numAvail)；
CARS(String location, int price, int numCars, int numAvail)；
CUSTOMERS(String custName)；
RESERVATIONS(String custName, int resvType, String resvKey) 
为简单起见，我们作下列假设：
1.在给定的一个班机上，所有的座位价格都一样；flightNum是表FLIGHTS的主键（primary key）。
2.在同一个地方的所有的宾馆房间价格也一样；location是表HOTELS的一个主键。
3.在同一个地方的所有出租车价格一样；location是表 CARS的一个主键。
4.custName是表CUSTOMERS的一个主键。
5.表RESERVATIONS包含着那些和客户预订的航班、出租车或宾馆房间相应的条目，具体的说，resvType指出预订的类型（1为预订航班，2为预订宾馆房间，3为预订出租车），而resvKey是表RESERVATIONS的一个主键。
6.在表FLIGHTS中，numAvail表示指定航班上的还可以被预订的座位数。对于一个给定的航班（flightNum）,数据库一致性的条件之一是，表RESERVATIONS中所有预订该航班的条目数加上该航班的剩余座位数必须等于该航班上总的座位数。这个条件对于表CARS和表HOTELS同样适用。

该应用系统完成如下基本功能：
1．航班，出租车，宾馆房间和客户基础数据的入库，更新（表中的属性也可以根据你的需要添加）。
2．预定航班，出租车，宾馆房间。
3．查询航班，出租车，宾馆房间，客户和预订信息。
4．查询某个客户的旅行线路。
5．检查预定线路的完整性。
