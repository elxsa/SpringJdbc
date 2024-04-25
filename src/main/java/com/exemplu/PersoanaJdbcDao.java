package com.exemplu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class PersoanaJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Persoana> findAll() {
        String sql = "select * from persoane";
        return jdbcTemplate.query(sql, new PersoanaMapper());
    }

    public Persoana findById(int id) {
        String sql = "select * from persoane where id=?";
        return jdbcTemplate.queryForObject(sql, new PersoanaMapper(), id);
    }

    public int deleteById(int id) {
        String sql = "delete from persoane where id=?";
        return jdbcTemplate.update(sql, id);
    }
    public int insert(Persoana p){
        String sql="insert into persoane values(?,?,?)";
        return jdbcTemplate.update(sql, p.getId(),p.getNume(),p.getVarsta());
    }
    public int update(Persoana p){
        String sql="update persoane set nume=?,varsta=? where id=?";
        return jdbcTemplate.update(sql, p.getNume(),p.getVarsta(),p.getId());
    }
}