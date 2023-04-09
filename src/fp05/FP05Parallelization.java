package fp05;

import java.util.stream.LongStream;

public class FP05Parallelization {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println(LongStream.range(0, 100000000).sum());
		
		System.out.println("Operation took " + (System.currentTimeMillis() - start) + " ms");
		
		start = System.currentTimeMillis();
		
		System.out.println(LongStream.range(0, 100000000).parallel().sum());
		
		System.out.println("Operation took " + (System.currentTimeMillis() - start) + " ms");
	}

}
