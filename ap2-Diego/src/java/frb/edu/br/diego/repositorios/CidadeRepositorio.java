/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.diego.repositorios;

import frb.edu.br.diego.contratos.ICidade;
import frb.edu.br.diego.entidades.CidadeDto;
import frb.edu.br.diego.entidades.PaisDto;
import frb.edu.br.diego.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class CidadeRepositorio extends DaoUtil implements ICidade{

    public CidadeRepositorio() {
    }

    @Override
    public boolean incluir(CidadeDto cidade) {
        String sql = "INSERT INTO cidade (cidade, pais_id) VALUES (?, ?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais().getPais_id());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0; 

    }

    @Override
    public boolean alterar(CidadeDto cidade) {
       
        String sql = "UPDATE cidade SET cidade = ?, pais_id = ? WHERE cidade_id = ?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais().getPais_id());
            ps.setInt(3, cidade.getCidade_id());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        
        String sql = "DELETE FROM cidade WHERE cidade_id = ?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0; 
    }

    @Override
    public CidadeDto getRegistroPorId(int id) {
        CidadeDto pais = new CidadeDto();
        PaisRepositorio paisrep = new PaisRepositorio();
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao from cidade where cidade_id = ? ";

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pais = new CidadeDto(rs.getInt("cidade_id"),rs.getString("cidade"),paisrep.getRegistroPorId(rs.getInt("pais_id")),rs.getTimestamp("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pais;
    }

    @Override
    public List<CidadeDto> getListaTodos() {
        List<CidadeDto> cidades = new LinkedList<CidadeDto>();
        PaisRepositorio paisrep = new PaisRepositorio();
        
        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao FROM cidade ORDER BY CIDADE";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //PaisDto pais = paisrep.getRegistroPorId(rs.getInt("pais_id"));
                cidades.add(new CidadeDto(rs.getInt("cidade_id"),rs.getString("cidade"),paisrep.getRegistroPorId(rs.getInt("pais_id")),rs.getTimestamp("ultima_atualizacao")) );
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaisRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cidades;
    }
    
}
