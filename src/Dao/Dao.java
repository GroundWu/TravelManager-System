package Dao;

import java.util.List;

public interface Dao {
	//���
	public void add(Object o);
	//ɾ��
	public void delete(Object o);
	//�޸�
	public void update(Object o);
	//��ѯ����
	public List<Object> getAll();
}
