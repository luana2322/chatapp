package chatroom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class clientchat extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable table;
	private JTextField txtsend;

	private DataInputStream in;
	private DataOutputStream out;
	private JTextPane textPane;
	private static DefaultTableModel model;
	String newmessage;
	private StyledDocument doc;
	private JButton buttonsend;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		clientchat frame = new clientchat();

	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public clientchat() throws UnknownHostException, IOException {
		init();
		this.setTitle("QUẢN LÝ KHÁCH SẠN");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void init() throws UnknownHostException, IOException {

		Socket socket = new Socket("localhost", 98);

		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());

		new Thread(() -> {
			try {
				in = new DataInputStream(socket.getInputStream());

				while (true) {

					String action = in.readUTF();

					switch (action) {
					case "add":
						model.setRowCount(0);
						newmessage = in.readUTF();
						String[] com = newmessage.split(",");
						for (int i = 0; i < com.length; i++) {
							model.addRow(new Object[] { com[i] });
						}

						break;
					case "emoji":
						 String name5=in.readUTF();
						ArrayList<Integer> iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position = doc.getLength();
						Icon icon = new ImageIcon(getClass().getResource("/icon/confused.png"));
						doc.insertString(position, name5+":", null);
						textPane.setCaretPosition(position + 2);
						textPane.insertIcon(icon);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "emoji1":
						 name5=in.readUTF();
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position1 = doc.getLength();
						Icon icon1 = new ImageIcon(getClass().getResource("/icon/emoji (1).png"));
						doc.insertString(position1, name5+":", null);
						textPane.setCaretPosition(position1 + 2);
						textPane.insertIcon(icon1);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position1);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "emoji2":
						 name5=in.readUTF();
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position2 = doc.getLength();
						Icon icon2 = new ImageIcon(getClass().getResource("/icon/emoji (2).png"));
						doc.insertString(position2, name5+":", null);
						textPane.setCaretPosition(position2 + 2);
						textPane.insertIcon(icon2);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position2);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "emoji3":
						 name5=in.readUTF();
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position3 = doc.getLength();
						Icon icon3 = new ImageIcon(getClass().getResource("/icon/emoji (3).png"));
						doc.insertString(position3, name5+":", null);
						textPane.setCaretPosition(position3 + 2);
						textPane.insertIcon(icon3);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position3);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "emoji4":
						 name5=in.readUTF();
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position4 = doc.getLength();
						Icon icon4 = new ImageIcon(getClass().getResource("/icon/emoji (4).png"));
						doc.insertString(position4, name5+":", null);
						textPane.setCaretPosition(position4 + 2);
						textPane.insertIcon(icon4);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position4);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "emoji5":
                      name5=in.readUTF();
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position5 = doc.getLength();
						Icon icon5 = new ImageIcon(getClass().getResource("/icon/emoji.png"));

						doc.insertString(position5, name5+":", null);
						textPane.setCaretPosition(position5 + 2);
						textPane.insertIcon(icon5);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position5);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;
					case "send":

						String messagereceive = in.readUTF();
						
						iconPositions = new ArrayList<>();

						// Chèn một tin nhắn icon vào Document
						doc = textPane.getStyledDocument();
						int position6= doc.getLength();
						
						doc.insertString(position6, " ", null);
						textPane.setCaretPosition(position6 + 1);
						
						doc.insertString(position6, messagereceive, null);

						// Lưu vị trí của tin nhắn icon vào ArrayList
						iconPositions.add(position6);

						// Gửi một tin nhắn text mới

						doc.insertString(doc.getLength(), "\n", null);

						// Đưa con trỏ về cuối Document
						textPane.setCaretPosition(doc.getLength());

						break;

					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}).start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1540, 863);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(225, 10, 1301, 41);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("CHAT ROOM");
		lblNewLabel.setBounds(0, 0, 280, 45);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(225, 53, 1338, 803);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setBounds(10, 10, 1087, 662);
		panel_2.add(textPane);
		textPane.setText("Phòng 308:Phòng 308 bị mất điện\nPhòng 201:Phòng 201 bị mất nước đề nghị quản lý khách sạn xử lý nhanh\n");

		JLabel lblNewLabel_4 = new JLabel("ONLINE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(1107, 10, 195, 49);
		panel_2.add(lblNewLabel_4);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1107, 69, 187, 703);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		model.addColumn("Online");

		table.setModel(model);

		JButton buttonstart = new JButton("Connect\r\n\r\n");
		buttonstart.setIcon(new ImageIcon(clientchat.class.getResource("/icon/plug-solid-_1_ (1).png")));
		buttonstart.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = txtsend.getText();

				try {
					out.writeUTF("add");
					out.writeUTF(name);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();

				}
				buttonstart.setEnabled(false);
				buttonsend.setEnabled(true);

			}
		});
		buttonstart.setBounds(0, 728, 177, 44);
		panel_2.add(buttonstart);

		txtsend = new JTextField();
		txtsend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsend.setText("Enter your room and click connect to connect with the hotel manager");
		txtsend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsend.setText("");
			}
		});
		txtsend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int o;
		                if(e.getKeyCode() == KeyEvent.VK_ENTER){
		                    if(!txtsend.getText().equals(""))
		                        buttonstart.doClick();
		                    o=1;
		                    if(o==1) {
		                    	buttonsend.doClick();
		                    }
		                        
		                }
			}
		});
		txtsend.setBounds(179, 728, 838, 43);
		panel_2.add(txtsend);
		txtsend.setColumns(10);

		buttonsend = new JButton("");
		buttonsend.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonsend.setIcon(new ImageIcon(clientchat.class.getResource("/icon/paper-plane-solid (1).png")));

		buttonsend.setEnabled(false);
		buttonsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String message = txtsend.getText();
				try {
					out.writeUTF("send");
					out.writeUTF(message);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();

				}
				txtsend.setText("");
			}
		});
		buttonsend.setBounds(1012, 728, 97, 44);
		panel_2.add(buttonsend);

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_9.setIcon(new ImageIcon(clientchat.class.getResource("/icon/confused.png")));
		btnNewButton_9.setBounds(10, 674, 85, 51);
		panel_2.add(btnNewButton_9);

		JButton btnNewButton_9_1 = new JButton("");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji1");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9_1.setIcon(new ImageIcon(clientchat.class.getResource("/icon/emoji (1).png")));
		btnNewButton_9_1.setBounds(105, 674, 85, 51);
		panel_2.add(btnNewButton_9_1);

		JButton btnNewButton_9_2 = new JButton("");
		btnNewButton_9_2.setIcon(new ImageIcon(clientchat.class.getResource("/icon/emoji (2).png")));
		btnNewButton_9_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji2");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9_2.setBounds(200, 674, 85, 51);
		panel_2.add(btnNewButton_9_2);

		JButton btnNewButton_9_3 = new JButton("");
		btnNewButton_9_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji3");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9_3.setIcon(new ImageIcon(clientchat.class.getResource("/icon/emoji (3).png")));
		btnNewButton_9_3.setBounds(296, 674, 85, 51);
		panel_2.add(btnNewButton_9_3);

		JButton btnNewButton_9_4 = new JButton("");
		btnNewButton_9_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji4");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9_4.setIcon(new ImageIcon(clientchat.class.getResource("/icon/emoji (4).png")));
		btnNewButton_9_4.setBounds(394, 674, 85, 51);
		panel_2.add(btnNewButton_9_4);

		JButton btnNewButton_9_5 = new JButton("");
		btnNewButton_9_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF("emoji5");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9_5.setIcon(new ImageIcon(clientchat.class.getResource("/icon/emoji.png")));
		btnNewButton_9_5.setBounds(488, 674, 85, 51);
		panel_2.add(btnNewButton_9_5);

	}
}
