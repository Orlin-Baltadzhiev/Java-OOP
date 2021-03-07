package Math;

public class Circle extends Shape {
    private Double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (this.getPerimeter() != null) {
            return getPerimeter();
        }
            Double param = 2 * Math.PI * this.radius;
            super.setPerimeter(param);

        return param;
    }

    @Override
    public Double calculateArea() {
        if(this.getArea() != null){
            return this.getArea();
        }
        Double area = Math.PI*this.radius*this.radius;
        this.setArea(area);
        return area;
    }

    public final Double getRadius() {
        return radius;
    }
}
