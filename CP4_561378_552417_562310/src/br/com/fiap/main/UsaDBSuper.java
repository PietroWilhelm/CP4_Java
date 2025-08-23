package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.JOptionPane;
import java.io.IOException;

// Pietro Paranhos Wilhelm Rm:561378, Leonardo Rodrigues Martins Rm:552417, Gabriel Neris Losano Rm:564093, Pedro de Matos Previtali Rm:564184
public class UsaDBSuper {
    public static void main(String[] args) {
        String aux, path, nome;
        int opcao;

        do {
            try {
                aux  = JOptionPane.showInputDialog("Registro Dos DBSuper Escolha: \n1.Cadastrar \n2.Consultar \n0.Sair");
                opcao = Integer.parseInt(aux);

                if (opcao == 0) break; // sair

                if (opcao != 1 && opcao != 2) {
                    JOptionPane.showMessageDialog(null, "Escolha incorreta (use 1, 2 ou 0).");
                    continue;
                }

                path  = JOptionPane.showInputDialog("Digite caminho da pasta/ Exemplo: C://Nome do arquivo");

                DragonBallSuper p = new DragonBallSuper();

                switch (opcao) {
                    case 1: {
                        nome = JOptionPane.showInputDialog("Nome:");
                        int ki = Integer.parseInt(JOptionPane.showInputDialog("Digite o Ki:"));
                        int tecnicas = Integer.parseInt(JOptionPane.showInputDialog("Digite as técnicas:"));
                        int velocidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade:"));
                        int transf = Integer.parseInt(JOptionPane.showInputDialog("Digite quantas transformações possui:"));

                        p.setNome(nome);
                        p.setKi(ki);
                        p.setTecnicas(tecnicas);
                        p.setVelocidade(velocidade);
                        p.setTransformacoes(transf);

                        JOptionPane.showMessageDialog(null, p.gravar(path));
                        break;
                    }
                    case 2: {
                        nome = JOptionPane.showInputDialog("Digite o nome do personagem:");
                        p.setNome(nome);
                        p = p.ler(path);

                        if (p == null) {
                            JOptionPane.showMessageDialog(null, "Caminho e/ou nome inexistente");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Exibindo dados:\nCaminho: " + path +
                                            "\nArquivo: " + nome + ".txt\n\n" + p.toString());
                        }
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números: 0, 1 ou 2." + e.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo!\n" + e.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de programa!");
    }
}