package fftl.SpringbootCRUD2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    public Role(){
    }
    public Role(String name){
        this.name = name;
    }
}
