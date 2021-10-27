/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import funcoes.AtcAbertura;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * DESENVOLVIDO POR CPD CARAPICUIBA 043
 * @author cbobio 
 * TEL: (11)41858115 OU 8116
 */
public class MenuPrincipal extends JFrame{
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo,mnBalanca,mnAbertura,mnExemplos, mnRelatorio;
    private JMenuItem miSair,miBotao,miCaixaOpcao,miGuiRadio,miGuiLabel,miGuiLista,miGuiAreaDeTexto,miGuiDialogoMensagem,
            miSrt50,miBalanca01,miAbertura,miOperadores,miFechamento,miRelAbertura,miRelFechamento;
	
	public MenuPrincipal(){
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes(){
		setTitle("Menu Principal");
        setBounds(0, 0, 780, 660);
        contentPane = getContentPane();
        
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("ARQUIVO");
        mnArquivo.setMnemonic('E');
        mnExemplos = new JMenu("EXEMPLOS");
        mnExemplos.setMnemonic('E');
        mnRelatorio = new JMenu("RELATORIO");
        mnRelatorio.setMnemonic('E');
        mnBalanca = new JMenu("CPD");
        mnBalanca.setMnemonic('E');
        mnAbertura = new JMenu("ATA CPD CARAPICUIBA ");
        mnAbertura.setMnemonic('E');
      
      
        
        miSair = new JMenuItem("sair" , new ImageIcon("sair.jpg"));
        miSair.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_S, ActionEvent.ALT_MASK));
        
      
        
        miBotao = new JMenuItem("Botão");
        miCaixaOpcao = new JMenuItem("Caixa de Opcão");
        miGuiRadio = new JMenuItem("Radio");
        miGuiLabel = new JMenuItem("Label");
        miGuiLista = new JMenuItem("Lista");
        miGuiAreaDeTexto = new JMenuItem("Area de texto");
        miGuiDialogoMensagem = new JMenuItem("Caixas de dialogo");
        
        
        
        miAbertura = new JMenuItem("Abertura de Loja");
        miFechamento = new JMenuItem("Fechamento de Loja");
        miOperadores = new JMenuItem("Usuarios");
        
        miBalanca01 = new JMenuItem ("Manutençao de Balanças");  
        miRelAbertura = new JMenuItem ("Manutenção");
        miRelFechamento = new JMenuItem ("Manutenção");
        
     
        
        miSrt50 = new JMenuItem("SRTBI50");
        
        //aba do menu arquivo 
        mnArquivo.add(miSair);
        
        //aba do menu ATA CPD CARAPICUIBA 
        mnAbertura.add(miAbertura);
        mnAbertura.add(miFechamento);
        
        mnAbertura.add(miOperadores);
        
        //aba do menu CPD
        mnBalanca.add(miBalanca01);
        mnBalanca.add(miRelAbertura);
        mnBalanca.add(miRelFechamento);
    
        
        //abas do menu relatorios
        mnRelatorio.add(miSrt50);
        
        // abas do menu exemplos
        mnExemplos.add(miBotao);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miGuiRadio);
        mnExemplos.add(miGuiLabel);
        mnExemplos.add(miGuiLista);
        mnExemplos.add(miGuiAreaDeTexto);
        mnExemplos.add(miGuiDialogoMensagem);
      
        //itens da barra de menu 
        mnBarra.add(mnArquivo);
        mnBarra.add(mnAbertura);
        mnBarra.add(mnBalanca);
        mnBarra.add(mnRelatorio);
        mnBarra.add(mnExemplos);
        setJMenuBar(mnBarra);
	}
	
	private void definirEventos(){
		miSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
              

	  	miAbertura.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				 AtcAbertura atcAbertura = new AtcAbertura();
                                 contentPane.removeAll();
                                 contentPane.add(atcAbertura);
                                 contentPane.validate();
			}
		}); 
                
        /**      miFechamento.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       Fechamento fechamento = new Fechamento();
                       contentPane.removeAll();
                       contentPane.add(fechamento);
                       contentPane.validate();
                   } 
                }); */
                
        /**        miBatimento.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       AtcFechamento atcFechamento = new AtcFechamento();
                       contentPane.removeAll();
                       contentPane.add(atcFechamento);
                       contentPane.validate();
                   } 
                });  */
                
       /**         miGuiLabel.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       GuiLabel guiLabel = new GuiLabel();
                       contentPane.removeAll();
                       contentPane.add(guiLabel);
                       contentPane.validate();
                   } 
                });  */
                
       /**         miGuiLista.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        GuiLista guiLista = new GuiLista();
                        contentPane.removeAll();
                        contentPane.add(guiLista);
                        contentPane.validate();
                    }
                });  */
                
       /**         miGuiAreaDeTexto.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       GuiAreaDeTexto guiAreaDeTexto = new GuiAreaDeTexto();
                       contentPane.removeAll();
                       contentPane.add(guiAreaDeTexto);
                       contentPane.validate();
                   }
                }); */
                
           /**     miGuiDialogoMensagem.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       GuiDialogoMensagem guiDialogoMensagem = new GuiDialogoMensagem();
                       contentPane.removeAll();
                       contentPane.add(guiDialogoMensagem);
                       contentPane.validate();
                   } 
                }); */
	}
	
	public static void abrir(){
		MenuPrincipal frame = new MenuPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, 
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
} 

