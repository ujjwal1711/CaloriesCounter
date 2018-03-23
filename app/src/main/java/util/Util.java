package util;

import java.text.DecimalFormat;

/**
 * Created by UjjwalNUtsav on 23-03-2018.
 */

public class Util {
    public static String formatNumber( int value) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;
    }

}
