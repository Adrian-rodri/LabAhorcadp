
package labahorcado;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    
    JuegoAhorcadoAzar juegoAzar;
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
        
        teclas[i][j].setText(String.valueOf(abecedario[i][j]));
        }
        char letra= abecedario[i][j];
        teclas[i][j].addActionListener(e ->{
            if(juegoFijo != null) {
                procesarLetra(letra);
            } else if(juegoAzar != null) {
                procesarLetraAzar(letra);
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
    actualizarInterfazFijo();
    resetearTeclado();
    }
    });
    //Boton jugar Azar
    btnAzar.addActionListener(e->{
    menuInicio(false);
    juegoAzar= new JuegoAhorcadoAzar();
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
    actualizarInterfazAzar();
    resetearTeclado();
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
    //boton administrar palabras
    btnAdmin.addActionListener(e -> {
    boolean adminAbierto=true;
    while(adminAbierto){
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
              ArrayList<String> lista = adminPalabras.getPalabras();
              String texto = String.join(", ",lista);
              JOptionPane.showMessageDialog(this,"Palabras actuales: \n"+texto);
              break;
             
          case 2:
              adminAbierto=false;
        
              break;
          default:
           adminAbierto=false;
              break;
      }
      
      }
    if(!adminAbierto)
        menuInicio(true);
    
        lblMenu.setBounds(280,200,500,30);

    });
    this.setVisible(true);
    }
    //Limpiar menu
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
    //Ingresa letra
    void procesarLetra(char letra){
        if(juegoFijo!=null && !juegoFijo.juegoTerminado()){
        boolean correcta= juegoFijo.intentarLetra(letra); 
        actualizarInterfazFijo();
        deshabilitarColor(letra, correcta);
        verificarJuego();
        }
    }
    //Actualiza palabra fijo
    void actualizarInterfazFijo(){
    if(juegoFijo!=null){
        StringBuilder palabraMostrar = new StringBuilder();
        for (int i = 0; i < juegoFijo.getPalabraActual().length(); i++) {
            palabraMostrar.append(juegoFijo.getPalabraActual().toLowerCase().charAt(i)).append(" ");
        }
        lblPalabraActual.setText(palabraMostrar.toString().trim());
        

        lblIntentos.setText("Intentos: " + juegoFijo.getIntentosRestantes() + "/" + juegoFijo.limiteIntentos);
        
        int intentosFallidos = juegoFijo.limiteIntentos - juegoFijo.getIntentosRestantes();
        actualizarFigura(intentosFallidos);
    
    }
    }
    //verificar
    void verificarJuego(){
        if(juegoFijo!= null ){
            if(juegoFijo.hasGanado()){
            JOptionPane.showMessageDialog(this, "Felicidades Ganaste! \nLa palabra era: "+ juegoFijo.getPalabraSecreta());
            deshabilitarTeclas();
            }else if(juegoFijo.hasPerdido()){
            JOptionPane.showMessageDialog(this, "Perdiste \n La palabra era: "+ juegoFijo.getPalabraSecreta());
            deshabilitarTeclas();
            }
        }
    }
    //deshabilitar teclas y cambiar color
    void deshabilitarColor(char letra, boolean correcta) {
    for (int i=0;i< 5; i++) {
        for (int j=0;j<6;j++) {
            if (Character.toUpperCase(abecedario[i][j]) == Character.toUpperCase(letra)) {
                teclas[i][j].setEnabled(false);
                //Verde si es correcta, rojo si es incorrecta
                if (correcta) {
                    teclas[i][j].setBackground(new Color(0x28A745)); // Verde
                } else {
                    teclas[i][j].setBackground(new Color(0xDC3545)); // Rojo
                }
            }}}}
    //Actualizar figura
    void actualizarFigura(int nivel) {
    String[] figuras = {
        " +-----+\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "=======",
        
        //Cabeza
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "=======",
        
        //Cuerpo
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        " |     |\n" +
        "       |\n" +
        "       |\n" +
        "=======",
        
        //Brazo izquierdo
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        "/|     |\n" +
        "       |\n" +
        "       |\n" +
        "=======",
        
        //Dos brazos
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        "/|\\    |\n" +
        "       |\n" +
        "       |\n" +
        "=======",
        
        //Pierna izquierda
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        "/|\\    |\n" +
        "/      |\n" +
        "       |\n" +
        "=======",
        
        //Dos piernas, perder
        " +-----+\n" +
        " |     |\n" +
        " O     |\n" +
        "/|\\    |\n" +
        "/ \\    |\n" +
        "       |\n" +
        "======="
    };
    if (nivel >= 0 && nivel < figuras.length) {
        txtFigura.setText(figuras[nivel]);
    } else if (nivel >= figuras.length) {
        txtFigura.setText(figuras[6]);
    }
}
    //Reset teclado
    void resetearTeclado() {
    for (int i=0;i<5; i++) {
        for (int j =0;j <6; j++) {
            if (abecedario[i][j] != '1') {
                teclas[i][j].setEnabled(true);
                teclas[i][j].setBackground(btn);
            }
        }
    }}
    //deshabilitar teclas
    void deshabilitarTeclas() {
        for (int i=0;i<5; i++) {
            for (int j=0; j<6; j++) {
                if (abecedario[i][j] != '1') {
                    teclas[i][j].setEnabled(false);
                }
            }
        }}
    //intentar letra zara
    void procesarLetraAzar(char letra){
     if (juegoAzar != null) {
            char letraMin = Character.toLowerCase(letra);
            juegoAzar.ingresarLetra(letraMin);
            actualizarInterfazAzar();

            boolean correcta = juegoAzar.palabraSecreta.indexOf(letraMin) >= 0;
            deshabilitarColor(letra, correcta);
            verificarJuegoAzar();
        }
    }
    //Logica Azar
    //Actualizar la palabra
    void actualizarInterfazAzar(){
        if (juegoAzar!= null) {
            StringBuilder palabraMostrar=new StringBuilder();
            for (int i= 0;i< juegoAzar.palabraSecreta.length(); i++) {
                char c= juegoAzar.palabraSecreta.charAt(i);
                if (juegoAzar.letrasUsadas.contains(c)) {
                    palabraMostrar.append(Character.toLowerCase(c)).append(" ");
                } else {
                    palabraMostrar.append("_ ");
                }
            }

            lblPalabraActual.setText(palabraMostrar.toString().trim());
            int intentosRestantes = juegoAzar.limiteIntentos - juegoAzar.intentosFallidos;
            lblIntentos.setText("Intentos: " + intentosRestantes + "/" + juegoAzar.limiteIntentos);
            actualizarFigura(juegoAzar.intentosFallidos);
        }
    }
    // verificar zara
    void  verificarJuegoAzar() {
        if (juegoAzar!=null) {
            boolean gano=true;
            for (int i=0;i< juegoAzar.palabraSecreta.length();i++) {
                char c =juegoAzar.palabraSecreta.charAt(i);
                if (!juegoAzar.letrasUsadas.contains(c)) {
                    gano = false;
                    break;
                }
            }
            if (gano) {
                JOptionPane.showMessageDialog(this,
                    "FELICIDADES! Ganaste\nLa palabra era: " + juegoAzar.palabraSecreta.toUpperCase());
                deshabilitarTeclas();
            }
            if (juegoAzar.intentosFallidos >= juegoAzar.limiteIntentos) {
                JOptionPane.showMessageDialog(this,
                    "PERDISTE!\nLa palabra era: " + juegoAzar.palabraSecreta.toUpperCase());
                deshabilitarTeclas();
            }
        }
        }
   }
