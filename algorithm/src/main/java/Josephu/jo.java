public class jo {
    public static void main(String[] args) {

        JoLink link=new JoLink();
        link.add(5);
        link.show();

    }
}

class JoLink{

    private int linkNo;
    private JoLink next;


    public int getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(int linkNo) {
        this.linkNo = linkNo;
    }


    public JoLink getNext() {
        return next;
    }

    public void setNext(JoLink next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "joLink{" +
                "linkNo=" + linkNo +
                '}';
    }

    public void add(int num){
        JoLink first=new JoLink();
        first.setLinkNo(0);
        first.setNext(first);
        //让first的下一个指针指向自己？
        for (int i = 1; i <num ; i++) {

            JoLink temp=first;
            JoLink cur=new JoLink();
            while (true){

                //first指针指向自己，已经遍历完毕
                if (temp.getNext()==first){
                    break;
                }

                //指针后移
                temp=temp.getNext();
            }

            //给新链表赋上编号
            cur.setLinkNo(i);

            //前后建立连接
            temp.setNext(cur);
            cur.setNext(first);
        }

    }
    public void show(){
        JoLink first=new JoLink();
        first.setLinkNo(0);
        first.setNext(first);
        while (true){

            //辅助节点temp，是first的拷贝
            JoLink temp=first;

            //temp指针指向first，已经遍历完毕
            if(temp.getNext()==first){
                break;
            }

            //打印节点的信息
            System.out.println(temp.getLinkNo());
        }
    }

}
