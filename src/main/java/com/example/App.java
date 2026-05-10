package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {
    public static void main(String[] args) {

        //  Setup Firefox for Jenkins (Headless mode)
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");              // REQUIRED
        options.addArguments("--no-sandbox");            // Recommended
        options.addArguments("--disable-dev-shm-usage"); // Recommended

        WebDriver driver = new FirefoxDriver(options);

        try {
            // ---- Test 1: SauceDemo Login ----
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // ---- Test 2: Practice Test Login ----
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // ---- Test 3: Product Search ----
            driver.get("https://automationexercise.com/products");
            driver.findElement(By.id("search_product")).sendKeys("blue top");
            driver.findElement(By.id("submit_search")).click();

            System.out.println("All test cases executed successfully ");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
