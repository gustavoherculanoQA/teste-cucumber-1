package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
//import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarroSteps {

    WebDriver driver;
    ChromeOptions options;

    public void scrollToElement(By element){
        WebElement lm = driver.findElement(element);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", lm);

    }

    public void waitElementVisible(By element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public CarroSteps() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-crash-reporter");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--log-level=3");
        options.addArguments("--output=/dev/null");
    }

    @Before
    public void abrirNavegador() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void fecharNavegador() {
        driver.quit();
        driver = null;
    }
    @Dado("que entrei no navegador e acessei o site da bmw")
    public void que_entrei_no_navegador_e_acessei_o_site_da_bmw()throws InterruptedException {
        driver.get("https://www.bmw.com.br/pt/index.html");
    }
    @Quando("selecionar modelos e selecionar {string}")
    public void selecionar_modelos_e_selecionar_bmw_series(String carro)throws InterruptedException {
        By linkDosModelos = By.cssSelector("div.cmp-globalnavigation__primary > ul > li:nth-child(1) > a");
        By linkDoCarro = By.xpath("//div[@data-product-name='"+carro+"']");
        waitElementVisible(linkDosModelos, 10);
        driver.findElement(linkDosModelos).click();
        Thread.sleep(1000);
        scrollToElement(linkDoCarro);
        //waitElementVisible(linkDoCarro, 5);
        Thread.sleep(4000);
        driver.findElement(linkDoCarro).click();
        Thread.sleep(3000);

    }
    @Entao("ira abrir um span do carro")
    public void ira_abrir_um_span_do_carro()throws InterruptedException{
        System.out.println("Deu certo");

    }

}