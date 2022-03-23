package com.flowcode.crudapp2.service;

import com.flowcode.crudapp2.entity.User;
import com.flowcode.crudapp2.exceptions.UserNotFoundException;
import com.flowcode.crudapp2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepo repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);

    }

    public User get(Integer id) throws UserNotFoundException{
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }

    public void deleteUser(Integer id) throws UserNotFoundException{
        Long count = repo.countByiD(id);
        if (count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID " + id);
        }
        repo.deleteById(id);
    }
}
