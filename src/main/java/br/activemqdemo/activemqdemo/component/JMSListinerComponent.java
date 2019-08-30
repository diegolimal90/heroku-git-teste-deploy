package br.activemqdemo.activemqdemo.component;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSListinerComponent {

	@Autowired
	private JmsTemplate jmsTemplateQueue;
	
	@Autowired
	private JmsTemplate jmsTemplateTopic;
	
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue(String str) {
		System.out.println("consumindo fila" + str);
	}
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue1(String str) {
		System.out.println("consumindo fila " + str);
	}
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue2(String str) {
		System.out.println("consumindo fila" + str);
	}
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue3(String str) {
		System.out.println("consumindo fila " + str);
	}
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue4(String str) {
		System.out.println("consumindo fila" + str);
	}
	@JmsListener(destination = "queue.sample")
	public void onReceiverQueue5(String str) {
		System.out.println("consumindo fila" + str);
	}
	
	@JmsListener(destination = "topic.sample", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(Message str) {
		System.out.println("consumindo topico" + str);
	}
	
	//"{user: 'wolmir', usando: 'fila'}"
	public void enviaMensagemFila(String mensagem) {
		jmsTemplateQueue.convertAndSend("queue.sample", mensagem);
	}
	
	//"{user: 'wolmir', usando: 'tópico'}"
	public void enviaMensagemTopico(String mensagem){
        jmsTemplateTopic.convertAndSend("topic.sample", mensagem);
	}
}
