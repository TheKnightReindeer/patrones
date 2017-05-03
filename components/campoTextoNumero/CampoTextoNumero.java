import javax.swing.*;
import java.awt.event.*;

public class CampoTextoNumero extends JTextField implements KeyListener {
  private int limMax;
  private int limMin;

  public CampoTextoNumero(){
    super();
    limMax = 10;
    limMin = 1;
    setColumns(limMax);
    addKeyListener(this);

    //esto se ve tremendamente feo
    setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String cadena = tf.getText();
        if(cadena.length() == 0){
          System.out.println("ingrese un número entre: " + getLimMin() + " y " + getLimMax());
          return false;
        }
        if(Integer.parseInt(cadena) < getLimMin()){
          System.out.println("debe ingresar un número no menor a: " + getLimMin());
          return false;
        }
        if(Integer.parseInt(cadena) > getLimMax()){
          System.out.println("debe ingresar un número no mayor a: " + getLimMax());
          return false;
        }
        return true;
      }
    });

  }

  public void setLimMax(int v){
    if(v >= limMin){
      limMax = v;
    }else{
      limMax = limMin;
    }
  }

  public int getLimMax(){
    return limMax;
  }
 
  public int getLimMin(){
    return limMin;
  }

  public void setLimMin(int v){
    if(v < 0){
      limMin = limMax;
    }
    if(v > limMax){
      limMin = limMax - 1;
    }else{
      limMin = v;
    }
  }

  @Override
  public void keyPressed(KeyEvent e){

  }

  @Override
  public void keyTyped(KeyEvent e) {
    char caracter = e.getKeyChar();
    if(caracter < '0' || caracter > '9'){
      e.consume();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
