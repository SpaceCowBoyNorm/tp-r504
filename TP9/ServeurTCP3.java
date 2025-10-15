import java.net.*;
import java.io.*;

public class ServeurTCP3
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

				String msg = dIn.readUTF();

                System.out.println("Message : " + msg);

				String rev = new StringBuilder ( msg ) . reverse ( ) . toString ( ) ;

				DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
				dOut.writeUTF(rev);

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

