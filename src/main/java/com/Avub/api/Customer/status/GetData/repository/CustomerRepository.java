package com.Avub.api.Customer.status.GetData.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> fetchEmployeeData(String mobileNo) {
        // SQL স্টেটমেন্টে প্যারামিটার হিসেবে ? ব্যবহার করুন
        String sql = "select * from v_cusone  where TRIM(MOBILE_NO) = ?";

        // SQL স্টেটমেন্ট এবং প্যারামিটারগুলো লগ করুন
        String trimmedMobileNo = mobileNo.trim();
        System.out.println("Trimmed Mobile Number: '" + trimmedMobileNo + "'");
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, trimmedMobileNo);

        // List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, mobileNo);

       // List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, mobileNo);

        // কনসোল লগ করুন যে কি রেজাল্টস আসছে
        System.out.println("Executing Query with trimmed mobileNo: " + mobileNo.trim());
        System.out.println("Parameter Type: " + mobileNo.getClass().getName());
        System.out.println("Query Results: " + results);


        return results;
    }
}

