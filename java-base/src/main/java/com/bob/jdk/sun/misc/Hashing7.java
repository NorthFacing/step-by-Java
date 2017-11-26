package com.bob.jdk.sun.misc;

import com.bob.jdk.java.util.concurrent.ThreadLocalRandom7;
import sun.misc.VM;

public class Hashing7 {

	private Hashing7() {
		throw new Error("No instances");
	}

	public static int murmur3_32(byte[] var0) {
		return murmur3_32(0, (byte[]) var0, 0, var0.length);
	}

	public static int murmur3_32(int var0, byte[] var1) {
		return murmur3_32(var0, (byte[]) var1, 0, var1.length);
	}

	public static int murmur3_32(int var0, byte[] var1, int var2, int var3) {
		int var4 = var0;

		int var5;
		int var6;
		for (var5 = var3; var5 >= 4; var4 = var4 * 5 + -430675100) {
			var6 = var1[var2] & 255 | (var1[var2 + 1] & 255) << 8 | (var1[var2 + 2] & 255) << 16 | var1[var2 + 3] << 24;
			var5 -= 4;
			var2 += 4;
			var6 *= -862048943;
			var6 = Integer.rotateLeft(var6, 15);
			var6 *= 461845907;
			var4 ^= var6;
			var4 = Integer.rotateLeft(var4, 13);
		}

		if (var5 > 0) {
			var6 = 0;
			switch (var5) {
				case 3:
					var6 ^= (var1[var2 + 2] & 255) << 16;
				case 2:
					var6 ^= (var1[var2 + 1] & 255) << 8;
				case 1:
					var6 ^= var1[var2] & 255;
				default:
					var6 *= -862048943;
					var6 = Integer.rotateLeft(var6, 15);
					var6 *= 461845907;
					var4 ^= var6;
			}
		}

		var4 ^= var3;
		var4 ^= var4 >>> 16;
		var4 *= -2048144789;
		var4 ^= var4 >>> 13;
		var4 *= -1028477387;
		var4 ^= var4 >>> 16;
		return var4;
	}

	public static int murmur3_32(char[] var0) {
		return murmur3_32(0, (char[]) var0, 0, var0.length);
	}

	public static int murmur3_32(int var0, char[] var1) {
		return murmur3_32(var0, (char[]) var1, 0, var1.length);
	}

	public static int murmur3_32(int var0, char[] var1, int var2, int var3) {
		int var4 = var0;
		int var5 = var2;

		int var6;
		int var7;
		for (var6 = var3; var6 >= 2; var4 = var4 * 5 + -430675100) {
			var7 = var1[var5++] & '\uffff' | var1[var5++] << 16;
			var6 -= 2;
			var7 *= -862048943;
			var7 = Integer.rotateLeft(var7, 15);
			var7 *= 461845907;
			var4 ^= var7;
			var4 = Integer.rotateLeft(var4, 13);
		}

		if (var6 > 0) {
			char var8 = var1[var5];
			var7 = var8 * -862048943;
			var7 = Integer.rotateLeft(var7, 15);
			var7 *= 461845907;
			var4 ^= var7;
		}

		var4 ^= var3 * 2;
		var4 ^= var4 >>> 16;
		var4 *= -2048144789;
		var4 ^= var4 >>> 13;
		var4 *= -1028477387;
		var4 ^= var4 >>> 16;
		return var4;
	}

	public static int murmur3_32(int[] var0) {
		return murmur3_32(0, (int[]) var0, 0, var0.length);
	}

	public static int murmur3_32(int var0, int[] var1) {
		return murmur3_32(var0, (int[]) var1, 0, var1.length);
	}

	public static int murmur3_32(int var0, int[] var1, int var2, int var3) {
		int var4 = var0;
		int var5 = var2;

		for (int var6 = var2 + var3; var5 < var6; var4 = var4 * 5 + -430675100) {
			int var7 = var1[var5++];
			var7 *= -862048943;
			var7 = Integer.rotateLeft(var7, 15);
			var7 *= 461845907;
			var4 ^= var7;
			var4 = Integer.rotateLeft(var4, 13);
		}

		var4 ^= var3 * 4;
		var4 ^= var4 >>> 16;
		var4 *= -2048144789;
		var4 ^= var4 >>> 13;
		var4 *= -1028477387;
		var4 ^= var4 >>> 16;
		return var4;
	}

	public static int stringHash32(String var0) {
		return Hashing7.Holder.LANG_ACCESS.getStringHash32(var0);
	}

	public static int randomHashSeed(Object var0) {
		int var1;
		if (VM.isBooted()) {
			var1 = ThreadLocalRandom7.current().nextInt();
		} else {
			int[] var2 = new int[]{System.identityHashCode(Hashing7.class), System.identityHashCode(var0), System.identityHashCode(Thread.currentThread()), (int) Thread.currentThread().getId(), (int) (System.currentTimeMillis() >>> 2), (int) (System.nanoTime() >>> 5), (int) (Runtime.getRuntime().freeMemory() >>> 4)};
			var1 = murmur3_32(var2);
		}

		return 0 != var1 ? var1 : 1;
	}

	private static class Holder {
		static final JavaLangAccess7 LANG_ACCESS = SharedSecrets7.getJavaLangAccess();

		private Holder() {
		}

		static {
			if (null == LANG_ACCESS) {
				throw new Error("Shared secrets not initialized");
			}
		}
	}
}
