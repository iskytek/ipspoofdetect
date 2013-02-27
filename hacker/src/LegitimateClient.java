package net;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

public class LegitimateClient
{

	private static int CLIENT_PORT = 8764;
	private static int SERVER_PORT = 8765;

	public static void initialize()
	{
		try
		{
			DatagramSocket socket = new DatagramSocket(LegitimateClient.CLIENT_PORT);	
			DatagramPacket packet = DatagramPacketFactory.newDatagramPacket();
			socket.connect(new InetSocketAddress(LegitimateClient.SERVER_PORT));
			
			socket.send(packet);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
