package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import model.PacketInfoStore;
import model.PacketInfo;

public class PacketProcessor
{

	public static PacketType processPacket(DatagramSocket socket, DatagramPacket packet)
	{
		PacketType type = PacketType.UNDETERMINED;
		String receivedIp = packet.getAddress().toString();
		
		System.out.println("Processing received packet - " + receivedIp);

		if(PacketInfoStore.isValid(receivedIp))
		{
			System.out.println("Received a valid packet from ip - " + receivedIp);	
			type = PacketType.LEGITIMATE;
		}
		else
		{
			//if ip address is not validated, carry out validation process again.
			if(PacketInfoStore.isIpAddrValidating(receivedIp))
			{
				//check if it is a ACK packet. If it is not, then ignore.	
				if(PacketValidator.isACKPacket(packet))
				{
					System.out.println("Legitimate client identified with ip - " + receivedIp);
					PacketInfoStore.validateIpAddr(receivedIp);
				}
			}
			else
			{
				//send ACK packet and also an SYN. Only if the client responds with an ACK, he is a valid client.	
				try
				{
					DatagramPacket newSYNPacket = DatagramPacketFactory.newDatagramSYNPacket(packet.getAddress(), packet.getPort());
					DatagramPacket newACKPacket = DatagramPacketFactory.newDatagramACKPacket(packet.getAddress(), packet.getPort());
					
					socket.send(newACKPacket);
					socket.send(newSYNPacket);
					
					PacketInfoStore.addNewValidatingPacketInfo(receivedIp, new PacketInfo(packet));
					type = PacketType.NEW;
				}
				catch(Exception ex)
				{
					System.out.println("Error sending syn or ack packet");
					ex.printStackTrace();
				}
			}
		}
		return type;
	}	
}
