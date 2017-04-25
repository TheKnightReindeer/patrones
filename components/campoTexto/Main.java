import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
  private JFrame v;
  private JPanel p;

  public Main(){
    v = new JFrame();
    p = new JPanel(new FlowLayout());
    v.add(p);
    v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    v.setSize(320, 240);
    v.setVisible(true);
  }

  public void agregar(JTextField c){
    p.add(c);
  }

  public static void main(String args[]){
    Main f = new Main();
    CampoTexto c1 = new CampoTexto();
    f.agregar(c1);
  }
}
