import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListaProdutos extends JFrame {
    private List<Produto> produtos;
    private DefaultTableModel tableModel;

    public ListaProdutos() {
        setTitle("Lista de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        produtos = new ArrayList<>();

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Valor"}, 0);
        JTable tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JButton adicionarBotao = new JButton("Cadastrar Novo Produto");
        adicionarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioProduto formularioProduto = new FormularioProduto(ListaProdutos.this, ListaProdutos.this);
                formularioProduto.setVisible(true);
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(adicionarBotao, BorderLayout.SOUTH);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        atualizarTabela();
    }

    private void atualizarTabela() {
        produtos.sort((p1, p2) -> Double.compare(p1.getValor(), p2.getValor()));
        tableModel.setRowCount(0);
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{produto.getNome(), produto.getValor()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaProdutos().setVisible(true);
            }
        });
    }
}