// This is free and unencumbered software released into the public domain.
// 
// Anyone is free to copy, modify, publish, use, compile, sell, or
// distribute this software, either in source code form or as a compiled
// binary, for any purpose, commercial or non-commercial, and by any
// means.
// 
// In jurisdictions that recognize copyright laws, the author or authors
// of this software dedicate any and all copyright interest in the
// software to the public domain. We make this dedication for the benefit
// of the public at large and to the detriment of our heirs and
// successors. We intend this dedication to be an overt act of
// relinquishment in perpetuity of all present and future rights to this
// software under copyright law.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
// IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
// OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
// ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
// OTHER DEALINGS IN THE SOFTWARE.
// 
// For more information, please refer to <http://unlicense.org/>

package com.bitcurry.byteops;

/**
 * Collection of helper methods that take some of the pain out of working with
 * the native <code>byte</code> type in Java. Each bitwise operation is
 * provided in four different flavors - one for each permutation of the
 * <code>byte</code> and <code>int</code> types. This way the programmer can
 * specify <code>and(myByteValue, 0xF7)</code> without getting errors about
 * missing method signatures. This library also masks any <code>int</code>
 * values before using them, so performing shifts and rotates will only operate
 * on bits 0 through 7.
 * 
 * Each of the 256 values of <code>byte</code> are also provided as constants
 * of the form <code>B0xHH</code> where HH is the two-digit hex value.
 * 
 * Note that this class does not <i>eliminate</i> the casts that Java makes
 * from <code>byte</code> to <code>int</code> and visa versa when bitwise
 * operations are performed, it simply hides the operations so the programmer
 * doesn't have to clutter code with them.
 * 
 * @author Nick Stevens <nick@bitcurry.com>
 */
public class ByteOps {

	private final static int BYTE_MASK = 0x000000FF;
	
	/**
	 * Perform bitwise AND of <code>op1</code> and <code>op2</code>
	 */
	public static final byte and(final byte op1, final byte op2) {
		return and((int)op1, (int)op2);
	}
	
	/**
	 * Perform bitwise AND of <code>op1</code> and <code>op2</code>
	 */
	public static final byte and(final byte op1, final int op2) {
		return and((int)op1, op2);
	}
	
	/**
	 * Perform bitwise AND of <code>op1</code> and <code>op2</code>
	 */
	public static final byte and(final int op1, final byte op2) {
		return and(op1, (int)op2);
	}
	
