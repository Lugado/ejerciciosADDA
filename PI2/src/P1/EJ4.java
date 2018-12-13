package P1;

import java.util.Comparator;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;


public class EJ4 {
	
	public static Integer encuentraPalabra(String p, List<String> lista) {
		return encuentraPalabra(p,lista,0,lista.size());
	}
	
	public static Integer encuentraPalabra(String p, List<String> lista, Integer i, Integer j) {
		Integer res = null;
		
		if(j-i==0) {
			res = -1;
		}else if(j-i <= 3) {
			if(p.equals(lista.get(i+2))) res = i+2;
			if(p.equals(lista.get(i+1))) res = i+1;
			if(p.equals(lista.get(i))) res = i;
		}else {
			int a = (i+j)/3;
			int b = a+a;
			if(p.compareTo(lista.get(a))<0) {
				res = encuentraPalabra(p, lista,i,a);
			}else if(p.compareTo(lista.get(b))<0) {
				res = encuentraPalabra(p, lista,a,b);
			}else {
				res = encuentraPalabra(p, lista, b, j);
			}
		}
		
		return res;
	}
	
	public static <T extends Comparable<? super T>> boolean ordenado(BinaryTree<T> t, Comparator<T> cmp) {
		
		boolean res = true;
		switch (t.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Binary:
			res = res && t.getLeft().getLabel().compareTo(t.getLabel()) < 0 
					&& t.getLabel().compareTo(t.getRight().getLabel()) < 0 ;
			break;


		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		/*List<String> prueba = new ArrayList<>();
		prueba.add("aa");
		prueba.add("ab");
		prueba.add("ac");
		prueba.add("bc");
		prueba.add("cc");
		prueba.add("de");
		prueba.add("w");
		System.out.println(prueba.indexOf("bc"));
		
		System.out.println(encuentraPalabra("bc", prueba));
	*/
		BinaryTree<String> Q = BinaryTree.parse("5(4(3,_),6(_,8(7,9)))");
        System.out.println(Q);
        System.out.println(ordenado(Q, Comparator.naturalOrder()));
	}

}
