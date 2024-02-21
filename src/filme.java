import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;
    private String paisOrigem;
    private Duracao duracao;
    private int avaliacao;
    private String sinopse;
    private List<String> diretores;
    private List<String> atoresPrincipais;
    private String classificacaoIndicativa;
    private double orcamento;
    private double receita;
    private String produtora;
    private String trailer;
    private List<String> premios;
    private List<String> criticas;
    private List<String> favoritosUsuarios;
    private List<String> comentariosUsuarios;
    private List<String> listaProducao;
    private Date dataLancamento;
    private String idiomaOriginal;
    private List<String> palavrasChave;
    private List<String> galeriaImagens;

    public Filme(String titulo, int ano, String genero, String paisOrigem, Duracao duracao, int avaliacao) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.paisOrigem = paisOrigem;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
        this.diretores = new ArrayList<>();
        this.atoresPrincipais = new ArrayList<>();
        this.premios = new ArrayList<>();
        this.criticas = new ArrayList<>();
        this.favoritosUsuarios = new ArrayList<>();
        this.comentariosUsuarios = new ArrayList<>();
        this.listaProducao = new ArrayList<>();
        this.palavrasChave = new ArrayList<>();
        this.galeriaImagens = new ArrayList<>();
    }

    public double calcularLucro() {
        return this.receita - this.orcamento;
    }

    public void adicionarPremio(String premio) {
        this.premios.add(premio);
    }

    public void adicionarCritica(String critica) {
        this.criticas.add(critica);
    }

    public void adicionarFavoritoUsuario(String usuario) {
        this.favoritosUsuarios.add(usuario);
    }

    public void adicionarComentarioUsuario(String comentario) {
        this.comentariosUsuarios.add(comentario);
    }

    public void adicionarListaProducao(String empresaProducao) {
        this.listaProducao.add(empresaProducao);
    }

    public void adicionarPalavraChave(String palavraChave) {
        this.palavrasChave.add(palavraChave);
    }

    public void adicionarImagem(String imagem) {
        this.galeriaImagens.add(imagem);
    }
}

class Ator {
    private String nome;
    private String identidade;

    public Ator(String nome, String identidade) {
        this.nome = nome;
        this.identidade = identidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }
}

class Diretor {
    private String nome;
    private String area;

    public Diretor(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

enum Duracao {
    CURTA,
    MEDIA,
    LONGA
}
