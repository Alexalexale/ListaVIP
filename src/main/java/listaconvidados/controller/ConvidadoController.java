package listaconvidados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import listaconvidados.model.Convidado;
import listaconvidados.model.Eventos;
import listaconvidados.service.ConvidadoService;
import listaconvidados.service.EmailService;
import listaconvidados.service.EventoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService convidadoService;
	@Autowired
	private EventoService eventoService;

	@RequestMapping("listaconvidados")
	public ModelAndView listaConvidados(Model model, @RequestParam("idEvento") String idEvento) {
		ModelAndView modelAndView = new ModelAndView("listaconvidados");
		modelAndView.addObject("idEvento", idEvento);
		if (idEvento == null) {
			modelAndView.addObject("convidados", convidadoService.obterTodos());
		} else {
			modelAndView.addObject("convidados", convidadoService.findByEvento(Long.valueOf(idEvento)));
		}
		return modelAndView;
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("idEvento") String idEvento, @RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone, Model model) {
		Convidado novoConvidado = new Convidado(nome, email, telefone);
		Eventos evento = eventoService.find(Long.valueOf(idEvento));
		novoConvidado.setEvento(evento);
		convidadoService.salvar(novoConvidado);
		new EmailService().enviar(nome, email, evento.getEmail());
		model.addAttribute("convidados", convidadoService.obterTodos());
		return "redirect:listaconvidados?idEvento=".concat(idEvento);
	}
}
