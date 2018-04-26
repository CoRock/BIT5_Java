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

       image = new ImageIcon("C:\\Users\\user\\Desktop\\java파일\\Chat\\src\\lion.jpg");
       jframe = new JFrame("감성톡톡");
       //login = new JFrame("로그인창");//로그인로그인
       jframe.setSize(600,800);
       //login.setSize(600,800);//로그인로그인
       jtf = new JTextField(30);

       // jta = new JTextArea("", 10, 50);
       jtp = new JTextPane();
       jtp.setPreferredSize(new Dimension(100, 500));
       jlb1 = new JLabel("초기ID : [ " + id + "]");
       jlb2 = new JLabel();
       jlb3 = new JLabel("IP : " + ip);
       
      /* loginjl = new JLabel("환영합니당♥");//로그인로그인
       loginjb1 = new JButton("login");//로그인로그인
       loginjb2 = new JButton("exit");//로그인로그인
*/       
       jbtn = new JButton("이모티콘");
       jp1 = new JPanel();
       jp2 = new JPanel();
       
     
       /*jlb1.setBackground(Color.red);
       jlb2.setBackground(Color.red);
       jlb3.setBackground(Color.red);*/
       // jta.setBackground(Color.pink);
  
       /*     login.setLayout(new GridLayout(3, 2, 10, 10));
       loginjl.setOpaque(true); 
       loginjl.setBackground(Color.RED);
       loginjb1.setBackground(Color.LIGHT_GRAY);//로그인로그인
       loginjb1.setFont(new Font("HY엽서L", Font.PLAIN, (int) 10));//로그인로그인
       loginjb2.setBackground(Color.GREEN);//로그인로그인
       loginjb2.setFont(new Font("HY엽서L", Font.PLAIN, (int) 10));//로그인로그인
*/       
       
       jtp.setBackground(Color.PINK);//대화창 보이는 팬
       jp1.setLayout(new BorderLayout());
       jp2.setLayout(new BorderLayout());
       jp1.add(jbtn, BorderLayout.EAST);
       jp1.add(jtf, BorderLayout.CENTER);
       jp2.add(jlb1, BorderLayout.WEST);
       jp2.add(jlb2, BorderLayout.CENTER);
       jp2.add(jlb3, BorderLayout.EAST);
       
       /*login.add(loginjl);//로그인로그인
       login.add(loginjb1);//로그인로그인
       login.add(loginjb2);//로그인로그인
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
                   oos.writeObject(id + "#exit"); // x표시로 종료이벤트가 발생하면 id+#exit 아웃스트림으로 전송
               } catch (IOException ee) {
                   ee.printStackTrace();
               }
               System.exit(0);
           }

           public void windowOpened(WindowEvent e) {
               jtf.requestFocus(); // 창이열리면 글쓰는공간에 포커스맞춰짐
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
       Object obj = e.getSource(); // 누른것의 객체를 obj 에 저장
       String msg = jtf.getText();
       String str = e.getActionCommand();
       	
       /*if (str.equals("Login")) {			//로그인창ㅜㅗㅗㅗ햐ㅕㅗㅑㅕㅐㅗㅕㅑㅗㅑㅗ
			jframe.setVisible(true);
			login.setVisible(false);
		}
       
       if (str.equals("exit")) {//로그인로그인
			System.exit(0);
		}*/
       
       
       if (obj == jtf) { // 누른것이 텍스트필드이면
           if (msg == null || msg.length() == 0) { // 글을 쓰지않으면 경고창 띄워줌
               JOptionPane.showMessageDialog(jframe, "글을쓰세요", "경고", JOptionPane.WARNING_MESSAGE);
           } else { // 글이있으면 id + # + 내용 을 아웃스트림전송
               try {
                   oos.writeObject(id + "#" + msg);
               } catch (IOException ee) {
                   ee.printStackTrace();
               }
               jtf.setText(""); // 글을쓰면 텍스트필드 초기화
           }
       } else if (obj == jbtn) { // 누른것이 이모티콘버튼이면
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
       MultiClient cc = new MultiClient("172.22.234.106","원하는 닉네임으로changeしてください");
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
       jtp.insertIcon(new ImageIcon("C:\\Users\\user\\Desktop\\java파일\\Chat\\src\\lion.jpg"));
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
		jtp.setText(""); // 초기화되고
		jtf.requestFocus();
	}
    
   public void vote() {
       votf = new JFrame("강퇴투표");
       votf.setBounds(900, 500, 100, 100);;
       bt1 = new JButton("찬성");
       bt2 = new JButton("반대");
       votf.add(bt1,BorderLayout.WEST);
       votf.add(bt2,BorderLayout.EAST);
       votf.setVisible(true);
       bt1.addActionListener(this);
       bt2.addActionListener(this);
   }
}