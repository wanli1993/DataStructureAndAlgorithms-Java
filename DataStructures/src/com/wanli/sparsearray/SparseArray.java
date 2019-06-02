package com.wanli.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * ϡ������
 * 
 * @author ����
 *
 */
public class SparseArray {
	public static void main(String[] args) throws IOException {
		// 1.����һ��Ԫ������ 10*10
		int chessArr[][] = new int[10][10];
		Random random=new Random();
		// 2.��ʼ��ԭʼ����
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				chessArr[i][j]=random.nextInt(3);
			}
		}
		
		// 3.����ά���� ת ϡ������
		// 3.1 �ȱ�����ά���� �õ���0���ݵĸ���
		int sum =0;
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				if(chessArr[i][j]!=0){
					sum++;
				}
			}
		}
		// 3.2������Ӧ��ϡ������;ϡ���������ص㣺��sum+1�У�3��
		int sparseArr[][] = new int[sum + 1][3];
		// 3.3��ϡ�������һ�и�ֵ
		sparseArr[0][0] = 10;//��ʾԭ������10��
		sparseArr[0][1] = 10;//��ʾԭ������10��
		sparseArr[0][2] = sum;//��ʾԭ������sum����Ϊ���ֵ
		// 3.4������ά���飬����0��ֵ��ŵ� sparseArr��
		int row =0;//��¼ϡ��������������Ҳ��ԭ����ڼ�����������
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				if(chessArr[i][j]!=0){
					row++;
					sparseArr[row][0]=i;
					sparseArr[row][1]=j;
					sparseArr[row][2]=chessArr[i][j];
				}
			}
		}

		// 4.��ϡ����������ļ���
		write(sparseArr);
		// 5.���ļ��ж�ȡ����
		int sparseArr1[][] =new int[sum+1][3];
		sparseArr1 =read(sparseArr1);
		// 6.��ӡ����
		print(sparseArr1);
		// 7.��ϡ������ ת ��ά����
		// 7.1����һ�����飬���ڽ���ת�����ԭ����
		int chessArr1[][] =new int[sparseArr1[0][0]][sparseArr1[0][1]];
		// 7.2����ϡ�������ԭ���鸳ֵ
		for(int i=1;i<sparseArr1.length;i++){
			chessArr1[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
		}
		// 8.��ӡԭ����
		print(chessArr1);
		
	}
	// ������д���ļ�
	public static void write(int[][] arry) throws IOException{
		FileWriter out =new FileWriter(new File("D:\\sparseArr.txt"));
		for(int i =0;i<arry.length;i++){
			for(int j=0;j<arry[i].length;j++){
				out.write(arry[i][j]+"\t");
			}
			out.write("\r\n");
		}
		out.close();
	}
	// ���ļ��ж�ȡ����
	public static int[][] read(int[][] arry) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("D:\\sparseArr.txt"));
		String line; //��ȡ��һ������
		int row=0;//���������
		while((line=in.readLine())!=null){
			String[] temp=line.split("\t");
			for(int i=0;i<temp.length;i++){
				arry[row][i]= Integer.parseInt(temp[i]);
			}
			row++;
		}
		in.close();
		return arry;
	}
	// ��ӡ����
	public static void print(int[][] arry){
		for(int i =0;i<arry.length;i++){
			for(int j=0;j<arry[i].length;j++){
				System.out.printf("%d\t", arry[i][j]);
			}
			System.out.println("");
		}	
	}	
	
}
