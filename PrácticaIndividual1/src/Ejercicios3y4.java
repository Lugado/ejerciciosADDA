import us.lsi.common.Streams2;
import us.lsi.common.Files2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicios3y4 {
	
	public static List<Integer> listaEnterosFicheroI(String f){
		List<String> l = Files2.getLines(f);
		List<Integer> solucion = new ArrayList<>();
		int i = 0;
		while(i < l.size()) {
			int j = 0;
			String[] s = l.get(i).split(",");
			while(j < s.length) {
				String cadena = s[j].trim();
				solucion.add(Integer.valueOf(cadena));
				j++;
			}	
			i++;
		}	
		return solucion;
	}
	
	public static List<Integer> listaEnterosFicheroR(String f){
		List<Integer> sol = new ArrayList<>();
		List<String> l = Files2.getLines(f);
		return listaEnterosFicheroR(sol, l, 0);
	}
	public static List<Integer> listaEnterosFicheroR(List<Integer> sol, List<String> l,int i){
		List<Integer> res = null;
		if(!(i < l.size())) {
			res = sol;
		}else {
			int j = 0;
			String[] s = l.get(i).split(",");
			while(j < s.length) {
				String cadena = s[j].trim();
				sol.add(Integer.valueOf(cadena));
				j++;
			}
			i++;
			res = listaEnterosFicheroR(sol,l,i);

		}
		return res;
			
		}

	public static List<Integer> listaEnterosFicheroF(String f){
		List<Integer> res = new ArrayList<>();
		Files2.getLines(f).stream().flatMap(i -> Streams2.fromString(i, ",")).forEach(j -> res.add(Integer.valueOf(j)));
		return res;
	}

	public static <T extends Comparable<? super T>> List<T> fusionListasMayMenI(List<T> l1,List<T>l2) {
		List<T> sol = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i<l1.size()&&j<l2.size()) {
			if(l1.get(i).compareTo(l2.get(j)) < 0) {
				sol.add(l2.get(j));
				j++;
			}else {
				sol.add(l1.get(i));
				i++;
			}	
		}
		if(i<l1.size()) {
			sol.addAll(l1.subList(i, l1.size()));
		}
		if(j<l2.size()) {
			sol.addAll(l2.subList(j, l2.size()));
		}
		
		return sol;
	}
	public static <T extends Comparable<? super T>> List<T> fusionListasMayMenR(List<T> l1,List<T>l2) {
		List<T> sol = new ArrayList<>();
		return fusionListasMayMenR(l1, l2, 0, 0, sol);
	}
	
	
	public static <T extends Comparable<? super T>> List<T> fusionListasMayMenR(List<T> l1,List<T>l2, int i, int j, List<T>sol) {
		List<T> res = new ArrayList<>();
		if(!(i<l1.size()&&j<l2.size())) {
			if(i<l1.size()) {
				sol.addAll(l1.subList(i, l1.size()));
			}
			if(j<l2.size()) {
				sol.addAll(l2.subList(j, l2.size()));
			}
			res = sol;
			
			
		}else {
			if(l1.get(i).compareTo(l2.get(j)) < 0) {
				sol.add(l2.get(j));
				j++;
			}else {
				sol.add(l1.get(i));
				i++;
			}	
			res = fusionListasMayMenR(l1,l2,i,j,sol);
		}
		return res;
	}
	
	public static <T extends Comparable<? super T>> List<T> fusionListasMayMenF(List<T> l1,List<T>l2) {
		List<T> res = new ArrayList<>();		
		l1.stream().forEach(i -> res.add(i));
		l2.stream().forEach(i -> res.add(i));
		res.stream();
		res.sort(Comparator.naturalOrder());
		res.sort(Comparator.reverseOrder());
		return res;
	}	
		

	public static void main(String[] args) {
	System.out.println(listaEnterosFicheroF("/home/luis/Escritorio/2ºIITI/ADDA/JAVA/PrácticaIndividual1/src/datos.txt"));
	List<Integer> l1 = new ArrayList<>();	
	List<Integer> l2 = new ArrayList<>();
	l1.add(4);
	l2.add(5);
	l1.add(2);
	l2.add(3);
	l1.add(2);
	l1.add(1);
	System.out.println(fusionListasMayMenF(l1, l2));
	}

}
