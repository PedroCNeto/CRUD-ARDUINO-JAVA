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
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaComposicaoKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblComposicao;
	private JTextField txtQuantidade;
	private JTextField txtNovaQtd;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComposicaoKit frame = new TelaComposicaoKit();
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
	
	public void RecarregarTable(DefaultTableModel modelo, String idKit) {
		modelo.setRowCount(0);
		tblComposicao.setModel(modelo);
		for(Composicao i : TelaPrincipal.ComposicoesCadastradas) {
			if(i.getIDKit().equals(idKit)) {
				modelo.addRow(new Object[] {i.getIDcomp(), i.getNomeKit(), i.getNomeComponente(), i.getQuantidade()});
			}
			tblComposicao.setModel(modelo);
		}
	}
	
	
	public TelaComposicaoKit(JFrame TelaInicial) {
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
		
		JButton btnVoltarComposicao = new JButton("Voltar");
		btnVoltarComposicao.setBounds(28, 21, 119, 44);
		btnVoltarComposicao.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnVoltarComposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVoltarComposicao);
		
		setContentPane(contentPane);
		
		JComboBox<ComboItem> cbComponentes = new JComboBox<ComboItem>();
		cbComponentes.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		cbComponentes.setBounds(136, 301, 119, 22);
		contentPane.add(cbComponentes);
		
		JComboBox<ComboItem> cbKits = new JComboBox<ComboItem>();
		cbKits.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		cbKits.setBounds(136, 334, 119, 22);
		contentPane.add(cbKits);
		
		JComboBox<ComboItem> cbKitsBusca = new JComboBox<ComboItem>();
		cbKitsBusca.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		cbKitsBusca.setBounds(372, 33, 84, 22);
		contentPane.add(cbKitsBusca);
		
		JLabel lblNewLabel = new JLabel("Componentes:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel.setBounds(28, 305, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblKits = new JLabel("Kits:");
		lblKits.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKits.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblKits.setBounds(28, 338, 98, 14);
		contentPane.add(lblKits);
		
		JScrollPane PainelTabela = new JScrollPane();
		PainelTabela.setBounds(28, 82, 428, 184);
		contentPane.add(PainelTabela);
		
		tblComposicao = new JTable();
		DefaultTableModel ModeloDados = new DefaultTableModel();
		ModeloDados.addColumn("ID");
		ModeloDados.addColumn("Kit");
		ModeloDados.addColumn("Componente");
		ModeloDados.addColumn("Quantidade");
		


		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(136, 367, 119, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		tblComposicao = new JTable();
		tblComposicao.setModel(ModeloDados);
		PainelTabela.setViewportView(tblComposicao);
		
		PainelTabela.setViewportView(tblComposicao);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblMensagem.setBounds(153, 33, 236, 14);
		contentPane.add(lblMensagem);
		
		JButton btnBuscarKit = new JButton("Buscar");
		btnBuscarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaPrincipal.KitsCadastrados.size() <= 0) {
					lblMensagem.setText("Insira kits!");
				}
				else {
					Object IdKitBuscar = cbKitsBusca.getSelectedItem();

					RecarregarTable(ModeloDados, ((ComboItem)IdKitBuscar).getValue());	
				}
			}
		});
		btnBuscarKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnBuscarKit.setBounds(466, 21, 113, 44);
		contentPane.add(btnBuscarKit);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtQuantidade.getText().isEmpty()) {
					lblMensagem.setText("Insira uma quantidade!");
				}
				else if(cbComponentes.getSelectedItem() == null) {
					lblMensagem.setText("Selecione um componente valido!");
				}
				else if(cbKits.getSelectedItem() == null) {
					lblMensagem.setText("Selecione um kit valido!");
				}
				else {
					
					try {
						int quantidade = Integer.valueOf(txtQuantidade.getText());
						if (quantidade > 0) {
							Object ComponenteItem = cbComponentes.getSelectedItem();
							Object KitItem = cbKits.getSelectedItem();
							Composicao Comp = new Composicao();
							Comp.setIDcomp(TelaPrincipal.idComposicao);
							Comp.setIDComponente(((ComboItem)ComponenteItem).getValue());
							Comp.setNomeComponente(((ComboItem)ComponenteItem).toString());
							Comp.setIDKit(((ComboItem)KitItem).getValue());
							Comp.setNomeKit(((ComboItem)KitItem).toString());
							Comp.setQuantidade(quantidade);

	
							lblMensagem.setText("Sucesso no cadastro!");
							txtQuantidade.setText("");
							TelaPrincipal.ComposicoesCadastradas.add(Comp);
							TelaPrincipal.idComposicao++;
							Object IdKitBuscar = cbKitsBusca.getSelectedItem();
							RecarregarTable(ModeloDados, ((ComboItem)IdKitBuscar).getValue());
						}
						else {
							lblMensagem.setText("Quantidade tem que ser maior que 0");
						}
					} catch (Exception e2) {
						lblMensagem.setText("Insira uma quantidade valida!");
					}
						

				}
			}
		});
		btnCadastrar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnCadastrar.setBounds(466, 82, 113, 44);
		contentPane.add(btnCadastrar);

		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblQuantidade.setBounds(28, 370, 98, 14);
		contentPane.add(lblQuantidade);
		
		JPanel pnlExclusao = new JPanel();
		pnlExclusao.setBounds(360, 291, 219, 96);
		contentPane.add(pnlExclusao);
		pnlExclusao.setLayout(null);
		pnlExclusao.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Deseja excluir?");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(71, 11, 90, 14);
		pnlExclusao.add(lblNewLabel_1);
		
		JPanel pnlAlt = new JPanel();
		pnlAlt.setBounds(334, 264, 245, 128);
		contentPane.add(pnlAlt);
		pnlAlt.setLayout(null);
		pnlAlt.setVisible(false);
		
		txtNovaQtd = new JTextField();
		txtNovaQtd.setBounds(126, 42, 105, 20);
		pnlAlt.add(txtNovaQtd);
		txtNovaQtd.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar Qtd");
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaPrincipal.ComposicoesCadastradas.size() > 0){
					int Linha = tblComposicao.getSelectedRow();
					try {
						int Codigo = (int) ModeloDados.getValueAt(Linha, 0);
						pnlExclusao.setVisible(true);
						btnExcluir.setEnabled(false);
						btnAlterar.setEnabled(false);
						btnCadastrar.setEnabled(false);
						tblComposicao.setEnabled(false);
						btnBuscarKit.setEnabled(false);

						
					} catch (Exception e2) {
						lblMensagem.setText("Selecione uma composicao!");
					}
				}
				else {
					lblMensagem.setText("Crie uma composicao!");
				}
			}
		});
		btnExcluir.setBounds(466, 195, 113, 44);
		contentPane.add(btnExcluir);
		btnExcluir.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TelaPrincipal.ComposicoesCadastradas.size() > 0){
					int Linha = tblComposicao.getSelectedRow();
					try {
						int Codigo = (int) ModeloDados.getValueAt(Linha, 0);
						pnlAlt.setVisible(true);
						btnExcluir.setEnabled(false);
						btnAlterar.setEnabled(false);
						btnCadastrar.setEnabled(false);
						tblComposicao.setEnabled(false);
						btnBuscarKit.setEnabled(false);

						
					} catch (Exception e2) {
						lblMensagem.setText("Selecione uma composicao!");
					}
				}
				else {
					lblMensagem.setText("Crie uma composicao!");
				}
			}
		});
		btnAlterar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnAlterar.setBounds(466, 140, 113, 44);
		contentPane.add(btnAlterar);

		JButton btnSim = new JButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Linha = tblComposicao.getSelectedRow();
				int Codigo = (int) ModeloDados.getValueAt(Linha, 0);
				for (Composicao i : TelaPrincipal.ComposicoesCadastradas) {
					if(i.getIDcomp() == Codigo) {
						pnlExclusao.setVisible(false);
						btnExcluir.setEnabled(true);
						btnAlterar.setEnabled(true);
						btnCadastrar.setEnabled(true);
						tblComposicao.setEnabled(true);
						btnBuscarKit.setEnabled(true);

						TelaPrincipal.ComposicoesCadastradas.remove(i);
						ModeloDados.removeRow(Linha);
						lblMensagem.setText("Exclusao concluida!");
						break;
					}
				}
			}
		});
		btnSim.setBounds(10, 48, 89, 23);
		pnlExclusao.add(btnSim);
		
		JButton btnNao = new JButton("Nao");
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlExclusao.setVisible(false);
				btnExcluir.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnCadastrar.setEnabled(true);
				tblComposicao.setEnabled(true);
				btnBuscarKit.setEnabled(true);

			}
		});
		btnNao.setBounds(120, 48, 89, 23);
		pnlExclusao.add(btnNao);
		

		
		JButton btnConfirmarAlt = new JButton("Alterar");
		btnConfirmarAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNovaQtd.getText().isEmpty()) {
					lblMensagem.setText("Escreva uma quantidade!");
				}
				else {
					try {
						if(Integer.valueOf(txtNovaQtd.getText()) > 0) {
							int Linha = tblComposicao.getSelectedRow();
							int Codigo = (int) ModeloDados.getValueAt(Linha, 0);
							for (Composicao i : TelaPrincipal.ComposicoesCadastradas) {
								if(i.getIDcomp() == Codigo) {
									pnlAlt.setVisible(false);
									btnExcluir.setEnabled(true);
									btnAlterar.setEnabled(true);
									btnCadastrar.setEnabled(true);
									tblComposicao.setEnabled(true);
									btnBuscarKit.setEnabled(true);

									ModeloDados.setValueAt(txtNovaQtd.getText(), Linha, 3);
									i.setQuantidade(Integer.valueOf(txtNovaQtd.getText()));
									lblMensagem.setText("Alteracao concluida!");
									break;
								}
							}

								
						}
						else {
							lblMensagem.setText("Erro - Quantidade <= 0!");
						}
					} catch (Exception e2) {
						lblMensagem.setText("Quantidade invalida!");
					}
				}
			}
		});
		btnConfirmarAlt.setBounds(27, 94, 89, 23);
		pnlAlt.add(btnConfirmarAlt);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlAlt.setVisible(false);
				btnExcluir.setEnabled(true);
				btnAlterar.setEnabled(true);
				btnCadastrar.setEnabled(true);
				tblComposicao.setEnabled(true);
				btnBuscarKit.setEnabled(true);
			}
		});
		btnCancelar.setBounds(126, 94, 89, 23);
		pnlAlt.add(btnCancelar);
		

		
		JLabel lblNewLabel_2 = new JLabel("Nova Quantidade:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(0, 44, 116, 14);
		pnlAlt.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Lista de Kits");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(360, 8, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		

		
		for (Componente i : TelaPrincipal.ComponentesCadastrados) {
			cbComponentes.addItem(new ComboItem(i.getNome(), i.getID()));
		}
		for (Kit i : TelaPrincipal.KitsCadastrados) {
			cbKits.addItem(new ComboItem(i.getNome(), i.getId()));
		}
		
		for (Kit i : TelaPrincipal.KitsCadastrados) {
			cbKitsBusca.addItem(new ComboItem(i.getNome(), i.getId()));
		}
	}
}
