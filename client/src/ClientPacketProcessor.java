package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ClientPacketProcessor
{

	public static String VALID_SERVER_IP;

	public static void processPacket(DatagramSocket receiverSocket, DatagramPacket receivedPacket)
	{
		String receivedIp = receivedPacket.getAddress().getHostAddress();
		if(receivedIp.equals(VALID_SERVER_IP))
		{	
			if(PacketValidator.isSYNPacket(receivedPacket))
			{
				//send an ack
				DatagramPacketFactory.newDatagramACKPacket(receivedPacket.getAddress(), receivedPacket.getPort());	
			}
		}
	}

}
