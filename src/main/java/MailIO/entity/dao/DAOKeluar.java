package MailIO.entity.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import MailIO.entity.Keluar;
import MailIO.entity.Masuk;
import MailIO.util.Db;

public class DAOKeluar implements DAO<Keluar> {
	private Db d;

	public DAOKeluar(Db d) {
		super();
		this.d = d;
	}

	@Override
	public void createTable() throws SQLException {
		d.exec("create table keluar(nomor int primary key,indek text not null,kode text not null,urut text not null,"
				+ "isi text not null,kpd text not null,peng text not null,tgl date not null,lamp text not null,"
				+ "catat text not null)");
	}

	@Override
	public void insert(Keluar v) throws SQLException {
		java.sql.PreparedStatement p=d.prep("insert into keluar values(?,?,?,?,?,?,?,?,?,?)");
		p.setInt(1, v.getNo());
		p.setString(2, v.getIndex());
		p.setString(3, v.getKode());
		p.setString(4, v.getUrut());
		p.setString(5, v.getIsi());
		p.setString(6, v.getKpd());
		p.setString(7, v.getPeng());
		p.setDate(8, v.getTgl());
		p.setString(9, v.getLamp());
		p.setString(10, v.getCatat());
		p.execute();
		p.close();
	}

	@Override
	public void delete(Keluar w) throws SQLException {
		java.sql.PreparedStatement p=d.prep("delete from keluar where nomor=?");
		p.setInt(1, w.getNo());
		p.execute();
		p.close();
	}

	@Override
	public void update(Keluar a, Keluar b) throws SQLException {
		java.sql.PreparedStatement p=d.prep("update keluar set nomor=?,indek=?,kode=?,urut=?,isi=?,kpd=?,peng=?,tgl=?,"
				+ "lamp=?,catat=? where nomor=?");
		p.setInt(1, b.getNo());
		p.setString(2, b.getIndex());
		p.setString(3, b.getKode());
		p.setString(4, b.getUrut());
		p.setString(5, b.getIsi());
		p.setString(6, b.getKpd());
		p.setString(7, b.getPeng());
		p.setDate(8, b.getTgl());
		p.setString(9, b.getLamp());
		p.setString(10, b.getCatat());
		p.setInt(11, a.getNo());
		p.execute();
		p.close();
	}

	@Override
	public List<Keluar> all() throws SQLException {
		List<Keluar>l=new java.util.LinkedList<>();
		java.sql.ResultSet r=d.getData("select nomor from keluar");
		while(r.next())l.add(new Keluar(r.getInt("no"),d));
		r.close();
		return l;
	}

	@Override
	public List<Keluar> cari(Map<String, String> m) throws SQLException {
		List<Keluar>l=new java.util.LinkedList<>();
		if(!m.isEmpty()) {
			String[]key=(String[]) m.keySet().toArray();
			String sql="select nomor from keluar where ";
			for(int x=0;x<key.length;x++) {
				sql+=sql+key[x]+" like ? ";
				if(x<key.length-1)sql+="and ";
			}java.sql.PreparedStatement p=d.prep(sql);
			for(int x=0;x<key.length;x++) p.setString(x+1, "%"+m.get(key[x])+"%");
			java.sql.ResultSet r=p.executeQuery();
			while(r.next())l.add(new Keluar(r.getInt("nomor"), d));
			r.close();
			p.close();
		}else l=all();
		return l;
	}

}
