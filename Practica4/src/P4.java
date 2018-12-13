import java.util.stream.Stream;

public class P4 {
	
	public static Integer buscaPropiedadRec(Integer[] a) {
		return buscaPropiedadRec(a, 0 , a.length,a.length/2) ;
	}
	
	public static Integer buscaPropiedadRec(Integer[] a, int i ,int j , int k) {
		Integer res = -1;
		if(k == a[k] || i == j) {
			res = k;
		}else if(k < a[k]){
			buscaPropiedadRec(a, i, k , (i +k)/2);
		}else {
			buscaPropiedadRec(a, k+1, j ,(k+1+j)/2);
		}
		return res;
	}
	public static Integer bucaPropI(Integer[] a){
		int res = -1;
		int i = 0;
		int j = a.length;
		int k = (i + j)/2;
		while(res == -1 && i != j){
			if(k < a[k] ){
				j = k;
				k = (i+j)/2;
			}else if(k > a[k]){
				i = k +1;
				k = (i + j)/2;
			}else{
				res = k;
			}
		}
		return res;
	}
	
	private static Aux1 siguiente(Aux1 x, Integer[] a) {
		int i = x.getI();
		int j = x.getJ();
		int k = x.getK();
		if(k < a[k] ){
			j = k;
		}else{
			i = k+1;
		}
		k = (i + j)/2;
		Aux1 res =  new Aux1(i, j, k);
		return res;
	}
	
	public static Integer buscaPropiedadP(Integer[] a) {
		Aux1 seed = new Aux1(0, a.length, a.length/2);
		
		return Stream.iterate(seed, x ->siguiente(x,a))
				.dropWhile(x -> a[x.getK()]!=x.getK()	)
				.findFirst().get().getK();
	}

	public static void main(String[] args) {
	Integer[] a = {-1,0,2,4,5};
	System.out.println(buscaPropiedadRec(a));

	}

}
