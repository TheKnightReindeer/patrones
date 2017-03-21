//using RedShapeDecorator to decorate Shape objects
public class Main {
  public static void main(String args[]){
    Shape circle = new Circle();
    //can decorate in one step
    Shape redCircle = new RedShapeDecorator(new Circle());
    //or in two
    Shape redRectangle = new Rectangle();
    redRectangle = new RedShapeDecorator(redRectangle);

    System.out.println("Normal circle");
    circle.draw();

    System.out.println("\nCirle with red border");
    redCircle.draw();

    System.out.println("\nRectangle with red border");
    redRectangle.draw();
  }
}
