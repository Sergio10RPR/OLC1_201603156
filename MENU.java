
package practicacompimodificacion;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import practicacompimodificacion.Arbol;

public class MENU extends javax.swing.JFrame {

    ArrayList<String> arrayLexemas = new ArrayList<>();
    ArrayList<String> arrayTokens=new ArrayList<>();
    ArrayList<Character> erroresAlmacenados=new ArrayList<>();
    ArrayList<Character> primeros=new ArrayList<>();
    ArrayList<Character> ultimos=new ArrayList<>();
    ArrayList<Character> unarios=new ArrayList<>();
    ArrayList<Character> conjuntos=new ArrayList<>();
    public static String lexemasAlmacenados="";
    public static String token="";
    public static String tokensG="";
    public static String lexemasG="";
    Arbol arbol=new Arbol();
    
    public MENU() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        jButton1.setText("GENERAR GRAFICAS");

        jButton2.setText("ANALISIS LEXICO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtConsola.setColumns(20);
        txtConsola.setFont(new java.awt.Font("Engravers MT", 0, 8)); // NOI18N
        txtConsola.setRows(5);
        jScrollPane2.setViewportView(txtConsola);

        jLabel1.setText("TOKENS-LEXEMAS");

        jButton3.setText("BORRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(123, 123, 123))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           String texto=txtEntrada.getText();
           analizarTexto(texto);
    }//GEN-LAST:event_jButton2ActionPerformed
    void analizarTexto(String entrada){
     String texto=entrada;
    int tamanio=texto.length();
    int pos=-1;
    int estado=0;
    String lexema="";
    while(pos<tamanio-1)
    {
        pos++;
        char caracter=texto.charAt(pos);
        
        switch(estado) //Estado Inicial, va a entrar todo el texto posible y aceptdo por el automata
        {
            case 0:
                if(caracter=='('){
                   lexema+="(";
                   token="PARENTESIS_IZQ";
                   arrayLexemas.add(lexema);
                   arrayTokens.add(token);
                   lexema="";
                }
                else if(caracter==')'){
                   lexema+=")";
                   token="PARENTESIS_DER";
                   arrayLexemas.add(lexema);
                   arrayTokens.add(token);
                   lexema="";
                }
                
                else if(Character.isDigit(caracter)){
                   estado=1;
                   lexema+=caracter;
                }
               
                else if(Character.isLetter(caracter)){
                   estado=4;
                   lexema+=caracter;
                }
                 else if(caracter=='/'){
                    estado=5;
                    lexema+=caracter;
                }
                 else if(caracter=='<'){
                     estado=6;
                 }
                 else if(caracter=='~'){
                     conjuntos.add(caracter);
                 }
                 else if(caracter=='.'){
                     
                     
                 }
                 else if(caracter=='+'){
                     estado=9;
                     unarios.add(caracter);
                     
                 }
                 else if(caracter=='*'){
                     estado=10;
                     unarios.add(caracter);
                     
                 }
                 else if(caracter=='?'){
                     estado=11;
                     unarios.add(caracter);
                     
                 }
                 else if(caracter=='¿'){
                     estado=12;
                     
                 }
                 else if(caracter=='\"'){
                     //estado=13;
                 }
                 else if(caracter=='|'){
                     unarios.add(caracter);
                 }
                     
                else if(Character.isWhitespace(caracter)){
                    
                }
                else{
                    erroresAlmacenados.add(caracter);
                }
                break;
            
            case 1:
                if(Character.isDigit(caracter)){
                   estado=1;
                   lexema+=caracter;
                }
                else if(caracter=='.'){
                   estado=2;
                   lexema+=caracter;
                }
                else if(caracter=='~'){
                   estado=7;
                }
                else{
                    token="NUMERO_ENTERO";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0;
                    pos--;
                }
                break;
            case 2:
                if(Character.isDigit(caracter)){
                   estado=3;
                   lexema+=caracter;
                }
                else{
                    
                }
                break;
            
            case 3:
                if(Character.isDigit(caracter))
                {
                    estado=3;
                    lexema+=caracter;
                }
                else{
                    token="NUMERO_DECIMAL";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                    }
                break;
            
            case 4:
                if(Character.isLetter(caracter))
                {
                    estado=4;
                    lexema+=caracter;
                }
                else if(Character.isDigit(caracter)){
                    estado=8;
                    lexema+=caracter;
                }
                else{
                    token="PALABRA";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                    }
                break;
            case 5:
                if(caracter=='/'){
                   estado=5;
                   lexema+=caracter;
                   
                }
                else if(caracter=='/'){
                   estado=5;
                   lexema+=caracter;
                }
                else if(Character.isLetter(caracter)){
                    estado=5;
                    lexema+=caracter;
                }
                else{
                    token="COMENTARIO_UNA_LINEA";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 6:
                if(caracter=='<'){
                   estado=6;
                   lexema+=caracter;
                }
                else if(caracter=='!'){
                    estado=6;
                    lexema+=caracter;
                }
                else if(Character.isLetter(caracter)){
                    estado=6;
                    lexema+=caracter;
                }
                else if(caracter=='!'){
                    estado=6;
                    lexema+=caracter;
                }
                else if(caracter=='>'){
                    estado=6;
                    lexema+=caracter;
                }
                else{
                    token="COMENTARIO_VARIAS_LINEAS";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 7:
                if(Character.isDigit(caracter)){
                    estado=7;
                    lexema+=caracter;
                }else{
                    token="CONJUNTO";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 8:
                if(Character.isDigit(caracter)){
                    estado=8;
                    lexema+=caracter;
                }
                else{
                     token="INDENTIFICADOR :";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 9:
                if(caracter=='+'){
                    estado=9;
                    lexema+=caracter;
                }
                else{
                    token="SIGNO + :";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 10:
                if(caracter=='*'){
                    estado=10;
                    lexema+=caracter;
                }
                else{
                    token="SIGNO + :";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                break;
            case 11:
                if(caracter=='?'){
                     estado=11;
                     lexema+=caracter;
                   }
                else{
                    token="SIGNO_? :";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                    
                }
                break;
            case 12:
                if(caracter=='¿'){
                    estado=12;
                    lexema+=caracter;
                }
                else{
                    token="SIGNO_¿ :";
                    lexemasAlmacenados=lexema;
                    arrayLexemas.add(lexemasAlmacenados);
                    arrayTokens.add(token);
                    lexema="";
                    estado=0; //Regresa al estado Inicial
                    pos--;
                }
                
                } 
    }
        
    }
     void Tabla(Arbol.Node padre,char caracter) {
        int cont = 0;
        while (Arbol.Node.correlativo==0) {
            cont++;
            if (!(padre.nodo1).equals("")) {
                if (Arbol.Node.correlativo == 1) {
                    switch (caracter) {
                        case '|':
                            Arbol.Node izquierdo = padre.left;
                           
                            }

                            break;
                       
                    }
                }
               
            }
        }
    
    public static int precedenciaSignos (char signo)
     {

        boolean con=false;
        if ( signo == '+' || signo=='-' || signo=='|')
                return 1;
        else if ( signo=='*' || signo=='/'|| signo == '%')
                return 2;
        else if (signo == '^' || signo=='?' )
                return 3;


        return -1;

     }
    public  String  Separando(String signo)
         {
       
       char dato,a,x;
       Queue signoSalida= new java.util.LinkedList();
       Stack Pila=new Stack();

        int i=0;

      for(i=0;i<signo.length();i++)
        {

            dato=signo.charAt(i);
            if (Character.isDigit(dato))
                {
                signoSalida.offer(dato);
                arbol.insert(signo,signo);

                }

            else
             {
                if(Pila.empty() || dato=='(' || precedenciaSignos(dato)>precedenciaSignos((Character)Pila.peek()) ){
                     Pila.push(dato);
                    arbol.insert(String.valueOf(dato), token);
                }
                   
                else{
                    {
                 if(precedenciaSignos(dato)==precedenciaSignos((Character)Pila.peek()))
                    {

                    x=(Character)Pila.peek();

                    if(x==dato)
                        {
                        Pila.push(dato);
                        arbol.insert(String.valueOf(dato), token);
                        }
                    else
                        {
                      x=(Character)Pila.pop();
                        signoSalida.offer(x);
                         arbol.insert(String.valueOf(dato), token);

                    Pila.push(dato);
                        }

                    }
                if(dato==')')
                    {
                        while((Character)Pila.peek()!='(')
                        {
                             x=(Character)Pila.pop();
                              arbol.insert(String.valueOf(dato), token);
                        signoSalida.offer(x);
                        }
                        Pila.pop();

                    }

                 }

             }//fin del else

        }// fin del metodo

        
         while(!Pila.empty())
             {

            signoSalida.offer(Pila.pop());

            }
      
        return "";
        }
        return null;
         }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtConsola;
    private javax.swing.JTextArea txtEntrada;
    // End of variables declaration//GEN-END:variables
}