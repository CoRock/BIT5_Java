import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class MultiClient implements ActionListener {
   private Socket socket;
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   private JFrame jframe,login,votf;
   private JTextField jtf;
   // private JTextArea jta;
   private JLabel jlb1, jlb2, jlb3,loginjl;
   private JPanel jp1, jp2;
   private String ip;
   private String id;
   private JButton jbtn,bt1,bt2,loginjb1,loginjb2;
   private JTextPane jtp;
   private ImageIcon image;
    
   public MultiClient(String argIp, String argId) {
       ip = argIp;
       id = argId;

       image = new ImageIcon("C:\\Users\\user\\Desktop\\java����\\Chat\\src\\lion.jpg");
       jframe = new JFrame("��������");
       //login = new JFrame("�α���â");//�α��ηα���
       jframe.setSize(600,800);
       //login.setSize(600,800);//�α��ηα���
       jtf = new JTextField(30);

       // jta = new JTextArea("", 10, 50);
       jtp = new JTextPane();
       jtp.setPreferredSize(new Dimension(100, 500));
       jlb1 = new JLabel("�ʱ�ID : [ " + id + "]");
       jlb2 = new JLabel();
       jlb3 = new JLabel("IP : " + ip);
       
      /* loginjl = new JLabel("ȯ���մϴ碾");//�α��ηα���
       loginjb1 = new JButton("login");//�α��ηα���
       loginjb2 = new JButton("exit");//�α��ηα���
*/       
       jbtn = new JButton("�̸�Ƽ��");
       jp1 = new JPanel();
       jp2 = new JPanel();
       
     
       /*jlb1.setBackground(Color.red);
       jlb2.setBackground(Color.red);
       jlb3.setBackground(Color.red);*/
       // jta.setBackground(Color.pink);
  
       /*     login.setLayout(new GridLayout(3, 2, 10, 10));
       loginjl.setOpaque(true); 
       loginjl.setBackground(Color.RED);
       loginjb1.setBackground(Color.LIGHT_GRAY);//�α��ηα���
       loginjb1.setFont(new Font("HY����L", Font.PLAIN, (int) 10));//�α��ηα���
       loginjb2.setBackground(Color.GREEN);//�α��ηα���
       loginjb2.setFont(new Font("HY����L", Font.PLAIN, (int) 10));//�α��ηα���
*/       
       
       jtp.setBackground(Color.PINK);//��ȭâ ���̴� ��
       jp1.setLayout(new BorderLayout());
       jp2.setLayout(new BorderLayout());
       jp1.add(jbtn, BorderLayout.EAST);
       jp1.add(jtf, BorderLayout.CENTER);
       jp2.add(jlb1, BorderLayout.WEST);
       jp2.add(jlb2, BorderLayout.CENTER);
       jp2.add(jlb3, BorderLayout.EAST);
       
       /*login.add(loginjl);//�α��ηα���
       login.add(loginjb1);//�α��ηα���
       login.add(loginjb2);//�α��ηα���
*/       
       jframe.add(jp1, BorderLayout.SOUTH);
       jframe.add(jp2, BorderLayout.NORTH);
       // JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
       // JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       // jframe.add(jsp, BorderLayout.CENTER);
       JScrollPane jsp = new JScrollPane(jtp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       jframe.add(jsp, BorderLayout.CENTER);

       jtf.addActionListener(this);
       jbtn.addActionListener(this);
       jframe.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
               try {
                   oos.writeObject(id + "#exit"); // xǥ�÷� �����̺�Ʈ�� �߻��ϸ� id+#exit �ƿ���Ʈ������ ����
               } catch (IOException ee) {
                   ee.printStackTrace();
               }
               System.exit(0);
           }

           public void windowOpened(WindowEvent e) {
               jtf.requestFocus(); // â�̿����� �۾��°����� ��Ŀ��������
           }
       });
       // jta.setEditable(false);
       jtp.setEditable(false);
       Toolkit tk = Toolkit.getDefaultToolkit();
       Dimension d = tk.getScreenSize();
       int screenHeight = d.height;
       int screenWidth = d.width;
       //jframe.pack();
       jframe.setLocation((screenWidth - jframe.getWidth()) / 2, (screenHeight - jframe.getHeight()) / 2);
       jframe.setResizable(false);
       jframe.setVisible(true);


