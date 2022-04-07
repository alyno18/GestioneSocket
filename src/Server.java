import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			//creazione stream di output ed invio di un messaggio
			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
			outToClient.writeBytes("Ciao");
			
			DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
			String in = inFromClient.toString();
			if(in.equals("orario")) {
				SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		        String timeStamp = date.format(new Date());
		        outToClient.writeBytes(timeStamp);
			}
			
			serverSocket.close();
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