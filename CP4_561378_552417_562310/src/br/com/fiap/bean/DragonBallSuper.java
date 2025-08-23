package br.com.fiap.bean;

import java.io.*;

// Pietro Paranhos Wilhelm Rm:561378, Leonardo Rodrigues Martins Rm:552417, Gabriel Neris Losano Rm:564093, Pedro de Matos Previtali Rm:564184
public class DragonBallSuper implements IDBSuper {
    //Atributos da classe
    private String nome;
    private int ki;
    private int tecnicas;
    private int velocidade;
    private int transformacoes;

    //Construtores
    public DragonBallSuper() { }

    public DragonBallSuper(String nome, int ki, int tecnicas, int velocidade, int transformacoes) {
        this.nome = nome;
        this.ki = ki;
        this.tecnicas = tecnicas;
        this.velocidade = velocidade;
        this.transformacoes = transformacoes;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public int getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacoes() {
        return transformacoes;
    }

    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    // Metodos Particulares
    private String caminhoArquivo(String path) {
        return path + File.separator + getNome() + ".txt";
    }

    @Override
    public String gravar(String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo(path)))) { //BW -> Ele acumula caracters na memório e escreve no arquivo em blocos    , FW -> Basicamente é o que escreve os caracters diratamente num arquivo e ele cria e abre o arquivo de texto para gravar
            bw.write(getNome());                            bw.newLine();
            bw.write(Integer.toString(getKi()));            bw.newLine();
            bw.write(Integer.toString(getTecnicas()));      bw.newLine();
            bw.write(Integer.toString(getVelocidade()));    bw.newLine();
            bw.write(Integer.toString(getTransformacoes()));bw.newLine();
        }
        return "Gravado em: " + caminhoArquivo(path);
    }

    @Override
    public DragonBallSuper ler(String path) throws IOException { // IOEXCEPTION -> É uma exceção que verifica quando algo daá erro na leitura/escrita
        File f = new File(caminhoArquivo(path));
        if (!f.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + f.getAbsolutePath());  // Acredito que o nome já seja autoexplicativo, contudo retorna um erro caso não encontre o arquivo
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha1 = br.readLine();
            String linha2 = br.readLine();
            String linha3 = br.readLine();
            String linha4 = br.readLine();
            String linha5 = br.readLine();

            // validação mínima de formato
            if (linha1 == null || linha2 == null || linha3 == null || linha4 == null || linha5 == null) {
                throw new IOException("Arquivo malformado: linhas faltando.");
            }

            this.nome = linha1;
            this.ki = Integer.parseInt(linha2.trim());
            this.tecnicas = Integer.parseInt(linha3.trim());
            this.velocidade = Integer.parseInt(linha4.trim());
            this.transformacoes = Integer.parseInt(linha5.trim());
        }

        return this;
    }

    @Override
    public String toString() { //TS -> Devolve o texto do objeto, serve em JOptionPane
        return "Nome: " + nome +
                "\nKI: " + ki +
                "\nTécnicas: " + tecnicas +
                "\nVelocidade: " + velocidade +
                "\nTransformações: " + transformacoes;
    }
}
