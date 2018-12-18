package com.example.hellosb.dao;

import com.example.hellosb.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
public interface PersonDao  extends JpaRepository<Person,Integer> {
}
