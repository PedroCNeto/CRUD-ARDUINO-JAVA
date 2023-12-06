import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DVAKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblKits;
	private JTextField txtAltNome;
	private JTextField txtAltPreco;
	private JTextField txtAltId;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DVAComponentes frame = new DVAComponentes();
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
	public void RecarregarTable(DefaultTableModel modelo) {
		for(Kit i : TelaPrincipal.KitsCadastrados) {
			modelo.addRow(new Object[] {i.getId(), i.getNome(), i.getPreco()});
			tblKits.setModel(modelo);
		}
	}
	
	public DVAKit(JFrame TelaInicial) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TelaInicial.setVisible(true);
			}
		});
		
		setBounds(100, 100, 614, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JFrame TelaAtual = this;
		
		JButton btnVoltarKits = new JButton("Voltar");
		btnVoltarKits.setBounds(28, 21, 119, 44);
		btnVoltarKits.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnVoltarKits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltarKits);
		
		setContentPane(contentPane);
		
		JScrollPane PainelTabela = new JScrollPane();
		PainelTabela.setBounds(28, 86, 393, 194);
		contentPane.add(PainelTabela);
		
		DefaultTableModel ModeloDados = new DefaultTableModel();
		
		ModeloDados.addColumn("Codigo");
		ModeloDados.addColumn("Nome");
		ModeloDados.addColumn("Preco");
		
		tblKits = new JTable();
		tblKits.setModel(ModeloDados);
		PainelTabela.setViewportView(tblKits);
		
		JPanel pnlExclusao = new JPanel();
		pnlExclusao.setBounds(377, 11, 211, 75);
		contentPane.add(pnlExclusao);
		pnlExclusao.setLayout(null);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnAlterar.setBounds(447, 194, 119, 44);
		contentPane.add(btnAlterar);
		
		JLabel lblMensagemBotao = new JLabel("");
		lblMensagemBotao.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		lblMensagemBotao.setBounds(157, 37, 332, 14);
		contentPane.add(lblMensagemBotao);
		JButton btnExcluir = new JButton("Excluir");
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaPrincipal.KitsCadastrados.size() > 0) {
					if(tblKits.getSelectedRowCount() > 0) {
						btnExcluir.setEnabled(false);
						btnAlterar.setEnabled(false);
						tblKits.setEnabled(false);
						pnlExclusao.setVisible(true);
					}
					else {
						lblMensagemBotao.setText("Selecione um linha para excluir!");
					}
				}
				else {
					lblMensagemBotao.setText("Adicione um componente para excluir!");
				}

			}
		});
		btnExcluir.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnExcluir.setBounds(447, 97, 119, 44);
		contentPane.add(btnExcluir);
		
		JPanel pnlAlteracao = new JPanel();
		pnlAlteracao.setBounds(28, 298, 538, 107);
		contentPane.add(pnlAlteracao);
		pnlAlteracao.setLayout(null);
		pnlAlteracao.setVisible(false);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaPrincipal.KitsCadastrados.size() > 0) {
					int Linha = tblKits.getSelectedRow();
					DefaultTableModel ModeloDados2 = (DefaultTableModel) tblKits.getModel();
					
					try {
						String Codigo = (String) ModeloDados2.getValueAt(Linha, 0);
						
						pnlAlteracao.setVisible(true);
						tblKits.setEnabled(false);
						btnAlterar.setEnabled(false);
						btnExcluir.setEnabled(false);
						
						for(Kit i : TelaPrincipal.KitsCadastrados) {
							if(Codigo == i.getId()) {
								txtAltId.setText(i.getId());
								txtAltNome.setText(i.getNome());
								txtAltPreco.setText(i.getPreco());
								break;
							}
						}
						
					} catch (Exception e2) {
						lblMensagemBotao.setText("Selecione uma linha para alterar!");
					}

					
				}
				else {
					lblMensagemBotao.setText("Adicione um kit para alterar!");
				}
			}
		});
		
		JButton btnConfirmarAlt = new JButton("Confirmar");
		btnConfirmarAlt.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
		            float ValorPreco = Float.parseFloat(txtAltPreco.getText());
		            if(ValorPreco >= 0) {
		            	int Linha = tblKits.getSelectedRow();
						String Codigo = (String) ModeloDados.getValueAt(Linha, 0);
						Kit temp = null;
						for(Kit i : TelaPrincipal.KitsCadastrados) {
							if(Codigo == i.getId()) {
								temp = i;
								break;
							}
						}
						temp.setNome(txtAltNome.getText());
						temp.setPreco(txtAltPreco.getText());
						ModeloDados.setValueAt(txtAltNome.getText(), Linha, 1);
						ModeloDados.setValueAt(txtAltPreco.getText(), Linha, 2);
						pnlAlteracao.setVisible(false);
						tblKits.setEnabled(true);
						btnAlterar.setEnabled(true);
						btnExcluir.setEnabled(true);
						
						for (Composicao i : TelaPrincipal.ComposicoesCadastradas) {
							if(i.getIDKit() == Codigo) {
								i.setNomeKit(txtAltNome.getText());
							}
						}
		            	
		            	lblMensagemBotao.setText("Alteracao Concluida");
		            }
		            else {
		            	lblMensagemBotao.setText("ERRO: Preco menor que 0");
		            }

		        } catch (NumberFormatException e1) {
		            lblMensagemBotao.setText("ERRO: O preco nao e valido.");
		        } 
						
			}
		});
		btnConfirmarAlt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnConfirmarAlt.setBounds(295, 10, 108, 36);
		pnlAlteracao.add(btnConfirmarAlt);
		
		
		JButton btnCancelarAlt = new JButton("Cancelar");
		btnCancelarAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAlteracao.setVisible(false);
				tblKits.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		btnCancelarAlt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnCancelarAlt.setBounds(295, 57, 108, 36);
		pnlAlteracao.add(btnCancelarAlt);
		
		txtAltId = new JTextField();
		txtAltId.setEditable(false);
		txtAltId.setEnabled(false);
		txtAltId.setBounds(122, 11, 119, 20);
		pnlAlteracao.add(txtAltId);
		txtAltId.setColumns(10);
		
		txtAltNome = new JTextField();
		txtAltNome.setBounds(122, 42, 119, 20);
		pnlAlteracao.add(txtAltNome);
		txtAltNome.setColumns(10);
		
		txtAltPreco = new JTextField();
		txtAltPreco.setBounds(122, 73, 119, 20);
		pnlAlteracao.add(txtAltPreco);
		txtAltPreco.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel.setBounds(66, 14, 46, 14);
		pnlAlteracao.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(66, 45, 46, 14);
		pnlAlteracao.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_2 = new JLabel("Preco:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(66, 76, 46, 14);
		pnlAlteracao.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		pnlExclusao.setVisible(false);
		
		JButton btnConfirmarExclusao = new JButton("Sim");
		btnConfirmarExclusao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Linha = tblKits.getSelectedRow();
				DefaultTableModel ModeloDados2 = (DefaultTableModel) tblKits.getModel();
				String Codigo = (String) ModeloDados2.getValueAt(Linha, 0);
				
				for (Kit i : TelaPrincipal.KitsCadastrados) {
					if (i.getId() == Codigo) {
						ModeloDados.removeRow(Linha);
						TelaPrincipal.KitsCadastrados.remove(i);
						lblMensagemBotao.setText("Exclusao concluida!");
						break;
					}
				}
				TelaPrincipal.ComposicoesCadastradas.removeIf(t -> t.getIDKit() == Codigo);

				
				pnlExclusao.setVisible(false);
				tblKits.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				
			}
		});
		btnConfirmarExclusao.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnConfirmarExclusao.setBounds(13, 42, 89, 23);
		pnlExclusao.add(btnConfirmarExclusao);
		
		JButton btnNegarExclusao = new JButton("Nao");
		btnNegarExclusao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlExclusao.setVisible(false);
				tblKits.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		btnNegarExclusao.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnNegarExclusao.setBounds(112, 42, 89, 23);
		pnlExclusao.add(btnNegarExclusao);
		
		JLabel lblNewLabel_3 = new JLabel("Deseja excluir?");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(63, 11, 122, 14);
		pnlExclusao.add(lblNewLabel_3);
		
		
		RecarregarTable(ModeloDados);
	}
}
