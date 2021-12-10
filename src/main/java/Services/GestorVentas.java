package Services;

import DAO.Util.VentaDTO;
import Domain.Cliente;
import Domain.Inmueble;
import Domain.Preferencia;
import Domain.Util.TipoInmueble;
import Domain.Venta;

public class GestorVentas {
    public void guardarVenta(VentaDTO vDTO){
        Venta v = new Venta();
        Cliente c = new Cliente();
        c.setNombre(vDTO.getCliente().getNombre());
        c.setApellido(vDTO.getCliente().getApellido());
        c.setId(vDTO.getCliente().getId());
        c.setUsername(vDTO.getCliente().getUsername());
        c.setPassword(vDTO.getCliente().getPassword());
        c.setTelefono(vDTO.getCliente().getTelefono());

        Preferencia preferenciaClienteAGuardar = new Preferencia();
        preferenciaClienteAGuardar.setTieneCochera(vDTO.getCliente().getPreferencias().getTieneCochera());
        preferenciaClienteAGuardar.setTienePatio(vDTO.getCliente().getPreferencias().getTienePatio());
        preferenciaClienteAGuardar.setTienePiscina(vDTO.getCliente().getPreferencias().getTienePiscina());
        preferenciaClienteAGuardar.setTieneAguaCorriente(vDTO.getCliente().getPreferencias().getTieneAguaCorriente());
        preferenciaClienteAGuardar.setTieneCloacas(vDTO.getCliente().getPreferencias().getTieneCloacas());
        preferenciaClienteAGuardar.setTieneGasNatural(vDTO.getCliente().getPreferencias().getTieneGasNatural());
        preferenciaClienteAGuardar.setTieneAguaCaliente(vDTO.getCliente().getPreferencias().getTieneAguaCaliente());
        preferenciaClienteAGuardar.setTieneTelefono(vDTO.getCliente().getPreferencias().getTieneTelefono());
        preferenciaClienteAGuardar.setTieneLavadero(vDTO.getCliente().getPreferencias().getTieneLavadero());
        preferenciaClienteAGuardar.setTienePavimento(vDTO.getCliente().getPreferencias().getTienePavimento());
        preferenciaClienteAGuardar.setMontoDisponible(vDTO.getCliente().getPreferencias().getMontoDisponible());
        preferenciaClienteAGuardar.setTipoInmueble(TipoInmueble.obtenerByString(vDTO.getCliente().getPreferencias().getTipoInmueble()));
        preferenciaClienteAGuardar.setBarrio(vDTO.getCliente().getPreferencias().getBarrio());
        preferenciaClienteAGuardar.setLocalidad(vDTO.getCliente().getPreferencias().getLocalidad());
        c.setPreferencia(preferenciaClienteAGuardar);

        Inmueble i = new Inmueble();
        i.setId(vDTO.getInmueble().getId());
        //i.setLocalidad(vDTO.getInmueble().getLocalidad());
        //i.setFotosInmueble(vDTO.getInmueble().getFotosInmueble());
        //i.setDireccion(vDTO.getInmueble().get);
        i.setEstado(vDTO.getInmueble().getEstado());
        i.setPropietarioInmueble(vDTO.getInmueble().);
        i.setCaracteristicasInmueble(vDTO.getInmueble().);
        i.setFechaCarga(vDTO.getInmueble().getFechaCarga());
        i.setFotoPrincipal(vDTO.getInmueble().getFotoPrincipal());
        i.setObservaciones(vDTO.getInmueble().getObservaciones());
        i.setPrecio(vDTO.getInmueble().getPrecio());
        i.setPrecioReserva(vDTO.getInmueble().getPrecioReserva());
        i.setPropiedadDestacada(vDTO.getInmueble().getPropiedadDestacada());


        v.setCliente(c);
        v.setInmueble(i);
    }
}
