/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ducle
 */
public class ManageCountry {
    ArrayList<EastAsiaCountries> list=new ArrayList<EastAsiaCountries>();
    // add country
    public void addCountryInformation(EastAsiaCountries country) throws Exception{
        list.add(country);
    }
    // get list after add
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception{
        EastAsiaCountries country= new EastAsiaCountries();
        // get last element in list
        country=list.get(list.size()-1);
        return country;
    }
    public ArrayList<EastAsiaCountries> searchInformationByName(String name) throws Exception{
        ArrayList<EastAsiaCountries> search=new ArrayList<>();
        for (EastAsiaCountries country : list) {
            if(country.getCountryName().toLowerCase().contains(name.toLowerCase())){
                search.add(country);
            }
        }
        return search;
    }
    // Sort the list in ascending order by countryName
    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder() throws Exception{
        ArrayList<EastAsiaCountries> sortList= new ArrayList<>();
        sortList.addAll(list);
        int n=sortList.size();
        // loop from fisrt country to last country in list, after each loop 1 country is sorted
        for (int i = 0; i < n; i++) {
            // loop from first to last country in unsorted list
            for (int j = 0; j <n-i-1; j++) {
                // swap two country if not in ascending order
                if(sortList.get(j).getCountryName().compareToIgnoreCase(sortList.get(j+1).getCountryName())>0){
                    Collections.swap(sortList, j, j+1);
                }
            }
        }
        return sortList;
    }
    // check duplicate country in the list
    public boolean checkDuplicate( String countryCode,String countryName){
        if(!list.isEmpty()){
            for (EastAsiaCountries eastAsiaCountries : list) {
                // check if input code match pre added code and input name match pre added name
                if(eastAsiaCountries.getCountryCode().equalsIgnoreCase(countryCode)
                        && eastAsiaCountries.getCountryName().equalsIgnoreCase(countryName)){
                    return true;
                }
            }
        }
        return false;
    }
    // get country list
    public ArrayList<EastAsiaCountries> getCountryList(){
        return list;
    }
    // display country list
    public void displayList(ArrayList<EastAsiaCountries> list){
        for (EastAsiaCountries eastAsiaCountries : list) {
            eastAsiaCountries.display();
        }
    }
}
