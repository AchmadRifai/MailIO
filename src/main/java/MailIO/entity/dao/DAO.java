package MailIO.entity.dao;

public interface DAO<T> {
	void createTable()throws java.sql.SQLException;
	void insert(T v)throws java.sql.SQLException;
	void delete(T w)throws java.sql.SQLException;
	void update(T a,T b)throws java.sql.SQLException;
	java.util.List<T>all()throws java.sql.SQLException;
	java.util.List<T>cari(java.util.Map<String, String>m)throws java.sql.SQLException;
}