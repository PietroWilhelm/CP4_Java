package br.com.fiap.bean;

import java.io.IOException;

public interface IDBSuper {
    // Exceções para ler e gravar
    DragonBallSuper ler(String path) throws IOException;
    String gravar(String path) throws IOException;
}
