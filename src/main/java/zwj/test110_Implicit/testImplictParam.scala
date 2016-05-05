package zwj.test110_Implicit

/**
 * Created by zhangwj on 16-3-31.
 */

object Test{

  implicit val KeyOrdering = new Ordering[Tuple2[String,Int]] {   //隐式参数
    override def compare(x: Tuple2[String,Int], y:Tuple2[String,Int]): Int = {
      x._2 - y._2
    }
  }

  def main(args: Array[String]) {
    val nums:Tuple2[String,Int]=("abc",1)
    val scores_m=scala.collection.mutable.Map("Alice"->10,"Bob"->3,("Cindy",8),nums)

    val maxTuple = scores_m.max;  //需要compare的函数会自动调用上面定义的隐式函数,max定义中包含隐式参数
    println(maxTuple)

  }
}
