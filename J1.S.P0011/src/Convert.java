import java.math.BigInteger;
import java.util.HashMap;
/**
 *
 * @author ducle
 */
public class Convert {
       final String valueHex = "0123456789ABCDEF";

    public String convertValue(String valueInput, int baseInput, int baseOutput) {
        StringBuilder result =new StringBuilder();
        switch (baseInput) {
            case 10:
                result.append(convertDecToOther(valueInput, baseOutput));
                break;
            case 2:
                result.append(convertBinToOther(valueInput, baseOutput));
                break;
            case 16:
                result.append(convertHexToOther(valueInput, baseOutput));
                break;
        }
        return result.toString();
    }
    // funtion to convert from decimal to binary or hexcimal
    private String convertDecToOther(String valueInput, int baseOutput) {
        BigInteger num = new BigInteger(valueInput);
        StringBuilder result = new StringBuilder();
        BigInteger outputBase = new BigInteger(Integer.toString(baseOutput));
        // loop to convert from dec to other
        do {
            // remain of num % ouputBase
            BigInteger remain = num.remainder(outputBase);
            // get value, value= num%outputbase 
            char Value = valueHex.charAt(remain.intValue());
            // check if input number is not 0
            if (!num.equals(new BigInteger("0"))) {
                result = result.append(Value);
                num = num.divide(outputBase);// num / outputBase
            } else {
                break;
            }
        } while (true);
        return result.reverse().toString();
    }
    // function to convert from binary to Decimal or Hexcimal
    private String convertBinToOther(String Input, int baseOutput) {
        // input base =2
        BigInteger inputBase = new BigInteger("2");
        StringBuilder result =new StringBuilder();        
        switch (baseOutput) {
            // Convert from bin to dec
            case 10:
                BigInteger value = new BigInteger("0");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < Input.length(); i++) {
                    // get each digit in string input
                    String digit = Character.toString(Input.charAt(i));
                    BigInteger temp = new BigInteger(digit);
                    // temp*inputbase^index 
                    value = value.add(
                            temp.multiply(inputBase.pow(Input.length() - 1 - i)));
                }
                result.append(value);
                break;
            // Convert from bin to hex    
            case 16:
                HashMap<String, String> BinToHex = new HashMap<String, String>();
                BinToHex.put("0000", "0");
                BinToHex.put("0001", "1");
                BinToHex.put("0010", "2");
                BinToHex.put("0011", "3");
                BinToHex.put("0100", "4");
                BinToHex.put("0101", "5");
                BinToHex.put("0110", "6");
                BinToHex.put("0111", "7");
                BinToHex.put("1000", "8");
                BinToHex.put("1001", "9");
                BinToHex.put("1010", "A");
                BinToHex.put("1011", "B");
                BinToHex.put("1100", "C");
                BinToHex.put("1101", "D");
                BinToHex.put("1110", "E");
                BinToHex.put("1111", "F");
                // check if user input missing 0 in the beginning
                while (Input.length() % 4 != 0) {
                    Input = "0" + Input;
                }
                //loop use to access each substring with length = 4 
                //of string from begining to the end
                for (int i = 0; i < Input.length(); i+=4) {
                    String key = Input.substring(i, i+4);
                    result.append(BinToHex.get(key)) ;
                }
                break;
        }
        return result.toString();
    }
    // function to convert from hexcimal to decimal or binary
    private String convertHexToOther(String Input, int baseOutput) {
        BigInteger inputBase = new BigInteger("16");
        StringBuilder result =new StringBuilder();
        switch(baseOutput){
            // convert from hex to bin
            case 2:
                HashMap<String, String> HexToBin = new HashMap<String, String>();
                HexToBin.put("0", "0000");
                HexToBin.put("1", "0001");
                HexToBin.put("2", "0010");
                HexToBin.put("3", "0011");
                HexToBin.put("4", "0100");
                HexToBin.put("5", "0101");
                HexToBin.put("6", "0110");
                HexToBin.put("7", "0111");
                HexToBin.put("8", "1000");
                HexToBin.put("9", "1001");
                HexToBin.put("A", "1010");
                HexToBin.put("B", "1011");
                HexToBin.put("C", "1100");
                HexToBin.put("D", "1101");
                HexToBin.put("E", "1110");
                HexToBin.put("F", "1111");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < Input.length(); i++) {
                    String key = Character.toString(Input.charAt(i));
                    result.append(HexToBin.get(key));
                }
                break;
            // convert from hex to dec
            case 10:
                BigInteger value = new BigInteger("0");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < Input.length(); i++) {
                    // get ditgit in string input
                    int digit = valueHex.indexOf(Character.toString(Input.charAt(i)));
                    BigInteger temp = new BigInteger(Integer.toString(digit));
                    // convert hex to dec by temp*inputbase^index
                    value = value.add(
                            temp.multiply(inputBase.pow(Input.length() - 1 - i)));
                }
                result.append(value);
        }
        return result.toString();
    }
 
}
