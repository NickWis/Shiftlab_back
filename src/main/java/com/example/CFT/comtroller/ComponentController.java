package com.example.CFT.comtroller;

import com.example.CFT.entity.Component;
import com.example.CFT.service.ComponentService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController

public class ComponentController {
    @Autowired private ComponentService componentService;

    @PostMapping("/component/save")
    public Component saveComponent(
            @Valid @RequestBody Component component)
    {
        return componentService.saveComponent(component);
    }

    @GetMapping("/component/getone/{id}")
    public Optional<Component> GetComponentList( @PathVariable("id") Long ComponentId)
    {
        return componentService.GetComponent( ComponentId);
    }

    @GetMapping("/component/getall")
    public List<Component> fetchComponentList()
    {
        return componentService.fetchComponentList();
    }

    @PutMapping("/component/put/{id}")
    public Component
    updateDepartment(@RequestBody Component component,
                     @PathVariable("id") Long ComponentId)
    {
        return componentService.updateComponent(
                component, ComponentId);
    }

    @DeleteMapping("/component/delete/{id}")
    public String deleteComponentById(@PathVariable("id") Long ComponentId)
    {
        componentService.deleteComponentById(
                ComponentId);
        return "Deleted Successfully";
    }

    @GetMapping("/component/{category}")
    public List<Component> FindByCategory(@PathVariable("category") String Category)
    {
        return componentService.FindByCategory(Category);
    }

}
