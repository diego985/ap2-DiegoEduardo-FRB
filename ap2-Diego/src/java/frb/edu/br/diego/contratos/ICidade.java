/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.contratos;

import frb.edu.br.diego.entidades.CidadeDto;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface ICidade {
    boolean incluir(CidadeDto cidade);
    boolean alterar(CidadeDto cidade);
    boolean deletar(int id);
    CidadeDto getRegistroPorId(int id);
    List<CidadeDto> getListaTodos();
    
}
