package player1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class player1 {

	public static void main(String[] args) {

		Socket socket = null;

		try {
			int serverPort = 7896;
			socket = new Socket("localhost", serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String data = in.readUTF();
			JOptionPane.showMessageDialog(null, "Player 1 esta ok: " + data);

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
