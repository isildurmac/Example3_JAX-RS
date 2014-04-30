package cu.uci.cdae.tutoriales;

import cu.uci.cdae.tutoriales.model.User;
import cu.uci.cdae.tutoriales.model.UserCollection;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 28/04/14.
 */
public class Client {



    public static void main(String[] args) {
/*
        User user = getUserbyID(1);
        System.out.println("Usuario:" + user.getName());
        printUsers();
*/
/*
        printUsers();
        User newUser = new User(1,"usuario1");
        createUser(newUser);
        printUsers();
*/

/*
        User user1 = getUserbyID(5);
        user1.setName("User5");
        updateUser(user1);
        printUsers();
*/
        //deleteUser(4);
        printUsers();




    }
    private static void deleteUser(Integer id){
        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );

        WebClient client = WebClient.create("http://127.0.0.1:5555/Example3_JAX-RS/api/gestUser/v1", providers);
        client = client. accept("application/json").type("application/json").path("/users").path(id);
        System.out.println(client.delete().getStatus());

    }

    private static void updateUser(User user) {
        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );

        WebClient client = WebClient.create("http://127.0.0.1:5555/Example3_JAX-RS/api/gestUser/v1", providers);
        client = client. accept("application/json").type("application/json").path("/users").path(user.getId());
        System.out.println(client.put(user).getStatus());

    }

    private static void printUsers(){
        UserCollection users =  getallUser();
        for (User u : users.getUsers()) {
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre " + u.getName());
            System.out.println("----------------");
        }
        System.out.println("////////////////////////////////////");
    }

    private static void createUser(User newUser) {
        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );

        WebClient client = WebClient.create("http://127.0.0.1:5555/Example3_JAX-RS/api/gestUser/v1", providers);
        client = client. accept("application/json").type("application/json").path("/adduser");
        System.out.println(client.post(newUser).getStatus());

    }

    private static UserCollection getallUser() {
        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );

        WebClient client = WebClient.create("http://127.0.0.1:5555/Example3_JAX-RS/api/gestUser/v1", providers);
        client = client.accept("application/json").type("application/json").path("/users");

        return client.get(UserCollection.class);
    }

    private static User getUserbyID(int i) {
        List<Object> providers = new ArrayList<Object>();
        providers.add( new JacksonJaxbJsonProvider() );

        WebClient client = WebClient.create("http://127.0.0.1:5555/Example3_JAX-RS/api/gestUser/v1", providers);
        client = client.accept("application/json").type("application/json").path("/users").path(i);

        return client.get(User.class);
    }
}
