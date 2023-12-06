import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static List<Componente> ComponentesCadastrados = new ArrayList<Componente>();
	public static int IdComponente = 1;
	public static List<Kit> KitsCadastrados = new ArrayList<Kit>();
	public static int idKit = 1;
	public static List<Composicao> ComposicoesCadastradas = new ArrayList<Composicao>();
	public static int idComposicao = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame TelaAtual = this;
		
		JButton btnMenuComponentes = new JButton("Menu de componentes");
		btnMenuComponentes.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnMenuComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComponentes frame = new TelaComponentes(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnMenuComponentes.setBounds(41, 139, 208, 63);
		contentPane.add(btnMenuComponentes);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds((TelaAtual.getWidth() / 2) - 54, 339, 100, 27);
		contentPane.add(btnSair);
		
		JButton btnMenuKits = new JButton("Menu de Kits");
		btnMenuKits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaKit frame = new TelaKit(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnMenuKits.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnMenuKits.setBounds(368, 139, 163, 63);
		contentPane.add(btnMenuKits);
		
		JButton btnCombinar = new JButton("Menu de composicao de kits");
		btnCombinar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComposicaoKit frame = new TelaComposicaoKit(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnCombinar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnCombinar.setBounds(192, 227, 228, 63);
		contentPane.add(btnCombinar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 301, 490, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 113, 490, 2);
		contentPane.add(separator_1);
		
		JLabel lblTitulo = new JLabel("Gerenciador de Kits de Arduino");
		lblTitulo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 25));
		lblTitulo.setBounds(101, 39, 403, 63);
		contentPane.add(lblTitulo);
	}
}
