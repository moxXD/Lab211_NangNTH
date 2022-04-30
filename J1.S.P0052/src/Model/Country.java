/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ducle
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    // default constructor
    public Country() {
    }
    // constructor with param
    // param countryCode; countryName; totalArea
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    // get country code
    public String getCountryCode() {
        return countryCode;
    }
    // set countrycode
    // param countryCode
    public void setCountryCode(String countryCode) {
        if(countryCode!=null){
            this.countryCode=countryCode;
        }else{
            System.out.println("countryCode cannot be null");
        }
    }
    // get country name
    public String getCountryName() {
        return countryName;
    }
    // set country name
    // param country name
    public void setCountryName(String countryName) {
        if(countryName!=null){
            this.countryName=countryName;
        }else{
            System.out.println("countryName cannot be null");
        }
    }
    // get totalArea
    public float getTotalArea() {
        return totalArea;
    }
    // set total Area
    // param totalArea
    public void setTotalArea(float totalArea) {
        if(totalArea>=0){
            this.totalArea=totalArea;
        }
    }
}
