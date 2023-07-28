package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "house")
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public House(String address, String location, Integer noOfRooms, Integer noOfBathrooms, Integer noOfFloors, BigDecimal area, BigDecimal price) {
        this.address = address;
        this.location = location;
        this.noOfRooms = noOfRooms;
        this.noOfBathrooms = noOfBathrooms;
        this.noOfFloors = noOfFloors;
        this.area = area;
        this.price = price;
    }
}
