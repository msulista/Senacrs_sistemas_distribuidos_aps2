package player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

import Carta.CartaST;
import Jogador.Jogador;

public class player1 {

	public static void main(String[] args) {

		Jogador jogador = new Jogador();

		Socket socket = null;

		try {
			int serverPort = 7896;
			String ip = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(ip, serverPort);
			
			//Envia e recebe objeto  exemplo http://pt.stackoverflow.com/questions/25520/enviar-objetos-via-socket
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			CartaST carta = jogador.realizaJogada();
			output.writeObject(carta);
	        output.flush();
	        output.reset();
	        output.close();
			
			
//			DataInputStream in = new DataInputStream(socket.getInputStream());
//			DataOutputStream out = new DataOutputStream(
//					socket.getOutputStream());
//			out.writeUTF(JOptionPane.showInputDialog("Informa menssagem: "));
			
//			String data = in.readUTF();
//			JOptionPane.showMessageDialog(null, "Player 1 esta ok: " + data);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Close falhou!");
				}
		}

	}

}
