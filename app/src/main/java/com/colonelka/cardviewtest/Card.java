package com.colonelka.cardviewtest;



import java.io.Serializable;


/**
 * This class is used as a type for the dataset used in MyAdapter
 * @author COLONELKA
 */
public class Card  implements Serializable{
    private String name;
    private String city;

    /**
     * Constructor to set the instance variable of the class
     * @author COLONELKA
     * @param name
     * @param city
     */
    public Card(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /**
     * @author COLONELKA
     * @return the selected school name
     */
    public String getName() {
        return name;
    }

    /**
     * @author COLONELKA
     * @return the selected school city
     */
    public String getCity() {
        return city;
    }
}
