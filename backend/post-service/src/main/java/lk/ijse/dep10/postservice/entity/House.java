package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}
