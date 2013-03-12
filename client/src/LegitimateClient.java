package net;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class LegitimateClient
{

	private static int CLIENT_PORT = 8764;
	private static int SERVER_PORT = 8765;

	public static void initialize()
	{
		try
		{
			DatagramSocket socket = new DatagramSocket(LegitimateClient.CLIENT_PORT);
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			DatagramPacket packet = DatagramPacketFactory.newDatagramSYNPacket(addr, LegitimateClient.SERVER_PORT);	
			
			System.out.println("Sending a syn packet");
			
			socket.send(packet);
			
			System.out.println("Listening for incomming packets");
			
			while(true)
			{
				socket.receive();	
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
