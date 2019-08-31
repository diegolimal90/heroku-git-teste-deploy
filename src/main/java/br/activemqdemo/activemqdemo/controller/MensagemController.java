package br.activemqdemo.activemqdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.activemqdemo.activemqdemo.component.JMSListinerComponent;

@RestController
public class MensagemController {

	@Autowired
	private JMSListinerComponent message;
	
	@PostMapping("/fila/mensagem")
	public void mensagem(@RequestBody String mensagem) {
		message.enviaMensagemFila(mensagem);
	}
	
	@GetMapping("/")
	public String hello() {
		return "Olá mundo!";
	}
}
