package MailIO.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import MailIO.util.Db;

public class Keluar {
	private int no;
	private String index,kode,urut,isi,kpd,peng;
	private java.sql.Date tgl;
	private String lamp,catat;

	public Keluar(int no, MailIO.util.Db d) throws SQLException {
		super();
		this.no = no;
		java.sql.PreparedStatement p=d.prep("select*from keluar where nomor=?");
		p.setInt(1, no);
		java.sql.ResultSet r=p.executeQuery();
		if(r.next())fillAll(r);
		r.close();
		p.close();
	}

	private void fillAll(ResultSet r) throws SQLException {
		index=r.getString("indek");
		kode=r.getString("kode");
		urut=r.getString("urut");
		isi=r.getString("isi");
		kpd=r.getString("kpd");
		peng=r.getString("peng");
		tgl=r.getDate("tgl");
		lamp=r.getString("lamp");
		catat=r.getString("catat");
	}

	public Keluar(String index, String kode, String urut, String isi, String kpd, String peng, String lamp,
			String catat, Db d) throws SQLException {
		super();
		this.index = index;
		this.kode = kode;
		this.urut = urut;
		this.isi = isi;
		this.kpd = kpd;
		this.peng = peng;
		this.lamp = lamp;
		this.catat = catat;
		tgl=java.sql.Date.valueOf(LocalDate.now());
		genNo(d);
	}

	private void genNo(Db d) throws SQLException {
		java.sql.ResultSet r=d.getData("select count(no)as oke from keluar");
		if(r.next())no=r.getInt("oke")+1;
		r.close();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getUrut() {
		return urut;
	}

	public void setUrut(String urut) {
		this.urut = urut;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getKpd() {
		return kpd;
	}

	public void setKpd(String kpd) {
		this.kpd = kpd;
	}

	public String getPeng() {
		return peng;
	}

	public void setPeng(String peng) {
		this.peng = peng;
	}

	public java.sql.Date getTgl() {
		return tgl;
	}

	public void setTgl(java.sql.Date tgl) {
		this.tgl = tgl;
	}

	public String getLamp() {
		return lamp;
	}

	public void setLamp(String lamp) {
		this.lamp = lamp;
	}

	public String getCatat() {
		return catat;
	}

	public void setCatat(String catat) {
		this.catat = catat;
	}
}