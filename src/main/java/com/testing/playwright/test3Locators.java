package com.testing.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class test3Locators {
    public static void main(String[] args) {
        //Todo: Locators

        try(Playwright playwright=Playwright.create()){
            Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

            Page page=browser.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
//
            System.out.println(page.title());

            Locator explore = page.locator("text='EXPLORE COURSES'");
            explore.click();


            //multiple elements
            Locator login=page.locator("text = Login");
            System.out.println("Btn count" + login.count());
            login.click();


            page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
            System.out.println(page.title());




            //multilepl elements 2
            Locator country=page.locator("Select#Form_getForm_Country option");
            for (int i=0;i<country.count();i++){
                String c=country.nth(i).textContent();
                System.out.println(i + ": " + c);

            }

            List<String> COuntryOptionsList = country.allTextContents();
            for (String cnt : COuntryOptionsList){
                System.out.println(cnt);
            }

            COuntryOptionsList.forEach(ele-> System.out.println(ele));


            //single element
            Locator contact=page.locator("text = Contact Sales");
            System.out.println("Btn count" + contact.count());
            //Error: strict mode violation: locator("text= Contact Sales") resolved to 2 elements, second one is the Actual element
//            contact.click();
//            contact.first().click();
            contact.last().click();

        }
    }
}
