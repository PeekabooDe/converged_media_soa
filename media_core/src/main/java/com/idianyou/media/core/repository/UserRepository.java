package com.idianyou.media.core.repository;

import com.idianyou.media.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

    User findByUsername(String username);
}
