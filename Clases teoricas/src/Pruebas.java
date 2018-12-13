public class Pruebas {
	public static void main(String[] args) {
		System.out.println(f(7L));
		System.out.println(fIter(7L));
	}
	// Rec. Multiple
	public static Long f(Long n) {
		Long r;
		if(n==0	|| n==1) {
			r = n;
		}else {
			r = f(n-1) + f(n-2);
		}
		return r;
	}
	// Iterativo
	public static Long fIter(Long n) {
		Long r;
		if(n==0	|| n==1) {
			r = n;
		}else {
			// r = f(n-1) + f(n-2);
			// Definimos 2 variables locales
			// pq tenemos 2 casos base
			Long a = 0L; // Inv: a = f(i-1)
			Long b = 1L; // Inv: b = f(i) 
			Integer i = 1; 
			while(i < n) {
				// <i',a',b'>=<i + 1, b, b + a> 
				// a' = f(i'-1) = f(i + 1 -1) = f(i) = b
				// b' = f(i') = f(i + 1) = 
				//    = f(i) + f(i - 1) = b + a
				Long aAux = b;
				Long bAux = b + a;
				a = aAux;
				b = bAux;
				i = i + 1;
			}// i == n --> b = f(i) = f(n) 
			r = b;						
		}
		return r;
	}
	
}
