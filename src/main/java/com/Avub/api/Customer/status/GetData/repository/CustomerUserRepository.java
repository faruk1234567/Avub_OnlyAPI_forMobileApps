package com.Avub.api.Customer.status.GetData.repository;

import com.Avub.api.Customer.status.GetData.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomerUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Map<String, Object>> findUserByMobile(String mobile) {
        String sql = "select distinct(MOBILE_NO), customer_name from IOBS_RKB.v_cusone where TRIM(MOBILE_NO) = ?";
        String trimmedMobileNo = mobile.trim();
        System.out.println("Trimmed Mobile Number: '" + trimmedMobileNo + "'");
        System.out.println("Executing Query with trimmed mobileNo: " + mobile.trim());
        System.out.println("Parameter Type: " + mobile.getClass().getName());
        List<Map<String, Object>> results= jdbcTemplate.queryForList(sql, new Object[]{trimmedMobileNo});
        System.out.println("Query Results: " + results);
        return results;


    }
}
