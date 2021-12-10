package Services;

import DAO.DAOBdLocalidad;
import Domain.Localidad;

import java.util.ArrayList;
import java.util.List;

public class GestorLocalidades {
    public GestorLocalidades() {
    }

    public List<String> listarLocalidades(){
        DAOBdLocalidad dl = new DAOBdLocalidad();
        List<Localidad> localidadesDominio = dl.listAll();
        List<String> localidadesString = new ArrayList();
        for(Localidad l: localidadesDominio){
            localidadesString.add(l.getNombre());
        }
        return localidadesString;
    }
}
