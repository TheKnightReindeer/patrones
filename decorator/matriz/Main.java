public class Main {
  public static void main(String args []){
    // Matriz m1 = new MatrizTresTres(2.0, 5.0, 6.0, 1.0, 4.0, 3.0, 1.0, 8.0, 4.0);
    // matriz sin inversa:
    // Matriz m1 = new MatrizTresTres(1.0, 2.0, 0.0, 3.0, -1.0, 2.0, -2.0, 3.0, -2.0);
    // matriz que su inversa son números enteros:
    Matriz m1 = new MatrizTresTres(1, -1, 0, 1, 0, -1, -6, 2, 3);
    m1.mostrar_valores();
    m1 = new DecoradorTranspuesta(m1);
    m1 = new DecoradorInversa(m1);
    m1.mostrar_valores();
  }
}
