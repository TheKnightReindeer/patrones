public class MenuItem extends MenuComponent { 
  //extender la interface MenuComponent
  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(
    //construir los objetos tal como la implementación
    //de iterador
    String name,
    String description,
    boolean vegetarian,
    double price){
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
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
  //métodos get
  //override the print method from MenuComponent
  public void print(){
    System.out.print(" " + getName());
    if(isVegetarian()){
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("   -- " + getDescription());
  }
}
