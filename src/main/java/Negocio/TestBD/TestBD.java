package Negocio.TestBD;

import javax.persistence.Persistence;

public class TestBD {
    public static void main(String[] args){
        Persistence.createEntityManagerFactory("Persistence");
    }
}
