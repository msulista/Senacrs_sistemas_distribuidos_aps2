package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SuperTrunfoServer {

	public static void main(String[] args) {

		DataInputStream in;
		DataOutputStream out;
		Socket clienteSocket = null;
		ServerSocket listenSocket = null;
		List<Socket> listaClientes = new ArrayList<>();

		try {
			int serverPort = 7896;

			for (int i = 0; i < 4; i++) {

				listenSocket = new ServerSocket(serverPort);
				clienteSocket = listenSocket.accept();
				listaClientes.add(clienteSocket);

				clienteSocket.close();
				listenSocket.close();
			}

			// an echo server
			Thread.sleep(300);

			for (Socket cliente : listaClientes) {

				in = new DataInputStream(clienteSocket.getInputStream());
				out = new DataOutputStream(clienteSocket.getOutputStream());
				Thread.sleep(3000);
				String data = in.readUTF();
				out.writeUTF(data);

				clienteSocket.close();
				listenSocket.close();
			}

		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				// fecha dentro de um finally para garantir que irá fechar
				// mesmo ocorrendo uma exceção.
				clienteSocket.close();
				listenSocket.close();
			} catch (IOException e) {/* close failed */

			}
		}

	}

}
