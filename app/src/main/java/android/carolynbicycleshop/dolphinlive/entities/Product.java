package android.carolynbicycleshop.dolphinlive.entities;

import kotlin.experimental.ExperimentalTypeInference;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Project: Dolphin Live
 * Package: android.carolynbicycleshop.dolphinlive.entities
 * <p>
 * User: carolyn.sher
 * Date: 12/3/2022
 * Time: 3:43 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int productID;
    private String productName;
    private double productPrice;

    public Product(int productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
