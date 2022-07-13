package com.example.CFT.service;

import com.example.CFT.entity.Component;
import java.util.List;
import java.util.Optional;

public interface ComponentService {

    Component saveComponent(Component component);

    Optional<Component> GetComponent(Long ComponentId);

    List<Component> fetchComponentList();

    Component updateComponent(Component component, Long ComponentId);

    void deleteComponentById(Long ComponentId);

    List<Component> FindByCategory( String Category);
}
