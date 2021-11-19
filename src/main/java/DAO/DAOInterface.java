package DAO;

import java.util.List;

public interface DAOInterface {
    public List<Object> getObjects(Class objectClass);
    public Object getObject(String nombre,Class objectClass);
    public Object getObject(Integer id,Class objectClass);
    public void setObject(Object object);
    public void refresh(Object object);
    public void close();
}
