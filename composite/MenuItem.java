public class MenuItem extends MenuComponent { 
  //extender la interface MenuComponent
  String name;
  String description;
  boolean vegetarian;
  double price;
  //modificacion 1
  int cantidad;
  //numero de elementos simples que tiene cada menú

  public MenuItem(
    //construir los objetos tal como la implementación de iterador
    String name,
    String description,
    boolean vegetarian,
    double price,
    int cantidad){
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
    this.cantidad = cantidad;
    }

  //métodos get
  public String getName(){
    return name;
  }
  public String getDescription(){
    return description;
  }
  public double getPrice(){
    return price;
  }
  public boolean isVegetarian(){
    return vegetarian;
  }
  public int getCantidad(){
    return cantidad;
  }
  //métodos get
  //override the print method from MenuComponent
  public void print(){
    System.out.print(" " + getName());
    if(isVegetarian()){
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("   -- " + getDescription() + " cantidad: " + getCantidad());
    System.out.println("cantidad: " + getCantidad());
  }
}
