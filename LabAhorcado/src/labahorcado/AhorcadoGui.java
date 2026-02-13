
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
    JTextArea txtFigura = new JTextArea();
    JButton[][] teclas= new JButton[5][6];
    
    JuegoAhorcadoAzar juegoAzar= new JuegoAhorcadoAzar();
    JuegoAhorcadoFijo juegoFijo;
    AdminPalabrasSecretas adminPalabras;
    JLabel lblPalabraActual= new JLabel();
    JLabel lblIntentos= new JLabel("Intentos: 6/6");
    
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
    //palabra
    lblPalabraActual.setBounds(50, 350, 500, 40);
    lblPalabraActual.setForeground(txt);
    lblPalabraActual.setFont(new Font("Arial", Font.BOLD, 32));
    lblPalabraActual.setHorizontalAlignment(SwingConstants.CENTER);
    lblPalabraActual.setVisible(false);
    lblPalabraActual.setText("_ _ _ _ _ _ _");
    //Intentos
    lblIntentos.setBounds(50, 400, 200, 30);
    lblIntentos.setForeground(txt);
    lblIntentos.setFont(new Font("Arial", Font.BOLD, 18));
    lblIntentos.setVisible(false);
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
    //Muñeco
    txtFigura.setBounds(400, 80, 200, 250);  // x, y, ancho, alto
    txtFigura.setBackground(bgr);
    txtFigura.setForeground(txt);
    txtFigura.setFont(new Font("Courier New", Font.BOLD, 30));
    txtFigura.setEditable(false);
    txtFigura.setVisible(false);
    //Agregar Palabras
    adminPalabras = new AdminPalabrasSecretas();
    adminPalabras.agregrarPlabras("java");
    adminPalabras.agregrarPlabras("programa");
    adminPalabras.agregrarPlabras("computadora");
    adminPalabras.agregrarPlabras("teclado");
    adminPalabras.agregrarPlabras("pantalla");
    adminPalabras.agregrarPlabras("monitos");
    adminPalabras.agregrarPlabras("desarrollo");
    //Generar teclado
    for(int i=0; i<5;i++){
        for(int j=0; j<6;j++){
        teclas[i][j]= new JButton();
        teclas[i][j].setBackground(btn);
        if(abecedario[i][j]== '1'){
            teclas[i][j].setText("");
            teclas[i][j].setVisible(false);
        }else{
        char letra= abecedario[i][j];
        teclas[i][j].setText(String.valueOf(abecedario[i][j]));}
        teclas[i][j].addActionListener(e ->{
            if(juegoFijo != null) {
                //procesarLetraFijo(letra);
            } else if(juegoAzar != null) {
                //procesarLetraAzar(letra);
    }
        
        });
        teclado.add(teclas[i][j]);
        }
    }
    
    //***Acciones
    //Boton jugar fijo
    btnFijo.addActionListener(e->{
    String palabra= JOptionPane.showInputDialog(this, "Ingrese la Palabra Secreta");
    if(palabra!= null && !palabra.isEmpty()){
        juegoFijo= new JuegoAhorcadoFijo(palabra.toLowerCase());
        menuInicio(false);
        lblMenu.setBounds(280,20,500,30);
        lblMenu.setText("Palabra Fija");
        teclado.setVisible(true);
        btnBack.setBounds(300,700,200,30);
        btnBack.setVisible(true);
        txtFigura.setVisible(true);
        txtFigura.setText(" +-----+\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "=======");
    lblPalabraActual.setVisible(true);
    lblIntentos.setVisible(true);
    }
    });
    //Boton jugar Azar
    btnAzar.addActionListener(e->{
    menuInicio(false);
    lblMenu.setBounds(280,20,500,30);
    lblMenu.setText("Palabra Random");
    teclado.setVisible(true);
    btnBack.setBounds(300,700,200,30);
    btnBack.setVisible(true);
    txtFigura.setVisible(true);
    txtFigura.setText(" +-----+\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "       |\n" +
                      "=======");
    lblPalabraActual.setVisible(true);
    lblIntentos.setVisible(true);
    });
    //Boton admin
    btnAdmin.addActionListener(e->{
    menuInicio(false);
    
    
    });
    //Boton Regresar
    btnBack.addActionListener(e->{
    menuInicio(true);
    teclado.setVisible(false);
    txtFigura.setVisible(false);
    lblPalabraActual.setVisible(false);
    lblIntentos.setVisible(false);
    });
    //Add
    add(lblPalabraActual);
    add(lblIntentos);
    add(txtFigura);
    add(btnBack);
    add(btnAdmin);
    add(teclado);
    add(btnAzar);
    add(btnFijo);
    add(lblMenu);
    //
    
    
    
    
    
    btnAdmin.addActionListener(e -> {
    menuInicio(false);
    
    String [] opciones ={"Agregar Palabra","Mostrar Palabras","Cancelar"};
    
      int seleccion = JOptionPane.showOptionDialog(
            this,
            "Eliga una accion",
            "Administrar Palabras",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]
    );
      
      switch (seleccion){
          case 0:
              String nueva = JOptionPane.showInputDialog(this, "Ingrerse la nueva palabra:");
              if(nueva != null && !nueva.trim().isEmpty()){
                  try{
                      adminPalabras.agregrarPlabras(nueva.trim().toLowerCase());
                      JOptionPane.showMessageDialog(this, "Palabra agregada: "+nueva);
                  }catch(Exception ex){
                      JOptionPane.showMessageDialog(this,"Error"+ex.getMessage());
                  }
              }
              break;
              
          case 1:
              break;
              
              
          default:
              menuInicio(true);
              break;
      }
      
    });

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
    void procesarLetra(char letra){
        if(juegoFijo!=null && !juegoFijo.juegoTerminado()){
        boolean correcta= juegoFijo.intentarLetra(letra); 
        actualizarInterfazFijo();
        //deshabilitarTeclaConColor(letra, correcta);
        //verificarEstadoJuegoFijo();
        }
    }
    void actualizarInterfazFijo(){
        //if()
    }
}
