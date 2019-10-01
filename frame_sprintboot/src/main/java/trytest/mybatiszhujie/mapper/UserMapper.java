package trytest.mybatiszhujie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import trytest.mybatiszhujie.bean.User;

@Mapper
public interface UserMapper {
    @Select("select * from user_ ")
    List<User> findAll();
    
    @Insert("insert into  user_  values(null,#{name})")
    public int save(User u);
    
    @Delete("delete from user_ where id= #{id}")
    public int del(int id);
    
    @Select("select * from user_ where id=#{id}")
    public User get(int id);
    
    @Select("update user_ set name=#{name} where id = #{id}")
    public int update(User u);
    	
}
