package com.jdy3.efarmersmarket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@ManyToOne
@JoinColumn(name = "productId")
protected Product product;

/** Retrieve product data */
/** Annotation to ignore this field during INSERT and UPDATE operations as it is read only from the entity's perspective */
@Column(insertable=false, updatable=false)
protected UUID productId = product.id;
@Column(insertable=false, updatable=false)
protected BigDecimal productPrice = product.price;

protected String productName = product.name;
protected String productVariety = product.variety;
protected String productPicture = product.picture;
protected String productDescription = product.description;
protected String productProvenance = product.provenance;
protected String productLocation = product.location;

@CreationTimestamp
protected Instant timeStamp;

public Transaction(UUID productId){
    this.productId = productId;
}

public long getTransactionId(){
    return transactionId;
}

public UUID getProductId(){
    return product.id;
}

public BigDecimal getProductPrice(){
    return productPrice;
}

public Instant getTimeStamp(){
    return timeStamp;
}

}
