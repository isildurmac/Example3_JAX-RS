package cu.uci.cdae.tutoriales.services.Impl;

import cu.uci.cdae.tutoriales.model.User;
import cu.uci.cdae.tutoriales.model.UserCollection;
import cu.uci.cdae.tutoriales.services.UserService;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jorge on 27/04/14.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    static {
        users.put(1, new User(1, "User1"));
        users.put(2, new User(2, "User2"));
        users.put(3, new User(3, "User3"));
    }

    public UserServiceImpl() {
    }

    @Override
    public UserCollection getUsers() {
        return new UserCollection(users.values());
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    @Override
    public Response add(User user) {
        if (user.getId() < users.size()) {
            user.setId(users.size() + 1);
        }
        users.put(user.getId(), user);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public void update(Integer id, User user) {
        users.put(id, user);
    }

    @Override
    public void delete(Integer id) {
        users.remove(id);
    }
}
