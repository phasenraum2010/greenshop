package org.woehlke.greenshop.oodm.catalog.model;

import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.entities.Special;

/**
 * Created by tw on 27.12.14.
 */
public class SpecialProduct {

    private Special special;
    private ProductDescription productDescription;

    public boolean isSpecialProduct(){
        return special != null;
    }

    public long getPercentage(){
        double oldPrice=productDescription.getProduct().getPrice();
        double newPrice=special.getNewPrice();
        double percentage = 100.0d*newPrice/oldPrice;
        return 100L-Math.round(percentage);
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialProduct)) return false;

        SpecialProduct that = (SpecialProduct) o;

        if (productDescription != null ? !productDescription.equals(that.productDescription) : that.productDescription != null)
            return false;
        if (special != null ? !special.equals(that.special) : that.special != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = special != null ? special.hashCode() : 0;
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SpecialProduct{" +
                "special=" + special +
                ", productDescription=" + productDescription +
                '}';
    }
}
