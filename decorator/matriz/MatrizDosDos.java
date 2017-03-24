public class MatrizDosDos implements Matriz{
  private int [][] valores = new int[2][2];
  public MatrizDosDos(int a, int b, int c, int d){
    valores[0][0] = a;
    valores[0][1] = b;
    valores[1][0] = c;
    valores[1][1] = d;
  }

  public int determinante(){
    return (valores[0][0] * valores[1][1]) - (valores[0][1] * valores[1][0]);
  }
  public void mostrar_valores(){
    System.out.println("Matriz de 2 x 2");
    for(int i = 0; i < valores.length; i++){
      for(int j = 0; j < valores[i].length; j++){
        System.out.print(valores[i][j] + "  ");
      }
      System.out.println();
    }
    System.out.println("determinante: " + determinante());
  }
}
