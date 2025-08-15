package Second_2;

import java.util.Objects;

public class Rectangle {

	private double width;
	private double height;
	
	public Rectangle() {}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (getClass() != obj.getClass() || obj == null) return false;
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle = [width: %s, height: %s]", width, height);
	}

}
