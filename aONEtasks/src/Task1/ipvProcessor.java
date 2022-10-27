/**
 * Class converts:
 *      ipv4 string line -> long
 *      long -> ipv4 string line
 *
 * @author = Nikita Bondar
 */


package Task1;

public class ipvProcessor {
    //
    public static String ipv4ToLine (long ipvNumber) {
        if (ipvNumber <0 || ipvNumber >4294967295L)  return null;

        return  ""+(ipvNumber/16_777_216) +"."+(ipvNumber/65_536%256)+"."+(ipvNumber/256%256)+"."+(ipvNumber%256);
    }


    //
    public static long ipv4ToNumber(String ipvLine){
        if (ipvLine.split("\\.").length == 4) {
            for (String el: ipvLine.split("\\.") ) {
                try{
                    long testNumber = Long.parseLong(el);
                    if (testNumber<0 || testNumber>255) return -1;
                } catch (Exception e){
                    return -1;
                }
            }
        }else return -1;

        String[] strings = ipvLine.split("\\.");
        return Long.parseLong(strings[0])*16_777_216+ Long.parseLong(strings[1])*65_536+Long.parseLong(strings[2])*256+Long.parseLong(strings[3]);
    }
}
