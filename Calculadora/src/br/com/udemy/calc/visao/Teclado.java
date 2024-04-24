package br.com.udemy.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.udemy.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color COR_CINZA_ESCURO = new Color (68, 68,68);
	private final Color COR_CINZA_CLARO = new Color (99,99,99);
	private final Color COR_LARANJA = new Color (242, 163,60);
	
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints C = new GridBagConstraints();
		
		setLayout(layout);
		
		C.weightx =1;
		C.weighty =1;
		C.fill = GridBagConstraints.BOTH;
		
		
		// Linha 1
		C.gridwidth =2;
		adicionarBotao ("AC", COR_CINZA_ESCURO, C, 0, 0);
		C.gridwidth =1;
		adicionarBotao ("±", COR_CINZA_ESCURO, C, 2, 0);
		adicionarBotao ("/", COR_LARANJA, C, 3, 0);
		
		// Linha 2
		adicionarBotao ("7", COR_CINZA_CLARO, C, 0, 1);
		adicionarBotao ("8", COR_CINZA_CLARO, C, 1, 1);
		adicionarBotao ("9", COR_CINZA_CLARO, C, 2, 1);
		adicionarBotao ("*", COR_LARANJA, C, 3, 1);
		
		// Linha 3
		adicionarBotao ("4", COR_CINZA_CLARO, C, 0, 2);
		adicionarBotao ("5", COR_CINZA_CLARO, C, 1, 2);
		adicionarBotao ("6", COR_CINZA_CLARO, C, 2, 2);
		adicionarBotao ("-", COR_LARANJA, C, 3, 2);
		
		// Linha 4
		adicionarBotao ("1", COR_CINZA_CLARO, C, 0, 3);
		adicionarBotao ("2", COR_CINZA_CLARO, C, 1, 3);
		adicionarBotao ("3", COR_CINZA_CLARO, C, 2, 3);
		adicionarBotao ("+", COR_LARANJA, C, 3, 3);
		
		// Linha 5
		
		C.gridwidth =2;
		adicionarBotao ("0", COR_CINZA_CLARO, C, 0, 4);
		C.gridwidth =1;
		adicionarBotao (",", COR_CINZA_CLARO, C, 2, 4);
		adicionarBotao ("=", COR_LARANJA, C, 3, 4);
		
	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao ( texto, cor);
		botao.addActionListener(this);
		add(botao, c);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
			
		}
	}

}
