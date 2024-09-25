package edu.unifacisa.br;

public class Revista extends Material{
    private final int NUMERO;

    //Construtor
    public Revista(String titulo, String autor, int NUMERO) {
        super(titulo, autor);
        this.NUMERO = NUMERO;
    }

    //Getters
    public int getNumero() {
        return NUMERO;
    }

    @Override
    public String toString() {
        return "Revista" +
                "\nTITULO: " + getTitulo() +
                "\nAUTOR: " + getAutor() +
                "\nNUMERO: " + getNumero();
    }
}
