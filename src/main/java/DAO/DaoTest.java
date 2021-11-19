package DAO;

import Domain.Provincia;

public class DaoTest {
    public static void main(String[] args){
        DAO dao = new DAO();
        dao.setObject(new Provincia("CHACO"));
        dao.close();


    }
}
