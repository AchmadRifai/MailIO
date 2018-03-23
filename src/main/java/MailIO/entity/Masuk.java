package MailIO.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import MailIO.util.Db;

public class Masuk {
	private int no;
	private String index,kode,urut,surat;
	private java.sql.Date terima;
	private String isi,dari;
	private java.sql.Date tgl;
	private String lamp,peng;
	private java.sql.Date terus;
	private String catat;

	public Masuk(int no, Db d) throws SQLException {
		super();
		this.no = no;
		java.sql.PreparedStatement p=d.prep("select*from masuk where nomor=?");
		p.setInt(1, no);
		ResultSet r=p.executeQuery();
		if(r.next())fillAll(r);
		r.close();
	}

	private void fillAll(ResultSet r) throws SQLException {
		terus=r.getDate("terus");
		index=r.getString("indek");
		kode=r.getString("kode");
		urut=r.getString("urut");
		isi=r.getString("isi");
		dari=r.getString("dari");
		tgl=r.getDate("tgl");
		lamp=r.getString("lamp");
		peng=r.getString("peng");
		catat=r.getString("catat");
		terima=r.getDate("terima");
	}

	public Masuk(String index, String kode, String urut, String surat, String isi, String dari, Date tgl, String lamp,
			String peng, String catat, Db d) throws SQLException {
		super();
		this.index = index;
		this.kode = kode;
		this.urut = urut;
		this.surat = surat;
		this.isi = isi;
		this.dari = dari;
		this.tgl = tgl;
		this.lamp = lamp;
		this.peng = peng;
		this.catat = catat;
		terima=java.sql.Date.valueOf(LocalDate.now());
		terus=null;
		genNo(d);
	}

	private void genNo(Db d) throws SQLException {
		java.sql.ResultSet r=d.getData("select count(no)as oke from masuk");
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

	public String getSurat() {
		return surat;
	}

	public void setSurat(String surat) {
		this.surat = surat;
	}

	public java.sql.Date getTerima() {
		return terima;
	}

	public void setTerima(java.sql.Date terima) {
		this.terima = terima;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getDari() {
		return dari;
	}

	public void setDari(String dari) {
		this.dari = dari;
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

	public String getPeng() {
		return peng;
	}

	public void setPeng(String peng) {
		this.peng = peng;
	}

	public java.sql.Date getTerus() {
		return terus;
	}

	public void setTerus(java.sql.Date terus) {
		this.terus = terus;
	}

	public String getCatat() {
		return catat;
	}

	public void setCatat(String catat) {
		this.catat = catat;
	}
}