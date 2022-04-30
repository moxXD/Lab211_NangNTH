

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducle
 */
public class Ebank {

    static ResourceBundle rb;
    GetData getData = new GetData();
    // function to display menu
    public void displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
    // set language to vietnamese
    public void VietnameseSystem() {
        Locale Vietnam = new Locale("vi");
        setLocale(Vietnam);
        login();
        System.exit(0);
    }

    // set language to English
    public void EnglishSystem() {
        Locale America = new Locale("en");
        setLocale(America);
        login();
        System.exit(0);
    }
    // function to set locale
    // param locale
    public void setLocale(Locale locale) {
        rb = ResourceBundle.getBundle("language", locale);

    }
    // check account number match requirment
    // param account
    public String checkAccountNumber(String account) {
        //regex: allow input must be 10 digits from 0 to 9
        if (account.matches("^[0-9]{10}$")) {
            return null;
        }
        return rb.getString("inputAcountError");
    }

    // check password match requirment length fromm 8 to 31
    // contains alphanumeric character
    // param password
    public String checkPassword(String password) {
        // (?=.*[A-Za-z]) match any , unlimited time in range A-Z and a-z
        // (?=.*[0-9]) match any , unlimted time in range 0-9
        // [A-Za-z0-9!@#$%^&*] Match a single character present in the list 
        // {8,31} matches the previous token between 8 and 31 times
        if (password.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{8,31}$")) {
            return null;
        }
        return rb.getString("inputPasswordError");
    }

    // generate random captcha
    public String generateCaptch() {
        String finalCapcha = "";
        String string = "";
        // create string from a to z ,0 to 9 both in upper and lowercase
        for (char c = 'a'; c <= 'z'; c++) {
            string += c;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            string += c;
        }
        for (char c = '0'; c <= '9'; c++) {
            string += c;
        }
        do {
            String capcha = "";
            boolean haveLowerChar = false;
            boolean haveUpperChar = false;
            boolean haveDigit = false;
            //loop use to generate 5 charater into capcha
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                // create random index [0-string length]
                int index = random.nextInt(string.length());
                char newChar = string.charAt(index);
                // check captcha contain number , letter in upper and lowercase
                if (newChar >= 'a' && newChar <= 'z') {
                    haveLowerChar = true;
                }
                if (newChar >= 'A' && newChar <= 'Z') {
                    haveUpperChar = true;
                } else {
                    haveDigit = true;
                }
                capcha += newChar;
            }
            //check value of boolean variable haveDigit, haveLowerChar, and haveUpperChar
            if (haveDigit && haveLowerChar && haveUpperChar) {
                finalCapcha = capcha;
                break;
            }
        } while (true);
        return finalCapcha;
    }
    // check captcha match requirment
    // param captchaInput; captchaGenerated
    public String checkCaptcha(String captchaInput, String captchaGenerated) {
        if (captchaInput.trim().matches(captchaGenerated.trim())
         || captchaInput.equals(captchaGenerated.substring(0,1))) {
            return null;
        }
        return rb.getString("CaptchaError");
    }
    // check captchainput contains character in captcha generate
    // param captchaInput; captchaGenerated

    // function to perform login
    public void login() {
        do {
            System.out.println(rb.getString("accountNumber"));
            String account = getData.getString();
            if (checkAccountNumber(account) == null) {
                break;
            }
            System.out.println(rb.getString("inputAcountError"));
        } while (true);
        do {
            System.out.println(rb.getString("Password"));
            String password = getData.getString();

            if (checkPassword(password) == null) {
                break;
            }
            System.out.println(rb.getString("inputPasswordError"));
        } while (true);
        do {
            String randomcaptcha = generateCaptch();
            System.out.println(rb.getString("Captcha") + randomcaptcha);
            System.out.println(rb.getString("inputCaptcha"));
            String captchaInput = getData.getString();
            if (checkCaptcha(captchaInput, randomcaptcha) == null) {
                break;
            }
            System.out.println(rb.getString("CaptchaError"));
        } while (true);
        System.out.println(rb.getString("success"));
    }
}
