package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ClientPacketProcessor
{

	public static String VALID_SERVER_IP;

	public static void processPacket(DatagramSocket receiverSocket, DatagramPacket receivedPacket)
	{
		try
		{
		System.out.println("Recieved Packet");
		String receivedIp = receivedPacket.getAddress().getHostAddress();
		System.out.println("Recieved Packet"+ receivedIp);

		if(receivedIp.equals(VALID_SERVER_IP))
		{	
			System.out.println("server ip valid");
			System.out.println("");System.out.println("");System.out.println("");System.out.println("");
			if(PacketValidator.isSYNPacket(receivedPacket))
			{
				System.out.println("packet validation passed");
				//send an ack
				DatagramPacket a = DatagramPacketFactory.newDatagramACKPacket(receivedPacket.getAddress(), receivedPacket.getPort());	
				System.out.println("sending ack");
				receiverSocket.send(a);
			}
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
