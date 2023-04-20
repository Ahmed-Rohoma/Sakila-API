package iti.jets.Web_Services.Soap;

import java.util.List;

import iti.jets.exception.ResourceNotFoundException;
import iti.jets.model.dto.CategoryDTO;
import iti.jets.model.mapper.CategoryMapper;
import iti.jets.service.CategoryService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@WebService
public class CategoryEndPoint {

    private CategoryService categoryService = null;

    public CategoryEndPoint() {
        categoryService = new CategoryService();
    }

    // @WebMethod
    // public Response getAll() {
    //     List<CategoryDTO> FilmsList = categoryService.getAll();
    //     GenericEntity<List<CategoryDTO>> entity = new GenericEntity<List<CategoryDTO>>(FilmsList) {
    //     };
    //     return Response.ok().entity(entity).build();
    // }

    @WebMethod
    public Response getById(@PathParam("oid") int id) {
        CategoryDTO existingCategory = categoryService.getByID(id);
        if (existingCategory == null) {
            throw new ResourceNotFoundException("Category with ID:" + id + " Not Found");
        }
        System.out.println(existingCategory);
        return Response.ok().entity(existingCategory).build();
    }

    @WebMethod
    public Response add(CategoryDTO category) {
        if (category != null) {
            categoryService.add(CategoryMapper.toEntity(category));
            return Response.ok().entity("Film with ID : " + category.getId() + " has been Added ").build();
        }
        return Response.ok().entity("Please Provide The Category in Correct Format").build();
    }

    @WebMethod
    public Response update(CategoryDTO category) {
        categoryService.update(CategoryMapper.toEntity(category));
        return Response.ok().entity("Film with ID : " + category.getId() + " has been Updated ").build();
    }

    @WebMethod
    public Response delete(@PathParam("id") int id) {
        categoryService.deleteByID(id);
        return Response.ok().entity("Category with ID : " + id + " has been Deleted ").build();
    }
}
