package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import util.ManipulaArquivoTXT;

public class JanelaPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu mnArquivo;
    private JMenuItem miNovo;
    private JMenuItem miAbrir;
    private JMenuItem miSalvar;
    private JMenuItem miSair;

    private JTextArea tatexto;

    public JanelaPrincipal() {

        super("Editor de texto Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barraMenu = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        miNovo = new JMenuItem("Novo");
        miAbrir = new JMenuItem("Abrir");
        miSalvar = new JMenuItem("Salvar");
        miSair = new JMenuItem("Sair");
        tatexto = new JTextArea();

        mnArquivo.add(miNovo);
        mnArquivo.add(miAbrir);
        mnArquivo.add(miSalvar);
        mnArquivo.addSeparator();
        mnArquivo.add(miSair);

        barraMenu.add(mnArquivo);
        this.setJMenuBar(barraMenu);

        this.getContentPane().add(tatexto);
        this.setSize(640, 480);
        this.setVisible(true);

        
        //Escuta do botão novo, utilizando classe interna anônima.
        miNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                miNovoOnClick();
            }

            private void miNovoOnClick() {
                tatexto.setText("");

            }

        });

        
        //Escuta do botão Abrir,  utilizando classe interna anônima.
        miAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                miAbrirOnClick();
            }

            private void miAbrirOnClick() {
                try {

                    JFileChooser arquivo = new JFileChooser();
                    int retorno = arquivo.showOpenDialog(null);

                    if (retorno == JFileChooser.APPROVE_OPTION) {
                        String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
                        String retorno2 = ManipulaArquivoTXT.lerArquivoTXT(nomeArquivo);

                        tatexto.setText(retorno2);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Erro, arquivo não existe");

                } catch (IOException ex) {

                    System.out.println("Erro" + ex);

                }

            }
        });

        //Escuta do botão salvar, utilizando classe interna anônima.
        miSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                miSalvarOnClick();
            }

            private void miSalvarOnClick() {
                try {

                    JFileChooser arquivo = new JFileChooser();
                    int retorno = arquivo.showSaveDialog(null);

                    if (retorno == JFileChooser.APPROVE_OPTION) {
                        String nomeArquivo = arquivo.getSelectedFile().getAbsolutePath();
                        String conteudo = tatexto.getText();
                        boolean retorno2 = ManipulaArquivoTXT.gravarArquivoTXT(nomeArquivo, conteudo);

                        if (retorno2 == true) {

                            JOptionPane.showMessageDialog(getContentPane(), "Arquivo salvo com sucesso");

                        }
                    }

                } catch (IOException ex) {

                    JOptionPane.showMessageDialog(getContentPane(), "Erro" + ex);

                }

            }
        });

        //Escuta do botão sair, utilizando classe interna anônima.
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                miSairOnClick();
            }

            private void miSairOnClick() {

                System.exit(0);
            }

        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JanelaPrincipal();
    }

}
