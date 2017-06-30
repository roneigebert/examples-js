package com.example.js;

import kikaha.urouting.api.*;

import javax.inject.Singleton;
import java.util.*;

/**
 * Created by ronei on 24/06/17.
 */
@Path("api/todo")
@Singleton
@Consumes( Mimes.JSON )
@Produces( Mimes.JSON )
public class TodoListResource {

    final Map<String, Todo> memoryTodos = new HashMap<>();

    @GET
    public List<Todo> findAll(){
        return new ArrayList<>( memoryTodos.values() );
    }

    @GET
    @Path("{id}")
    public Todo findById( @PathParam("id") String id ){
        return memoryTodos.get( id );
    }

    @PUT
    @POST
    public void persist( Todo todo ){
        if ( todo.getId() == null )
            todo.setId(UUID.randomUUID().toString());
        memoryTodos.put(todo.getId(), todo);
    }

    @DELETE
    @Path("{id}")
    public void delete( @PathParam("id") String id ){
        memoryTodos.remove( id );
    }


}
