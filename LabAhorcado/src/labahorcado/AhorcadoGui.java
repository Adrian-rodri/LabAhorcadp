
package labahorcado;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;

public class AhorcadoGui extends JFrame{
    Color bgr= new Color(0x00000);
    Color txt= new Color(0xFAEB92);
    Color btn= new Color(0xFF5FCF);
    Color sub = new Color(0x9929EA);
    
    JLabel lblMenu= new JLabel("Juego Ahorcado");
    JButton btnFijo= new JButton("Jugar Ahorcado Fijo");
    JButton btnAzar= new JButton("Jugar Ahorcado Azar");
    JButton btnAdmin= new JButton("Administar Plabaras");
    JButton btnBack=  new JButton("Regresar ");
    JButton[][] teclas= new JButton[5][6];
    char[][] abecedario={{'a','b','c','d','e','f'},
                         {'g','h','i','j','k','l'},
                         {'m','n','o','p','q','r'},
                         {'s','t','u','v','w','x'},
                         {'1','1','x','y','z','1'}};
    
    JPanel teclado= new JPanel(new GridLayout(5,6,2,2));
    AhorcadoGui(){
    this.setSize(800,800);
    this.setVisible(true);
    this.setLayout(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.getContentPane().setBackground(bgr);
    this.setResizable(false);
    //titulo
    lblMenu.setForeground(txt);
    lblMenu.setBounds(280,200,500,30);
    lblMenu.setFont(new Font("Times New Roman", Font.BOLD, 35));
    lblMenu.setVisible(true);
    // Boton jugar fijo
    btnFijo.setBounds(295, 240, 200,30);
    btnFijo.setBackground(btn);
    btnFijo.setForeground(bgr);
    //Boton Azar
    btnAzar.setBounds(295, 280, 200, 30);
    btnAzar.setBackground(btn);
    btnAzar.setForeground(bgr);
    //Boton Admin palabras
    btnAdmin.setBounds(295, 320,200,30);
    btnAdmin.setBackground(btn);
    btnAdmin.setForeground(bgr);
    //Boton regresar
    btnBack.setBackground(bgr);
    btnBack.setForeground(btn);
    //Teclado
    teclado.setBounds(250, 450, 300,200);
    teclado.setBackground(bgr);
    teclado.setVisible(false);
    for(int i=0; i<5;i++){
        for(int j=0; j<6;j++){
        teclas[i][j]= new JButton();
        teclas[i][j].setBackground(btn);
        if(abecedario[i][j]== '1'){
            teclas[i][j].setText("");
            teclas[i][j].setVisible(false);
        }else{
        teclas[i][j].setText(String.valueOf(abecedario[i][j]));}
        teclado.add(teclas[i][j]);
        }
    }
    
    //***Acciones
    //Boton jugar fijo
    btnFijo.addActionListener(e->{
    menuInicio(false);
    lblMenu.setBounds(280,20,500,30);
    lblMenu.setText("Palabra Fija");
    teclado.setVisible(true);
    btnBack.setBounds(300,700,200,30);
    btnBack.setVisible(true);
    
    });
    //Boton jugar Azar
    btnAzar.addActionListener(e->{
    menuInicio(false);
    lblMenu.setBounds(280,20,500,30);
    lblMenu.setText("Palabra Random");
    teclado.setVisible(true);
    btnBack.setBounds(300,700,200,30);
    btnBack.setVisible(true);
    
    });
    //Boton admin
    btnAdmin.addActionListener(e->{
    menuInicio(false);
    
    
    });
    //Boton Regresar
    btnBack.addActionListener(e->{
    menuInicio(true);
    teclado.setVisible(false);
    
    });
    //Add
    add(btnBack);
    add(btnAdmin);
    add(teclado);
    add(btnAzar);
    add(btnFijo);
    add(lblMenu);
    //
    
    
    
    
    this.setVisible(true);
    }
    void menuInicio(boolean tons){
        if(tons){
        lblMenu.setBounds(280,200,500,30);
        lblMenu.setText("Juego Ahorcado");
        btnBack.setVisible(false);
        }
        btnFijo.setVisible(tons);
        btnAzar.setVisible(tons);
        btnAdmin.setVisible(tons);
    }
}
