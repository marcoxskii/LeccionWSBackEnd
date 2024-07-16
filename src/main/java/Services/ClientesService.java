package Services;

import java.util.List;

import business.GestionClientes;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Cliente;

@Path("/clientes")
/***
 * SOLICITUD DE EJEMPLO
 * PUT demo.ups/rs/clientes/
 * POST demo.ups/rs/clientes/
 * DELETE demo.ups/rs/clientes/?id=0350026
 * GET demo.ups/rs/clientes/
 * GET demo.ups/rs/clientes/0350026

***/
public class ClientesService {

    @Inject
    private GestionClientes gClientes;

    @POST
    @jakarta.ws.rs.Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Cliente cliente){

        try {
            gClientes.createCliente(cliente);
            return Response.status(201).entity(cliente).build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.status(400).entity(new Respuesta (Respuesta.Error,"Error en BD")).build();
        }
    }
    @PUT
    @jakarta.ws.rs.Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Cliente cliente){
        
        try {
            gClientes.updateCliente(cliente);
            return Response.ok(cliente).build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.status(400).entity(new Respuesta (Respuesta.Error,"Error en BD")).build();
        }   
    }

    
    @DELETE
    @Path("/{cedula}")
    @jakarta.ws.rs.Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("cedula") String cedula){

        try {
            gClientes.deleteCliente(cedula);
            return Response.noContent().build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta (Respuesta.Error,e.getMessage())).build();
        }
        
    }

    @GET
    @Path("/{cedula}")
    @jakarta.ws.rs.Produces("application/json")
    public Response get(String cedula){

        Cliente cliente;
        try{
            cliente = gClientes.getCliente(cedula);
            return Response.ok(cliente).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(404).entity(new Respuesta(Respuesta.Error, e.getMessage())).build();
        }
    }

    @GET
    @jakarta.ws.rs.Produces("application/json")
    public Response list() {
        try{
            List<Cliente> clientes = gClientes.getClientes();
            return Response.ok(clientes).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta (Respuesta.Error,e.getMessage())).build();
        }
        

    }
    
}
