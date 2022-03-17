package com.senai.br.cadastro_cliente.DAO;

import com.senai.br.cadastro_cliente.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ClienteDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean novoCliente(Cliente cliente){
        String sql = "INSERT INTO cadastrocliente.cliente(nome, cpf, telefone)VALUES (?,?,?) ";
        jdbcTemplate.update(sql, cliente.getNome_cliente(),cliente.getCpf_cliente(),cliente.getTelefone_cliente());

        return true;
    }

    public List<Cliente> buscarTodosClientes(){
        String sql = "SELECT id,nome,cpf,telefone FROM cadastrocliente.cliente";

        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new Cliente
                        (rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone")));

   }

    @SuppressWarnings("deprecation")
	public Cliente buscarClientePorId(int id){
        String sql ="SELECT id,nome,cpf,telefone FROM cadastrocliente.cliente WHERE id = ?";

        return  jdbcTemplate.queryForObject(sql,new Object[]{id}
                ,(rs, rowNum) -> new Cliente
                (rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone")));

    }
//
    public boolean alterarCliente(Cliente cliente){
        String sql = "UPDATE  cadastrocliente.cliente SET nome=?,cpf=?,telefone=? WHERE id =?";

        Object[] params = {cliente.getNome_cliente(),cliente.getCpf_cliente(),cliente.getTelefone_cliente(),cliente.getId()};
        jdbcTemplate.update(sql,params);

        return true;

    }

    public int excluirCliente(int id){
        String sql = "DELETE FROM cadastrocliente.cliente where id =?" ;
        Object[] params = {id};

        int result = jdbcTemplate.update(sql,params);

        return result;


    }


}
