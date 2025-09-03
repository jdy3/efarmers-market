package com.jdy3.efarmersmarket;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

/** Annotation on the abstract base class to allow mapping for the concrete child class tables */
@MappedSuperclass

public abstract class Transaction {
/** Abstract class for all farm transaction tables */

/** Implement product id column as a foreign key in transaction tables */

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
protected long transactionId;
@Column(name = "id")

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "product_id", referencedColumnName = "id")
protected Product product;

}
