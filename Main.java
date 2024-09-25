import edu.unifacisa.br.*;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        String escolhaMenuPrincipal;

        final String[] OPCOES_MENU = {
                "Adicionar Novo Material",
                "Pesquisar Material Título",
                "Excluir Material Título",
                "Listar Todos os Materiais",
                "Sair do Sistema"
        };

        final String[] OPCOES_MENU_MATERIAL = {
                "Livro",
                "Revista"
        };

        Biblioteca biblioteca = new Biblioteca();

        do {
            escolhaMenuPrincipal = (String) JOptionPane.showInputDialog(
                    null,
                    "Navegue no menu e escolha uma opção:",
                    "Biblioteca Virtual - Menu", JOptionPane.QUESTION_MESSAGE,
                    null, OPCOES_MENU, OPCOES_MENU[0]
            );

            switch (escolhaMenuPrincipal) {
                case "Adicionar Novo Material": // Adicionar Livro
                    menuAdicionar(biblioteca, OPCOES_MENU_MATERIAL);
                    break;

                case "Pesquisar Material Título": // Buscar Livro por Título
                    menuPesquisarLivro(biblioteca, OPCOES_MENU_MATERIAL);
                    break;

                case "Excluir Material Título": // Remover Livro
                    menuExcluir(biblioteca, OPCOES_MENU_MATERIAL);
                    break;

                case "Listar Todos os Materiais": // Listar Livros
                    menuListar(biblioteca, OPCOES_MENU_MATERIAL);
                    break;

                case "Sair do Sistema": // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...", "Biblioteca Virtual - Sair", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case null:
                    JOptionPane.showMessageDialog(null, "Saindo...", "Biblioteca Virtual - Sair", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    escolhaMenuPrincipal = "Sair do Sistema";
                    JOptionPane.showMessageDialog(null, "Saindo...", "Biblioteca Virtual - Sair", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } while (escolhaMenuPrincipal != null && !escolhaMenuPrincipal.equals("Sair do Sistema")); // Continua até o usuário escolher sair
    }

    public static void menuAdicionar(Biblioteca biblioteca, String[] OPCOES_MENU_MATERIAL) {

        boolean sucesso;

        String escolhaMenuLivro;
        String titulo;
        String autor;
        String numero;

        escolhaMenuLivro = (String) JOptionPane.showInputDialog(
                null,
                "Navegue no menu e escolha uma opção:",
                "Biblioteca Virtual - Tipo De Material", JOptionPane.QUESTION_MESSAGE,
                null, OPCOES_MENU_MATERIAL, OPCOES_MENU_MATERIAL[0]
        );

        if (escolhaMenuLivro == null) return;

        titulo = obterEntrada("Digite o título:");
        if (titulo == null) return;

        autor = obterEntrada("Digite o autor:");
        if (autor == null) return;

        switch (escolhaMenuLivro) {

            case "Livro":
                Genero[] generos = Genero.values();

                Genero genero = (Genero) JOptionPane.showInputDialog(
                        null,
                        "Navegue no menu e escolha uma opção:",
                        "Biblioteca Virtual - Livro Tipo", JOptionPane.QUESTION_MESSAGE,
                        null, generos, generos
                );

                if (genero == null) return;

                Livro livro = new Livro();
                livro = new Livro(titulo, autor, genero);

                sucesso = biblioteca.adicionarLivro(livro);

                JOptionPane.showMessageDialog(
                        null,
                        sucesso ?
                                "Livro adicionado com sucesso!" :
                                "Livro não foi adicionado!",
                        "Livro Cadastrar!",
                        sucesso ?
                                JOptionPane.INFORMATION_MESSAGE :
                                JOptionPane.ERROR_MESSAGE,
                        null
                );
                break;

            case "Revista":
                int numeroInt;
                do {
                    numero = obterEntrada("Digite o número da revista:");

                    if (numero == null) return;

                    numeroInt = Integer.parseInt(numero);

                    if (numeroInt < 0) {
                        JOptionPane.showMessageDialog(null,
                                "Número da revista precisa ser maior ou igual a 0, e inteiro.",
                                "Número Revista - ERRO",
                                JOptionPane.WARNING_MESSAGE,
                                null);
                    }

                } while (numeroInt < 0);

                Revista revista = new Revista(titulo, autor, numeroInt);

                sucesso = biblioteca.adicionarRevista(revista);

                JOptionPane.showMessageDialog(
                        null,
                        sucesso ?
                                "Revista adicionado com sucesso!" :
                                "Revista não foi adicionado!",
                        "Revista Cadastrar!",
                        sucesso ?
                                JOptionPane.INFORMATION_MESSAGE :
                                JOptionPane.ERROR_MESSAGE,
                        null
                );

                break;

            default:

                break;
        }

    }

    public static void menuExcluir(Biblioteca biblioteca, String[] OPCOES_MENU_MATERIAL) {

        boolean sucesso;

        String escolhaMenuLivro;
        String titulo;

        escolhaMenuLivro = (String) JOptionPane.showInputDialog(
                null,
                "Navegue no menu e escolha uma opção:",
                "Biblioteca Virtual - Tipo De Material", JOptionPane.QUESTION_MESSAGE,
                null, OPCOES_MENU_MATERIAL, OPCOES_MENU_MATERIAL[0]
        );

        if (escolhaMenuLivro == null) return;

        switch (escolhaMenuLivro) {

            case "Livro":

                final String[] TITULOLIVROS = biblioteca.listarLivros().split(",");

                titulo = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção:",
                        "Biblioteca Virtual - Titulo Do Livro", JOptionPane.QUESTION_MESSAGE,
                        null, TITULOLIVROS, TITULOLIVROS[0]);

                if (titulo == null) return;

                Livro livro = biblioteca.pesquisarLivro(titulo);

                if (livro == null) return;

                sucesso = biblioteca.removerLivro(livro);

                JOptionPane.showMessageDialog(
                        null,
                        sucesso ?
                                "Livro excluido com sucesso!" :
                                "Livro não foi excluido!",
                        "Livro Excluido!",
                        sucesso ?
                                JOptionPane.INFORMATION_MESSAGE :
                                JOptionPane.ERROR_MESSAGE,
                        null
                );
                break;

            case "Revista":

                final String[] TITULOREVISTAS = biblioteca.listarRevistas().split(",");

                titulo = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção:",
                        "Biblioteca Virtual - Titulo Do Livro", JOptionPane.QUESTION_MESSAGE,
                        null, TITULOREVISTAS, TITULOREVISTAS[0]);

                if (titulo == null) return;

                Revista revista = biblioteca.pesquisarRevista(titulo);

                if (revista == null) return;

                sucesso = biblioteca.removerRevista(revista);

                JOptionPane.showMessageDialog(
                        null,
                        sucesso ?
                                "Revista excluido com sucesso!" :
                                "Revista não foi excluido!",
                        "Revista Excluida!",
                        sucesso ?
                                JOptionPane.INFORMATION_MESSAGE :
                                JOptionPane.ERROR_MESSAGE,
                        null
                );

                break;

            default:

                break;
        }

    }

    public static void menuListar(Biblioteca biblioteca, String[] OPCOES_MENU_MATERIAL) {


        String escolhaMenuLivro;
        String titulo;

        escolhaMenuLivro = (String) JOptionPane.showInputDialog(
                null,
                "Navegue no menu e escolha uma opção:",
                "Biblioteca Virtual - Tipo De Material", JOptionPane.QUESTION_MESSAGE,
                null, OPCOES_MENU_MATERIAL, OPCOES_MENU_MATERIAL[0]
        );

        if (escolhaMenuLivro == null) return;

        switch (escolhaMenuLivro) {

            case "Livro":

                final String[] TITULOLIVROS = biblioteca.listarLivros().split(",");

                titulo = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção:",
                        "Biblioteca Virtual - Titulo Do Livro", JOptionPane.QUESTION_MESSAGE,
                        null, TITULOLIVROS, TITULOLIVROS[0]);

                if (titulo == null) return;

                break;

            case "Revista":

                final String[] TITULOREVISTAS = biblioteca.listarRevistas().split(",");

                titulo = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção:",
                        "Biblioteca Virtual - Titulo Do Livro", JOptionPane.QUESTION_MESSAGE,
                        null, TITULOREVISTAS, TITULOREVISTAS[0]);

                if (titulo == null) return;

                break;

            default:

                break;
        }

    }

    public static void menuPesquisarLivro(Biblioteca biblioteca, String[] OPCOES_MENU_MATERIAL) {

       String escolhaMenuLivro;

        String titulo;

        escolhaMenuLivro = (String) JOptionPane.showInputDialog(
                null,
                "Navegue no menu e escolha uma opção:",
                "Biblioteca Virtual - Tipo De Material", JOptionPane.QUESTION_MESSAGE,
                null, OPCOES_MENU_MATERIAL, OPCOES_MENU_MATERIAL[0]
        );

        if (escolhaMenuLivro == null) return;

        titulo = obterEntrada("Digite o título:");
        if (titulo == null) return;

        switch (escolhaMenuLivro) {

            case "Livro":

                Livro livro = biblioteca.pesquisarLivro(titulo);

                if (livro == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Livro não Localizado",
                            "Dados do Livro", JOptionPane.ERROR_MESSAGE,
                            null);
                    return;
                }

                JOptionPane.showMessageDialog(
                        null, livro.toString(),
                        "Dados do Livro", JOptionPane.INFORMATION_MESSAGE,
                        null);

                break;

            case "Revista":

                Revista revista = biblioteca.pesquisarRevista(titulo);

                if (revista == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Revista não Localizado",
                            "Dados da Revista", JOptionPane.ERROR_MESSAGE,
                            null);
                    return;
                }

                JOptionPane.showMessageDialog(
                        null, revista.toString(),
                        "Dados da Revista", JOptionPane.INFORMATION_MESSAGE,
                        null);

                break;
            default:

                break;
        }

    }

    public static String obterEntrada(String mensagem) {

        String entrada;

        while (true) {
            entrada = JOptionPane.showInputDialog(null, mensagem, "Biblioteca Virtual - Entrada", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null)
                return null; // Caso o usuário clique em "Cancelar" a entrada será igual a null e ele será redirecionado para o menu inicial.

            else if (entrada.trim().isEmpty())
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Biblioteca Virtual - Erro", JOptionPane.ERROR_MESSAGE);

            else break;
        }
        return entrada.trim();
    }
}


