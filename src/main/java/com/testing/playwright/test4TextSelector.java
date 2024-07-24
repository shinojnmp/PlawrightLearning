package com.testing.playwright;

import com.microsoft.playwright.*;

import java.sql.SQLOutput;
import java.util.List;

public class test4TextSelector {
    public static void main(String[] args) {
        try(Playwright playwright=Playwright.create()){
            Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

            Page page=browser.newPage();
//            page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
//            System.out.println(page.title());
//
//            Locator links=page.locator("text=Privacy Policy");
//            System.out.println(links.count());
//
//            for (int i=0;i< links.count();i++){
//                System.out.println(links.nth(i).textContent());
//                if (links.nth(i).textContent().trim().contains("Service Privacy Policy")){
//                    System.out.println("inside");
//                    links.nth(i).click();
//                    break;
//                }
//            }

            //fixme: not working as new page introduced
            page.navigate("https://demo.opencart.com/index.php?route=account/login");
            System.out.println(page.title());
            Locator neCustomer=page.locator("div.mb-3 h2:has-text('New Customer')");
            System.out.println(neCustomer.count());


        }
    }
}
