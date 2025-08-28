package com.jdy3.efarmersmarket.produce;

import java.time.LocalDate;

import com.jdy3.efarmersmarket.Product;

public class Produce extends Product {

    /** Restrict produce input category values */
    public enum Category {Cereal, Vegetable, Fruit};

//     public class Water {
//     private int temperature;

//     public Water(int temperature) {
//         if (temperature < 0 || temperature > 100) {
//             throw new IllegalArgumentException("Temperature must be between 0 and 100.");
//         }
//         this.temperature = temperature;
//     }
// }

    protected Category category;
    protected LocalDate expiryDate;

}
