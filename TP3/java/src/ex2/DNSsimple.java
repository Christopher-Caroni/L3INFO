package ex2;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/*
 * envoi question DNS / reception reponse et affichage hexa rapide ...
 */

public class DNSsimple {

	public static void main(String[] args) {
		byte[] message = { (byte) 0x08, (byte) 0xbb, (byte) 0x01,
				(byte) 0x00, /*
								 * a) 12 octets d'entete : identifiant de
								 * requete parametres [RFC1035, 4.1.1]
								 */
				(byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
				(byte) 0x03, (byte) 0x77, (byte) 0x77,
				(byte) 0x77, /* b) QUESTION [RFC1035, 4.1.2] */
				(byte) 0x04, (byte) 0x6c, (byte) 0x69,
				(byte) 0x66, /* b.1) QNAME : "3www4lifl2fr0" [RFC1035, 3.1] */
				(byte) 0x6c, (byte) 0x02, (byte) 0x66, (byte) 0x72, (byte) 0x00, (byte) 0x00,
				(byte) 0x01, /*
								 * b.2) QTYPE : A (a host address) [RFC1035,
								 * 3.2.3]
								 */
				(byte) 0x00, (byte) 0x01 }; /*
											 * b.3) QCLASS : IN (the Internet)
											 * [RFC1035, 3.2.4]
											 */

		/* 1) Get DNS server address ... by DNS ... (??!) */
		System.err.print(" get inetaddress by name ... (on peut bien entendu mieux faire) ");
		InetAddress destination;
		try {
			destination = InetAddress
					.getByName("193.49.225.15"/*
												 * ou 8.8.8.8 ou celui dans
												 * /etc/resolv.conf ...
												 */);
		} catch (Exception e) {
			System.err.println("[error] :" + e.getMessage());
			return;
		}
		System.err.println("[ok]");

		/* 2) creation d'un DatagramPacket pour l'envoi de la question DNS */
		System.err.println(" preparing  datagrampacket, message size : " + message.length);
		DatagramPacket dp = new DatagramPacket(message, message.length, destination, 53);

		/* 3) creation d'un DatragramSocket (port au choix ) */
		System.err.print(" create datagram socket  ... ");
		DatagramSocket ds;
		try {
			ds = new DatagramSocket();
		} catch (Exception e) {
			System.err.println("[error] :" + e.getMessage());
			return;
		}
		System.err.println("[ok]");

		/* 4) et envoi du packet */
		System.err.print(" send datagram ... ");
		try {
			ds.send(dp);
		} catch (Exception e) {
			System.err.println("[error] :" + e.getMessage());
			return;
		}
		System.err.println("[ok]");

		/* 5) reception du packet */
		dp = new DatagramPacket(new byte[512], 512);
		System.err.print(" receive datagram ... ");
		try {
			ds.receive(dp);
		} catch (Exception e) {
			System.err.println("[error] :" + e.getMessage());
			return;
		}
		System.err.println("[ok]");

		/* affichage complet du packet recu (pas tres lisible ...) */
		byte[] rec = dp.getData();
		System.out.println("- message length : " + dp.getLength());
		System.out.println("- message : \n" + new String(rec, 0, dp.getLength()));

		/* affichage des bytes */
		for (int i = 0; i < dp.getLength(); i++) {
			System.out.print("," + Integer.toHexString((rec[i]) & 0xff));
			if ((i + 1) % 16 == 0)
				System.out.println("");
		}
		System.out.println();

		// QDCOUNT starts at offset 4
		System.out.println("QDCOUNT: " + getTwoByteAtOffsetAsString(rec, 4));
		System.out.println("ANCOUNT: " + getTwoByteAtOffsetAsString(rec, 6));

		int answerStart = skipQuestion(rec);
		byte[] rdata = readAnswer(rec, answerStart);

		// we now have the IPv4 @ in a 4 byte array
		System.out.print("\nAddress is : ");
		for (int i = 0; i < rdata.length; i++) {
			int dec = singleByteToInt(rdata[i]);
			System.out.print(dec + " ");
		}

	}

	private static int skipQuestion(byte[] rec) {
		// header size = 12, so Question starts at offset 12
		int answerStart = -1;
		boolean foundEndQname = false;
		int i = 12;

		while (!foundEndQname) {
			int singleValue = singleByteToInt(rec[i]);
			i++;
			if (singleValue == 0) {
				foundEndQname = true;
				answerStart = i + 4;
			}
		}
		// System.out.println(Integer.toHexString((rec[answerStart]) & 0xff));
		return answerStart;
	}

	static boolean foundType1 = false;

	private static byte[] readAnswer(byte[] rec, int answerStart) {
		// il faut donc chercher la 2e reponse qui a le type 1 qui contient l'IP

		int offset = answerStart;
		while (!foundType1) {
			offset = getType1DataOffset(rec, offset);
		}
		return Arrays.copyOfRange(rec, offset, offset + 4);
	}

	private static int getType1DataOffset(byte[] rec, int answerStart) {
		System.out.println("\nANSWER OFFSET: " + answerStart);
		
		
		int i = answerStart;
		int type = -1;
		boolean foundEndName = false;
		int rdLengthOffset = -1;
		

		byte[] ptr = Arrays.copyOfRange(rec, i, i + 2);
		int dec = byteToInt(ptr);
		boolean firstIsPointer = dec >= 192;
		boolean prevIsPointer = false;

		while (!foundEndName) {
			ptr = Arrays.copyOfRange(rec, i, i + 2);
			dec = byteToInt(ptr);
			if (prevIsPointer && dec < 192) {
				foundEndName = true;
				continue;
			} else if (dec >= 192) {
				prevIsPointer = true;
			} else if (firstIsPointer && dec == 00) {
				foundEndName = true;
				continue;
			}
			i++;
		}
		// i is now at end of name

		type = byteToInt(Arrays.copyOfRange(rec, i, i + 2));
		rdLengthOffset = i + 8; // type, class and ttl have combined length of 8

		byte[] rdLengthByte = Arrays.copyOfRange(rec, rdLengthOffset, rdLengthOffset + 2);

		System.out.println(
				"TYPE: " + (Integer.toHexString((rec[i]) & 0xff)) + ", " + (Integer.toHexString((rec[i + 1]) & 0xff)));
		System.out.println("CLASS: " + (Integer.toHexString((rec[i + 2]) & 0xff)) + ", "
				+ (Integer.toHexString((rec[i + 3]) & 0xff)));


		System.out.println("RDLENGTH: " + (Integer.toHexString((rec[rdLengthOffset]) & 0xff)) + ", "
				+ (Integer.toHexString((rec[rdLengthOffset + 1]) & 0xff)));

		
		if (type == 1) {
			foundType1 = true;
		}
		return rdLengthOffset +2;
	}

	private static int singleByteToInt(byte rec) {
		return rec & 0xFF;
	}

	private static int byteToInt(byte[] rec) {
		return ((rec[0] & 0xFF) * 256) | ((rec[1] & 0xFF));
	}

	private static String getByteAtOffsetAsString(byte rec) {
		return Integer.toHexString((rec) & 0xff);
	}

	private static String getTwoByteAtOffsetAsString(byte[] rec, int offset) {
		return Integer.toHexString((rec[offset]) & 0xff) + ", " + Integer.toHexString((rec[offset + 1]) & 0xff);
	}
}
