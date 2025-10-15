import java.net.*;
import java.io.*;

public class ClientTCP3
{
	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 49967);
		DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
		dOut.writeUTF(args[0]);

		DataInputStream dIn = new DataInputStream(socket.getInputStream());
		String rev = dIn.readUTF();
		System.out.println("Message inversé reçu : " + rev);

		socket.close();
	}
}

