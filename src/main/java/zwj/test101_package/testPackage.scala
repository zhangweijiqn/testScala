package zwj.test101_package

/**
 * Created by Administrator on 2016/2/11 0011.
 */

class testPackage {
  import java.awt._     //引入java包,import可以出现在任何位置
  //selector( 选取器）
  import java.awt.{Color,Font}

  //重命名
  import java.util.{HashMap=>JavaHashMap}
  val m = new JavaHashMap[String,Int]

  //隐藏某个成员
  import java.util.{HashSet=>_,_}
  import collection.mutable.HashMap //每个scala程序都隐式引入java.lang._  scala._  import的是相对路径，scala.collection可以省略scala

}