	/**
	 * Perform bitwise AND of <code>op1</code> and <code>op2</code>
	 */
	public static final byte and(final int op1, final int op2) {
		return (byte)(op1 & op2 & BYTE_MASK);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the left
	 */
	public static final byte lrotate(final byte op1, final byte n) {
		return lrotate((int)op1, (int)n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the left
	 */
	public static final byte lrotate(final byte op1, final int n) {
		return lrotate((int)op1, n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the left
	 */
	public static final byte lrotate(final int op1, final byte n) {
		return lrotate(op1, (int)n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the left
	 */
	public static final byte lrotate(final int op1, final int n) {
		int top = (op1 & BYTE_MASK) << n;
		int bottom = (op1 & BYTE_MASK) >>> (8-n);
		return (byte)((top | bottom) & BYTE_MASK);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the left. Zeroes
	 * are shifted into the lowest bit.
	 */
	public static final byte lshift(final byte op1, final byte n) {
		return lshift((int)op1, (int)n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the left. Zeroes
	 * are shifted into the lowest bit.
	 */
	public static final byte lshift(final byte op1, final int n) {
		return lshift((int)op1, n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the left. Zeroes
	 * are shifted into the lowest bit.
	 */
	public static final byte lshift(final int op1, final byte n) {
		return lshift(op1, (int)n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the left. Zeroes
	 * are shifted into the lowest bit.
	 */
	public static final byte lshift(final int op1, final int n) {
		return (byte)((op1 & BYTE_MASK) << n);
	}
	
	/**
	 * Bitwise invert <code>op1</code>
	 */
	public static final byte not(final byte op1) {
		return not((int)op1);
	}
	
	/**
	 * Bitwise invert <code>op1</code>
	 */
	public static final byte not(final int op1) {
		return (byte)(~op1 & BYTE_MASK);
	}
	
	/**
	 * Perform bitwise OR of <code>op1</code> and <code>op2</code>
	 */
	public static final byte or(final byte op1, final byte op2) {
		return or((int)op1, (int)op2);
	}
	
	/**
	 * Perform bitwise OR of <code>op1</code> and <code>op2</code>
	 */
	public static final byte or(final byte op1, final int op2) {
		return or((int)op1, op2);
	}
	
	/**
	 * Perform bitwise OR of <code>op1</code> and <code>op2</code>
	 */
	public static final byte or(final int op1, final byte op2) {
		return or(op1, (int)op2);
	}
	
	/**
	 * Perform bitwise OR of <code>op1</code> and <code>op2</code>
	 */
	public static final byte or(final int op1, final int op2) {
		return (byte)(op1 | op2 & BYTE_MASK);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the right
	 */
	public static final byte rrotate(final byte op1, final byte n) {
		return rrotate((int)op1, (int)n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the right
	 */
	public static final byte rrotate(final byte op1, final int n) {
		return rrotate((int)op1, n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the right
	 */
	public static final byte rrotate(final int op1, final byte n) {
		return rrotate(op1, (int)n);
	}
	
	/**
	 * Rotate <code>op1</code> by <code>n</code> bits to the right
	 */
	public static final byte rrotate(final int op1, final int n) {
		int top = (op1 & BYTE_MASK) << (8-n);
		int bottom = (op1 & BYTE_MASK) >>> n;
		return (byte)(top | bottom);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the right. Zeroes
	 * are shifted into the highest bit.
	 */
	public static final byte rshift(final byte op1, final byte n) {
		return rshift((int)op1, (int)n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the right. Zeroes
	 * are shifted into the highest bit.
	 */
	public static final byte rshift(final byte op1, final int n) {
		return rshift((int)op1, n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the right. Zeroes
	 * are shifted into the highest bit.
	 */
	public static final byte rshift(final int op1, final byte n) {
		return rshift(op1, (int)n);
	}
	
	/**
	 * Shift <code>op1</code> by <code>n</code> bits to the right. Zeroes
	 * are shifted into the highest bit.
	 */
	public static final byte rshift(final int op1, final int n) {
		return (byte)((op1 & BYTE_MASK) >>> n);
	}
	
	/** 
	 * Perform bitwise XOR of <code>op1</code> and <code>op2</code> 
	 */
	public static final byte xor(final byte op1, final byte op2) {
		return xor((int)op1, (int)op2);
	}

	/** 
	 * Perform bitwise XOR of <code>op1</code> and <code>op2</code> 
	 */
	public static final byte xor(final byte op1, final int op2) {
		return xor((int)op1, op2);
	}
	
	/** 
	 * Perform bitwise XOR of <code>op1</code> and <code>op2</code> 
	 */
	public static final byte xor(final int op1, final byte op2) {
		return xor(op1, (int)op2);
	}

	/** 
	 * Perform bitwise XOR of <code>op1</code> and <code>op2</code> 
	 */
	public static final byte xor(final int op1, final int op2) {
		return (byte)((op1 ^ op2) & BYTE_MASK);
	}
	
	/* Below here are all bytes 0-255 as constants */
	public static final byte B0x00 = (byte) 0x00;
	public static final byte B0x01 = (byte) 0x01;
	public static final byte B0x02 = (byte) 0x02;
	public static final byte B0x03 = (byte) 0x03;
	public static final byte B0x04 = (byte) 0x04;
	public static final byte B0x05 = (byte) 0x05;
	public static final byte B0x06 = (byte) 0x06;
	public static final byte B0x07 = (byte) 0x07;
	public static final byte B0x08 = (byte) 0x08;
	public static final byte B0x09 = (byte) 0x09;
	public static final byte B0x0A = (byte) 0x0A;
	public static final byte B0x0B = (byte) 0x0B;
	public static final byte B0x0C = (byte) 0x0C;
	public static final byte B0x0D = (byte) 0x0D;
	public static final byte B0x0E = (byte) 0x0E;
	public static final byte B0x0F = (byte) 0x0F;
	public static final byte B0x10 = (byte) 0x10;
	public static final byte B0x11 = (byte) 0x11;
	public static final byte B0x12 = (byte) 0x12;
	public static final byte B0x13 = (byte) 0x13;
	public static final byte B0x14 = (byte) 0x14;
	public static final byte B0x15 = (byte) 0x15;
	public static final byte B0x16 = (byte) 0x16;
	public static final byte B0x17 = (byte) 0x17;
	public static final byte B0x18 = (byte) 0x18;
	public static final byte B0x19 = (byte) 0x19;
	public static final byte B0x1A = (byte) 0x1A;
	public static final byte B0x1B = (byte) 0x1B;
	public static final byte B0x1C = (byte) 0x1C;
	public static final byte B0x1D = (byte) 0x1D;
	public static final byte B0x1E = (byte) 0x1E;
	public static final byte B0x1F = (byte) 0x1F;
	public static final byte B0x20 = (byte) 0x20;
	public static final byte B0x21 = (byte) 0x21;
	public static final byte B0x22 = (byte) 0x22;
	public static final byte B0x23 = (byte) 0x23;
	public static final byte B0x24 = (byte) 0x24;
	public static final byte B0x25 = (byte) 0x25;
	public static final byte B0x26 = (byte) 0x26;
	public static final byte B0x27 = (byte) 0x27;
	public static final byte B0x28 = (byte) 0x28;
	public static final byte B0x29 = (byte) 0x29;
	public static final byte B0x2A = (byte) 0x2A;
	public static final byte B0x2B = (byte) 0x2B;
	public static final byte B0x2C = (byte) 0x2C;
	public static final byte B0x2D = (byte) 0x2D;
	public static final byte B0x2E = (byte) 0x2E;
	public static final byte B0x2F = (byte) 0x2F;
	public static final byte B0x30 = (byte) 0x30;
	public static final byte B0x31 = (byte) 0x31;
	public static final byte B0x32 = (byte) 0x32;
	public static final byte B0x33 = (byte) 0x33;
	public static final byte B0x34 = (byte) 0x34;
	public static final byte B0x35 = (byte) 0x35;
	public static final byte B0x36 = (byte) 0x36;
	public static final byte B0x37 = (byte) 0x37;
	public static final byte B0x38 = (byte) 0x38;
	public static final byte B0x39 = (byte) 0x39;
	public static final byte B0x3A = (byte) 0x3A;
	public static final byte B0x3B = (byte) 0x3B;
	public static final byte B0x3C = (byte) 0x3C;
	public static final byte B0x3D = (byte) 0x3D;
	public static final byte B0x3E = (byte) 0x3E;
	public static final byte B0x3F = (byte) 0x3F;
	public static final byte B0x40 = (byte) 0x40;
	public static final byte B0x41 = (byte) 0x41;
	public static final byte B0x42 = (byte) 0x42;
	public static final byte B0x43 = (byte) 0x43;
	public static final byte B0x44 = (byte) 0x44;
	public static final byte B0x45 = (byte) 0x45;
	public static final byte B0x46 = (byte) 0x46;
	public static final byte B0x47 = (byte) 0x47;
	public static final byte B0x48 = (byte) 0x48;
	public static final byte B0x49 = (byte) 0x49;
	public static final byte B0x4A = (byte) 0x4A;
	public static final byte B0x4B = (byte) 0x4B;
	public static final byte B0x4C = (byte) 0x4C;
	public static final byte B0x4D = (byte) 0x4D;
	public static final byte B0x4E = (byte) 0x4E;
	public static final byte B0x4F = (byte) 0x4F;
	public static final byte B0x50 = (byte) 0x50;
	public static final byte B0x51 = (byte) 0x51;
	public static final byte B0x52 = (byte) 0x52;
	public static final byte B0x53 = (byte) 0x53;
	public static final byte B0x54 = (byte) 0x54;
	public static final byte B0x55 = (byte) 0x55;
	public static final byte B0x56 = (byte) 0x56;
	public static final byte B0x57 = (byte) 0x57;
	public static final byte B0x58 = (byte) 0x58;
	public static final byte B0x59 = (byte) 0x59;
	public static final byte B0x5A = (byte) 0x5A;
	public static final byte B0x5B = (byte) 0x5B;
	public static final byte B0x5C = (byte) 0x5C;
	public static final byte B0x5D = (byte) 0x5D;
	public static final byte B0x5E = (byte) 0x5E;
	public static final byte B0x5F = (byte) 0x5F;
	public static final byte B0x60 = (byte) 0x60;
	public static final byte B0x61 = (byte) 0x61;
	public static final byte B0x62 = (byte) 0x62;
	public static final byte B0x63 = (byte) 0x63;
	public static final byte B0x64 = (byte) 0x64;
	public static final byte B0x65 = (byte) 0x65;
	public static final byte B0x66 = (byte) 0x66;
	public static final byte B0x67 = (byte) 0x67;
	public static final byte B0x68 = (byte) 0x68;
	public static final byte B0x69 = (byte) 0x69;
	public static final byte B0x6A = (byte) 0x6A;
	public static final byte B0x6B = (byte) 0x6B;
	public static final byte B0x6C = (byte) 0x6C;
	public static final byte B0x6D = (byte) 0x6D;
	public static final byte B0x6E = (byte) 0x6E;
	public static final byte B0x6F = (byte) 0x6F;
	public static final byte B0x70 = (byte) 0x70;
	public static final byte B0x71 = (byte) 0x71;
	public static final byte B0x72 = (byte) 0x72;
	public static final byte B0x73 = (byte) 0x73;
	public static final byte B0x74 = (byte) 0x74;
	public static final byte B0x75 = (byte) 0x75;
	public static final byte B0x76 = (byte) 0x76;
	public static final byte B0x77 = (byte) 0x77;
	public static final byte B0x78 = (byte) 0x78;
	public static final byte B0x79 = (byte) 0x79;
	public static final byte B0x7A = (byte) 0x7A;
	public static final byte B0x7B = (byte) 0x7B;
	public static final byte B0x7C = (byte) 0x7C;
	public static final byte B0x7D = (byte) 0x7D;
	public static final byte B0x7E = (byte) 0x7E;
	public static final byte B0x7F = (byte) 0x7F;
	public static final byte B0x80 = (byte) 0x80;
	public static final byte B0x81 = (byte) 0x81;
	public static final byte B0x82 = (byte) 0x82;
	public static final byte B0x83 = (byte) 0x83;
	public static final byte B0x84 = (byte) 0x84;
	public static final byte B0x85 = (byte) 0x85;
	public static final byte B0x86 = (byte) 0x86;
	public static final byte B0x87 = (byte) 0x87;
	public static final byte B0x88 = (byte) 0x88;
	public static final byte B0x89 = (byte) 0x89;
	public static final byte B0x8A = (byte) 0x8A;
	public static final byte B0x8B = (byte) 0x8B;
	public static final byte B0x8C = (byte) 0x8C;
	public static final byte B0x8D = (byte) 0x8D;
	public static final byte B0x8E = (byte) 0x8E;
	public static final byte B0x8F = (byte) 0x8F;
	public static final byte B0x90 = (byte) 0x90;
	public static final byte B0x91 = (byte) 0x91;
	public static final byte B0x92 = (byte) 0x92;
	public static final byte B0x93 = (byte) 0x93;
	public static final byte B0x94 = (byte) 0x94;
	public static final byte B0x95 = (byte) 0x95;
	public static final byte B0x96 = (byte) 0x96;
	public static final byte B0x97 = (byte) 0x97;
	public static final byte B0x98 = (byte) 0x98;
	public static final byte B0x99 = (byte) 0x99;
	public static final byte B0x9A = (byte) 0x9A;
	public static final byte B0x9B = (byte) 0x9B;
	public static final byte B0x9C = (byte) 0x9C;
	public static final byte B0x9D = (byte) 0x9D;
	public static final byte B0x9E = (byte) 0x9E;
	public static final byte B0x9F = (byte) 0x9F;
	public static final byte B0xA0 = (byte) 0xA0;
	public static final byte B0xA1 = (byte) 0xA1;
	public static final byte B0xA2 = (byte) 0xA2;
	public static final byte B0xA3 = (byte) 0xA3;
	public static final byte B0xA4 = (byte) 0xA4;
	public static final byte B0xA5 = (byte) 0xA5;
	public static final byte B0xA6 = (byte) 0xA6;
	public static final byte B0xA7 = (byte) 0xA7;
	public static final byte B0xA8 = (byte) 0xA8;
	public static final byte B0xA9 = (byte) 0xA9;
	public static final byte B0xAA = (byte) 0xAA;
	public static final byte B0xAB = (byte) 0xAB;
	public static final byte B0xAC = (byte) 0xAC;
	public static final byte B0xAD = (byte) 0xAD;
	public static final byte B0xAE = (byte) 0xAE;
	public static final byte B0xAF = (byte) 0xAF;
	public static final byte B0xB0 = (byte) 0xB0;
	public static final byte B0xB1 = (byte) 0xB1;
	public static final byte B0xB2 = (byte) 0xB2;
	public static final byte B0xB3 = (byte) 0xB3;
	public static final byte B0xB4 = (byte) 0xB4;
	public static final byte B0xB5 = (byte) 0xB5;
	public static final byte B0xB6 = (byte) 0xB6;
	public static final byte B0xB7 = (byte) 0xB7;
	public static final byte B0xB8 = (byte) 0xB8;
	public static final byte B0xB9 = (byte) 0xB9;
	public static final byte B0xBA = (byte) 0xBA;
	public static final byte B0xBB = (byte) 0xBB;
	public static final byte B0xBC = (byte) 0xBC;
	public static final byte B0xBD = (byte) 0xBD;
	public static final byte B0xBE = (byte) 0xBE;
	public static final byte B0xBF = (byte) 0xBF;
	public static final byte B0xC0 = (byte) 0xC0;
	public static final byte B0xC1 = (byte) 0xC1;
	public static final byte B0xC2 = (byte) 0xC2;
	public static final byte B0xC3 = (byte) 0xC3;
	public static final byte B0xC4 = (byte) 0xC4;
	public static final byte B0xC5 = (byte) 0xC5;
	public static final byte B0xC6 = (byte) 0xC6;
	public static final byte B0xC7 = (byte) 0xC7;
	public static final byte B0xC8 = (byte) 0xC8;
	public static final byte B0xC9 = (byte) 0xC9;
	public static final byte B0xCA = (byte) 0xCA;
	public static final byte B0xCB = (byte) 0xCB;
	public static final byte B0xCC = (byte) 0xCC;
	public static final byte B0xCD = (byte) 0xCD;
	public static final byte B0xCE = (byte) 0xCE;
	public static final byte B0xCF = (byte) 0xCF;
	public static final byte B0xD0 = (byte) 0xD0;
	public static final byte B0xD1 = (byte) 0xD1;
	public static final byte B0xD2 = (byte) 0xD2;
	public static final byte B0xD3 = (byte) 0xD3;
	public static final byte B0xD4 = (byte) 0xD4;
	public static final byte B0xD5 = (byte) 0xD5;
	public static final byte B0xD6 = (byte) 0xD6;
	public static final byte B0xD7 = (byte) 0xD7;
	public static final byte B0xD8 = (byte) 0xD8;
	public static final byte B0xD9 = (byte) 0xD9;
	public static final byte B0xDA = (byte) 0xDA;
	public static final byte B0xDB = (byte) 0xDB;
	public static final byte B0xDC = (byte) 0xDC;
	public static final byte B0xDD = (byte) 0xDD;
	public static final byte B0xDE = (byte) 0xDE;
	public static final byte B0xDF = (byte) 0xDF;
	public static final byte B0xE0 = (byte) 0xE0;
	public static final byte B0xE1 = (byte) 0xE1;
	public static final byte B0xE2 = (byte) 0xE2;
	public static final byte B0xE3 = (byte) 0xE3;
	public static final byte B0xE4 = (byte) 0xE4;
	public static final byte B0xE5 = (byte) 0xE5;
	public static final byte B0xE6 = (byte) 0xE6;
	public static final byte B0xE7 = (byte) 0xE7;
	public static final byte B0xE8 = (byte) 0xE8;
	public static final byte B0xE9 = (byte) 0xE9;
	public static final byte B0xEA = (byte) 0xEA;
	public static final byte B0xEB = (byte) 0xEB;
	public static final byte B0xEC = (byte) 0xEC;
	public static final byte B0xED = (byte) 0xED;
	public static final byte B0xEE = (byte) 0xEE;
	public static final byte B0xEF = (byte) 0xEF;
	public static final byte B0xF0 = (byte) 0xF0;
	public static final byte B0xF1 = (byte) 0xF1;
	public static final byte B0xF2 = (byte) 0xF2;
	public static final byte B0xF3 = (byte) 0xF3;
	public static final byte B0xF4 = (byte) 0xF4;
	public static final byte B0xF5 = (byte) 0xF5;
	public static final byte B0xF6 = (byte) 0xF6;
	public static final byte B0xF7 = (byte) 0xF7;
	public static final byte B0xF8 = (byte) 0xF8;
	public static final byte B0xF9 = (byte) 0xF9;
	public static final byte B0xFA = (byte) 0xFA;
	public static final byte B0xFB = (byte) 0xFB;
	public static final byte B0xFC = (byte) 0xFC;
	public static final byte B0xFD = (byte) 0xFD;
	public static final byte B0xFE = (byte) 0xFE;
	public static final byte B0xFF = (byte) 0xFF;
	
}
