import java.net.*;
import java.io.*;

public class ClientTCP2
{
	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 49967);
		DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
		dOut.writeUTF(args[0]);
		dOut.flush();
		dOut.close();
		socket.close();
	}
}

