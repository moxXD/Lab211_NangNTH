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
public class EastAsiaCountries extends Country{
    private String countryTerrain;
    // default constructor
    public EastAsiaCountries() {
    }
    // constructor with parameter
    // param countryTerrain; countryCode; countryName; totalArea 
    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    // display
    public void display() {
        System.out.format("%-10s %-15s %-15s %-15s \n",countryCode,countryName,totalArea,countryTerrain);
    }
}
