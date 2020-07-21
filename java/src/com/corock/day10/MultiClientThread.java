import java.io.IOException;

public class MultiClientThread extends Thread {
    private int count = 0, count1 = 0;
    private MultiClient mc;
 
    public MultiClientThread(MultiClient mc) {
        this.mc = mc;
    }
 
    public void run() {
        String message = null;
        String votename = null;
        String[] receivedMsg = null, wmessage = null;
        boolean voteck = false;
        boolean isStop = false;
        while (!isStop) {
            try {
                message = (String) mc.getOis().readObject(); // message �� �г���#���� << ���� ����
                System.out.println(message);
                receivedMsg = message.split("#"); // receivedMsg[0] �г��� , receivedMsg[1] ����
                wmessage = receivedMsg[1].split(" ");
            } catch (Exception e) {
                e.printStackTrace();
                isStop = true;
            }
            System.out.println(receivedMsg[0] + "," + receivedMsg[1]); // �г���,���� ���� ǥ��
            if (receivedMsg[1].equals("exit")) { // ������ exit �̸�
                if (receivedMsg[0].equals(mc.getId())) { // �г��Ӻ��� ������ ���� �ƴϸ� ta�� �����ؽ�Ʈ���
                    mc.exit();
                } else {
                    mc.append(receivedMsg[0] + "���� ���� �ϼ̽��ϴ�." + System.getProperty("line.separator"));
                    mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                }
            } else if (receivedMsg[0].equals("vote")) { // ������ /vote �̸�
                if(receivedMsg[2].equals("ag")) {
                    count1 = Integer.parseInt(receivedMsg[4])+1;
                }else if(receivedMsg[1].equals("/clear")){               
                    mc.Clear();
                }else if(receivedMsg[2].equals("op")){
                    count1 = Integer.parseInt(receivedMsg[4]);
                }
                count = Integer.parseInt(receivedMsg[3])+1;
                try {
                    mc.getOos().writeObject("count#"+count+"#"+count1);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mc.append(receivedMsg[1] + System.getProperty("line.separator"));
            }
            else if(receivedMsg[1].equals("/list")){               
                int len =receivedMsg.length-1;
                String numStr2 = String.valueOf(len);
                mc.append("���������ο� :"+numStr2+System.getProperty("line.separator"));
                for(int i=0;i<receivedMsg.length;i++){
                   mc.append(receivedMsg[i]+System.getProperty("line.separator"));
                }     
            }
            
            else if (receivedMsg[0].equals("voteresult")) { // ������ /voteresult �̸�
                count = 0;
                if (receivedMsg[1].equals("voteag")) {
                    if (votename.equals(mc.getId())) {
                        mc.exit();
                    }else {
                        mc.append(votename + "���� ���� ���Ͽ����ϴ�." + System.getProperty("line.separator"));
                        mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                    }
                } else if (receivedMsg[1].equals("voteop")) {
                    mc.append("���� �ݴ� �Ǿ����ϴ�." + System.getProperty("line.separator"));
                    mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                }
            } else if (wmessage[0].equals("/w")) { // ������ /w �̸�
                if (wmessage[1].equals(mc.getId())) {
                    mc.append(wmessage[1] + "<<" + receivedMsg[0] + " : " + wmessage[2]
                            + System.getProperty("line.separator"));
                }
                if (receivedMsg[0].equals(mc.getId())) {
                    mc.append(receivedMsg[0] + ">>" + wmessage[1] + " : " + wmessage[2]
                            + System.getProperty("line.separator"));
                }
            } else if (wmessage[0].equals("/change")) { // ������ /change �̸�
                if (receivedMsg[0].equals(mc.getId())) {
                    mc.setId(wmessage[1]);
                    mc.getJlb1().setText("Usage ID : [ " + mc.getId() + "]");
                }
                mc.append(receivedMsg[0] + "���� �г����� �����Ͽ����ϴ�. (" + receivedMsg[0] + " >> " + wmessage[1] + ")"
                        + System.getProperty("line.separator"));
            } else if (wmessage[0].equals("imo")) { // ������ /imo �̸�
                mc.setImo();
                mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
            } else if (wmessage[0].equals("/vote")) { // ������ /vote �̸�
                mc.append(wmessage[1] + "���� ���� ��ǥ�� ���۵Ǿ����ϴ�." + System.getProperty("line.separator"));
                votename = wmessage[1];
                voteck = true;
            } else { // ������ exit �� �ƴϸ� ta �� �������
                mc.append(receivedMsg[0] + " : " + receivedMsg[1] + System.getProperty("line.separator"));
                mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
            }
 
            if (voteck) {
                mc.vote();
                voteck = false;
            }
        }
    }
}