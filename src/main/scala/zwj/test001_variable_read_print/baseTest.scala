package zwj.test001_variable_read_print

/**
 * Created by zhangwj on 16-6-23.
 */
object baseTest {

  def test(): Unit ={
    //test maximum Integer
    println(Integer.MAX_VALUE)  //2的31次方减1，Integer包含正负

    //test string span
    val Str = "abc\tdef\tghi"
    val spanStr = Str.span(_!='\t') //split，在第一个满足条件的地方将字符串拆分成2部分
    println(spanStr)

    //test Option class,Option可以代表一个不存在的值 None,存在的为Some
    val data = if(Str.isEmpty)None else Some(Str)
    println(data) //Some(abc	def	ghi)
    println(data.get) //abc	def	ghi,如果data为None，这里会抛异常：java.util.NoSuchElementException: None.get
    println(data.getOrElse("a"))  //推荐该方式，data为None时，返回"a",传入多个参数("a","b","c")，返回(a,b,c)

    val Str2 = Array[Int]()
    val data2 = if(Str2.isEmpty)None else Some(Str2)
    if (data2 equals None) {
      println("None")
    } else {
      println("not None")
    }

  }

  def main(args: Array[String]) {

    test

  }
}
