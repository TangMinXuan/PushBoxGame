package PushBoxGame2;

public class LinkStack 
{
	private item base;
    private item top;
     
    class item
    {
        public int data;
        public item next;
    }
     
    /**
     * 初始化栈
     * */
    void initStack()
    {
        top = new item();
        base = new item();
        top.data=0;
        top.next=base;
        base.data=0;
        base.next=null;
    }
     
    /**
     * 入栈
     * */
    void push(int data)
    {
        item e = new item();
        e.data = data;
        if(top.next==base)//第一次入栈操作
        {
            e.next=base;
            top.next=e;
        }
        else
        {
            e.next=top.next;
            top.next=e;
        }
         
    }
     
    /**
     * 出栈
     * */
    int pop()
    {
        if(top.next==base)
        {
            System.out.println("栈中没有元素！");
            return 0;
        }
        else
        {
        	int redata = top.next.data;
        	top.next = top.next.next;
            return redata;
        }
    }
     
    /**
     * 打印栈
     * */
    void print()
    {
        System.out.print("打印栈：");
        item temp =top;
        while(temp.next!=base)
        {
            System.out.print(temp.next.data+"\t");
            temp =temp.next;
        }
        System.out.println();
    }
}
