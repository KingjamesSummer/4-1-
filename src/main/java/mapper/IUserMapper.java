package mapper;

import entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {
    @Select(value = "select * from user order by password")
    List<User> getAllUsers();
    @Select("select * from user where username=#{un}")
    User getUserById(String un);
    @Select("select * from user where username = #{un} and password=#{pwd}")
    User getUserByUsernameAndPassword(@Param("un") String un,@Param("pwd") String pwd);
    @Insert("insert ignore into user(username,password,aeg) value(#{username},#{password},#{age})")
    int addUser(User user);
    @Delete("delete from user where username=#{un}")
    int deleteUser(String username);
    @Update("update user set password=#{password},realname=#{realname} where username=#{username}")
    int updateUser(User user);
}
