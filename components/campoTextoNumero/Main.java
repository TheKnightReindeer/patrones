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
    v.setSize(200, 200);
    v.setVisible(true);
  }

  public void agregar(JTextField c){
    p.add(c);
  }

  public static void main(String args[]){
    Main f = new Main();
    CampoTextoNumero c1 = new CampoTextoNumero();
    c1.setLimMax(100);
    CampoTextoNumero c2 = new CampoTextoNumero();
    CampoTextoNumero c3 = new CampoTextoNumero();
    CampoTextoNumero c4 = new CampoTextoNumero();
    f.agregar(c1);
    f.agregar(c2);
    f.agregar(c3);
    f.agregar(c4);
  }
}
