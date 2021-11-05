package Negocio;

import javax.persistence.*;

@Entity
@Table(name="test")
public class Test {
    @Id
    @Column(name = "id_test")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_test;
    @Column(name = "testAtribute")
    private String testAtribute = "Hello world";

    public Test (){

    }

}
