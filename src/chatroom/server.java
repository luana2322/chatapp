package chatroom;

import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class server implements Runnable {
	private List<Customer> clients;
	private ServerSocket serverSocket;
	private DataInputStream in;
	DataOutputStream out;
	StringBuilder str;
	private String user1;
	private String pw1;
	private String tien1, tien2;
	private int max;
	private String loaiphong3;
	private int gia3, tien3;
	private int lau3;
	private String phong3;
	private int a2, a1;

	String url = "jdbc:MySQl://localhost:3306/qlks";
	String username = "root";
	String password = "";

	public server(int port) throws IOException {
		clients = new ArrayList<>();
		serverSocket = new ServerSocket(98);

	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				Customer customer = new Customer(null, clientSocket);
				clients.add(customer);

				Thread thread = new Thread(() -> {
					try {
						DataInputStream in = new DataInputStream(clientSocket.getInputStream());
						DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
						Connection c;
						while (true) {
							String action = in.readUTF();
							switch (action) {
							
							case "add":
								String nameadd = in.readUTF();
								customer.setName(nameadd);
								sendOnlineList();
								break;
							case "send":
								String message = in.readUTF();
								sendToAll(message, customer);
								break;
							case "sendone":
								String message1 = in.readUTF();
								sendToAll(message1, customer);
								break;
							case "emoji":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji");
									out5.writeUTF(customer.getName());
								}

								break;
							case "emoji1":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji1");
									out5.writeUTF(customer.getName());
								}
								break;
							case "emoji2":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji2");
									out5.writeUTF(customer.getName());
								} 
								break;
							case "emoji3":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji3");
									out5.writeUTF(customer.getName());
								}
								break;
							case "emoji4":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji4");
									out5.writeUTF(customer.getName());
								}
								break;
							case "emoji5":
								for (Customer client : clients) {
									DataOutputStream out5 = new DataOutputStream(client.getSocket().getOutputStream());
									out5.writeUTF("emoji5");
							
									out5.writeUTF(customer.getName());
								}
								break;

							}	
					}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						clients.remove(clientSocket);

					}
				});
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void sendOnlineList() throws IOException {
		StringBuilder builder = new StringBuilder();
		for (Customer client : clients) {
			builder.append(client.getName()).append(",");
		}
		String list = builder.toString();
		for (Customer client : clients) {
			DataOutputStream out = new DataOutputStream(client.getSocket().getOutputStream());
			out.writeUTF("add");
			out.writeUTF(list);
		}
	}

	private void sendToAll(String message, Customer sender) throws IOException {
		for (Customer client : clients) {

			DataOutputStream out = new DataOutputStream(client.getSocket().getOutputStream());
			out.writeUTF("send");
			out.writeUTF(sender.getName() + ": " + message);

		}
	}

	public static void main(String[] args) {
		try {
			server server = new server(98);
			new Thread(server).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}