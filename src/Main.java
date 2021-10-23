import view.MainMenu;

public class Main {
    public static void main(String[] args) {
//        View view = new View();
//        view.run();
//        MainMenu mainMenu = new MainMenu("Main Menu" , null);
//        mainMenu.show();
//        mainMenu.execute();

        DrawingClass drawingClass = new DrawingClass();
        Shape4 shape = new Shape4();
        Shape3 shape1 = new Shape3();
        drawingClass.drawWithDrawingClass(shape1);

    }


}
class Shape {
    private int size;

    public String draw(){
        return "Shape";
    }
}
class Shape2 extends Shape{
    @Override
    public String draw() {
        return("Shape2 !!!!");
    }
}
class Shape3 extends Shape{
    @Override
    public String draw() {
        return("Shape3 !!!!");
    }
}
class Shape4 extends Shape{
    @Override
    public String draw() {
        return("Shape4 !!!!");
    }
}
class DrawingClass{
    public void drawWithDrawingClass(Shape shape){
        System.out.println(shape.draw());
    }
}
