package com.Avub.api.Customer.status.GetData.Servise;



import com.Avub.api.Customer.status.GetData.model.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationService {

   /* private final JwtUtil jwtUtil;


    private final UserRepository userRepository; // আপনার ইউজার রেপোজিটরি

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public AuthenticationService(JwtUtil jwtUtil, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String authenticate(String username, String password) {
        User user = userRepository.findByMobileNumber(username);
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid username or password");
    }*/
   @Autowired
   private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    public String authenticate(String mobileNo, String rawPassword) {
        // Fetch the encrypted password from the database
        mobileNo = mobileNo.trim();
        String query = "SELECT CUS_PWD FROM CUSTOMER_INFORMATION WHERE mobile_no = ?";
        String encryptedPassword = jdbcTemplate.queryForObject(query, new Object[]{mobileNo}, String.class);

        // Validate the password
        if (encryptedPassword != null && bCryptPasswordEncoder.matches(rawPassword, encryptedPassword)) {
            // Generate a token if authentication is successful
            return jwtUtil.generateToken(mobileNo);
        } else {
            throw new RuntimeException("Invalid mobile number or password");
        }
    }

}

