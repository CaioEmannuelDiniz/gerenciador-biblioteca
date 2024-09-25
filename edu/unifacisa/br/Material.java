package edu.unifacisa.br;

public class Material {
    private String titulo;
    private String autor;

    //Construtor
    public Material(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Material() {
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }


    @Override
    public String toString() {
        return "Material{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
