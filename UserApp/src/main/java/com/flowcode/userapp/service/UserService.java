package com.flowcode.userapp.service;

import com.flowcode.userapp.entity.User;
import com.flowcode.userapp.exceptions.UsersNotFoundException;
import com.flowcode.userapp.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Repo repository;

    public List getAllUsers() throws UsersNotFoundException {
        if (repository.count() > 0) {
            return repository.findAll();
        } else {
            throw new UsersNotFoundException("No Users Were Found in Repository");
        }
    }

    public User addUser(User user) throws DuplicateKeyException{
        if(repository.existsByUserIdAndCourseId(user.getUserId(), user.getCourseId())){
            throw new DuplicateKeyException("User already exists");
        }
        return repository.save(user);
    }

    public List findById(BigInteger id) {
        List results = repository.findByuserId(id);
        if (results.isEmpty()){
           throw new NoResultException("No Results found with ID " + id);
        } else {
            return results;
        }
    }

    public List findByCourseId(BigInteger id) {
        List results = repository.findByCourseId(id);
        if (results.isEmpty()){
            throw new NoResultException("No Results found with ID " + id);
        } else {
            return results;
        }
    }
}
