package net.ogify.rest.resources;

import net.ogify.database.UserController;
import net.ogify.database.entities.User;
import net.ogify.engine.friends.FriendProcessor;
import net.ogify.engine.secure.AuthController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by melges.morgen on 14.02.15.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") Long id) {
        return UserController.getUserById(id);
    }

    @GET
    public User getCurrentUser(@CookieParam(AuthController.USER_ID_COOKIE_NAME) Long userId) {
        return UserController.getUserById(userId);
    }

    @GET
    @Path("{id}/friends")
    public Set<Long> getUserFriends(@PathParam("id") Long userId) throws ExecutionException {
        return FriendProcessor.getUserFriendsIds(userId);
    }

    @GET
    @Path("{id}/extendedFriends")
    public Set<Long> getUserExtendedFriends(@PathParam("id") Long userId) throws ExecutionException {
        return FriendProcessor.getUserExtendedFriendsIds(userId);
    }
}
