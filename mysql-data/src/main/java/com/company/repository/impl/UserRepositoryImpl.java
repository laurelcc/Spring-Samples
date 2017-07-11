package com.company.repository.impl;

import com.company.DO.User;
import com.company.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huanbenwang on 2017/7/11.
 */
@Component
public abstract class UserRepositoryImpl implements UserRepository {

    @Cacheable("users")
    public List<User> kByIdStartsWith(String id){
        simulateSlowService();

        return findByIdStartsWithIgnoreCase(id);
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
