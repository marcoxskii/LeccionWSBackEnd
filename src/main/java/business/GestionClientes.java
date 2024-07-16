package business;

import java.util.List;

import dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import model.Cliente;

@Stateless
public class GestionClientes {

    @Inject
    private ClienteDAO daoCliente;

    public Cliente getCliente(String cedula) throws Exception{
        if(cedula.length() !=10){
            throw new Exception("Cedula Incorrecta: (Excede los 10 digitos)");
        }
        Cliente cliente = daoCliente.read(cedula);
        if (cliente == null){
            throw new Exception("Cliente no existe");
        }
        return cliente;
    }

    public List<Cliente> getClientes(){
        return daoCliente.getAll();
        
    }

    public void createCliente(Cliente cliente) throws Exception{
        if(cliente.getCedula().length() !=10){
            throw new Exception("Cedula Incorrecta: (Excede los 10 digitos)");
        }
        
        daoCliente.insert(cliente);

    }

    public void updateCliente(Cliente cliente) throws Exception{
        if(cliente.getCedula().length() !=10){
            throw new Exception("Cedula Incorrecta: (Excede los 10 digitos)");
        }
        daoCliente.update(cliente);
    }

    public void deleteCliente(String cedula) throws Exception{
        if(cedula.length() !=10){
            throw new Exception("Cedula Incorrecta: (Excede los 10 digitos)");
        } 

        Cliente cliente = daoCliente.read(cedula);
        if(cliente == null){
            throw new Exception("Cliente no existe");
        } 

        daoCliente.delete(cedula);
    }
}
