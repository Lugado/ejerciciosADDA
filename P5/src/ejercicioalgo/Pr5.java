package ejercicioalgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import us.lsi.dyv.problemasdelistas.ProblemasDeListas;
import us.lsi.math.Math2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;
public class Pr5 {   //CAMBIA EL Ppal POR EL NOMBRE DE TU CLASE AAAAAAAAAA

    
    public static <E> boolean contieneEtiqueta(Tree<E> t, E etiq) {
        
        boolean res = false;
        
        switch(t.getType()) {
        case Empty:
            res = false;
            break;
        case Leaf:
            res = etiq.equals(t.getLabel());
            break;
        case Nary:
            res = etiq.equals(t.getLabel());
            if(!res) {
                res = t.getChildren().stream().anyMatch(x -> contieneEtiqueta(x, etiq));
            }
            break;
        }
        
        return res;
    }
    
    
    public static <T> boolean equalTree(Tree<T> a, Tree<T> b) {
        boolean res = false;
        
        if(a.getType().equals(a.getType())) {
            switch(a.getType()) {
            case Empty:
                res = true;
                break;
            case Leaf:
                res = a.getLabel().equals(b.getLabel());
                break;
            case Nary:
                res = a.getNumOfChildren() == b.getNumOfChildren() &&
                    a.getLabel().equals(b.getLabel());
                
                if(res) {
                    res = IntStream.range(0, a.getNumOfChildren())
                            .allMatch(i -> equalTree( a.getChild(i), b.getChild(i) ));
                }
                break;
            }
        }
        
        return res;
    }
    
    public static <T extends Comparable<T>> T menorEtiqueta(BinaryTree<T> arbol, Comparator<T> comp){
    	T res = null;
    	
    	switch(arbol.getType()) {
    	case Empty:
    		break;
    	case Leaf:
    		res = arbol.getLabel();
    		break;
    	case Binary:
    		if(arbol.getLeft().equals(null)) {
    			res = arbol.getLabel();
    			res = comp.compare(res, menorEtiqueta(arbol.getRight(), comp)) < 0 ? res: menorEtiqueta(arbol.getRight(), comp);	
    		}else if(arbol.getLeft().equals(null)){
    			res = arbol.getLabel();
        		res = comp.compare(res, menorEtiqueta(arbol.getLeft(), comp)) < 0 ? res: menorEtiqueta(arbol.getLeft(), comp);
    		}else if(arbol.getLeft().equals(null)&& arbol.getLeft().equals(null)) {
    			res = arbol.getLabel();
    		}else {
    			res = arbol.getLabel();
        		res = comp.compare(res, menorEtiqueta(arbol.getLeft(), comp)) < 0 ? res: menorEtiqueta(arbol.getLeft(), comp);
        		res = comp.compare(res, menorEtiqueta(arbol.getRight(), comp)) < 0 ? res: menorEtiqueta(arbol.getRight(), comp);	
    		}
    		
    		break;
    	}
    	
    	return res;
    }
    
    public static <T> BinaryTree<T> CS(BinaryTree<T> arbol) {
    	BinaryTree<T> res = null;
    	
    	switch (arbol.getType()) {
		
    	case Empty:
    		res = BinaryTree.empty();
			break;
        case Leaf:
        	res = BinaryTree.leaf(arbol.getLabel());
			break;
        case Binary:
			res = BinaryTree.binary(arbol.getLabel(), CS(arbol.getRight()), CS(arbol.getLeft()));
			break;
		}
    	
    	
    	return res;
    }
    
    public static <T> List<T> listaPostorden(BinaryTree<T> a){
    	List<T> res = new ArrayList<>();
    	switch (a.getType()) {
		case Empty:
			break;
		case Leaf:
			res.add(a.getLabel());
			break;
		case Binary:
			res.addAll(listaPostorden(a.getLeft()));
			res.addAll(listaPostorden(a.getRight()));
			res.add(a.getLabel());
			break;
		}
    	return res;
    }
    


    public static void main(String[] args) {
        
        /*Tree<Integer> t1 = Tree.nary(5, Tree.leaf(1),Tree.leaf(2));
        Tree<Integer> t2 = Tree.nary(6, t1, Tree.leaf(4));
        Tree<Integer> t3 = Tree.nary(7, t2, t1,Tree.leaf(3));
        System.out.println(t3);
        System.out.println(contieneEtiqueta(t3,1));
        Tree<Integer> t4 = Tree.nary(7, t2, t1,Tree.leaf(3));
        Tree<Integer> t5 = Tree.nary(7, t2, t1,Tree.leaf(8));
        System.out.println(equalTree(t3, t4));
        System.out.println(equalTree(t3, t5));
        */
        /*BinaryTree<String> t = BinaryTree.parse("1(3(4,_),5(_,6(7,8)))");
        System.out.println(t);
        System.out.println(menorEtiqueta(t, Comparator.naturalOrder()));
   */
    	BinaryTree<String> Q = BinaryTree.parse("1(3(4,_),5(_,6(7,8)))");
        System.out.println(Q);
        BinaryTree<String> w = CS(Q);
        System.out.println(w);
    
    }

}