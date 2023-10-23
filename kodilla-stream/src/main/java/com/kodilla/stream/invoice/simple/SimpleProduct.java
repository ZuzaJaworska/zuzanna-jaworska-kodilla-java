package com.kodilla.stream.invoice.simple;

import java.util.Objects;

public class SimpleProduct {

    private final String productName;
    private final double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct that = (SimpleProduct) o;
        if (Double.compare(productPrice, that.productPrice) != 0) return false;
        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName != null ? productName.hashCode() : 0;
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
