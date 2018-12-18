package com.example.hellosb.dao;

import com.example.hellosb.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@Mapper
public interface AccountMapper {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

    @Update("update account set money=#{money} where id=#{id}")
    int update2(@Param("money") double money, @Param("id") int  id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    List<Account> findAccountList();
}