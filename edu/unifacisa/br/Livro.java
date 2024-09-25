package edu.unifacisa.br;

public class Livro extends Material {
    private final Genero GENERO;

    //Construtor
    public Livro(String titulo, String autor, Genero GENERO) {
        super(titulo, autor);
        this.GENERO = GENERO;
    }

    public Livro() {
        super();
        this.GENERO=null;

    }

    //Getters
    public Genero getGenero() {

        return GENERO;
    }

    @Override
    public String toString() {
        return "Livro" +
                "\nTITULO: " + getTitulo() +
                "\nAUTOR: " + getAutor() +
                "\nGENERO: " + getGenero();
    }
}
