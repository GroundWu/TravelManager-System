package Dao;

import java.util.List;

public interface Dao {
	//添加
	public void add(Object o);
	//删除
	public void delete(Object o);
	//修改
	public void update(Object o);
	//查询所有
	public List<Object> getAll();
}
