package com.exemplu;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class PersoanaMapper implements RowMapper<Persoana>{
    @Override
    public Persoana mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Persoana(rs.getInt("id"), rs.getString("nume"), rs.getInt("varsta"));
    }
}
