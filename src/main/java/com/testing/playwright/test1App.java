package com.testing.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class test1App {
    public void test1() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }

    public void test2ChromiumHeadless() {
        //Server
        try (Playwright playwright = Playwright.create()) {
            //Browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            //page
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }

    public void test2Chromium() {
        //Server
        try (Playwright playwright = Playwright.create()) {
            //Browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            //page
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
//            page.pause();
            page.close();

        }
    }

    public void test2RealBrowsersChrome() {
        //Server
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
            lp.setHeadless(false);
            lp.setSlowMo(50);
            lp.setChannel("chrome");
            //Browser
            Browser browser = playwright.chromium().launch(lp);
            //page
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
//            page.pause();
            page.close();

        }
    }

    public void test2RealBrowsersFireFoxAndWebKit() {
        //Server
        try (Playwright playwright = Playwright.create()) {

            //Browser
            //.setChannel("firefox") Optional
//            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();
            page.navigate("http://playwright.dev");

            // Expect a title "to contain" a substring.
//            assertThat(page).hasTitle(Pattern.compile("Playwright"));

            // create a locator
            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

            // Expect an attribute "to be strictly equal" to the value.
//            assertThat(getStarted).hasAttribute("href", "/docs/intro");

            // Click the get started link
            getStarted.click();

            // Expects page to have a heading with the name of Installation.
//            assertThat(page.getByRole(AriaRole.HEADING,
//                    new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        }


    }


    public static void main(String[] args) {
        test1App obj = new test1App();
//        obj.test1();
//        obj.test2ChromiumHeadless();
//        obj.test2Chromium();
//        obj.test2RealBrowsersChrome();
        obj.test2RealBrowsersFireFoxAndWebKit();
    }
}
