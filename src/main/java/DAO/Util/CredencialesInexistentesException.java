package DAO.Util;

public class CredencialesInexistentesException extends Exception {
    public CredencialesInexistentesException(String errorMessage) {
        super(errorMessage);
    }
}