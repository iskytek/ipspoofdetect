package model;

import java.net.DatagramPacket;
import java.util.Calendar;

public class PacketInfo
{

	private String ipAddr;
	private long timeSinceCreation;

	public PacketInfo(DatagramPacket packet)
	{
		this.ipAddr = packet.getAddress().getHostAddress();	
		this.timeSinceCreation = Calendar.getInstance().getTimeInMillis();
	}

	public long getCreationTime()
	{
		return this.timeSinceCreation;
	}

}
