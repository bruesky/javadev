package com.example.hellosb.dao;
import com.example.hellosb.entity.AccountJPA;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */

public interface AccountDao  extends JpaRepository<AccountJPA,Integer> {
}
