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
		DatagramPacket newPacket = null;
		try
		{
		String ackString = "ACK";
		byte[] buff = ackString.getBytes("utf-8");
		//InetAddress addr = InetAddress.getByName(ipAddr);
		newPacket = new DatagramPacket(buff, buff.length, addr, host);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
		return newPacket;
	}

	public static DatagramPacket newDatagramSYNPacket(InetAddress addr, int host)
	{
		DatagramPacket newPacket = null;
		try
		{
		String synString = "SYN";
		byte[] buff = synString.getBytes("utf-8");
		//InetAddress addr = InetAddress.getByName(ipAddr);
		newPacket = new DatagramPacket(buff, buff.length, addr, host);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return newPacket;
	}

}
