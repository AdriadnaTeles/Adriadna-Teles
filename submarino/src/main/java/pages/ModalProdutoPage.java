package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalProdutoPage {
	
	private WebDriver driver;

	private By mensagemProdutoAdicionado = By.cssSelector(".container div h2:nth-child(1)");

	private By descricaoProduto = By.cssSelector("td.details h4 a");

	private By precoProduto = By.cssSelector("tr td.price:nth-child(5)");
	
	private By quantidadeProdutoCarrinho = By.cssSelector("input.item-quantity");
	
	private By botaoAtualizar = By.cssSelector("td.quantity form input:nth-child(3)");

	private By subtotal = By.cssSelector("tr td.price:nth-child(6)");
	
	//private By botaoProceedToCheckout = By.cssSelector("#send-40B003 input:first-child");

	public ModalProdutoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obterMensagemProdutoAdicionado() {

		FluentWait wait = new FluentWait(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofSeconds(1))
		.ignoring(NoSuchElementException.class);				
	wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemProdutoAdicionado));
		
		return driver.findElement(mensagemProdutoAdicionado).getText();
	}

	public String obterDescricaoProduto() {
		return driver.findElement(descricaoProduto).getText();
	}
	   

   public String obterPrecoProduto() {
		return driver.findElement(precoProduto).getText();
	}
   
   public void clicaremAtualizar() {
	  driver.findElement(botaoAtualizar).click();
  }

	public String obterQuantidadeProduto() {
		return driver.findElement(quantidadeProdutoCarrinho).getText();
	}

	public String obterSubtotal() {
		return driver.findElement(subtotal).getText();
	}
	
	//public CarrinhoPage clicarBotaoProceedToCheckout() {
		//driver.findElement(botaoProceedToCheckout).click();
		//return new CarrinhoPage(driver);		
	

}


