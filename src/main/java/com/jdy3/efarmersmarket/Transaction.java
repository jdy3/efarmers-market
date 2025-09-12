package com.jdy3.efarmersmarket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/** Annotation on the abstract base class to allow mapping for the concrete child class tables */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Transaction {
/** Abstract class for all farm transaction tables */

/** Implement product id column as a foreign key in transaction tables */

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
protected long transactionId;

/** Ensure product relationship is not lazily fetched after creating transactions */
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "productId", nullable = false)
protected Product product;

protected BigDecimal productPrice;
protected String productName;
protected String productPicture;
protected String productDescription;
protected String productProvenance;
protected String productLocation;

@CreationTimestamp
protected Instant timeStamp;

public long getTransactionId(){
    return transactionId;
}

public void setProduct(Product product){
    this.product = product;
}

@JsonProperty("productId")
public UUID getProductId() {
    return product != null ? product.getId() : null;
}

public void setProductPrice(BigDecimal inputPrice){
    this.productPrice = inputPrice;
}

public BigDecimal getProductPrice(){
    return productPrice;
}

public void setProductName(String inputName){
    this.productName = inputName;
}

public String getProductName(){
    return productName;
}

public void setproductPicture(String inputPicture){
    this.productPicture = inputPicture;
}

public String getProductPicture(){
    return productPicture;
}

public void setProductDescription(String inputDescription){
    this.productDescription = inputDescription;
}

public String getProductDescription(){
    return productDescription;
}

public void setProductProvenance(String inputProvenance){
    this.productProvenance = inputProvenance;
}

public String getProductProvenance(){
    return productProvenance;
}

public void setProductLocation(String inputLocation){
    this.productLocation = inputLocation;
}

public String getProductLocation(){
    return productLocation;
}

public Instant getTimeStamp(){
    return timeStamp;
}

}
