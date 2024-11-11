package com.flipfit.restController;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.bean.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.business.FlipFitGymOwnerBusiness;
@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)

public class OwnerController {
    private final IFlipFitGymOwner flipFitGymOwnerBusiness;
    private FlipFitGymOwner flipFitOwner;
    @Inject
    public OwnerController(FlipFitGymOwnerBusiness flipFitGymOwnerService) {
        this.flipFitGymOwnerBusiness = flipFitGymOwnerService;
    }
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public FlipFitGymOwner login(FlipFitUser user){
//        flipFitGymOwnerBusiness.login(user);
//        this.flipFitOwner = owner;
//        return owner;
//    }
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymOwner register(FlipFitGymOwner flipFitGymOwner){
        FlipFitGymOwner owner = flipFitGymOwnerBusiness.registerOwner(flipFitGymOwner);
        this.flipFitOwner = owner;
        return owner;
    }

    @POST
    @Path("/addCentre")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymCentre addGymCentre(FlipFitGymCentre flipFitGymCentre) throws InvalidChoiceException{
//        flipFitGymCentre.setOwnerID(flipFitOwner.getUserId());
        return flipFitGymOwnerBusiness.addCentre(flipFitGymCentre) ;
    }

    @POST
    @Path("/addSlot")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot) throws InvalidChoiceException{
//        flipFitGymCentre.setOwnerID(flipFitOwner.getUserId());
        return flipFitGymOwnerBusiness.addSlot(flipFitSlot) ;
    }

    @GET
    @Path("/viewCentres")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner){
        return flipFitGymOwnerBusiness.viewCentres(owner);
    }
//    @GET
//    @Path("/viewCustomers/{centreID}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<FlipFitUser> viewFlipFitCustomers(@PathParam("centreID") int centreID){
//        System.out.println("centreID: " + centreID);
//        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
//        flipFitGymCentre.setCentreID(centreID);
//        return flipFitGymOwnerBusiness.viewFlipFitCustomers(flipFitGymCentre);
//    }
    @PUT
    @Path("/editDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner) throws InvalidChoiceException{
        return flipFitGymOwnerBusiness.editDetails(flipFitGymOwner);
    }
}
