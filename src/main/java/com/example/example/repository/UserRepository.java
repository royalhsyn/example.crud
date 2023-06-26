package com.example.example.repository;

import com.example.example.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.time.temporal.Temporal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate template;

    public User creat(User user){
        String sql="insert into users (name,surname,age) values(?,?,?)";
        PreparedStatementCallback<? extends Object> callback=ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.execute();
            return ps;
        };
        template.execute(sql,callback);
        return user;
    }
    public User update( User user,Long id){
        String sql ="update users set name=?,surname=?,age=? where id=?";
        PreparedStatementCallback<? extends Object> callback=ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.setLong(4,id);
            ps.execute();
            return ps;
        };
        template.execute(sql,callback);
        return user;
    }
    public void delete(Long id){
        String sql="delete from users where id=?";
        PreparedStatementCallback<? extends Object> callback=ps -> {
            ps.setLong(1, id);
            ps.execute();
            return ps;
        };
        template.execute(sql,callback);
    }
    public List<User> getAll(User user){
        String sql="select * from users";
        return template.query(sql, (rs, rowNum) -> new User(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4)

        ));
    }
}
