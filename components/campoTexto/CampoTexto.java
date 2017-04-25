import javax.swing.JTextField;
import java.io.Serializable;
import java.awt.event.*;

public class CampoTexto extends JTextField implements Serializable, KeyListener {
  private int longMax;
  private int longMin;

  public CampoTexto(){
    super();
    longMax = 4;
    longMin = 4;
    setColumns(longMax);
    addKeyListener(this);
  }
  
  public void setLongMax(int v){
    if(v >= longMin){
      longMax = v;
    }else{
      longMax = longMin;
    }
  }

  public int getLongMax(){
    return longMax;
  }

  public void setLongMin(int v){
    if(v < 0){
      longMin = longMax;
    }
    if(v > longMax){
      longMin = longMax - 1;
    }else{
      longMin = v;
    }
  }

  @Override
  public void keyPressed(KeyEvent e){

  }

  @Override
  public void keyTyped(KeyEvent e) {
    char caracter = e.getKeyChar();
    if(caracter >= '0' && caracter <= '9'){
      e.consume();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
