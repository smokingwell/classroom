package com.example.tests;

import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;

public class simpleTest extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://change-this-to-the-site-you-are-testing/", "*chrome");
	}
	public void testSimple() throws Exception {
		selenium.open("/");
		selenium.type("q", "fedora");
		selenium.click("btnG");
		selenium.click("link=Fedora Project");
		verifyTrue(selenium.isTextPresent("Fedora 12: Unite."));
	}
}
