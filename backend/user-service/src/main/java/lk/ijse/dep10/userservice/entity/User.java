package lk.ijse.dep10.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="_user")
public class User implements Serializable {
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "address",nullable = false)
    private String Address;
    @Column(name = "tel_no",nullable = false)
    private String telNo;
    @Column(name = "email",nullable = false)
    private String email;
    @Id
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
}
