package lk.ijse.dep10.postservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
    @OneToOne
    @JoinColumn(name = "house_id", nullable = false, referencedColumnName = "id" , unique = true)
    private House house;

    public Post(String title, String description, String userName, Date date, House house) {
        this.title = title;
        this.description = description;
        this.userName = userName;
        this.date = date;
        this.house = house;
    }
}
