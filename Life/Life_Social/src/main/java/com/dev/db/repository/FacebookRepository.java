package com.dev.db.repository;

import com.dev.db.entity.Facebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface FacebookRepository extends
        JpaRepository<Facebook, Long> {

    Facebook findByUserName(String userName);
}
