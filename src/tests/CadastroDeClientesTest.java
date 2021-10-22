package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeClientesTest {

	@Test
	public void CadastroDeClientesTest() {

		// Executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver//chromedriver.exe");

		// Abrindo o navegador (Google Chrome)
		WebDriver driver = new ChromeDriver();

		// Maximizar o navegador
		driver.manage().window().maximize();

		// Acessar a página web do sistema que será testado
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio03");

		// Preencher o nome do cliente
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");

		// Preencher o Rg
		driver.findElement(By.xpath("//*[@id=\"RG\"]")).sendKeys("1234567890");

		// Preencher o CPF
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys("098.123.876-00");

		// Preencher a data de nascimento
		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys("10/10/1980");

		// Clicar no botão realizar escrição
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// Capturar a mensagem exibida no sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Verificar se a mensagem é igual a: “Processo realizado com sucesso”
		assertEquals(mensagem, "Processo realizado com sucesso");

		try {
			// o selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Cadastro de funcionário com sucesso.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechando o navegador
		driver.close();
		driver.quit();
	}
	
}

	