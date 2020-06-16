package string;

/**
 * 468. Validate IP Address
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 */
public class ValidateIPAddress {
    public static void main(String[] args) {
        ValidateIPAddress ip = new ValidateIPAddress();
        System.out.println(ip.validIPAddress("20.0.2.2"));
        System.out.println(ip.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
    private String validIPAddress(String IP) {

        if(IP == null || IP.isEmpty())
            return "Neither";


        if(checkIPV4(IP))
            return "IPv4";
        if(checkIPV6(IP))
            return "IPv6";
        else
            return "Neither";
    }

    private boolean checkIPV4(String IP){
        if(!IP.contains(".")  || IP.endsWith("."))
            return false;
        IP = IP.toLowerCase();
        String[] str = IP.split("[.]");
        if(str.length !=4)
            return false;

        for(String group:str){
            if(group.isEmpty() || group.length() >3 || (group.charAt(0)=='0' && group.length()>1) || group.charAt(0)=='-' )
                return false;
            try {
                if(Integer.parseInt(group) < 0 || Integer.parseInt(group) > 255 )
                    return false;
            }catch(NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIPV6(String IP){
        if(!IP.contains(":")  || IP.endsWith(":"))
            return false;
        IP = IP.toLowerCase();
        String[] str = IP.split(":");
        if(str.length !=8)
            return false;

        for(String group:str){
            if(group.isEmpty() || group.length()>4)
                return false;
            for(char c:group.toCharArray()){
                if(c<'0'||c>'f')
                    return false;
            }

        }
        return true;
    }
}
