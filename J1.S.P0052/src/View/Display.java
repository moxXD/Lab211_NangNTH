/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.ManageCountry;
import Model.EastAsiaCountries;
import Ultility.GetData;
import java.util.ArrayList;
/**
 *
 * @author ducle
 */
public class Display {
    ManageCountry countryManage=new ManageCountry();
    GetData getData=new GetData();
    // display menu interface
    public void displayMenu(){
        System.out.println("1. Enter the information for 11 countries in Southeast Asia.");
        System.out.println("2. Display recent added country information.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
    }
    // add new country
    public void addCountry(){
        // check if country list has 11 country or not
        if(countryManage.getCountryList().size()==11){
            System.out.println("All 11 country has been added");
            return;
        }
        System.out.println("=======Add Country=======");
        String countryCode;
        String countryName;
        do{
            countryCode = getData.getString("Enter code of country :");
            countryName = getData.getString("Enter name of country :");
            // check duplicate country
            if (countryManage.checkDuplicate(countryCode, countryName) == false) {
                break;
            }
        }while(true);
        float area=getData.getArea("Enter country totalArea: ");
        String terrain = getData.getString("Enter terrain of country :");
        EastAsiaCountries country = new EastAsiaCountries(terrain, countryCode, countryName, area);
        try {
            countryManage.addCountryInformation(country);
            System.out.println("========= Added =========");
            System.out.format("%-10s %-15s %-15s %-15s \n", "ID", "Name", "Total Area", "Terrain");
            country.display();
        } catch (Exception e) {
            System.out.println("Add country fail!!!");
        }
    }
    // display last added county
    public void displayLastInputCountry(){
        // check if country list is empty
        if(countryManage.getCountryList().isEmpty()){
            System.out.println("List is Empty!!!");
            return;
        }
        try{
            System.out.println("========= Last input ==========");
            System.out.format("%-10s %-15s %-15s %-15s \n","ID","Name","Total Area","Terrain");
            countryManage.getRecentlyEnteredInformation().display();
        }catch(Exception e){
            System.out.println("get last input country fail!!!");
        }
    }
    // display search by name function
    public void search(){
        // check if country list is empty
        if(countryManage.getCountryList().isEmpty()){
            System.out.println("List is empty!!!");
            return;
        }
        ArrayList<EastAsiaCountries> list = new ArrayList<>();
        String countryName = getData.getString("Enter name of country :");
        try {
            System.out.println("========== Search ==========");
            System.out.format("%-10s %-15s %-15s %-15s \n","ID","Name","Total Area","Terrain");
            list = countryManage.searchInformationByName(countryName);
            countryManage.displayList(list);
        } catch (Exception e) {
            System.out.println("search fail!!!");
        }
    }
    // display sorted list by countryName
    public void displayCountryAfterSort(){
        // check if country list is empty
        if(countryManage.getCountryList().isEmpty()){
            System.out.println("List is empty!!!");
            return;
        }
        ArrayList<EastAsiaCountries> list= new ArrayList<>();
        try{
            System.out.println("========== Sorted Country ==========");
            System.out.format("%-10s %-15s %-15s %-15s \n","ID","Name","Total Area","Terrain");
            list=countryManage.sortInformationByAscendingOrder();
            for (EastAsiaCountries eastAsiaCountries : list) {
                eastAsiaCountries.display();
            }
        }catch(Exception e){
            System.out.println("Sort fail!!!");
        }
    }
}
