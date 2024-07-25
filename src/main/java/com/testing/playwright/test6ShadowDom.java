package com.testing.playwright;

import com.microsoft.playwright.*;

public class test6ShadowDom {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

            Page page = browser.newPage();


//
//		//Page -- DOM --> Shadow DOM --> elements
            //identify the parent node of shadow root node (opened)
            page.navigate("https://books-pwakit.appspot.com/");
            page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
            String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
            System.out.println(text);

//		//Page -- DOM --> iFrame --> Shadow DOM --> elements

            //todo: page chnaged on selector hub
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");
        page.pause();

        }
    }
}
