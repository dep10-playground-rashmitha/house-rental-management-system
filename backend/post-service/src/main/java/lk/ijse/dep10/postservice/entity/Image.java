package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "image")
public class Image implements Serializable {
    @Id
    private byte[] image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "image_house",
                joinColumns = @JoinColumn(name = "image", referencedColumnName = "image"),
                inverseJoinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id",nullable = false))
    private House house;
}
