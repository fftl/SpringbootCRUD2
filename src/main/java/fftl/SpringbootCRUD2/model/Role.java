package fftl.SpringbootCRUD2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    public Role(){
    }
    public Role(String name){
        this.name = name;
    }
}
