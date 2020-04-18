package com.example.mySpringBoot.util;

import com.example.mySpringBoot.model.Employee;
import com.example.mySpringBoot.controller.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        return new EntityModel<>(employee, // EntityModel<T> is a generic container from Spring HATEOAS that includes not only the data but a collection of links
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(), //  build a link to the EmployeeController 's one() method, and flag it as a self link
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees")); //  build a link to the aggregate root, all(), and call it "employees"
    }
}
