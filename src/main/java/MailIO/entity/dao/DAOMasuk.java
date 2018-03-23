package MailIO.entity.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import MailIO.entity.Masuk;
import MailIO.util.Db;

public class DAOMasuk implements DAO<Masuk> {
	private Db d;

	public DAOMasuk(Db d) {
		super();
		this.d = d;
	}

	@Override
	public void createTable() throws SQLException {
		d.exec("create table masuk(nomor int primary key,indek text not null,kode text not null,urut text not null,"
				+ "surat text not null,terima date not null,isi text not null,dari text not null,tgl date not null,"
				+ "lamp text not null,peng text not null,terus date,catat text not null)");
	}

	@Override
	public void insert(Masuk v) throws SQLException {
		java.sql.PreparedStatement p=d.prep("insert into masuk values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		p.setInt(1, v.getNo());
		p.setString(2, v.getIndex());
		p.setString(3, v.getKode());
		p.setString(4, v.getUrut());
		p.setString(5, v.getSurat());
		p.setDate(6, v.getTerima());
		p.setString(7, v.getIsi());
		p.setString(8, v.getDari());
		p.setDate(9, v.getTgl());
		p.setString(10, v.getLamp());
		p.setString(11, v.getPeng());
		p.setDate(12, v.getTerus());
		p.setString(13, v.getCatat());
		p.execute();
		p.close();
	}

	@Override
	public void delete(Masuk w) throws SQLException {
		java.sql.PreparedStatement p=d.prep("delete from masuk where nomor=?");
		p.setInt(1, w.getNo());
		p.execute();
		p.close();
	}

	@Override
	public void update(Masuk a, Masuk b) throws SQLException {
		java.sql.PreparedStatement p=d.prep("update masuk set nomor=?,indek=?,kode=?,urut=?,surat=?,terima=?,isi=?,dari=?,tgl=?,"
				+ "lamp=?,peng=?,terus=?,catat=? where nomor=?");
		p.setInt(1, b.getNo());
		p.setString(2, b.getIndex());
		p.setString(3, b.getKode());
		p.setString(4, b.getUrut());
		p.setString(5, b.getSurat());
		p.setDate(6, b.getTerima());
		p.setString(7, b.getIsi());
		p.setString(8, b.getDari());
		p.setDate(9, b.getTgl());
		p.setString(10, b.getLamp());
		p.setString(11, b.getPeng());
		p.setDate(12, b.getTerus());
		p.setString(13, b.getCatat());
		p.setInt(14, a.getNo());
		p.execute();
		p.close();
	}

	@Override
	public List<Masuk> all() throws SQLException {
		List<Masuk>l=new java.util.LinkedList<>();
		java.sql.ResultSet r=d.getData("select nomor from masuk");
		while(r.next()) {
			l.add(new Masuk(r.getInt("nomor"),d));
		}r.close();
		return l;
	}

	@Override
	public List<Masuk> cari(Map<String, String> m) throws SQLException {
		List<Masuk>l=new java.util.LinkedList<>();
		if(!m.isEmpty()) {
			String[]key=(String[]) m.keySet().toArray();
			String sql="select nomor from masuk where ";
			for(int x=0;x<key.length;x++) {
				sql+=sql+key[x]+" like ? ";
				if(x<key.length-1)sql+="and ";
			}java.sql.PreparedStatement p=d.prep(sql);
			for(int x=0;x<key.length;x++) p.setString(x+1, "%"+m.get(key[x])+"%");
			java.sql.ResultSet r=p.executeQuery();
			while(r.next())l.add(new Masuk(r.getInt("nomor"), d));
			r.close();
			p.close();
		}else l=all();
		return l;
	}

}
