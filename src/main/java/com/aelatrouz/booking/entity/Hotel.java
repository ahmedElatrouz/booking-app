package com.aelatrouz.booking.entity;



import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int rating;
    private String amenities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
