/*
    viet 1 method reverse nhan vao 1 string va in ra cac tu trong string
    theo thu tu nguoc lai, chu cai dau tien viet hoa.Neu string ma rong thi 
    hien yeu cau bat nguoi dung nhap lai den khi nao ko rong thi thoi
 */
import java.util.*;
/**
 *
 * @author ducle
 */
public class Main {
    public static void main(String[] args) {
        // Prompt ask user to input a string
        String str = inputString();
        // Reverse and print out string as requirment
        Reverse(str);
    }
    // function to ask user to input string
    public static String inputString() {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        str = sc.nextLine();
        return str;
    }
    // reverse word in string function
    public static void Reverse(String str) {
        Scanner sc= new Scanner(System.in);
        while(true){
        if(str.trim().isEmpty()){       
            System.out.println("input cannot be empty");
            System.out.println("Please enter again: ");
            str = sc.nextLine();                   
        }else break;
        }
        // delete white space at beginning and end of the string
        String s = str.trim();
        // split string input after "."
        String[] splt = s.split("[\\.]");// hello there; abc xyz
        StringBuilder result = new StringBuilder();
        // loop running from last to beginning of spl
        for (int i = splt.length - 1; i >= 0; i--) {
            // split splt after whitespace
            String[] splt1 = splt[i].split("\\s+");
            StringBuilder temp = new StringBuilder();
            // loop running from last to beginning of splt1 
            for (int j = splt1.length - 1; j >= 0; j--) {
                // append each element in splt1 and white space behind after each loop 
                temp.append(splt1[j]+" ");
            }
            // return result with first character of string toUppercase
            result.append(temp.substring(0, 1).toUpperCase() + temp.substring(1).trim());
            // put a comma after each element of array splt
            if (i > 0) {
                result.append(". ");
            }
        }       
        if(checkComma(str)){
            result.append(".");
        }
        System.out.println("String after reverse: ");
        System.out.println(result.toString());       
    }
    // check comma at the end of string
    public static boolean checkComma(String str) {
        char[] c = str.toCharArray();
        if(c[c.length - 1] == '.') {
            return true;
        }
        return false;
    }
}
