import java.io.*;
import java.net.*;

public class ServeurUDP
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket socket = new DatagramSocket(44969);
			System.out.println("Serveur UDP en attente sur le port 44969...");

			byte[] buffer = new byte[1024];

			while (true)
			{
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

				socket.receive(packet);

				String msg = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
				System.out.println("Reçu de " + packet.getAddress() + ":" + packet.getPort() + " -> " + msg);

				byte[] replyData = msg.getBytes("UTF-8");
				DatagramPacket reply = new DatagramPacket(replyData, replyData.length, packet.getAddress(), packet.getPort());

				socket.send(reply);
			}
		}
			catch (IOException e)
			{
				System.err.println("Erreur serveur UDP : " + e.getMessage());
		}
	}
}


