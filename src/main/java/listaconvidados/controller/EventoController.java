package listaconvidados.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import listaconvidados.model.Evento;
import listaconvidados.service.EventoService;

@Controller
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@RequestMapping("listaeventos")
	public String listaConvidados(Model model) {
		model.addAttribute("eventos", eventoService.obterTodos());
		return "listaeventos";
	}

	@RequestMapping(value = "salvarEvento", method = RequestMethod.POST)
	public String salvar(@RequestParam("id") BigInteger id, @RequestParam("email") String email, @RequestParam("descricao") String descricao, Model model) {
		Evento novoEvento = new Evento(descricao, email);
		if (id != null) {
			novoEvento.setId(id.longValue());
		}
		eventoService.salvar(novoEvento);
		model.addAttribute("eventos", eventoService.obterTodos());
		return "listaeventos";
	}

	@RequestMapping(value = "findEvento", method = RequestMethod.POST)
	@ResponseBody
	public Evento findEvento(@RequestParam("id") long id) {
		return eventoService.find(id);
	}
}
