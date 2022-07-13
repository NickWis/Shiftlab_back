package com.example.CFT.service;

import com.example.CFT.entity.Component;
import com.example.CFT.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentRepository componentRepository;

    @Override
    public Component saveComponent(Component component)
    {
        if(((component.getCategory()).length()==0)||((component.getSeriesNumber()).length()==0)
        ||((component.getManufacturer()).length()==0)||((component.getPrice()).length()==0)
                ||((component.getInStock()).length()==0)||((component.getProperties()).length()==0))
            throw new IllegalArgumentException("Пустая область");
        if(!(component.getPrice().matches("[0-9]+"))) throw new IllegalArgumentException("Цена это число");
        if(!(component.getInStock().matches("[0-9]+"))) throw new IllegalArgumentException("На складе цифрами");
        return componentRepository.save(component);
    }

    @Override
    public Optional<Component> GetComponent( Long ComponentId)
    {
        return  componentRepository.findById(ComponentId);
    }


    @Override
    public List<Component> fetchComponentList()
    {
        return (List<Component>) componentRepository.findAll();
    }

    @Override
    public Component
    updateComponent(Component component,
                     Long ComponentId)
    {
        Component depDB
                = componentRepository.findById(ComponentId)
                .get();

        if (Objects.nonNull(component.getCategory())
                && !"".equalsIgnoreCase(
                component.getCategory())) {
            depDB.setCategory(
                    component.getCategory());
        }

        if (Objects.nonNull(component.getSeriesNumber())
                && !"".equalsIgnoreCase(
                component.getSeriesNumber())) {
            depDB.setSeriesNumber(
                    component.getSeriesNumber());
        }

        if (Objects.nonNull(component.getManufacturer())
                && !"".equalsIgnoreCase(
                component.getManufacturer())) {
            depDB.setManufacturer(
                    component.getManufacturer());
        }

        if (Objects.nonNull(component.getPrice())
                && !"".equalsIgnoreCase(
                component.getPrice())) {
            depDB.setPrice(
                    component.getPrice());
        }

        if (Objects.nonNull(component.getInStock())
                && !"".equalsIgnoreCase(
                component.getInStock())) {
            depDB.setInStock(
                    component.getInStock());
        }

        if (Objects.nonNull(component.getProperties())
                && !"".equalsIgnoreCase(
                component.getProperties())) {
            depDB.setInStock(
                    component.getProperties());
        }

        return componentRepository.save(depDB);
    }

    @Override
    public void deleteComponentById(Long ComponentId)
    {
        componentRepository.deleteById(ComponentId);
    }

    @Override
    public List<Component>FindByCategory(String Category)
    {
        return (List<Component>) componentRepository.findAllCategory(Category);
    }
}
