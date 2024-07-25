package com.testing.playwright;

import com.microsoft.playwright.*;

public class test5Frames {
    public static void main(String[] args) {
        try(Playwright playwright=Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

            Page page = browser.newPage();
//            page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
//
//            //same  for xpath and css selector
//            String header=page.frameLocator("frame[name='main']").locator("h2").textContent();
//            System.out.println(header);
//
//            //method 2 mainly work with name,id etc
//            String header1=page.frame("main").locator("h2").textContent();
//            System.out.println(header1);

            page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

            Locator img=page.locator("img[title='Vehicle-Registration-Forms-and-Examples']");
            img.scrollIntoViewIfNeeded();
            System.out.println("count-"+ img.count());
            img.click();

            page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8")
                    .fill(" Automation");
            page.pause();

        }
    }
}
