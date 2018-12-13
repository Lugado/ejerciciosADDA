import java.util.ArrayList;
import java.util.List;

public class Prueba {

		public static boolean esPrimo1(int n) {
			int i = 2;
			boolean sol = true;
			while(i<=Math.sqrt(n)&&sol) {
				if(n%i==0) {
					sol = false;
				}
				i++;
			}
			return sol;
		}
		
		public static boolean esPrimo2(int n) {
			return esPrimo2(n,2,false);
			
		}
		
		public static boolean esPrimo2(int n,int i, boolean enc) {
			
			boolean res;
			
			if(!(i<=Math.sqrt(n)&&enc)) {
				res =  !enc;
			}else {
				if(n%i==0) {
					enc = true;
				}
				i++;
			}
			return esPrimo2(n-1,i,enc);
			
		}
		
		public static List<Integer> listaCuadradosPrimos(int n){
			List<Integer> sol = new ArrayList<>();
			int i = 2;
			while(i <= n) {
				if(esPrimo1(i)==true) {
					sol.add(i*i);
				}
				i++;
			}
			return sol;
		}
		
		public static List<Integer> listaCuadradosPrimosR(int n){
			List<Integer> sol = new ArrayList<>();
			return listaCuadradosPrimosR(n,2,sol);
		}

		public static List<Integer> listaCuadradosPrimosR(int n,int i,List<Integer> sol){
			List<Integer> res = null;
			if(!(i<=n)) {
				res = sol;
			}else {
				if(esPrimo1(i)) {
					sol.add(i*i);
				}
				res = listaCuadradosPrimosR(n, i+1, sol);
			}
			return res;
		}
		
		
		public static boolean mismoSingnoIncremento(List<Integer> l1, List<Integer> l2) {
			int i = 1;
			boolean res = true;
			int s = l1.size();
			while(i < s) {
				if(l1.get(i)-l1.get(i-1) > 0 && l2.get(i)-l2.get(i-1) < 0 
						|| l2.get(i)-l2.get(i-1) > 0 && l1.get(i)-l1.get(i-1) < 0) {
					res = false;
				}
				i++;
			}
			return res;
		}
		
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> sol = listaCuadradosPrimosR(10);
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(5);
		l1.add(4);
		l2.add(5);
		l2.add(7);
		boolean res = mismoSingnoIncremento(l1, l2);
		System.out.println(res);
	}

}
