package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, name = "user_name")
    private String userName;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false, name = "no_of_rooms")
    private Integer noOfRooms;
    @Column(nullable = false, name = "no_of_bathrooms")
    private Integer noOfBathrooms;
    @Column(nullable = false, name = "no_of_floors")
    private Integer noOfFloors;
    @Column(nullable = false)
    private BigDecimal area;
    @Column(nullable = false)
    private BigDecimal price;

    public Post(String title, String description, String userName, Date date, String address, String location, Integer noOfRooms, Integer noOfBathrooms, Integer noOfFloors, BigDecimal area, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.userName = userName;
        this.date = date;
        this.address = address;
        this.location = location;
        this.noOfRooms = noOfRooms;
        this.noOfBathrooms = noOfBathrooms;
        this.noOfFloors = noOfFloors;
        this.area = area;
        this.price = price;
    }
}
