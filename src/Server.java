import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
	public static void main(String[] args) {
		try {
			//apertura porta, avvio del servizio
			ServerSocket serverSocket=new ServerSocket(2000);
			System.out.println("Server avviato correttamente");
			//attesa di richieste dal client
			Socket socket=serverSocket.accept();
			System.out.println("Connessione avvenuta");
			System.out.println("Socket: " +socket);
		} catch(BindException e) {
			System.err.println("porta occupata");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Errore avvio del server sulla porta 2000");
			e.printStackTrace();
		}
	}
}