import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class CampoTextoNumero extends JTextField implements KeyListener {
  private int limMax;
  private int limMin;
  private int decimales;

  public CampoTextoNumero(){
    super();
    limMax = 10;
    limMin = 1;
    decimales = 2;
    setColumns(limMax);
    addKeyListener(this);

    //esto se ve tremendamente feo
    setInputVerifier(new InputVerifier() {
      public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String cadena = tf.getText();
        // System.out.println(cadena.substring(cadena.indexOf('.') + 1, cadena.length()));
        if(cadena.length() == 0){
          System.out.println("ingrese un número entre: " + getLimMin() + " y " + getLimMax());
          return false;
        }
        if(!Pattern.matches("\\d*\\.?\\d+", cadena)){
          System.out.println("ingrese un solo punto decimal");
          return false;
        }
        String decs = cadena.substring(cadena.indexOf('.') + 1, cadena.length());
        if(decs.length() < getDecimales()){
          System.out.println("ingrese al menos: " + getDecimales() + " decimales");
          return false;
        }
        try{
          if(Double.parseDouble(cadena) < (double)getLimMin()){
            System.out.println("debe ingresar un número mayor a: " + getLimMin());
            return false;
          }
          if(Double.parseDouble(cadena) > (double)getLimMax()){
            System.out.println("debe ingresar un número menor a: " + getLimMax());
            return false;
          }
          if(Integer.parseInt(cadena) < getLimMin()){
            System.out.println("debe ingresar un número mayor a: " + getLimMin());
            return false;
          }
          if(Integer.parseInt(cadena) > getLimMax()){
            System.out.println("debe ingresar un número menor a: " + getLimMax());
            return false;
          }
        } catch(Exception e){}
        return true;
      }
    });

  }

  public int getLimMax(){
    return limMax;
  }

  public int getLimMin(){
    return limMin;
  }

  public int getDecimales(){
    return decimales;
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

  public void setLimMax(int v){
    if(v >= limMin){
      limMax = v;
    }else{
      limMax = limMin;
    }
  }

  public void setDecimales(int v){
    if(v < 0){
      decimales = 2;
    }else{
      decimales = v;
    }
  }

  @Override
  public void keyPressed(KeyEvent e){
  }

  @Override
  public void keyTyped(KeyEvent e) {
    char caracter = e.getKeyChar();
    if((caracter < '0' || caracter > '9') && caracter != '.'){
      e.consume();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
