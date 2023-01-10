package ru.someboy.naradareweb.model;

import java.time.LocalDateTime;

/**
 * @author Slipets Artem
 */
public class Product {

    private int id;

    private int idProduct;

    private String storeName;

    private String productName;

    private boolean inStock;

    private int retailPrice;

    private int wholesalePrice;

    private String count;

    private LocalDateTime dateTime;

    private String productLink;

    private String photoLink;
    private String search;

    public Product() {
    }

    public Product(int idProduct, String storeName, String productName, boolean inStock, int retailPrice, int wholesalePrice, String count, LocalDateTime dateTime, String productLink, String photoLink) {
        this.idProduct = idProduct;
        this.storeName = storeName;
        this.productName = productName;
        this.inStock = inStock;
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
        this.count = count;
        this.dateTime = dateTime;
        this.productLink = productLink;
        this.photoLink = photoLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(int wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
