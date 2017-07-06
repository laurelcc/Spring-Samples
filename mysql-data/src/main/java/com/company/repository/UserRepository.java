package com.company.repository;

import com.company.DO.User;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huanbenwang on 2017/7/6.
 */
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameStartsWithIgnoreCase(String name);
}
