package Login;

import java.security.SecureRandom;


public class GenerateOTP {

    public static String generate(){
        SecureRandom sr = new SecureRandom();
        //random integer
        String pass = "";
        for (int i = 0; i < 32; i++) {
            // from 33 dec. to 126 dec. in ASCII Table
            int OTP = sr.nextInt(93)+33;
            pass += (char) OTP;
        }

        return pass;
    }



    
}
