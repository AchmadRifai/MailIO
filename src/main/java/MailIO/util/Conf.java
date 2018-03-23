package MailIO.util;

import javax.xml.bind.annotation.XmlAccessType;

@javax.xml.bind.annotation.XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlRootElement
public class Conf {
	private String host;
	private int port;
	private String name,user,pass;

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Conf(String host, int port, String name, String user, String pass) {
		super();
		this.host = host;
		this.port = port;
		this.name = name;
		this.user = user;
		this.pass = pass;
	}
	public Conf() {
		super();
		// TODO Auto-generated constructor stub
	}
}