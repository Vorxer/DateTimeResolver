import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

import java.util.TimeZone;
import java.time.zone.*;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.zone.*;

public class Dtr {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Year");
        String year = input.nextLine();
        System.out.println("Enter the Month");
        String month = input.nextLine();
        System.out.println("Enter the Date");
        String date = input.nextLine();
        System.out.println("Enter the Hour");
        String hour = input.nextLine();
        System.out.println("Enter the Minuite");
        String minuite = input.nextLine();
        System.out.println("Enter the Second");
        String second = input.nextLine();

        System.out.println("UTC Time : " + convertToUTC(resolveUserInput(year,month,date,hour,minuite,second)));
        System.out.println("LA Standard Time : " + convertToPST(resolveUserInput(year,month,date,hour,minuite,second)));

    }

    public static ZonedDateTime resolveUserInput(String year, String month, String date,String hour, String minuite, String second){
        ZoneId tz = ZoneId.systemDefault();
        //try{
            ZonedDateTime resolvedZDT = ZonedDateTime.parse(year+"-"+month+"-"+date+"T"+hour+":"+minuite+":"+second+tz.getRules().getOffset(Instant.now()) + "[" + tz + "]");
            return resolvedZDT;
        /*}catch (Exception e){
        System.out.println("Error, Could not Resolve User Input");
            System.out.println(e.getStackTrace());
            System.exit();
        }*/

    }

    public static ZonedDateTime convertToUTC(ZonedDateTime inputZDT){
        ZonedDateTime UTCDateTime = inputZDT.withZoneSameInstant(ZoneOffset.UTC);
        return UTCDateTime;
    }

    public static ZonedDateTime convertToPST(ZonedDateTime inputZDT){
        ZonedDateTime PSTDateTime = inputZDT.withZoneSameInstant(ZoneOffset.of("-0800"));
        return PSTDateTime;
    }
}
