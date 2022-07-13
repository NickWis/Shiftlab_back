package com.example.CFT.repository;


import com.example.CFT.entity.Component;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Long> {
   @Query ("SELECT c FROM Component c Where c.Category = :name")
   List<Component> findAllCategory(@Param("name") String name);
   Optional<Component> findById(Long id);

}
