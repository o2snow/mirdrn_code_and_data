package edu.map.ws.common;

import java.util.Random;

public class SimpleCipher {

	private byte[] s;
	private byte i;
	private byte j;
	private int m_meb;

	private SimpleCipher(byte[] rawUserKey, int meb) {
		m_meb = meb;

		if (0 == m_meb)
			return;

		// Restrict max key length to 56 bits for now.
		int keyLength = rawUserKey.length;
		if (keyLength > meb)
			keyLength = meb;
		byte[] userKey = new byte[keyLength];
		System.arraycopy(rawUserKey, 0, userKey, 0, keyLength);

		s = new byte[0x100];
		byte index1;
		byte index2;
		int counter;

		for (counter = 0; counter < 0x100; counter++)
			s[counter] = (byte) (counter % 0x100);

		i = j = 0;
		index1 = index2 = 0;
		for (counter = 0; counter < 0x100; counter++) {
			index2 = (byte) (userKey[index1 & 0xFF] + s[counter] + index2);
			byte tmp = s[counter];
			s[counter] = s[index2 & 0xFF];
			s[index2 & 0xFF] = tmp;
			index1 = (byte) ((++index1 & 0xFF) % keyLength);
		}
	}

	private byte[] processData(byte[] inoutString) {
		return processData(inoutString, 0, inoutString.length);
	}

	private byte[] processData(byte[] inoutString, int index, int length) {
		if (0 == m_meb) {
			return inoutString;
		}

		while (length-- != 0) {
			byte a = s[++i & 0xFF];
			j += a;
			byte b = s[j & 0xFF];
			s[j & 0xFF] = a;
			s[i & 0xFF] = b;
			a += b;
			inoutString[index++] ^= s[a & 0xFF];
		}
		return inoutString;
	}

	private static byte[] createPassword() {
		byte[] password = new byte[8];
		new Random().nextBytes(password);
		return password;
	}

	private static String convertBytes2String(byte[] ba) {

		StringBuffer buf = new StringBuffer(ba.length);
		for (byte b : ba) {
			
			byte k;
			k = (byte) (( b & 0xF0 ) >> 4);
			char cc = (char) (k > 9 ? k + 0x37 : k + 0x30);
			buf.append(cc);
			
			k =  (byte) (b & 0x0F);
			cc = (char) (k > 9 ? k + 0x37 : k + 0x30);
			buf.append(cc);
		}

		return buf.toString();
	}

	private static byte[] convertString2Bytes(String s) {
		int len = s.length() >> 1;
		byte[] ba = new byte[len];
		int index = 0;
		for (int i = 0; i < len; i++) {
			index = i << 1;
			String t = s.substring(index, index + 2);
			ba[i] = (byte) (Integer.parseInt(t, 16));
		}
		return ba;
	}

	public static String encrypted(String plainText) {
		byte[] password = createPassword();
		SimpleCipher cipher = new SimpleCipher(password, 64);

		int len = plainText.length();
		byte plainBytes[] = new byte[len];
		for (int i = 0; i < len; i++) {
			plainBytes[i] = (byte) plainText.charAt(i);
		}

		byte[] encrypted = cipher.processData(plainBytes);

		String s1 = convertBytes2String(password);
		String s2 = convertBytes2String(encrypted);
		return s1 + s2;
	}

	public static String decrypted(String encryptedText) {
		String s1 = encryptedText.substring(0, 16);
		String s2 = encryptedText.substring(16);

		byte[] password = convertString2Bytes(s1);
		byte[] reverted = convertString2Bytes(s2);

		SimpleCipher cipher = new SimpleCipher(password, 64);
		byte[] plainText = cipher.processData(reverted);

		StringBuffer buffer = new StringBuffer();

		for (byte b : plainText) {			
			char c = (char)b;
			buffer.append(c);
		}
		return buffer.toString();
		
	}

	public static void main(String s[]) {
		try {

			long id = 168888888;
			String plainText = String.valueOf(id);
			
			plainText = "System.out.println(--------> password = + password+, +pwd);";
			System.out.println("--------> plain=" + plainText);

			String what = encrypted(plainText);
			System.out.println("--------> what=" + what);

			String anwer = decrypted(what);
			System.out.println("--------> anwer=" + anwer);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
