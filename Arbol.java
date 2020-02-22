
package practicacompimodificacion;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Arbol {
    public Node root;
 
    public static class Node {
        public String nodo1;
        public String nodo2;
        public int balance;
        public int height;
        public Node left;
        public Node right;
        public Node parent;
        public static int correlativo=1;
        public final int id;
        Node(String n1,String n2,Node parent) {
            this.nodo1 = n1;
            this.parent = parent;
            this.nodo1=n2;
            this.id=correlativo++;
        }
        public void graficar(String path){
        FileWriter fichero=null;
        PrintWriter escritor;
        try{
            fichero=new FileWriter("aux_grafico.dot");
            escritor=new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        }catch(Exception e){
            System.out.println("Error al escribir el archivo auxiliar");
        }finally{
            try{
                if(null!=fichero){
                  fichero.close();  
                }
            }catch(Exception e){
               System.out.println("Error al cerrar el archivo auxiliar");
            }
        }
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o "+path+" aux_grafico.dot");
            //Thread.sleep(500);
        }catch(Exception ex){
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
            
        }
    }
    public String getCodigoGraphviz(){
        return "digraph grafica{\n"+
                "rankdir=TB;\n"+
                "node [shape=record,style=filled,fillcolor=seashell];\n"+
                getCodigoInterno()+
                "}\n";
    }
     public String getCodigoInterno(){
        String etiqueta;
        if(left==null && right==null){
            etiqueta="nodo"+id+"[label=\""+nodo1+"\\l"+nodo2+"\"];\n";
        }else{
            etiqueta="nodo"+id+"[label=\"<C0>|"+nodo1+"\\l"+nodo2+"|<C1>\"];\n";
        }
        if(left!=null){
            etiqueta=etiqueta+left.getCodigoInterno()+
                    "nodo"+id+":C0->nodo"+left.id+"\n";
        }
        if(right!=null){
            etiqueta=etiqueta+right.getCodigoInterno()+
                    "nodo"+id+":C1->nodo"+right.id+"\n";
        }
        return etiqueta;
    }
    
    }
 
    public boolean insert(String nodo1,String nodo2) {
        if (root == null) {
            root = new Node(nodo1,nodo2, null);
            return true;
        }
 
        Node n = root;
        while (true) {
            if (n.nodo1 == nodo1)
                return false;
 
            Node parent = n;
 
            boolean goLeft = n.nodo1.compareTo(nodo2)>0;
            n = goLeft ? n.left : n.right;
 
            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(nodo1,nodo2, parent);
                } else {
                    parent.right = new Node(nodo1,nodo2,parent);
                }
                
                break;
            }
        }
        return true;
    }
 
}

