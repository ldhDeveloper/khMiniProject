package marble.run;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import marble.controller.ServerBackground;
 
public class ServerGui extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
    private JTextArea jta = new JTextArea(40, 25);
    private JTextField jtf = new JTextField(25);
    private ServerBackground server = new ServerBackground();
    private JScrollPane scroll = new JScrollPane(jta);
    
    public ServerGui() throws IOException {
    	
        add(scroll, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200, 100, 400, 600);
        setTitle("서버 구동중");
 
        server.setGui(this);
        server.start();
    }
 
    public static void main(String[] args) throws IOException {
        new ServerGui();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "서버 : "+ jtf.getText() + "\n";
        System.out.print(msg);
        server.sendMessage(msg);
        jtf.setText("");
    }
 
    public void appendMsg(String msg) {
    	jta.append(msg);
    	jta.setCaretPosition(jta.getDocument().getLength());
    }
 
}