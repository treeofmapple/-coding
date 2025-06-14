package OperUsers;

import java.util.Objects;

public class ComplexNumber {
    public int real;
    public int image;

    public ComplexNumber(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public String showC() {
        return this.real + " + " + this.image + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return real == that.real && image == that.image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, image);
    }
}
