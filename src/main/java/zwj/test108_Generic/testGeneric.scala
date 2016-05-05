package zwj.test108_Generic

/**
 * Created by Administrator on 2016/2/20 0020.
 */

class Pair[T,S](val first:T,val second:S){  //泛型类：泛型T，S
  println("first:"+first.getClass)
  println("second:"+second.getClass)
}

class Pair2[T <: Comparable[T]](val first:T,val second:T){  //<:Comparable[T]添加一个上界，意味着T必须是Comparable[T]的子类
  def getSmall = if(first.compareTo(second)<0)first else second
}

case class Rating[@specialized(Int, Long) ID](user: ID, item: ID, rating: Float)  //specialized限定泛型的类型


object testGeneric {

  //泛型函数
  def getMiddle[T](a:Array[T]) = a(a.length/2)  //参数类型同样放在方法名后

  def main(args: Array[String]) {
    val p1 = new Pair("hello",123)
    val p2 = new Pair[Any,Any]("hello",123) //可以自己指定类型

    println(getMiddle(Array("Mary","had","a","little","lamb")))

    val p3 = new Pair2("Fred","Brooks")
    println(p3.getSmall)

    val rating = new Rating(1,2,1.2f);
    println(rating.item)
  }
}
