package net;

import java.net.DatagramPacket;

public class PacketValidator
{

	public static boolean isACKPacket(DatagramPacket packet)
	{
		boolean result = false;
		byte[] data = packet.getData();
		String stringData = new String(data);
		if(stringData.equals("ACK"))
		{
			result = true;
		}
		return result;
	}

	public static boolean isSYNPacket(DatagramPacket packet)
	{
		boolean result = false;
		byte[] data = packet.getData();
		String stringData = new String(data);
		if(stringData.equals("SYN"))
		{
			result = true;
		}
		return result;
	}

}
