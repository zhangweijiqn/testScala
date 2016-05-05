package zwj.test108_Generic

/**
 * Created by zhangwj on 16-4-1.
 */
/*类型变量界定，T是一个类型变量，对其进行界定,也就是类新界定*/
class Pair_TypeDefine1[T<:Comparable[T]](val first:T,val second:T){ // T<:Comparable[T]类型变量界定，Comparable[T]指定比较的类型为
  def smaller = if(first.compareTo(second)<0)first else second    //如果没有类型变量界定，调用compareTo方法会报错
}

/*视图界定,兼容类型变量界定+隐式转换*/
class Pair_ViewDefine2_1[T<%Comparable[T]](val first:T,val second:T) {  //T<%Comparable[T]意味着T可以被隐式转换成Comparable[T]
  def smaller = if(first.compareTo(second)<0)first else second    //如果没有类型变量界定，调用compareTo方法会报错
}

class Pair_ViewDefine2_2[T<%Ordered[T]](val first:T,val second:T) {   //Ordered特质在Comparable基础上额外提供了关系操作符
  def smaller = if(first<second)first else second
}

/*上下文界定*/
class Pair_ContextDefine[T:Ordering](val first:T,val second:T){   //T:M, M是另一个泛型类，要求必须存在一个类型为Ordering[T]的隐式值
  def smaller(implicit ord:Ordering[T]) = //当需要使用隐式值的方法时，需要添加隐式参数
    if(ord.compare(first,second)<0)first else second
}


object testTypeDefine {

  def main (args: Array[String] ) {

    /*类型变量界定*/
    //String是Comparable的子类
    val p1 = new Pair_TypeDefine1("Fred","Brooks")
    println(p1.smaller)


    //Int不是Comparable的子类，RichInt是
    val p2 = new Pair_ViewDefine2_1(1,2)  //如果使用类型变量界定会报错，这里使用视图界定
    println(p2.smaller)

    /*上下文界定*/
    //引入隐式值(Ordering对象)，该隐式值中重写了compareTo方法
    import zwj.test110_Implicit.Test._
    val p4 = new Pair_ContextDefine("Alice"->10,"Bob"->5) //前提Pair_ContextDefine类界定了泛型类Ordering
    println(p4.smaller)
    println(p4.smaller(KeyOrdering))//上面的隐式参数和显式传入implicit对象 效果相同

  }
}


