/*
package com.Avub.api.Customer.status.GetData.repository;

import com.Avub.api.Customer.status.GetData.model.Customer;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepoImpl {
    private final JdbcTemplate jdbcTemplate;

    public CustomerRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Customer> getCustomerById(String mobile_no) {
        String selectByIdQuery = "SELECT a.mobile_no, a.customer_id, a.CUSTOMER_NAME, b.AVAILABLE_BALANCE, b.ACCOUNT_STATUS_CODE, b.branch_code, b.ACCOUNT_NO, c.ACCOUNT_TYPE_NAME, d.BRANCH_NAME, d.CONTACT_PERSON "
                + "FROM IOBS_RKB.CUSTOMER_INFORMATION a "
                + "JOIN IOBS_RKB.ACCOUNT_INFORMATION b ON a.CUSTOMER_ID = b.CUSTOMER_ID "
                + "JOIN IOBS_RKB.ACCOUNT_TYPE c ON b.ACCOUNT_TYPE_CODE = c.ACCOUNT_TYPE_CODE "
                + "JOIN IOBS_RKB.BRANCH_INFO d ON b.BRANCH_CODE = d.BRANCH_CODE "
                + "WHERE a.mobile_no = ? "
                + "AND b.ACCOUNT_STATUS_CODE <> '09'";

        return jdbcTemplate.query(selectByIdQuery, new Object[]{mobile_no}, new OrderDetailsRowMapper());
    }

    private static class OrderDetailsRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer cus = new Customer();
            cus.setMobile_no(rs.getString("mobile_no"));
            cus.setCustomer_id(rs.getString("customer_id"));
            cus.setCUSTOMER_NAME(rs.getString("CUSTOMER_NAME"));
            cus.setAVAILABLE_BALANCE(rs.getBigDecimal("AVAILABLE_BALANCE")); // Use BigDecimal for currency
            cus.setACCOUNT_STATUS_CODE(rs.getString("ACCOUNT_STATUS_CODE")); // Assuming ACCOUNT_STATUS_CODE is a string
            cus.setBranch_code(rs.getString("branch_code")); // Use String if branch_code is alphanumeric
            cus.setACCOUNT_NO(rs.getString("ACCOUNT_NO")); // Use String if ACCOUNT_NO is alphanumeric
            cus.setACCOUNT_TYPE_NAME(rs.getString("ACCOUNT_TYPE_NAME"));
            cus.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
            cus.setCONTACT_PERSON(rs.getString("CONTACT_PERSON")); // Assuming CONTACT_PERSON is a string

            return cus;
        }
    }
}












*/
