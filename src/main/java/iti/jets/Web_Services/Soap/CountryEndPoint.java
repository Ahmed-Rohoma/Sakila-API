package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.CountryDTO;
import iti.jets.model.mapper.CountryMapper;
import iti.jets.service.CountryService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@WebService
public class CountryEndPoint {

    private CountryService countryService = null;

    public CountryEndPoint() {
        countryService = new CountryService();
    }

    // @WebMethod
    // public Response getAll() {
    //     List<CountryDTO> FilmsList = countryService.getAll();
    //     GenericEntity<List<CountryDTO>> entity = new GenericEntity<List<CountryDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @WebMethod
    public Response getById(@PathParam("oid") int id) {
        CountryDTO existingCountry = countryService.getByID(id);
        if (existingCountry == null) {
            throw new ResourceNotFoundException("Country with ID:" + id + " Not Found");
        }
        System.out.println(existingCountry);
        return Response.ok().entity(existingCountry).build();
    }

    @WebMethod
    public Response add(CountryDTO country) {
        if (country != null) {
            countryService.add(CountryMapper.toEntity(country));
            return Response.ok().entity("Film with ID : " + country.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The country in Correct Format").build();
    }

    @WebMethod
    public Response update(CountryDTO country) {
        countryService.update(CountryMapper.toEntity(country));
        return Response.ok().entity("country with ID : " + country.getId() + " has been Updated ").build();
    }


    @WebMethod
    public Response delete(@PathParam("id") int id) {
        countryService.deleteByID(id);
        return Response.ok().entity("country with ID : " + id + " has been Deleted ").build();
    }
}
