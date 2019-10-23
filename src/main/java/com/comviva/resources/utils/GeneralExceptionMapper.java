package com.comviva.resources.utils;

import com.comviva.domain.exceptions.DomainException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        //logger.error("", e);
        if (e instanceof WebApplicationException) {
            return ((WebApplicationException) e).getResponse();
        }
        Integer code = e instanceof DomainException ? ((DomainException) e).getCode() :
                Response.Status.CONFLICT.getStatusCode();
        Map map = new HashMap();
        map.put("code", code);
        map.put("message", e.getMessage());
        return Response.status(Response.Status.CONFLICT). entity(map).type(MediaType.APPLICATION_JSON).build();
    }
}
