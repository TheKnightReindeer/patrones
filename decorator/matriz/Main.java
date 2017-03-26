public class Main {
  public static void main(String args []){
    Matriz m1 = new MatrizTresTres(2.0, 5.0, 6.0, 1.0, 4.0, 3.0, 1.0, 8.0, 4.0);
    m1.mostrar_valores();
    // m1 = new DecoradorInversa(m1);
    m1 = new DecoradorTranspuesta(m1);
    m1.mostrar_valores();
  }
}
