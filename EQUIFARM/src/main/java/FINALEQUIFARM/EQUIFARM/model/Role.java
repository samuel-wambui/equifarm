package FINALEQUIFARM.EQUIFARM.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="roles")
@Setter
@Getter
public class Role {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
