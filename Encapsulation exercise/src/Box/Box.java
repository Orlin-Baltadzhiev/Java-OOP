package Box;

public class Box {
    private double length;
    private double width;
    private double height;
    private Double surfaceArea;
    private Double lateralSurfaceArea;
    private Double volume;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.height = height;

    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f%n", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }

    public double calculateVolume() {
        return this.width * this.length * this.height;
    }

    public double calculateSurfaceArea() {
        if (this.surfaceArea ==null){
            return this.surfaceArea =2 * this.length * this.width + this.calculateLateralSurfaceArea();
        }

        return this.surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }
}
