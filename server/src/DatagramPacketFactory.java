package net;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramPacketFactory
{

	private static int PACKET_DATA_SIZE = 256;
	
	public static DatagramPacket newDatagramPacket()
	{
		byte[] buff = new byte[DatagramPacketFactory.PACKET_DATA_SIZE];
		DatagramPacket newPacket = new DatagramPacket(buff, buff.length);	
		return newPacket;
	}
	
	public static DatagramPacket newDatagramACKPacket(InetAddress addr, int host)
	{
		String ackString = "ACK";
		byte[] buff = ackString.getBytes();
		//InetAddress addr = InetAddress.getByName(ipAddr);
		DatagramPacket newPacket = new DatagramPacket(buff, buff.length, addr, host);
		return newPacket;
	}

	public static DatagramPacket newDatagramSYNPacket(InetAddress addr, int host)
	{
		String synString = "SYN";
		byte[] buff = synString.getBytes();
		//InetAddress addr = InetAddress.getByName(ipAddr);
		DatagramPacket newPacket = new DatagramPacket(buff, buff.length, addr, host);
		return newPacket;
	}

}
