package net;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import net.DatagramPacketFactory;
import net.PacketProcessor;
import net.PacketType;

public class Receiver
{

	private static String SERVER_IP = "";
	private static int SERVER_APP_PORT = 8765;

	private DatagramSocket mReceiverSocket; 
	
	public Receiver()
	{
	}

	public void initialize()
	{
		try
		{
			this.mReceiverSocket = new DatagramSocket(Receiver.SERVER_APP_PORT);
			DatagramPacket receivedPacket = DatagramPacketFactory.newDatagramPacket();	
			InetAddress currPacAddr = null;

			System.out.println("Listening for incomming packets");
			
			while(true)
			{	
				this.mReceiverSocket.receive(receivedPacket);
				System.out.println("Receiver - " + receivedPacket.getAddress().getHostAddress());
				PacketType type = PacketProcessor.processPacket(this.mReceiverSocket, receivedPacket);	
			}
		}
		catch(Exception ex)
		{
			System.out.println("Receiver initialization failed because of the following exception - ");
			ex.printStackTrace();
		}
		finally
		{
			System.out.println("Closing socket as code terminated due to some problem");
			this.mReceiverSocket.close();
		}
	}

}
