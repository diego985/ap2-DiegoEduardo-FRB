/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.contratos;

import frb.edu.br.diego.entidades.PaisDto;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IPais {
    boolean incluir(PaisDto pais);
    boolean alterar(PaisDto pais);
    boolean deletar(int id);
    PaisDto getRegistroPorId(int id);
    List<PaisDto> getListaTodos();
    
}
