package views;

import java.util.List;

import business.GestionClientes;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Cliente;

@Named("clientes")
@RequestScoped
public class VistaClientes {
    @Inject
    private GestionClientes gClientes;
    private Cliente persona = new Cliente();
    private List<Cliente> listado;

    @PostConstruct
    public void init(){
        listado = gClientes.getClientes();

    }

    public Cliente getPersona() {
        return persona;
    }
    public void setPersona(Cliente persona) {
        this.persona = persona;
    }

    public GestionClientes getgClientes() {
        return gClientes;
    }

    public void setgClientes(GestionClientes gClientes) {
        this.gClientes = gClientes;
    }

    public List<Cliente> getListado() {
        return listado;
    }

    public void setListado(List<Cliente> listado) {
        this.listado = listado;
    }

    public String guardar() {
        System.out.println(this.persona); 
        try {
            gClientes.createCliente(persona);
            listado = gClientes.getClientes(); 
            persona = new Cliente(); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Éxito", "Cliente guardado correctamente."));
            return "listadoclientes";
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Error", e.getMessage()));
            return null; 
        }
    }
 
}
