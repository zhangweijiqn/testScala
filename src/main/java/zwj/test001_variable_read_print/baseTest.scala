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
    println(data.get) //abc	def	ghi

  }

  def main(args: Array[String]) {

    test

  }
}
