package com.senai.br.cadastro_cliente.controller;

import com.senai.br.cadastro_cliente.DAO.ClienteDAO;
import com.senai.br.cadastro_cliente.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ClienteController {

    @Autowired
    ClienteDAO clienteDAO;

    /////////////////////////////////Cadastro de Clientes\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @RequestMapping(value = "/cadastroCliente", method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        model.addAttribute("formCliente", new Cliente());
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @RequestMapping(value = "/cadastroCliente", method = RequestMethod.POST)
    public ModelAndView foi(@ModelAttribute("formCliente") Cliente cliente, Model model) {
        model.addAttribute("nome", cliente.getNome_cliente());
        clienteDAO.novoCliente(cliente);

        ModelAndView cadstroCliente = new ModelAndView("cadstroCliente");
        return cadstroCliente;
    }
//////////////////////////////////////Lista de Clientes///////////////////////////////////////////

    @RequestMapping(value = "/listaCliente", method = RequestMethod.GET)
    public ModelAndView listaCliente(Model model) {
        ModelAndView listaCliente = new ModelAndView("listaCliente");
        model.addAttribute("listaReq", clienteDAO.buscarTodosClientes());
        return listaCliente;
    }
///////////////////////////////////////Excluir CLiente//////////////////////////////////////////////////

    @RequestMapping(value = "/excluirCliente/{id}", method = RequestMethod.GET)
    public ModelAndView excluirCliente(@PathVariable int id) {
        ModelAndView excluirCliente = new ModelAndView("excluidoCliente");
        clienteDAO.excluirCliente(id);

        return excluirCliente;

    }
/////////////////////////////////////Alterar Cliente//////////////////////////////////////////////////
    @RequestMapping(value = "/alteraCliente/{id}", method = RequestMethod.GET)
    public ModelAndView alterarCliente(@PathVariable int id, Model model) {

        ModelAndView alterarCliente = new ModelAndView("alteraCliente");
        model.addAttribute("clienteReq", clienteDAO.buscarClientePorId(id));

        return alterarCliente;

    }

    @RequestMapping(value = "/alteraCliente/{id}", method = RequestMethod.POST)
    public ModelAndView clienteAlterado(@ModelAttribute("clienteReq") Cliente cliente, Model model, @PathVariable int id) {

        model.addAttribute("nome", cliente.getNome_cliente());
        model.addAttribute("id", id);

        clienteDAO.alterarCliente(cliente);

        ModelAndView clienteAlterado = new ModelAndView("clienteAlterado");

        return clienteAlterado;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

