package com.Avub.api.Customer.status.GetData.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerLoan {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CustomerDeposit.class);

    public CustomerLoan(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Map<String, Object>> fetchEmployeeLoanData(String mobileNo) {
        String sql = "SELECT A.MOBILE_NO,A.CUSTOMER_NAME,B.AVAILABLE_BALANCE,B.ACCOUNT_STATUS_CODE,B.AVAILABLE_BALANCE, B.BRANCH_CODE,B.ACCOUNT_NO,C.ACCOUNT_TYPE_NAME , D.BRANCH_NAME, D.CONTACT_PERSON\n" +
                "FROM IOBS_RKB.CUSTOMER_INFORMATION A,IOBS_RKB.ACCOUNT_INFORMATION B,IOBS_RKB.ACCOUNT_TYPE C ,IOBS_RKB.BRANCH_INFO D WHERE TRIM(A.MOBILE_NO)= ? AND A.CUSTOMER_ID=B.CUSTOMER_ID\n" +
                "AND C.ACCOUNT_TYPE_CODE=B.ACCOUNT_TYPE_CODE AND B.BRANCH_CODE = D.BRANCH_CODE AND B.ACCOUNT_STATUS_CODE<>'09' \n" +
                "AND C.MODULE_TYPE_CODE IN (SELECT MODULE_TYPE_CODE\n" +
                "                                             FROM IOBS_RKB.MODULE_INFO\n" +
                "                                            WHERE MODULE_FOR_LOAN = 'Y')";
        String trimmedMobileNo = mobileNo.trim();
        try {
            logger.info("Executing SQL: {} with parameter: {}", sql, trimmedMobileNo);
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, trimmedMobileNo);
            return result;
        } catch (BadSqlGrammarException e) {
            logger.error("SQL syntax error: SQL = {} with parameter = {}", sql, trimmedMobileNo, e);
            throw e;
        } catch (Exception e) {
            logger.error("Error executing query with parameter = {}: {}", trimmedMobileNo, e.getMessage(), e);
            throw e;
        }
    }
}
