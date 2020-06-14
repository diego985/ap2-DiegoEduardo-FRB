/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.entidades;

import java.sql.Timestamp;

/**
 *
 * @author Diego
 */
public class CidadeDto {
    private int cidade_id;
    private String cidade;
    private PaisDto pais;
    private Timestamp ultima_atualizacao;

    public CidadeDto() {
        pais = new PaisDto();
    }

    public CidadeDto(int cidade_id, String cidade, PaisDto pais, Timestamp ultima_atualizacao) {
        this.cidade_id = cidade_id;
        this.cidade = cidade;
        this.pais = pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    /*public CidadeDto(int cidade_id) {
        this.cidade_id = cidade_id;
        pais = new PaisDto();
    }*/
    

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    public Timestamp getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
}
