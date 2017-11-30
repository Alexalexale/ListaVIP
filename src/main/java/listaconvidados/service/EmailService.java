package listaconvidados.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailDestinatario, String mensagem) {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("projeto.lab.eng.soft@gmail.com", "projeto.lab.eng.soft2017"));
			email.setSSLOnConnect(true);

			email.setFrom("projeto.lab.eng.soft@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá¡ " + nome + ". Você acaba de ser convidado pelo ListaVIP. &nbsp".concat(mensagem));
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		
	}

}
