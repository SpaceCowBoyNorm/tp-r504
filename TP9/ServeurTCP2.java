import java.net.*;
import java.io.*;

public class ServeurTCP2
{
	public static void main(String[] args) throws Exception
	{
		try {
			ServerSocket socketserver = new ServerSocket(49967);
			System.out.println("serveur en attente");
			while (true)
			{
				Socket socket = socketserver.accept();
				System.out.println("Connection d’un client");
				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				System.out.println("Message : " + dIn.readUTF());
				socket.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("Erreur : " + e.getMessage());
//			socketserver.close();
		}
	}
}
