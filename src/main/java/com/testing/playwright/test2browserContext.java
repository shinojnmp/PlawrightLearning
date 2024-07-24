package com.testing.playwright;

import com.microsoft.playwright.*;

public class test2browserContext {
    public static void main(String[] args) {
        try(Playwright playwright=Playwright.create()){
            Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            BrowserContext brCx1=browser.newContext();
            Page page1=brCx1.newPage();
            page1.navigate("https://www.youtube.com/");
            System.out.println(page1.title());

            BrowserContext brCx2=browser.newContext();
            Page page2=brCx2.newPage();
            page2.navigate("https://playwright.dev/");
            System.out.println(page2.title());

            page1.close();
            brCx1.close();
            page2.close();
            brCx2.close();
        }
    }
}
