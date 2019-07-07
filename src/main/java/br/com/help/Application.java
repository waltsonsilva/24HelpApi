package br.com.help;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.help.beans.Profissional;
import br.com.help.beans.Profissional.ProfissionalBuilder;
import br.com.help.enums.Servicos;
import br.com.help.repository.ProfissionalRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
		ProfissionalBuilder pro = Profissional.builder().cpf("111.111.111-12")
				.id(1)
				.nome("Teste Builder")
				.servico(Servicos.JARDINAGEM);
		
		System.out.println(pro);
	}

	 @Bean
	    CommandLineRunner init(ProfissionalRepository service) {
	        return args -> {
	        	service.deleteAll();
	            LongStream.range(1, 11)
	                    .mapToObj(i -> {
	                        Profissional c = new Profissional();
	                        c.setNome("Contact " + i);
	                        c.setServico(Servicos.ELETRICO);
	                        c.setCpf("(111) 111-1111");
	                        return c;
	                    })
	                    .map(v -> service.save(v))
	                    .forEach(System.out::println);
	        };
	    }
}
