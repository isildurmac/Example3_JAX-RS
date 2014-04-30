package cu.uci.cdae.tutoriales.services;

import cu.uci.cdae.tutoriales.model.User;
import cu.uci.cdae.tutoriales.model.UserCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Jorge on 27/04/14.
 */
@Path("/v1")
public interface UserService {

    @GET
    @Path("/users")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    UserCollection getUsers();

    @GET
    @Path("/users/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    User getUser(@PathParam("id") Integer id);

    @POST
    @Path("/adduser")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    Response add(User user);

    @PUT
    @Path("users/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void update(@PathParam("id") Integer id, User user);

    @DELETE
    @Path("users/{id}")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void delete(@PathParam("id") Integer id);


}
