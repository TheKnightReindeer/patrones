//manejar aquí toda la creación de menú y menuItems
public class MenuTestDrive {
  public static void main(String args[]){
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
    MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert! n_n");
    MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
    //usar el método add, de Composite para agregar cada menú en el primer nivel, allMenus
    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);
    allMenus.add(cafeMenu);
    allMenus.add(dessertMenu);
    //ahora agregar items a cada menú
    dinerMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));
    dinerMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));
    dinerMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));
    dinerMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));
    // cafeMenu.add(dessertMenu); //agregar un menú a un menú
    dessertMenu.add(new MenuItem( "Apple pie", "Apple pie with a flakey crust, topped with vanilla ice cream", true, 1.59, 20));
    pancakeHouseMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));
    pancakeHouseMenu.add(new MenuItem( "Pasta", "spaghetti with marinara sauce, and a slice of sourdough bread", true, 3.89, 10));

    Waitress w = new Waitress(allMenus);
    w.printMenu();
  }
}
