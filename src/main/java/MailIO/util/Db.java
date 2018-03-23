package MailIO.util;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Db {
	private java.sql.Connection con;
	private java.sql.Statement s;

	public Db(Conf c) throws SQLException {
		super();
		try {
			com.mysql.jdbc.Driver.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			Db.hindar(e);
		}con=java.sql.DriverManager.getConnection("jdbc:mysql://"+c.getHost()+":"+c.getPort()+"/"+c.getName(), 
				c.getUser(), c.getPass());
		s=con.createStatement();
	}

	public static void hindar(Exception e) {
		java.sql.Timestamp d=java.sql.Timestamp.valueOf(LocalDateTime.now());
		java.io.File f=new java.io.File(System.getProperty("user.home")+"/.MailIO/error/"+d.getDate()+"a"+d.getMonth()+"a"+
		d.getYear()+"b"+d.getHours()+"a"+d.getMinutes()+"a"+d.getSeconds()+"a"+d.getNanos()+".log");
		if(!f.getParentFile().exists())f.getParentFile().mkdirs();
		if(f.exists())f.delete();
		try {
			java.io.PrintWriter o=new java.io.PrintWriter(f);
			e.printStackTrace(o);
			o.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void exec(String sql) throws SQLException {
		s.executeUpdate(sql);
	}

	public java.sql.ResultSet getData(String sql) throws SQLException{
		return s.executeQuery(sql);
	}

	public java.sql.PreparedStatement prep(String sql) throws SQLException{
		return con.prepareStatement(sql);
	}

	public void close() throws SQLException {
		s.close();
		con.close();
	}
}