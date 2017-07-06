package com.company.repository;

import com.company.DO.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huanbenwang on 2017/7/6.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
