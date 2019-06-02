package com.wanli.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 稀疏数组
 * 
 * @author 万里
 *
 */
public class SparseArray {
	public static void main(String[] args) throws IOException {
		// 1.创建一个元素数组 10*10
		int chessArr[][] = new int[10][10];
		Random random=new Random();
		// 2.初始化原始数组
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				chessArr[i][j]=random.nextInt(3);
			}
		}
		
		// 3.将二维数组 转 稀疏数组
		// 3.1 先遍历二维数组 得到非0数据的个数
		int sum =0;
		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				if(chessArr[i][j]!=0){
					sum++;
				}
			}
		}
		// 3.2创建对应的稀疏数组;稀疏索引的特点：有sum+1行，3列
		int sparseArr[][] = new int[sum + 1][3];
		// 3.3给稀疏数组第一行赋值
		sparseArr[0][0] = 10;//表示原数组有10行
		sparseArr[0][1] = 10;//表示原数组有10列
		sparseArr[0][2] = sum;//表示原数组有sum个不为零的值
		// 3.4遍历二维数组，将非0的值存放到 sparseArr中
		int row =0;//记录稀疏索引的行数，也是原数组第几个非零数据
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

		// 4.将稀疏数组存入文件中
		write(sparseArr);
		// 5.从文件中读取数据
		int sparseArr1[][] =new int[sum+1][3];
		sparseArr1 =read(sparseArr1);
		// 6.打印数组
		print(sparseArr1);
		// 7.将稀疏数组 转 二维数组
		// 7.1创建一个数组，用于接受转换后的原数组
		int chessArr1[][] =new int[sparseArr1[0][0]][sparseArr1[0][1]];
		// 7.2遍历稀疏数组给原数组赋值
		for(int i=1;i<sparseArr1.length;i++){
			chessArr1[sparseArr1[i][0]][sparseArr1[i][1]]=sparseArr1[i][2];
		}
		// 8.打印原数组
		print(chessArr1);
		
	}
	// 将数组写入文件
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
	// 从文件中读取数组
	public static int[][] read(int[][] arry) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("D:\\sparseArr.txt"));
		String line; //读取的一行数据
		int row=0;//数组的行数
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
	// 打印数组
	public static void print(int[][] arry){
		for(int i =0;i<arry.length;i++){
			for(int j=0;j<arry[i].length;j++){
				System.out.printf("%d\t", arry[i][j]);
			}
			System.out.println("");
		}	
	}	
	
}
