// Соблюдение LSP: нет наследования между Square и Rectangle
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

public class LiskovCompliance {
    public static void printArea(Shape shape) {
        System.out.println("Площадь: " + shape.getArea());
    }

    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 4);
        Shape sq = new Square(5);

        printArea(rect); // 20.0
        printArea(sq);   // 25.0
    }
}
