package player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import Carta.Baralho;
import Carta.CartaST;

public class Player2 {

	public static void main(String[] args) {
		
		Baralho baralho = new Baralho();
		List<CartaST> maoPlayer = baralho.geraBaralhoPlayer();

		Socket socket = null;

		try {
			int serverPort = 7897;
			String ip = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(ip, serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(JOptionPane.showInputDialog("Informa menssagem: "));
			String data = in.readUTF();
			JOptionPane.showMessageDialog(null, "Player 2 esta ok: " + data);

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
