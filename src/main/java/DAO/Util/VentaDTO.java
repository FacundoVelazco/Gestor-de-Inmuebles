package DAO.Util;

import Domain.Inmueble;

public class VentaDTO {
    private Long id;
    private ClienteDTO cliente;
    private InmuebleDTO inmueble;

    public VentaDTO(){};
    public VentaDTO(ClienteDTO clienteDTO, InmuebleDTO inmuebleDTO){
        cliente = clienteDTO;
        inmueble = inmuebleDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public InmuebleDTO getInmueble() {
        return inmueble;
    }

    public void setInmueble(InmuebleDTO inmueble) {
        this.inmueble = inmueble;
    }
}
