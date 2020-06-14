/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.controladores;

import frb.edu.br.diego.contratos.IPais;
import frb.edu.br.diego.entidades.PaisDto;
import frb.edu.br.diego.repositorios.PaisRepositorio;
import java.util.List;

/**
 *
 * @author Diego
 */
public class PaisController {
    
    private PaisDto pais;
    private List<PaisDto> paises = null;
    private IPais paisrepositorio = new PaisRepositorio();

    public PaisController() {
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    public List<PaisDto> getPaises() {
        if(paises==null)
            paises = paisrepositorio.getListaTodos();
        
        return paises;
    }
    
    public String preparaInclusao(){
        pais = new PaisDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        paisrepositorio.incluir(pais);
        paises = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        paisrepositorio.alterar(pais);
        paises = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        paisrepositorio.deletar(pais.getPais_id());
        paises = null;
        return "refresh";
    }

    
    
    
}
