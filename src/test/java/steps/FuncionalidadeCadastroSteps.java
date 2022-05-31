package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;



public class FuncionalidadeCadastroSteps {

    WebDriver Walle;
    private java.lang.Object Object;


    @Before
    public void rodeAntes() {

        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        Walle = new ChromeDriver();
    }


    @Dado("que o usuario acesse a tela de login do site via URL {string}")
    public void que_o_usuario_acesse_a_tela_de_login_do_site_via_url(String url) {
        Walle.get(url);
    }

    @Quando("informar um Email {string} valido")
    public void informar_um_email_valido(String email) {
        Walle.findElement(By.id("user-name")).sendKeys(email);
    }


    @Quando("informar a Senha {string}")
    public void informar_a_senha(String senha) {
        Walle.findElement(By.id("password")).sendKeys(senha);
    }


    @Quando("clicar no botao Login <login>")
    public void clicar_no_botao_login_login() {
        Walle.findElement(By.id("login-button")).click();
    }


    @Entao("devera Logar {string} o usuario")
    public void devera_logar_o_usuario(String logar) {
        if (logar.equals("login com sucesso")) {
            Assertions.assertEquals("Swag Labs", Walle.getTitle());
        }
        //outra forma de pegar o elemento Walle.findElement(By.linkText("nome do item"))
        //usado para pegar o link do topo cabeçalo com outros itens para escolher

        if (logar.equals("login sem sucesso")) {
            Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",
                    Walle.findElement(By.tagName("h3")).getText());
            String texto = Walle.findElement(By.tagName("h3")).getText();
            System.out.println(texto);
        }
    }

    @After(order = 1)
    public void Screenshot(Scenario cenario) {
        File file = ((TakesScreenshot)Walle).getScreenshotAs(OutputType.FILE);
       try {
        FileUtils.copyFile(file, new File("target/screenshot/"+ cenario.getId() + ".jpg"));
   } catch (IOException e) {
        e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharNavegador() {
        Walle.quit();
    }

}

