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

public class TelaComponentes extends JFrame {
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
	public TelaComponentes(JFrame TelaInicial) {
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
		
		JButton btnVoltarComponentes = new JButton("Voltar");
		btnVoltarComponentes.setBounds(28, 21, 119, 44);
		btnVoltarComponentes.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnVoltarComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtual.setVisible(false);
				TelaInicial.setVisible(true);
			}
		});
		
		
		
		contentPane.setLayout(null);
		contentPane.add(btnVoltarComponentes);
		
		JButton btnComponenteCadastrar = new JButton("Cadastrar Componentes");
		btnComponenteCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroComponente frame = new TelaCadastroComponente(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnComponenteCadastrar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnComponenteCadastrar.setBounds(178, 130, 203, 63);
		contentPane.add(btnComponenteCadastrar);
		
		JButton btnComponenteVisualizarLista = new JButton("Visualizar, Alterar ou Excluir Componentes");
		btnComponenteVisualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DVAComponentes frame = new DVAComponentes(TelaAtual);
				frame.setVisible(true);
				TelaAtual.setVisible(false);
			}
		});
		btnComponenteVisualizarLista.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnComponenteVisualizarLista.setBounds(91, 244, 382, 63);
		contentPane.add(btnComponenteVisualizarLista);
	}
}
