package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "image")
public class Image implements Serializable {
    @Id
    private String img;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "image_post",
                joinColumns = @JoinColumn(name = "img", referencedColumnName = "img"),
                inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id",nullable = false))
    private Post post;
}
