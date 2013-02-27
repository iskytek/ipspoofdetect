package model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Calendar;

public class PacketInfoStore
{
	private static int ACK_PACKET_WAIT = 15;
	private static Hashtable<String, PacketInfo> validList;
	private static Hashtable<String, PacketInfo> ackWaitList;

	static
	{
		PacketInfoStore.ackWaitList = new Hashtable<String, PacketInfo>();
		PacketInfoStore.validList = new Hashtable<String, PacketInfo>();
		PacketInfoStore.startScheduledCleanup();
	}

	public static void addNewValidatingPacketInfo(String ip, PacketInfo packetInfo)
	{
		System.out.println("Validating packet added with ip - " + ip);
		PacketInfoStore.ackWaitList.put(ip, packetInfo);	
	}

	public static boolean isValid(String ipAddr)
	{
		boolean result = false;
		if(PacketInfoStore.validList.get(ipAddr) != null)
		{
			result = true;
		}
		return result;
	}

	public static boolean isIpAddrValidating(String ipAddr)
	{
		boolean result = false;
		if(PacketInfoStore.ackWaitList.get(ipAddr) != null)
		{
			result = true;
		}
		return result;
	}

	public static void validateIpAddr(String ipAddr)
	{
		PacketInfo validInfo = PacketInfoStore.ackWaitList.get(ipAddr);
		PacketInfoStore.validList.put(ipAddr, validInfo);
		PacketInfoStore.ackWaitList.remove(ipAddr);
	}

	public static void startScheduledCleanup()
	{
		new Thread(new Runnable() {
			public void run()
			{
				System.out.println("Starting scheduled cleanup of ackWaitList");
				while(true)
				{
					try
					{
						System.out.println("Clenup executed");
						Thread.sleep(15000);
						//search for packets which have exceeded wait time and remove from ackWaitList
						removeSpoofedEntries();
					}
					catch(Exception ex)
					{
						System.out.println("Thread sleep failed");
						ex.printStackTrace();
					}
				}
			}
				
			private void removeSpoofedEntries()
			{
				//iterate all ipaddresses to check their timestamps. If timestamp is older than 15 seconds, the the ip address is spoofed	
				Iterator it = ackWaitList.entrySet().iterator();
			
				Map.Entry currentEntry = null;	
				long currentTime = 0;
				PacketInfo currentInfo = null;
				
				while(it.hasNext())
				{
					currentEntry = (Map.Entry) it.next();
					currentTime = Calendar.getInstance().getTimeInMillis();
					currentInfo = (PacketInfo) currentEntry.getValue();	
					if((currentTime - currentInfo.getCreationTime()) > 15000)
					{
						System.out.println("Spoofed ip address detected - " + currentEntry.getKey() + ". Releasing all resources related to this");
						it.remove();
					}
				}
			}

		}).start();
	}
}
