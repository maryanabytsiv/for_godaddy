package com.godaddy.repository;


import com.godaddy.entity.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactCrudRepository extends CrudRepository<ContactEntity, String> {

    List<ContactEntity> findByName(@Param("name") String name);

}
