package com.wildcodeschool.hibernate.springHibernateExample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wildcodeschool.hibernate.springHibernateExample.entities.member;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface memberDao extends JpaRepository<member, Long> {

    @Modifying
    @Transactional
    int deleteByName (String name);
}
