/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import dao.AberturaDao;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
/**
 * DESENVOLVIDO POR CPD CARAPICUIBA 043
 * @author cbobio (Carlos Bóbio 11 97419-1590)
 * TEL: (11)41858115 OU 8116
 */
public class AtcAbertura extends JPanel{
     private JLabel label1,label2,label3,label4,label5,label6,label7;
     private JButton btGravar, btAlterar, btExcluir, btNovo, btLocalizar, btCancelar,  btLimpar;
     private JScrollPane descServico;
     private AberturaDao abertura;
     private JTextField tfMat, tfNome, tfData;
     private JTextArea taDesc;
     private final static String novaLinha = "\n";
     
       public AtcAbertura(){
		inicializarComponentes();
		definirEventos();
	}
     
     private  void inicializarComponentes(){
         setLayout(null);
                label1 = new JLabel("ATA CPD CARAPICUIBA ABERTURA");
                label2 = new JLabel("MATRICULA:");
                label3 = new JLabel("NOME:");
                label4 = new JLabel("DESCRIÇÃO DO OCORRIDO NO DIA :");
                label5 = new JLabel("CARAPICUIBA 043 ATACADAO 2021");
                label6 = new JLabel("DATA:");
                label7 = new JLabel("DESENVOLVIDO POR CPD CARAPICUIBA");
                
                tfMat = new JTextField();
                tfNome = new JTextField();
                tfData = new JTextField(); 
                
                btGravar = new JButton("Gravar");
                btGravar.setToolTipText("Grava um Registro");
                btAlterar = new JButton("Alterar");
                btAlterar.setToolTipText("Altera um Registro");
                btExcluir = new JButton("Excluir");
                btExcluir.setToolTipText("Exclui o Registro");
                btNovo = new JButton("Novo");
                btNovo.setToolTipText("Insere um novo Registro");
                btLocalizar = new JButton("Localiza");
                btLocalizar.setToolTipText("Localiza um Registro");
                btCancelar = new JButton("Cancelar");
                btCancelar.setToolTipText("Cancela uma Operação");
                btLimpar = new JButton("Limpa");
                btLimpar.setToolTipText("Limpa o Campo de Texto");
                
                taDesc= new JTextArea(5, 50);
		descServico = new JScrollPane(taDesc);
                
                
                //labels posicoes
                label1.setBounds(25,15,250,25);
                label2.setBounds(25,45,180,45);
                label3.setBounds(25, 90, 125, 45);
                label4.setBounds(25, 120, 250, 45);
                label5.setBounds(25 ,380, 300, 45);
                label6.setBounds(300, 90, 125,45);
                label7.setBounds(450, 500, 250, 45);
                
                 //text arera
                add(tfMat);
                add(tfNome);
		add(descServico);
                add(tfData);
                
                 //caixa de textos posicoes
                tfMat.setBounds(100, 57, 80, 20);
                tfNome.setBounds(110, 105, 150, 20);
                tfData.setBounds(335, 105, 80, 20);
                
                //area de texto posição 
                descServico.setBounds(25, 160, 600, 200);
                
                //botoes posicao
		btLimpar.setBounds(640, 323, 80, 35);
                btGravar.setBounds(25, 450, 85, 35);
                btAlterar.setBounds(120, 450, 85, 35);
                btExcluir.setBounds(215, 450, 85, 35);
                btLocalizar.setBounds(310, 450, 85, 35);
                btCancelar.setBounds(405, 450, 85, 35);
                
                //Adicionando label
                add(label1);
                add(label2);
                add(label3);
                add(label4);
                add(label5);
                add(label6);
                add(label7);
                
                 //Adicionando botoes
		add(btLimpar);
                add(btGravar);
                add(btAlterar);
                add(btExcluir);
                add(btLocalizar);
                add(btCancelar);
                
                 abertura = new AberturaDao();
		if (!abertura.bd.getConnection()){
			JOptionPane.showMessageDialog(null, "Falha na Conexão, o Sistema sera Fechado !!!");
			System.exit(0);
		}
     }
     
     private void definirEventos(){
         btLimpar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//tfMat.setText("");
				taDesc.setText("");
                               // tfNome.setText("");
                               //tfData.setText("");
                               
			}
		});
     }
     
     
}
