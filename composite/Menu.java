//composite class
//puede guardar MenuItems o Menús
//no implementa getPrice, tampoco isVegetarian,
//ya que esos métodos son para items INDIVIDUALES
//no tendría sentido aplicarlos a un menú

import java.util.ArrayList;
import java.util.Iterator;
@SuppressWarnings("unchecked")
public class Menu extends MenuComponent {
  ArrayList menuComponents = new ArrayList();
  String name;
  String description;
  //agregar atributo cantidad de elementos
  protected int numberOfElements;

  public Menu(String name, String description){
    this.name = name;
    this.description = description;
  }
  public void add(MenuComponent menuComponent){
    menuComponents.add(menuComponent);
    if(menuComponent instanceof MenuItem){
      numberOfElements++;
    }
  }
  public void remove(MenuComponent menuComponent){
    menuComponents.remove(menuComponent);
  }
  public MenuComponent getChild(int i){
    return (MenuComponent)menuComponents.get(i);
  }
  public String getName(){
    return name;
  }
  public String getDescription(){
    return description;
  }
  public int getNumberOfElements(){
    return numberOfElements;
  }
  public void print(){
    System.out.println("\n "+ getName());
    System.out.println(", " + getDescription());
    System.out.println("Total de elementos: " + getNumberOfElements());
    System.out.println("---------------------");
    
    //se usa un iterador para imprimir todos los
    //componentes, sean Menús o MenuItems
    Iterator iterator = menuComponents.iterator();
    while(iterator.hasNext()){
      MenuComponent menuComponent = (MenuComponent)iterator.next();
      menuComponent.print();
    }
  }
}
