package electronics_wherehouse;
/**
 * This program implements an application that
 * does the following ................
 /** declares product variables
 /** Contains constructors for product
 /** Contains getters and setters
 /** Contains a too string for the constructors
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productCost;
    private String productInStock;
    private String productCategory;

    public Product(int productId, String productName, String productDescription, double productCost, String productInStock, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productInStock = productInStock;
        this.productCategory = productCategory;
    }

    public Product(int productId, String productName, String productDescription, double productCost, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productCategory = productCategory;
    }

    //Getters and Setters

    public int getProductId() {

        return productId;
    }

    public void setId(int productId) {

        this.productId = productId;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public String getProductDescription() {

        return productDescription;
    }

    public void setProductDescription(String productDescription) {

        this.productDescription = productDescription;
    }

    public double getProductCost() {

        return productCost;
    }

    public void setProductCost(double productCost) {

        this.productCost = productCost;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String isInStock() {
        return productInStock;
    }

    public void setInStock(String productInStock) {
        this.productInStock = productInStock;
    }


    //Methods

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCost=" + productCost +
                ", productInStock=" + productInStock +
                ", productCategory" + productCategory +
                '}';
    }

}




