import javax.swing.*;
public class Texto extends Figura {
  JLabel elemento;
  String valor;
  public Texto(JLabel elemento, String nombre, String valor, int tamaño, int x, int y){
    super(elemento, nombre, valor, tamaño, x, y);
    System.out.println("Se ha creado un texto");
    System.out.println(elemento);
  }
  
  public String getValor(){
      return (String)valor;
  }
  public void dibujar(){
      System.out.println("voy a dibujar el texto en el jLabel...");
    elemento.setText(valor);
  }
}
