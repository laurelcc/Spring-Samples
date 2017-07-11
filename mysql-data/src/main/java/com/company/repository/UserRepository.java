package com.company.repository;

import com.company.DO.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huanbenwang on 2017/7/6.
 */
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameStartsWithIgnoreCase(String name);

    @Cacheable("users")
    List<User> findByIdStartsWithIgnoreCase(String id);
}
