package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ModalProdutoPage;
import pages.ProdutoPage;

public class HomePageTests extends BaseTests {
	
	@Test
	public void testContarProdutos_quarentaeseteProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is (47));
	}
    @Test 
    public void testValidarCarrinho_ZeroItensNoCarrinho() {
    	int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
 	    //System.out.println(produtosNoCarrinho);
 	    assertThat (produtosNoCarrinho, is (0));
    }
    
    ProdutoPage produtoPage;
    String nomeProduto_ProdutoPage;
    @Test
    public void testValidarDetalhesDoProduto_DescricaoEValorIguais () {
    	int indice = 0;
    	String nomeProduto_HomePage = homePage.obterNomeProduto(indice);
    	String precoProduto_HomePage =homePage.obterPrecoProduto (indice);
    	
    	System.out.println(nomeProduto_HomePage);
    	System.out.println(precoProduto_HomePage);
    	
    	produtoPage = homePage.clicarProduto(indice);
    	
    	String nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
    	String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();
    	System.out.println(nomeProduto_ProdutoPage);
    	System.out.println(precoProduto_ProdutoPage);
    	//assertThat (nomeProduto_HomePage.toUpperCase(), is (nomeProduto_ProdutoPage));
    	precoProduto_ProdutoPage = produtoPage.obterPrecoProduto().replace("por: ", "");
    	assertThat (precoProduto_HomePage, is (precoProduto_ProdutoPage));
    	
    	
    	
    }
    
    LoginPage loginPage;
    @Test
    public void testLoginComSucesso_UsuarioLogado() {
    
    	//Clicar no Botão Sign in na home page
    	
    	 loginPage = homePage.clicarBotaoSign();
    	
    	
    	//Preencher usuario e senha
    	loginPage.preencherEmail("adria.dna.tb@hotmail.com");
    	loginPage.preencherPassword("zulmira60");
    	
    	
    	//Clicar no botão Sign in para logar
    	loginPage.clicarBotaoSignIn();
    	
    	
    	//Validar se o usuário está validado de fato
    	
    	assertThat(homePage.estaLogado("Robson"), is (true));
    	
    	carregarPaginaInicial();
    	
    	
    	
    	
    }   
    
    ModalProdutoPage modalProdutoPage;
    @Test
    public void  testIncluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {
    	int quantidadeProduto = 2;
    	//int qtdProdutosNoCarrinho = 1;
        String obterQuantidadeProdutoString ="2";
		// --Pre-condições
		// usuario logado
    	//if(!homePage.estaLogado("Robson")) {
    		testLoginComSucesso_UsuarioLogado();
    	
    	//}
    	testValidarDetalhesDoProduto_DescricaoEValorIguais();
    
    	
    	// Adicionar no carrinho
    			modalProdutoPage = produtoPage.clicarBotaoAddToCart(); 
    		
    			
    			 
    	// Selecionar quantidade
    		
    		produtoPage.alterarQuantidade(quantidadeProduto);
    		
    	//Validações
    		//assertThat(modalProdutoPage.obterMensagemProdutoAdicionado()
    				//.endsWith("1 item no meu carrinho"), is(true));
    		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado()
                          .endsWith("1 item no meu carrinho"));
    		
    		System.out.println(modalProdutoPage.obterQuantidadeProduto());
    		
    			
    		System.out.println(obterQuantidadeProdutoString);
    		
    		//assertThat (modalProdutoPage.obterQuantidadeProduto() , is (Integer.toString(quantidadeProduto)));
    		modalProdutoPage.clicaremAtualizar();
    		
    	   	//Remover do carrinho
    	  	  //produtoPage.clicarRemoverDoCarrinho();
    		
    		System.out.println(modalProdutoPage.obterDescricaoProduto());
    		
    		homePage.clicarEstaLogado();
    		homePage.clicarBotaoSair();
    		
    		//String precoProdutoString = modalProdutoPage.obterPrecoProduto();
    		//precoProdutoString = precoProdutoString.replace("R$","");
    		//Double precoProduto = Double.parseDouble(precoProdutoString);
    		
    		
    		//String subtotalString = modalProdutoPage.obterSubtotal();
    		//subtotalString = subtotalString.replace("R$", "");
    		//Double subtotal = Double.parseDouble(subtotalString);
    		
    		//Double subtotalCalculado = (2) * precoProduto;
    		
    		//assertThat (subtotal, is (subtotalCalculado));
    }
   
    
    }
	 
	 
	  