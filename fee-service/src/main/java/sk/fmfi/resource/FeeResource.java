package sk.fmfi.resource;

import io.quarkus.runtime.util.StringUtil;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import sk.fmfi.model.Fee;
import sk.fmfi.resource.dto.FeeDTO;
import sk.fmfi.service.FeeService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("fee")
public class FeeResource {

    private final FeeService service;

    @Inject
    public FeeResource(FeeService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response getFees(@QueryParam("acno") String acno) {
        List<Fee> fees;

        if (StringUtil.isNullOrEmpty(acno)) {
            fees = service.getAllFees();
        } else {
            fees = service.getFeesForAcno(acno);
        }
        return Response.ok(fees).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Operation(
            description = "Method for fee creation",
            summary = "Fee creation"
    )
    public Response createFee(@RequestBody(description = "data for new fee") FeeDTO feeDTO) {
        service.createFee(feeDTO.getTransactionId(), feeDTO.getAcno(), feeDTO.getTransactionAmount());
        return Response.ok().build();
    }
}
