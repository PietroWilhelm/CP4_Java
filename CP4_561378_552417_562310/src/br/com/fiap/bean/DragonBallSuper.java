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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo(path)))) {
            bw.write(getNome());                            bw.newLine();
            bw.write(Integer.toString(getKi()));            bw.newLine();
            bw.write(Integer.toString(getTecnicas()));      bw.newLine();
            bw.write(Integer.toString(getVelocidade()));    bw.newLine();
            bw.write(Integer.toString(getTransformacoes()));bw.newLine();
        }
        return "Gravado em: " + caminhoArquivo(path);
    }

    @Override
    public DragonBallSuper ler(String path) throws IOException {
        File file = new File(caminhoArquivo(path));
        if (!file.exists()) return null;  // permite o main decidir a mensagem

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            this.nome = safeStr(br.readLine());
            this.ki   = converteInt(safeStr(br.readLine()));
            this.tecnicas = converteInt(safeStr(br.readLine()));
            this.velocidade = converteInt(safeStr(br.readLine()));
            this.transformacoes = converteInt(safeStr(br.readLine()));
        }
        return this;
    }

    private static String safeStr(String s) {
        return s == null ? "" : s.trim();
    }

    private static int converteInt(String s) {
        try {
            return Integer.parseInt(s.trim());

        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nKI: " + ki +
                "\nTécnicas: " + tecnicas +
                "\nVelocidade: " + velocidade +
                "\nTransformações: " + transformacoes;
    }
}
