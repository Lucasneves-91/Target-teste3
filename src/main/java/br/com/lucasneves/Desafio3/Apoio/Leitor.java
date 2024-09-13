package br.com.lucasneves.Desafio3.Apoio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Leitor {
    private final String nomeArquivo;
    private List<Dados> dadosList;

    public Leitor(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.dadosList = objectMapper.readValue(lerArquivo(), new TypeReference<>(){});
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    private File lerArquivo() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + this.nomeArquivo);

        return resource.getFile();
    }

    public List<Dados> getArquivoCompleto() {
        return this.dadosList;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public List<Dados> getDadosList() {
        return dadosList;
    }

    public void setDadosList(List<Dados> dadosList) {
        this.dadosList = dadosList;
    }
}
