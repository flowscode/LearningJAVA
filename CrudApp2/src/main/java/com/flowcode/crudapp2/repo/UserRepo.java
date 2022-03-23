package com.flowcode.crudapp2.repo;

import com.flowcode.crudapp2.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    public Long countByiD(Integer id);
}
