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

  def main(args: Array[String]) {
    val li = List (4, 3, 6, 7, 1, 2, 9, 5).map(i => (i, 10-i)).toIterable
    println(li.top(3, _._2)) // li类型为Iterable，没有top方法，会调用隐式转换提供的方法，返回一个匿名类对象，该对象中包含了top方法
  }

}
