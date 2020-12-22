package fftl.SpringbootCRUD2.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;
    private String passwd;
    private String username;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roels;
}
