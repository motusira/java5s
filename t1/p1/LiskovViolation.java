// НАРУШЕНИЕ LSP
class Rectangle {
    protected double width;
    protected double height;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(double width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
        this.width = height;
    }
}

public class LiskovViolation {
    public static void main(String[] args) {
        Rectangle r = new Square();
        r.setWidth(5);
        r.setHeight(4);

        System.out.println("Ожидаемая площадь: 5 * 4 = 20");
        System.out.println("Фактическая площадь: " + r.getArea()); // 16
    }
}
