import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct {
        static ChromeDriver driver = null;
         WebDriverWait wait = null;

        @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            String exePath = "C:\\Users\\Signs\\Downloads\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);
            driver = new ChromeDriver();
        }

        @Before
        public void setUp() throws Exception {
            driver.get("https://www.saucedemo.com/");
        }

        @Test
        public void testLogin() {
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.className("btn_action")).click();

            wait = new WebDriverWait(driver, 2);

            // Test
            driver.manage().window().maximize();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='inventory_container']/div/div[2]/div[3]/button"))).click();
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_0_title_link")));


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='inventory_container']/div/div[5]/div[3]/button"))).click();
            wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_2_title_link")));

            // Test
            wait.until(ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container"))).click();


            Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Bike Light"));

            Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Onesie"));

        }

        @AfterClass
        public static void CleanUp(){
            driver.quit();
        }
    }

