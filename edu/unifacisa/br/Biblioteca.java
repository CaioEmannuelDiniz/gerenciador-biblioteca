package edu.unifacisa.br;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Livro> livros;
    ArrayList<Revista> revistas;

    //Construtor
    public Biblioteca() {
        livros = new ArrayList<>();
        revistas = new ArrayList<>();
    }

    //Adicionar
    public boolean adicionarLivro(Livro livro) {
        return pesquisarLivro(livro.getTitulo()) == null && livros.add(livro);
    }

    public boolean adicionarRevista(Revista revista) {
        return pesquisarRevista(revista.getTitulo()) == null && revistas.add(revista);
    }

    //Remover
    public boolean removerLivro(Livro livro) {
        return livros.remove(livro);
    }

    public boolean removerRevista(Revista revista) {
        return revistas.remove(revista);
    }

    //Pesquisar
    public Livro pesquisarLivro(String titulo) {
        for (Livro liv : livros) {
            if (liv.getTitulo().equals(titulo)) {
                return liv;
            }
        }
        return null;
    }

    public Revista pesquisarRevista(String titulo) {
        for (Revista rev : revistas) {
            if (rev.getTitulo().equals(titulo)) {
                return rev;
            }
        }
        return null;
    }

    //Listar
    public String listarLivros() {
        StringBuilder titulosLivro = new StringBuilder();
        for (Livro liv : livros) {
            titulosLivro.append(liv.getTitulo()).append(",");

        }
        return titulosLivro.toString();
    }

    public String listarRevistas() {
       StringBuilder titulosRevista = new StringBuilder();
       for (Revista rev : revistas) {
           titulosRevista.append(rev.getTitulo()).append(",");
       }
       return titulosRevista.toString();
    }

}
