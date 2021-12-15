

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://training.qastorming.com/";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void ilkSenaryo() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SHOP NOW")));
        WebElement shopNowButton = driver.findElement(By.linkText("SHOP NOW"));
        if(shopNowButton.isDisplayed()){
            System.out.println("Şu anda anasayfadasınız");
        }
        else{
            System.out.println("Şu anda anasayfada değilsiniz");
        }
        shopNowButton.click();
        WebElement productsPage = driver.findElement(By.cssSelector("h1[class='tg-page-header__title']"));
        if(productsPage.isDisplayed()){
            System.out.println("Products sayfasına gittiniz");
        }
        else{
            System.out.println("Products sayfasına gidemediniz");
        }
        WebElement addToCart = driver.findElement(
                By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']" +
                        "[data-product_id='205']"));
        addToCart.click();
        Thread.sleep(3000);
        WebElement sepetİkonu = driver.findElement(By.cssSelector("[class='tg-icon tg-icon-shopping-cart']"));
        sepetİkonu.click();
        Thread.sleep(2000);
        WebElement urunEklendi = driver.findElement(By.linkText("Empire Waist Red Dress"));
        if(urunEklendi.isDisplayed()){
            System.out.println("Ürün sepete eklendi");
        }
        else{
            System.out.println("Ürün sepete eklenmedi");
        }
        WebElement quantity = driver.findElement(By.cssSelector("[id*='quantity']"));
        quantity.clear();
        Thread.sleep(2000);
        quantity.sendKeys("3");
        Thread.sleep(2000);
        WebElement updateCart = driver.findElement(By.name("update_cart"));
        updateCart.click();
        Thread.sleep(2000);
        WebElement remove = driver.findElement(By.cssSelector("td[class='product-remove'] a[class='remove']"));
    }

    @Test
    public void ikinciSenaryo() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SHOP NOW")));
        WebElement shopNowButton = driver.findElement(By.linkText("SHOP NOW"));
        if(shopNowButton.isDisplayed()){
            System.out.println("Şu anda anasayfadasınız");
        }
        else{
            System.out.println("Şu anda anasayfada değilsiniz");
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(("window.scrollTo (0, document.body.scrollHeight)"));
        Thread.sleep(2000);

        WebElement contactInfo = driver.findElement(By.cssSelector("[class*='footer-sidebar-4']"));
        if(contactInfo.isDisplayed()){
            System.out.println("Contact Info alanı görüldü");
        }
        else{
            System.out.println("Contact Info alanı görülmedi");
        }
        WebElement arrowUp = driver.findElement(By.cssSelector("[class*='arrow-up']"));
        arrowUp.click();
        Thread.sleep(2000);
        WebElement sayfa = driver.findElement(By.cssSelector("img[class='custom-logo']"));
        if(sayfa.isDisplayed()){
            System.out.println("Sayfanın en yukarısına gidildi");
        }
        else{
            System.out.println("Sayfanın en yukarısına gidilemedi");
        }
    }

    @Test
    public void üçüncüSenaryo() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SHOP NOW")));
        WebElement shopNowButton = driver.findElement(By.linkText("SHOP NOW"));
        if(shopNowButton.isDisplayed()){
            System.out.println("Şu anda anasayfadasınız");
        }
        else{
            System.out.println("Şu anda anasayfada değilsiniz");
        }
        WebElement shopButton = driver.findElement(By.linkText("Shop"));
        shopButton.click();
        Thread.sleep(2000);
        WebElement productsPage = driver.findElement(By.cssSelector("h1[class='tg-page-header__title']"));
        if(productsPage.isDisplayed()){
            System.out.println("Products sayfasına gittiniz");
        }
        else{
            System.out.println("Products sayfasına gidemediniz");
        }
        Select dropdown = new Select(driver.findElement(By.name("orderby")));
        dropdown.selectByVisibleText("Sort by latest");
        Thread.sleep(2000);

        WebElement addToCart1 = driver.findElement(
                By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']" +
                        "[data-product_id='214']"));
        addToCart1.click();
        Thread.sleep(3000);
        WebElement addToCart2 = driver.findElement(
                By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']" +
                        "[data-product_id='213']"));
        addToCart2.click();
        Thread.sleep(3000);
        WebElement addToCart3 = driver.findElement(
                By.cssSelector("[class='button product_type_simple add_to_cart_button ajax_add_to_cart']" +
                        "[data-product_id='212']"));
        addToCart3.click();
        Thread.sleep(3000);
        WebElement viewCart = driver.findElement(By.cssSelector("[class='added_to_cart wc-forward']"));
        viewCart.click();
        Thread.sleep(3000);
        WebElement cart = driver.findElement(By.cssSelector("[class='tg-page-header__title']"));
        if(cart.isDisplayed()){
            System.out.println("Sepet sayfası açıldı");
        }
        else{
            System.out.println("Sepet sayfası açılamadı");
        }
        WebElement ürün1 = driver.findElement(By.linkText("Yellow Stripe Coat"));
        WebElement ürün2 = driver.findElement(By.linkText("Blue Lace Dress"));
        WebElement ürün3 = driver.findElement(By.linkText("Yellow Cropped Jacket"));
        if((ürün1.isDisplayed())&&(ürün2.isDisplayed())&&(ürün3.isDisplayed())){
            System.out.println("Doğru ürünler eklendi");
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
