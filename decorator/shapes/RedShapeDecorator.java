//concrete class which extends the ShapeDecorator Class
//Remember: ShapeDecorator is abstract, it cannot create instances
public class RedShapeDecorator extends ShapeDecorator {
  public RedShapeDecorator(Shape decoratedShape){
    super(decoratedShape);
  }
  @Override
  public void draw(){
    decoratedShape.draw();
    setRedBorder(decoratedShape);
  }
  private void setRedBorder(Shape decoratedShape){
    System.out.println("Border color: red");
  }
} 
