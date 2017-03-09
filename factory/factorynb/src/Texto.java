import javax.swing.*;
public class Texto extends Figura {
  public Texto(String nombre, Object valor, int tamaño, int x, int y){
    super(nombre, valor, tamaño, x, y);
    System.out.println("Se ha creado un texto");
  }
  
  public String getValor(){
      return (String)valor;
  }
  public Object dibujar(){
    return this.getValor();
  }
}
