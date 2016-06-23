package zwj.test001_variable_read_print

/**
 * Created by zhangwj on 16-6-23.
 */
object baseTest {
  def main(args: Array[String]) {
    println(Integer.MAX_VALUE)  //2的31次方减1，Integer包含正负
    val Str = "abc\tdef\tghi"
    val spanStr = Str.span(_!='\t') //split，在第一个满足条件的地方
    println(spanStr)
  }
}
