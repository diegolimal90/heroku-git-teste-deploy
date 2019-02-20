package br.activemqdemo.activemqdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
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
		System.out.println(str);
	}
	
	@JmsListener(destination = "topic.sample", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(String str) {
		System.out.println(str);
	}
	
	public void run(ApplicationArguments args) throws Exception{
		jmsTemplateQueue.convertAndSend("queue.sample", "{user: 'wolmir', usando: 'fila'}");
        jmsTemplateTopic.convertAndSend("topic.sample", "{user: 'wolmir', usando: 'tópico'}");
	}
}
