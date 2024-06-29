package automatizados.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class ProdutoTest extends BaseTest{

    public static ProdutoPO produtoPage;

    @BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}

    @Test
    public void TC001_CriarNovoProduto(){
        produtoPage.criarProduto(1, "Bomba", 2, 5, new Date());
        int qtde = produtoPage.contaProdutos();
        assertTrue(qtde>0);
    }

    @Test
    public void TC002_BloquearProdutoComCampoNomeVazio(){
        produtoPage.criarProduto(1235, "", 0, 70, new Date());

		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void TC003_Excluir(){        
        produtoPage.criarProduto(1, "Sorvete", 9, 69, new Date());
        produtoPage.buttonClose.click();
        produtoPage.buttonExcluir.click();
        int quantidade = produtoPage.contaProdutos();
        assertTrue(quantidade == 0);
       }
    
}