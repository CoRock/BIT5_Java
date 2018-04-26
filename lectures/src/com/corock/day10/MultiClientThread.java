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
                message = (String) mc.getOis().readObject(); // message 에 닉네임#내용 << 으로 저장
                System.out.println(message);
                receivedMsg = message.split("#"); // receivedMsg[0] 닉네임 , receivedMsg[1] 내용
                wmessage = receivedMsg[1].split(" ");
            } catch (Exception e) {
                e.printStackTrace();
                isStop = true;
            }
            System.out.println(receivedMsg[0] + "," + receivedMsg[1]); // 닉네임,내용 으로 표시
            if (receivedMsg[1].equals("exit")) { // 내용이 exit 이면
                if (receivedMsg[0].equals(mc.getId())) { // 닉네임비교후 내꺼면 종료 아니면 ta에 종료텍스트출력
                    mc.exit();
                } else {
                    mc.append(receivedMsg[0] + "님이 종료 하셨습니다." + System.getProperty("line.separator"));
                    mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                }
            } else if (receivedMsg[0].equals("vote")) { // 내용이 /vote 이면
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
                mc.append("현재접속인원 :"+numStr2+System.getProperty("line.separator"));
                for(int i=0;i<receivedMsg.length;i++){
                   mc.append(receivedMsg[i]+System.getProperty("line.separator"));
                }     
            }
            
            else if (receivedMsg[0].equals("voteresult")) { // 내용이 /voteresult 이면
                count = 0;
                if (receivedMsg[1].equals("voteag")) {
                    if (votename.equals(mc.getId())) {
                        mc.exit();
                    }else {
                        mc.append(votename + "님이 강퇴 당하였습니다." + System.getProperty("line.separator"));
                        mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                    }
                } else if (receivedMsg[1].equals("voteop")) {
                    mc.append("강퇴가 반대 되었습니다." + System.getProperty("line.separator"));
                    mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
                }
            } else if (wmessage[0].equals("/w")) { // 내용이 /w 이면
                if (wmessage[1].equals(mc.getId())) {
                    mc.append(wmessage[1] + "<<" + receivedMsg[0] + " : " + wmessage[2]
                            + System.getProperty("line.separator"));
                }
                if (receivedMsg[0].equals(mc.getId())) {
                    mc.append(receivedMsg[0] + ">>" + wmessage[1] + " : " + wmessage[2]
                            + System.getProperty("line.separator"));
                }
            } else if (wmessage[0].equals("/change")) { // 내용이 /change 이면
                if (receivedMsg[0].equals(mc.getId())) {
                    mc.setId(wmessage[1]);
                    mc.getJlb1().setText("Usage ID : [ " + mc.getId() + "]");
                }
                mc.append(receivedMsg[0] + "님이 닉네임을 변경하였습니다. (" + receivedMsg[0] + " >> " + wmessage[1] + ")"
                        + System.getProperty("line.separator"));
            } else if (wmessage[0].equals("imo")) { // 내용이 /imo 이면
                mc.setImo();
                mc.getJtp().setCaretPosition(mc.getJtp().getDocument().getLength());
            } else if (wmessage[0].equals("/vote")) { // 내용이 /vote 이면
                mc.append(wmessage[1] + "님의 강퇴 투표가 시작되었습니다." + System.getProperty("line.separator"));
                votename = wmessage[1];
                voteck = true;
            } else { // 내용이 exit 가 아니면 ta 에 내용출력
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