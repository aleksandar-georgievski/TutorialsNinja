package Utils;

import java.util.Date;

public class Utilities {

    public static String generateEmailWithTimeStamp() {
        Date date = new Date();
        String timeStamp = date.toString().replace(" ","").replace(":","");
        return  "ace"+timeStamp+"@gmail.com";
    }

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 5;

}







