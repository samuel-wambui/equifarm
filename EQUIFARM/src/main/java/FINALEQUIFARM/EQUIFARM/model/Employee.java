package FINALEQUIFARM.EQUIFARM.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name="username")
    private String username;
    @Column(name = "pfNumber")
    private int pfNumber;
    @Column(name = "email")
    private String email;
    @Getter
    @Column(name = "password")
    private String password;
@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "User_roles",joinColumns = @JoinColumn(name = "user, id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName ="id" ))
    private List<Role> roles =new ArrayList<>();
}
