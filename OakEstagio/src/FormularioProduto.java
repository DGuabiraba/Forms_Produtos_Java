import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormularioProduto extends JDialog {
    private JTextField nomeCampo;
    private JTextArea descricaoArea;
    private JTextField valorCampo;
    private JComboBox<String> disponivelCombo;
    private ListaProdutos listaProdutos;

    public FormularioProduto(JFrame parent, ListaProdutos listaProdutos) {
        super(parent, "Cadastrar Produto", true);
        this.listaProdutos = listaProdutos;

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel nomeLabel = new JLabel("Nome do produto:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nomeLabel, constraints);

        nomeCampo = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(nomeCampo, constraints);

        JLabel descricaoLabel = new JLabel("Descrição do produto:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(descricaoLabel, constraints);

        descricaoArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(descricaoArea);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(scrollPane, constraints);

        JLabel valorLabel = new JLabel("Valor do produto:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(valorLabel, constraints);

        valorCampo = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(valorCampo, constraints);

        JLabel disponivelLabel = new JLabel("Disponível para venda:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(disponivelLabel, constraints);

        disponivelCombo = new JComboBox<>(new String[]{"Sim", "Não"});
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(disponivelCombo, constraints);

        JButton salvarBotao = new JButton("Salvar");
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeCampo.getText();
                String descricao = descricaoArea.getText();
                double valor = Double.parseDouble(valorCampo.getText());
                boolean disponivel = disponivelCombo.getSelectedItem().equals("Sim");

                Produto produto = new Produto(nome, descricao, valor, disponivel);
                listaProdutos.adicionarProduto(produto);
                dispose();
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(salvarBotao, constraints);

        pack();
        setLocationRelativeTo(parent);
    }
}