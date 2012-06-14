package ru.urscorp.dao.dto;

import java.io.Serializable;


/**
 * Dto для информации о пользователе
 * 
 * @author Lev
 *
 */
public class UserDto implements Serializable{

	private String userAgent;
	private String ip;
	private int port;
	private String hash;

	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	@Override
	public String toString() {
		String res = "";
		if(userAgent!=null)
			res+=userAgent;

		if(ip!=null)
			res+=ip;
		
		res+=port;
		
		
		return super.toString();
	}

}
