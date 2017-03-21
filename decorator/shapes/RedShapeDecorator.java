//concrete class which extends the ShapeDecorator Class
public class RedShapeDecorator extends ShapeDecorator {
  //Remember: ShapeDecorator is abstract, it cannot create instances
  public RedShapeDecorator(Shape decoratedShape){
    super(decoratedShape);
  }
  @Override
  public void draw(){
    decoratedShape.draw(); //this attribute comes from extended class Decorator
    setRedBorder(decoratedShape);
  }
  private void setRedBorder(Shape decoratedShape){
    System.out.println("Border color: red");
  }
} 
