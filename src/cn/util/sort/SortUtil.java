package cn.util.sort;

public class SortUtil {
	//插入排序
	//直接插入排序  时间复杂度=O(n^2)
	public static void insertSort(int[] table){
		for(int i=1;i<table.length;i++){//每个元素和他前边的数据集一次比较
			int temp = table[i],j;
			for(j=i-1;j>-1&&temp<table[j];j--){//若前一个元素比当前元素大，则向前移动
				table[j+1] = table[j];
			}
			table[j+1] = temp;//temp到达插入位置
		}
	    print(table);
	}
	
	//希尔排序
	public static void shellSort(int[] table){
		for(int delta=table.length/2;delta>0;delta/=2){//控制增量，增量每次减半
			//一趟中若干组，每个元素在自己的组中进行直接插入排序
			for(int i=delta;i<table.length;i++){
				int temp = table[i];        //当前带插入元素
				int j = i-delta;            //相距delta远
				while(j>=0 && temp<table[j]){//一组中前面较大的元素向后移
					table[j+delta] = table[j];
					j-=delta;                //继续与前面的相距delta的元素比较，较大的元素向后移
				}
				table[j+delta] = temp;       //元素插入位置
			}
		}
		print(table);
	}
	
	//交换排序
	//冒泡排序 时间复杂度=O(n^2)
	public static void bubbleSort(int[] table){
		boolean changed = true;
		for(int i=1;i<table.length&&changed;i++){
			changed = false;
			for(int j=0;j<table.length-i;j++){
				if(table[j]>table[j+1]){
					int temp = table[j];
					table[j] = table[j+1];
					table[j+1] = temp;
					changed = true;
				}
			}
		}
		print(table);
	}
	
	//快速排序 
	public static void quickSort(int[] table,int low,int hight){
		if(low<hight){
			int i=low,j=hight;
			int vot = table[i];              //第一个元素作为基准值
			while(i!=j){
				while(i<j && vot<=table[j])  //从后向前寻找最小值
					j--;
				if(i<j){
					table[i] = table[j];
					i++;
				}
				while(i<j && vot>table[i]){  //从前向后寻找最大值
					i++;
				}
				if(i<j){
					table[j] = table[i];
					j--;
				}
			}
			table[i] = vot;
			System.out.println(low+".."+hight+", vot="+vot+" ");
			print(table);
			quickSort(table,low,j-1);
			quickSort(table,i+1,hight);
		}
	}
	
	public static void quickSort(int[] table){
		quickSort(table,0,table.length-1);
	}
	
	
	//选择排序    
	//直接选择排序                               每次选出最小值排到第一位
	public static void selectSort(int[] table){
		for(int i=0;i<table.length-1;i++){
			int min = i;
			for(int j=i+1;j<table.length;j++){
				if(table[j]<table[min]){
					min = j;                     //记住最小元素的下标
				}
			}
			if(min != i){
				int temp = table[i];
				table[i] = table[min];
				table[min] = temp;
			}
		}
		print(table);
	}
	
	//堆排序  1调整为最小堆
	public static void sift(int[] table,int low,int hight){
		int i = low;                                //子树的根
		int j = 2*i+1;                              //j为i个节点的左孩子节点
		int temp = table[i];                        //获得第i个节点的值
		while(j<=hight){
			if(j<hight && table[j]>table[j+1])
				j++;                                 //j为temp左右孩子节点中较小者
			if(temp>table[j]){                       //若temp节点的值比孩纸节点中较小的值大；
				table[i] = table[j];                 //孩子节点中的较小值上移
				i = j;                               //i,j 向下一层
				j = 2*i+1;                           //
			}else
				j=hight+1;                           //退出循环
		}
		table[i] = temp;                             //当前子树的原值调整后的位置
	}
	//堆排序
	public static void headSort(int[] table){
		int n = table.length;
		for(int j=n/2-1;j>=0;j--){
			sift(table,j,n-1);                       //创建最小堆；
		}
		print(table);
		for(int j=n-1;j>0;j--){
			int temp = table[0];                     //每趟将最小值交换到最后，再调整成堆
			table[0] = table[j];
			table[j] = temp;
			sift(table,0,j-1);
		}
		
		print(table);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] table = random(10);
		print(table);
		//insertSort(table);
        //shellSort(table);
		//bubbleSort(table);
		//quickSort(table);
		//selectSort(table);
		headSort(table);
	}
	
	public static int[] random(int n){
		if(n>0){
			int[] table = new int[n];
			for(int i=0;i<n;i++)
				table[i] = (int)(Math.random()*100);
			return table;
		}
		return null;
	}

	public static void print(int[] table){
		for(int a:table){
			System.out.print(a+",");
		}
		System.out.println();
	}
}
