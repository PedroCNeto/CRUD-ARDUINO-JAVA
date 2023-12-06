import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastroComponente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeComp;
	private JTextField txtPrecoComp;
	private JTextField txtIDComp;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					TelaCadastroComponente frame = new TelaCadastroComponente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroComponente(JFrame TelaInicial) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TelaInicial.setVisible(true);
			}
		});
		
		JFrame TelaAtual = this;
		
		setBounds(100, 100, 614, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVoltarTelaComponente = new JButton("Voltar");
		btnVoltarTelaComponente.setBounds(23, 21, 119, 44);
		btnVoltarTelaComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnVoltarTelaComponente.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		contentPane.add(btnVoltarTelaComponente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(78, 76, 466, 2);
		contentPane.add(separator);
		
		JLabel lblTituloCadComp = new JLabel("Cadastrar Componentes");
		lblTituloCadComp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 29));
		lblTituloCadComp.setBounds(123, 76, 421, 77);
		contentPane.add(lblTituloCadComp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(78, 151, 466, 2);
		contentPane.add(separator_1);
		
		int larguraParaTxt = ((TelaAtual.getWidth() / 2) - 20);
		int larguraParaLbl = ((TelaAtual.getWidth() /2) - 220);
		
		txtNomeComp = new JTextField();
		txtNomeComp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeComp.setBounds(287, 232, 156, 28);
		contentPane.add(txtNomeComp);
		txtNomeComp.setColumns(10);
		
		txtPrecoComp = new JTextField();
		txtPrecoComp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrecoComp.setColumns(10);
		txtPrecoComp.setBounds(287, 271, 156, 28);
		contentPane.add(txtPrecoComp);
		
		txtIDComp = new JTextField();
		txtIDComp.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDComp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIDComp.setEnabled(false);
		txtIDComp.setEditable(false);
		txtIDComp.setColumns(10);
		txtIDComp.setBounds(larguraParaTxt, 193, 156, 28);
		txtIDComp.setText(String.valueOf(TelaPrincipal.IdComponente));
		contentPane.add(txtIDComp);
		
		JLabel lblIDComp = new JLabel("ID (Automatico)");
		lblIDComp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDComp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblIDComp.setBounds(larguraParaLbl, 197, 165, 18);
		contentPane.add(lblIDComp);
		
		JLabel lblNomeDoComponente = new JLabel("Nome do componente");
		lblNomeDoComponente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoComponente.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNomeDoComponente.setBounds(87, 237, 165, 18);
		contentPane.add(lblNomeDoComponente);
		
		JLabel lblPrecoDoComponente = new JLabel("Preco do componente");
		lblPrecoDoComponente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecoDoComponente.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblPrecoDoComponente.setBounds(87, 276, 165, 18);
		contentPane.add(lblPrecoDoComponente);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblMensagem.setBounds(195, 377, 185, 14);
		contentPane.add(lblMensagem);
		
		JButton btnCadComp = new JButton("Cadastrar");
		btnCadComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente CompCad = new Componente();
				CompCad.setID(txtIDComp.getText());
				CompCad.setNome(txtNomeComp.getText());
				CompCad.setPreco(txtPrecoComp.getText());
				try {
		            float ValorPreco = Float.parseFloat(CompCad.getPreco());
		            if(ValorPreco >= 0) {
		            	TelaPrincipal.ComponentesCadastrados.add(CompCad);
		            	TelaPrincipal.IdComponente++;
		        		txtIDComp.setText(String.valueOf(TelaPrincipal.IdComponente));
		        		txtNomeComp.setText("");
		        		txtPrecoComp.setText("");
		            	
		            	lblMensagem.setText("Sucesso no cadastro");
		            }
		            else {
		            	lblMensagem.setText("ERRO: Preco menor que 0");
		            }

		        } catch (NumberFormatException e1) {
		            lblMensagem.setText("ERRO: O preco nao e valido.");
		        } 
			}
		});
		btnCadComp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		btnCadComp.setBounds(195, 310, 185, 56);
		contentPane.add(btnCadComp);
		
	}
}
