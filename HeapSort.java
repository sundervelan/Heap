import java.util.Arrays;

public class generateHeap {
	
	static int heapArray[];
	static int heapsize=0;
	int heapCapacity;
   generateHeap(int capacity)
	{
		 heapArray = new int[capacity];
		 heapCapacity = capacity;
		 
	}
	
	
	public generateHeap() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int normalArray[] = {44,5,33,8,2,12,89,16,15,90,6,21,23};
		
		int capacity = normalArray.length;
		
		generateHeap sort = new generateHeap(capacity);
		
		for(int i=0;i<normalArray.length;i++)
		{
			sort.insertElement(normalArray[i]);
		}
		sort.print();
		//sort.removeMaxElement();
		//sort.print();
		//sort.removeElement(5);
		//sort.print();
		
		for (int k=heapsize-1;k>=0;k--)
		{
			int temp = heapArray[0];
			heapArray[0] = heapArray[k];
			heapArray[k]= temp;
			
			sort.Heapify(k,0);	
			System.out.println(Arrays.toString(heapArray));	
		}
		sort.print();
		
	}
	

	
	public void Heapify(int k,int i)
	{
	
		int largest =i;
		heapsize=k;
		try
		{
		if (i<heapsize && heapArray[i]<heapArray[rightChild(i)])
		{
			largest =rightChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Right child not found for"+  heapArray[i]);
		}
		
		try
		{
		if (i<heapsize && heapArray[largest]<heapArray[leftChild(i)])
		{
		
			largest =leftChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Left child not found for "+ heapArray[i]);
		}
		if(largest != i)
		{
			swap(largest,i);
			i = largest;
		 Heapify(heapsize,i);
		}
		
	}
	
	public void removeElement(int value)
	{
	
		System.out.println(heapArray[value-1]);
		
		if(value > heapsize)
		{
			System.out.println(" The index is not present in heap");
			return;
		}
		if(value < 0)
		{
			System.out.println(" The index is not present in heap");
			return;
		}
		
		
		heapArray[value-1] = heapArray[heapsize-1];
		heapsize--;
		if(heapArray[value-1]> heapArray[parent(value-1)])
		{
			removeFilterUp(value);
		}
		if(heapArray[value-1]< heapArray[parent(value-1)])
		{
			removeFilterDown(value-1);
		}
		
		
		
	}
	public void removeFilterDown(int value)
	{
		int largest =value;
		int i =value;
		try
		{
		if (i<heapsize && heapArray[i]<heapArray[rightChild(i)])
		{
			largest =rightChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Right child not found for"+  heapArray[i]);
		}
		
		try
		{
		if (i<heapsize && heapArray[largest]<heapArray[leftChild(i)])
		{
		
			largest =leftChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Left child not found for "+ heapArray[i]);
		}
		
		if(largest != i)
		{
			swap(largest,i);
			i = largest;
			removeFilterDown(i);
		}
		
	}
	
	
	
	
	public void removeFilterUp(int value)
	{
	}
	
	public int parent(int value)
	{
		if(value%2 ==0)
		return (value/2)-1;
		else
			return value/2;
	}
	public void print()
	{
		System.out.println(Arrays.toString(heapArray));
		for (int i = 0; i < heapsize / 2; i++ )
        {
            System.out.print(" PARENT : " + heapArray[i] + " LEFT CHILD : " + heapArray[leftChild(i)]
                  + " RIGHT CHILD :" + heapArray[rightChild(i)]);
            System.out.println();
        }
	}
	
	private void swap(int fpos,int spos)
    {
        int tmp;
        tmp = heapArray[fpos];
        heapArray[fpos] = heapArray[spos];
        heapArray[spos] = tmp;
    }
	
	public void insertElement(int val)
	{
		
		heapArray[heapsize]= val;
		heapsize++;
		int current = heapsize-1;
				
		while(current>0)
		{
		if(heapArray[current] > heapArray[parent(current)])
		{
			swap(parent(current),current);
		}
		current =parent(current); 		
		}
	}
	public void removeMaxElement()
	{
		
		if(heapsize<=0)
		{	System.out.println("Heap is empty");}
		
		
		if(heapsize==1)
		{
			heapsize--;
			System.out.println(heapArray[0]);
		}
	
		System.out.println("Removing the maximum element " + heapArray[0]); 
		heapArray[0] = heapArray[heapsize-1];
		heapsize--;
		maxHeapify(0);
		
	}
	public int rightChild(int value)
	{
		if((value*2)+2 <heapsize)
		{ 
			return (value*2)+2;
		}
		else
		{
			return -1;
		}
	}
	public int leftChild(int value)
	{
		
		if((value*2)+1 <heapsize)
		{ 
			return (value*2)+1;
		}
		else
		{
			return -1;
		}
	}
	
	
	public void maxHeapify(int i)
	{
	
		int largest =i;
		
		try
		{
		if (i<heapsize && heapArray[i]<heapArray[rightChild(i)])
		{
			largest =rightChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Right child not found for"+  heapArray[i]);
		}
		
		try
		{
		if (i<heapsize && heapArray[largest]<heapArray[leftChild(i)])
		{
		
			largest =leftChild(i);
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Left child not found for "+ heapArray[i]);
		}
		if(largest != i)
		{
			swap(largest,i);
			i = largest;
			maxHeapify(i);
		}
		
	}
	

}