/*
		login.setLocation((screenWidth - jframe.getWidth()) / 2, (screenHeight - jframe.getHeight()) / 2);
		login.setResizable(false);
		login.setVisible(true);*/
   }

   public void actionPerformed(ActionEvent e) {
       Object obj = e.getSource(); // �������� ��ü�� obj �� ����
       String msg = jtf.getText();
       String str = e.getActionCommand();
       	
       /*if (str.equals("Login")) {			//�α���â�̤ǤǤ���ŤǤ��Ť��ǤŤ��Ǥ���
			jframe.setVisible(true);
			login.setVisible(false);
		}
       
       if (str.equals("exit")) {//�α��ηα���
			System.exit(0);
		}*/
       
       
       if (obj == jtf) { // �������� �ؽ�Ʈ�ʵ��̸�
           if (msg == null || msg.length() == 0) { // ���� ���������� ���â �����
               JOptionPane.showMessageDialog(jframe, "����������", "���", JOptionPane.WARNING_MESSAGE);
           } else { // ���������� id + # + ���� �� �ƿ���Ʈ������
               try {
                   oos.writeObject(id + "#" + msg);
               } catch (IOException ee) {
                   ee.printStackTrace();
               }
               jtf.setText(""); // �������� �ؽ�Ʈ�ʵ� �ʱ�ȭ
           }
       } else if (obj == jbtn) { // �������� �̸�Ƽ�ܹ�ư�̸�
           try {
               oos.writeObject(id + "#" + "imo");
           } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
           }
       } else if(obj == bt1) {
           System.out.println(bt1.getText());
           try {
               oos.writeObject(id + "#" + "voteag");
           } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
           }
           votf.dispose();
       }else if(obj == bt2){
           System.out.println(bt2.getText());
           try {
               oos.writeObject(id + "#" + "voteop");
           } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
           }
           votf.dispose();
       }
   }

   public void exit() {
       System.exit(0);
   }

   public void init() throws IOException {
       socket = new Socket(ip, 7777);
       System.out.println("connected...");
       oos = new ObjectOutputStream(socket.getOutputStream());
       ois = new ObjectInputStream(socket.getInputStream());
       MultiClientThread ct = new MultiClientThread(this);
       Thread t = new Thread(ct);
       t.start();
   }

   public static void main(String args[]) throws IOException {
       MultiClient cc = new MultiClient("172.22.234.106","���ϴ� �г�������change���ƪ�������");
       cc.init();
      
   }

   public ObjectInputStream getOis() {
       return ois;
   }
    
   public ObjectOutputStream getOos() {
       return oos;
   }

   public JTextPane getJtp() {
       return jtp;
   }
    
   public JLabel getJlb1() {
       return jlb1;
   }
    
   public void setImo() {
       jtp.insertIcon(new ImageIcon("C:\\Users\\user\\Desktop\\java����\\Chat\\src\\lion.jpg"));
       append(System.getProperty("line.separator"));
  
   
   }
   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }

   public void append(String s) {
       try {
           Document doc = jtp.getDocument();
           doc.insertString(doc.getLength(), s, null);
       } catch (BadLocationException exc) {
           exc.printStackTrace();
       }
   }
   public void Clear() {
		jtp.setText(""); // �ʱ�ȭ�ǰ�
		jtf.requestFocus();
	}
    
   public void vote() {
       votf = new JFrame("������ǥ");
       votf.setBounds(900, 500, 100, 100);;
       bt1 = new JButton("����");
       bt2 = new JButton("�ݴ�");
       votf.add(bt1,BorderLayout.WEST);
       votf.add(bt2,BorderLayout.EAST);
       votf.setVisible(true);
       bt1.addActionListener(this);
       bt2.addActionListener(this);
   }
}