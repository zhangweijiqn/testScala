package zwj.test006_Array

/**
 * Created by zhangwj on 16-5-3.
 */
object testListTop {

  implicit def iterExt[B](iter: Iterable[B]) = new {    //匿名类
    def top[C](n: Int, f: B =>C)(implicit ord: Ordering[C]): List[B] = {
      def updateSofar (sofar: List [B], el: B): List [B] = {
        //println (el + " - " + sofar)

        if (ord.compare(f(el), f(sofar.head)) > 0)
          (el :: sofar.tail).sortBy (f)
        else sofar
      }

      val (sofar, rest) = iter.splitAt(n)
      (sofar.toList.sortBy (f) /: rest) (updateSofar (_, _)).reverse
    }
  }

  def testSliding(): Unit ={
    val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    xs.sliding(4,2).foreach(println)
    //sliding第一个参数的含义是几个元素组成一个List，本例中第一个参数是4，所以是每4个元素组成一个List，剩余元素不够的组成一个List。
    //第二个参数的含义可以理解为，每次List第一个元素相对上一个List的第一个元素移动的步数。
  }

  def testGrouped(): Unit ={
    //当size和step相等的时候，可以简化使用grouped方法
    val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    xs.grouped(4).foreach(println)
  }

  def main(args: Array[String]) {
    val li = List (4, 3, 6, 7, 1, 2, 9, 5).map(i => (i, 10-i)).toIterable
    println(li.top(3, _._2)) // li类型为Iterable，没有top方法，会调用隐式转换提供的方法，返回一个匿名类对象，该对象中包含了top方法

    testSliding()

    testGrouped()
  }

}
