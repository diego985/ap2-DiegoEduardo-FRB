/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.controladores;

import frb.edu.br.diego.contratos.IEndereco;
import frb.edu.br.diego.entidades.EnderecoDto;
import frb.edu.br.diego.repositorios.EnderecoRepositorio;
import java.util.List;

/**
 *
 * @author Diego
 */
public class EnderecoController {

    private EnderecoDto endereco;
    private List<EnderecoDto> enderecos = null;
    private IEndereco enderecorepositorio = new EnderecoRepositorio();
    
    public EnderecoController() {
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<EnderecoDto> getEnderecos() {
        if(enderecos == null)
            enderecos = enderecorepositorio.getListaTodos();
        
        return enderecos;
    }
    
    
    public String preparaInclusao(){
        endereco = new EnderecoDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        enderecorepositorio.incluir(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        enderecorepositorio.alterar(endereco);
        enderecos = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        enderecorepositorio.deletar(endereco.getEndereco_id());
        enderecos = null;
        return "refresh";
    }


    
    
    
    
}
