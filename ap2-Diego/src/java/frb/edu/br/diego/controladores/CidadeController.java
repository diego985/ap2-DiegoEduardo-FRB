/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.controladores;

import frb.edu.br.diego.contratos.ICidade;
import frb.edu.br.diego.entidades.CidadeDto;
import frb.edu.br.diego.repositorios.CidadeRepositorio;
import java.util.List;

/**
 *
 * @author Diego
 */
public class CidadeController {

    private CidadeDto cidade;
    private List<CidadeDto> cidades = null;
    private ICidade cidaderepositorio = new CidadeRepositorio();
    
    public CidadeController() {
    }

    public CidadeDto getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDto cidade) {
        this.cidade = cidade;
    }

    public List<CidadeDto> getCidades() {
        if(cidades==null)
            cidades = cidaderepositorio.getListaTodos();
        
        return cidades;
    }
    
    public String preparaInclusao(){
        cidade = new CidadeDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        cidaderepositorio.incluir(cidade);
        cidades = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        cidaderepositorio.alterar(cidade);
        cidades = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        cidaderepositorio.deletar(cidade.getCidade_id());
        cidades = null;
        return "refresh";
    }

    
}
