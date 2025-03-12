/*
package com.Avub.api.Customer.status.GetData.Rabib;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private static final Logger logger = LoggerFactory.getLogger(Repository.class);
    private final JdbcTemplate jdbcTemplate;
@Autowired
    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public model findByMobileNumber(String mobileNumber) {
        String trimmedMobileNumber = mobileNumber.trim();
        System.out.println("Querying for mobile number: " + trimmedMobileNumber);
        String sql = "SELECT * FROM CUSTOMER_INFORMATION WHERE TRIM(MOBILE_NO) = ?";
        System.out.println("Hellow");
        try {
            List<model> results = jdbcTemplate.query(sql, new Object[]{trimmedMobileNumber}, new UserRowMapper());
            System.out.println("Query results: " + results);
            if (results.isEmpty()) {
                System.out.println("No user found with mobile number: " + trimmedMobileNumber);
                return null;
            } else {
                return results.get(0); // Only one result expected
            }
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No user found with mobile number: " + trimmedMobileNumber);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void updatePassword(String mobileNumber, String password) {
        String trimmedMobileNumber = mobileNumber.trim();
        String sql = "UPDATE CUSTOMER_INFORMATION SET CUS_PWD = ? WHERE MOBILE_NO = ?";
        logger.debug("Executing SQL: {}", sql);
        logger.debug("With parameters: password: {}, mobileNumber: {}", password, trimmedMobileNumber);
        try {
            int rowsAffected = jdbcTemplate.update(sql, password, trimmedMobileNumber);
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully for mobile number: " + trimmedMobileNumber);
            } else {
                System.out.println("No user found with mobile number: " + trimmedMobileNumber);
            }
        } catch (Exception e) {
            System.err.println("Error updating password: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }


    private static class UserRowMapper implements RowMapper<model> {
        @Override
        public model mapRow(ResultSet rs, int rowNum) throws SQLException {
            model modelp = new model();
            modelp.setMobileNumber(rs.getString("MOBILE_NO").trim());
            modelp.setPassword(rs.getString("CUS_PWD"));

            return modelp;
        }
    }
}

*/
