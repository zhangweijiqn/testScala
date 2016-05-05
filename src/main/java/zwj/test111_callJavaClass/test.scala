package zwj.test111_callJavaClass



/**
 * Created by zhangwj on 16-4-20.
 *    Scala调用Java类
 */
object test {

  def getDate() ={

    import java.text.DateFormat
    import java.util.{Date, Locale}

    val df = DateFormat.getDateTimeInstance(
      DateFormat.FULL, DateFormat.SHORT, Locale.CHINA);
    df.format(new Date())
  }

  def main(args: Array[String]) {
    println(getDate())
  }
}
