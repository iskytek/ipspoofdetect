package net;

import java.net.DatagramPacket;

public class PacketValidator
{

	public static boolean isACKPacket(DatagramPacket packet)
	{
		boolean result = false;
		try
		{
		byte[] data = packet.getData();
		String stringData = new String(data, 0, packet.getLength());
		if(stringData.equals("ACK"))
		{
			result = true;
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
		

		
	public static boolean isSYNPacket(DatagramPacket packet)
	{
		boolean result = false;
		try
		{
		
		byte[] data = packet.getData();
		String stringData = new String(data, 0, packet.getLength());
		String syn = "SYN";
		System.out.println("validating syn data - " + stringData.length() + " " + syn.length());
		if(stringData.equals("SYN"))
		{
			System.out.println("returning true");
			result = true;
		
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;

	}

}
