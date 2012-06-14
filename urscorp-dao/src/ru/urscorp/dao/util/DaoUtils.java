package ru.urscorp.dao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.sql.Timestamp;

import ru.urscorp.dao.dto.UserDto;

public class DaoUtils {

	public static Timestamp getTs(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static String generateHash(UserDto userDto){
		String hash = null;
		try {
			MessageDigest sha512 = MessageDigest.getInstance("SHA-512","BC");
			sha512.digest((userDto.getIp()+));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
}
