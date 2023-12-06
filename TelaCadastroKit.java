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

public class TelaCadastroKit extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeKit;
	private JTextField txtPrecoKit;
	private JTextField txtIDKit;

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
	public TelaCadastroKit(JFrame TelaInicial) {
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
		
		JButton btnVoltarTelaKit = new JButton("Voltar");
		btnVoltarTelaKit.setBounds(23, 21, 119, 44);
		btnVoltarTelaKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnVoltarTelaKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		contentPane.add(btnVoltarTelaKit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(78, 76, 466, 2);
		contentPane.add(separator);
		
		JLabel lblTituloCadKits = new JLabel("Cadastrar Kits");
		lblTituloCadKits.setFont(new Font("Microsoft YaHei", Font.PLAIN, 29));
		lblTituloCadKits.setBounds(204, 76, 421, 77);
		contentPane.add(lblTituloCadKits);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(78, 151, 466, 2);
		contentPane.add(separator_1);
		
		int larguraParaTxt = ((TelaAtual.getWidth() / 2) - 20);
		int larguraParaLbl = ((TelaAtual.getWidth() /2) - 220);
		
		txtNomeKit = new JTextField();
		txtNomeKit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeKit.setBounds(287, 232, 156, 28);
		contentPane.add(txtNomeKit);
		txtNomeKit.setColumns(10);
		
		txtPrecoKit = new JTextField();
		txtPrecoKit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrecoKit.setColumns(10);
		txtPrecoKit.setBounds(287, 271, 156, 28);
		contentPane.add(txtPrecoKit);
		
		txtIDKit = new JTextField();
		txtIDKit.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDKit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIDKit.setEnabled(false);
		txtIDKit.setEditable(false);
		txtIDKit.setColumns(10);
		txtIDKit.setBounds(larguraParaTxt, 193, 156, 28);
		txtIDKit.setText(String.valueOf(TelaPrincipal.idKit));
		contentPane.add(txtIDKit);
		
		JLabel lblIDKit = new JLabel("ID (Automatico)");
		lblIDKit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblIDKit.setBounds(larguraParaLbl, 197, 165, 18);
		contentPane.add(lblIDKit);
		
		JLabel lblNomeDoKit = new JLabel("Nome do kit");
		lblNomeDoKit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNomeDoKit.setBounds(87, 237, 165, 18);
		contentPane.add(lblNomeDoKit);
		
		JLabel lblPrecoDoKit = new JLabel("Preco do componente");
		lblPrecoDoKit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecoDoKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblPrecoDoKit.setBounds(87, 276, 165, 18);
		contentPane.add(lblPrecoDoKit);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblMensagem.setBounds(195, 377, 185, 14);
		contentPane.add(lblMensagem);
		
		JButton btnCadKit = new JButton("Cadastrar");
		btnCadKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kit KitCad = new Kit();
				KitCad.setId(txtIDKit.getText());
				KitCad.setNome(txtNomeKit.getText());
				KitCad.setPreco(txtPrecoKit.getText());
				try {
		            float ValorPreco = Float.parseFloat(KitCad.getPreco());
		            if(ValorPreco >= 0) {
		            	TelaPrincipal.KitsCadastrados.add(KitCad);
		            	TelaPrincipal.idKit++;
		            	txtIDKit.setText(String.valueOf(TelaPrincipal.idKit));
		            	txtNomeKit.setText("");
		            	txtPrecoKit.setText("");
		            	
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
		btnCadKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		btnCadKit.setBounds(195, 310, 185, 56);
		contentPane.add(btnCadKit);
		
	}
}
