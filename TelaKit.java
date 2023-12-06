import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaKit extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComponentes frame = new TelaComponentes();
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
	public TelaKit(JFrame TelaInicial) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TelaInicial.setVisible(true);
			}
		});
		setBounds(100, 100, 614, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JFrame TelaAtual = this;
		
		JButton btnVoltarKit = new JButton("Voltar");
		btnVoltarKit.setBounds(28, 21, 119, 44);
		btnVoltarKit.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnVoltarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		
		
		
		contentPane.setLayout(null);
		contentPane.add(btnVoltarKit);
		
		JButton btnKitCadastrar = new JButton("Cadastrar Kit");
		btnKitCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroKit frame = new TelaCadastroKit(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnKitCadastrar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnKitCadastrar.setBounds(178, 130, 203, 63);
		contentPane.add(btnKitCadastrar);
		
		JButton btnKitsVisualizarLista = new JButton("Visualizar, Alterar ou Excluir Kits");
		btnKitsVisualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DVAKit frame = new DVAKit(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnKitsVisualizarLista.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnKitsVisualizarLista.setBounds(91, 244, 382, 63);
		contentPane.add(btnKitsVisualizarLista);
	}
}
