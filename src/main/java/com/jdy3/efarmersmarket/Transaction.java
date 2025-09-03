package com.jdy3.efarmersmarket;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

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

@CreationTimestamp
protected Instant timeStamp;

protected BigDecimal cost;

public Transaction(UUID productId, BigDecimal transactionCost){
    this.cost = transactionCost;
}

}
