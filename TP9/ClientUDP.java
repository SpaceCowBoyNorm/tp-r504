import java.io.*;
import java.net.*;

public class ClientUDP
{
	public static void main(String[] args) throws Exception
	{
		String s = "Hello World";
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("adresse=" + addr.getHostName());
		byte[] data = s.getBytes ();
		DatagramPacket packet = new DatagramPacket(data, data.length, addr, 49969);
		DatagramSocket sock = new DatagramSocket();
		sock.send(packet);

		byte[] buffer = new byte[1024];
		DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
		sock.receive(responsePacket);

		String received = new String(responsePacket.getData(), 0, responsePacket.getLength());
		System.out.println("Received : " + received);
		sock.close();
	}
}


