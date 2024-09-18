package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BotaoSteps {

    WebDriver driver;
    ChromeOptions options;

    public BotaoSteps() {
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
    }

    @After
    public void fecharNavegador() {
        driver.quit();
        driver = null;
    }

    @Dado("que eu estou na pagina de login")
    public void que_eu_estou_na_pagina_de_login() {
        driver.get("http://24.9.93.34");
    }

    @Quando("eu preecher login {string} e senha {string}")
    public void eu_preecher_login_e_senha_corretos(String login, String senha) {
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(senha);
    }

    @E("eu clico no botao Entrar")
    public void eu_clico_no_botao_Entrar() {
        driver.findElement(By.id("login")).click();

    }

    @Entao("o sistema mostra a notificacao {string}")
    public void o_sistema_mostra_uma_notificacao_de_sucesso(String resultadoEsperado) throws InterruptedException {
        Thread.sleep(2000);
        String notificacao = driver.findElement(By.cssSelector("#toast_notification > div > div.toast")).getText();
        Assert.assertEquals(resultadoEsperado, notificacao);
    }
}