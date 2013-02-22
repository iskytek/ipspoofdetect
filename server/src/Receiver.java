package net;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class Receiver
{

	private static String SERVER_IP = "";
	private static int SERVER_APP_PORT = 8765;

	private boolean mStopReceiving;

	public Receiver()
	{
	}

	public void initialize()
	{
		try
		{
			DatagramSocket receiverSocket = new DatagramSocket(Receiver.SERVER_APP_PORT);
			byte[] buff = new byte[256];
			DatagramPacket receivedPacket = new DatagramPacket(buff, buff.length);	
			InetAddress currPacAddr = null;
			System.out.println("Starting infinite loop to listen for incomming packets");
			while(true)
			{	
				receiverSocket.receive(receivedPacket);
				currPacAddr = receivedPacket.getAddress();
				System.out.println("packet received with src addr - " + currPacAddr.getHostName());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Receiver initialization failed because of the following exception - ");
			ex.printStackTrace();
		}
	}

}
