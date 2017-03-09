public abstract class Figura {
  protected String nombre;
  protected Object valor;
  protected int tamaño;
  protected int posicionx;
  protected int posiciony;
  protected Object elemento;

  public Figura(String n, Object v, int t, int x, int y){ 
    nombre = n;
    valor = v;
    tamaño = t;
    posicionx = x;
    posiciony = y;
  }
  public Object getValor(){
     return valor;
  }
  public abstract Object dibujar();//mostrar el elemento
  //String para texto, Graphic para poligono
  
  public void trasladar(int x, int y){ 
    System.out.println("antigua posición: (" + posicionx + " , " + posiciony + ")");
    posicionx = x;
    posiciony = y;
    System.out.println("nueva posición: (" + posicionx + " , " + posiciony + ")");
  }
  public void escalar(int r){ 
    System.out.println("antiguo tamaño: " + tamaño);
    tamaño = tamaño * r;
    System.out.println("nuevo tamaño: " + tamaño);
  }
}
