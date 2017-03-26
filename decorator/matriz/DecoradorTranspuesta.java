public class DecoradorTranspuesta extends Decorador implements Matriz {
  double[] valores = new double[9];
  public DecoradorTranspuesta(Matriz m){
    super(m);
  }

  public void mostrar_valores(){
    m.mostrar_valores();
    System.out.println("Transpuesta de la matriz");
    transpuesta(m);
  }

  public void transpuesta(Matriz m){
    valores = m.getValores();
    System.out.println("| " + valores[0] + " " + valores[3] + " " + valores[6] + " |");
    System.out.println("| " + valores[1] + " " + valores[4] + " " + valores[7] + " |");
    System.out.println("| " + valores[2] + " " + valores[5] + " " + valores[8] + " |");
  }

  public double [] getValores(){
    return m.getValores();
  }
}
