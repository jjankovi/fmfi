package sk.fmfi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class AdvancedGreeting {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@QueryParam("subject") String subject) {
        if (subject == null || subject.isBlank()) {
            subject = "World";
        }
        return "Hello, " + subject;
    }

}
