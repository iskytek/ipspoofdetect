package main;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Main
{
	public static void main(String[]args)
	{
		try
		{	
			//start and detect source ip address	
			DatagramSocket inputSocket = new DatagramSocket(8765);
			
			byte[] buff = new byte[256];
			DatagramPacket receivedPacket = new DatagramPacket(buff, buff.length);
			
			System.out.println("Server initialized. Receiving packets");
			
			while(true)
			{
				inputSocket.receive(receivedPacket);	
				System.out.println(" " + receivedPacket.getAddress().getHostAddress());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error when creating socket");
			ex.printStackTrace();
		}	
	}	
}
