package br.com.lucasneves.Desafio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Leitor leitor = new Leitor("dados.json");
		double faturamentoMes = 0.0;
		List<Dados> arquivoSemZerados = new ArrayList<>();


		List<Dados> arquivoCompleto = leitor.getArquivoCompleto();

		for(Dados dados : arquivoCompleto) {
			if(dados.getValor() > 0.0) {
				faturamentoMes += dados.getValor();
				arquivoSemZerados.add(dados);
			}
		}

		double media = faturamentoMes / arquivoSemZerados.size();

		arquivoSemZerados.sort(Comparator.comparing(Dados::getValor));

		Dados menorFaturamento = arquivoSemZerados.get(0);
		Dados maiorFaturamento = arquivoSemZerados.get(arquivoSemZerados.size() -1);

		int countDiasAcimaDaMedia = 0;

		for(Dados dados : arquivoSemZerados) {
			if(dados.getValor() > media) {
				countDiasAcimaDaMedia++;
			}
		}

		System.out.println("Menor faturamento: " + menorFaturamento);
		System.out.println("Maior faturamento: " + maiorFaturamento);
		System.out.println("Dias acima da média: " + countDiasAcimaDaMedia);
	}

	}


