package org.tinygroup.buildinfo.common.security;


public class EncryptionMD5 implements Encryption{

	public String execute(String inputStr) {
		return MD5Util.GetMD5Code(inputStr);     
	}

}
