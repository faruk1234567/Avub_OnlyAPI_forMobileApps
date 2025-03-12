package com.Avub.api.Customer.status.GetData.Rabib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@org.springframework.stereotype.Repository
public class CusRepository {
    private static final Logger logger = LoggerFactory.getLogger(Repository.class);
    private final JdbcTemplate jdbcTemplate;
@Autowired
    public CusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public CusModel findByMobileNumber(String mobileNumber) {
        String trimmedMobileNumber= mobileNumber.trim();
        System.out.println("Querying for mobile number: " + trimmedMobileNumber);
        String sql = "SELECT * FROM CUSTOMER_INFORMATION WHERE TRIM(MOBILE_NO) = ?";

        System.out.println("Hellow");
        try {
            List<CusModel> results = jdbcTemplate.query(sql, new Object[]{trimmedMobileNumber}, new UserRowMapper());
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
        String sql = "UPDATE CUSTOMER_INFORMATION SET CUS_PWD = ? WHERE TRIM(MOBILE_NO) = ?";

        // Check if the user exists before updating
        CusModel existingUser = findByMobileNumber(trimmedMobileNumber);
        if (existingUser == null) {
            logger.warn("No existing user found with mobile number: {}", trimmedMobileNumber);
            return;
        }

        try {
            // Log the SQL and parameters
            logger.debug("Executing SQL: {}", sql);
            logger.debug("With parameters: password: {}, mobileNumber: {}", password, trimmedMobileNumber);

            // Update query execution
            int rowsAffected = jdbcTemplate.update(sql, password, trimmedMobileNumber);
            logger.debug("Rows affected by update: {}", rowsAffected);

            if (rowsAffected > 0) {
                logger.info("Password updated successfully for mobile number: {}", trimmedMobileNumber);
            } else {
                logger.warn("No user found with mobile number: {}", trimmedMobileNumber);
            }
        } catch (Exception e) {
            // Log the exception and rethrow it
            logger.error("Error updating password for mobile number: {}", trimmedMobileNumber, e);
            throw e;
        }
    }


    private static class UserRowMapper implements RowMapper<CusModel> {
        @Override
        public CusModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            CusModel cusModel = new CusModel();
            cusModel.setMobileNumber(rs.getString("MOBILE_NO").trim());
            cusModel.setPassword(rs.getString("CUS_PWD"));

            return cusModel;
        }
    }
}
