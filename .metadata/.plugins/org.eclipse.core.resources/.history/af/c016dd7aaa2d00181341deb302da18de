package ex2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("Saisissez une adresse symbolique : (\"stop\" pour terminer) ");
			System.out.println("-----------------------------------------------------------");
			String domain = sc.nextLine();
			if (domain.equalsIgnoreCase("stop")) {
				System.out.println("bye");
				break;
			}
			printDatagram(domain);
		}
		sc.close();

	}

	private static void printDatagram(String domain) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);

		/*
		 * ID: A 16 bit identifier assigned by the program that generates any
		 * kind of query. This identifier is copied the corresponding reply and
		 * can be used by the requester to match up replies to outstanding
		 * queries.
		 */
		dos.writeShort(0x1234);

		/*
		 * QR : A one bit field that specifies whether this message is a query
		 * (0), or a response (1).
		 */
		dos.writeShort(0x0100);

		/*
		 * QDCOUNT : an unsigned 16 bit integer specifying the number of entries
		 * in the question section.
		 */
		dos.writeShort(0x0001);

		/*
		 * ANCOUNT : an unsigned 16 bit integer specifying the number of
		 * resource records in the answer section.
		 */
		dos.writeShort(0x0000);

		/*
		 * NSCOUNT : an unsigned 16 bit integer specifying the number of name
		 * server resource records in the authority records section.
		 */
		dos.writeShort(0x0000);

		/*
		 * ARCOUNT : an unsigned 16 bit integer specifying the number of
		 * resource records in the additional records section.
		 */
		dos.writeShort(0x0000);

		String[] domainParts = domain.split("\\.");
		System.out.println(domain + " has " + domainParts.length + " parts");

		for (int i = 0; i < domainParts.length; i++) {
			System.out.println("Writing: " + domainParts[i]);
			byte[] domainBytes = domainParts[i].getBytes("UTF-8");
			dos.writeByte(domainBytes.length);
			dos.write(domainBytes);
		}

		// No more parts
		dos.writeByte(0x00);

		// Type 0x01 = A (Host Request)
		dos.writeShort(0x0001);

		// Class 0x01 = IN
		dos.writeShort(0x0001);

		byte[] dnsFrame = baos.toByteArray();

		System.out.println("Sending: " + dnsFrame.length + " bytes");
		for (int i = 0; i < dnsFrame.length; i++) {
			System.out.print("0x" + String.format("%x", dnsFrame[i]) + " ");
		}

	}

}
