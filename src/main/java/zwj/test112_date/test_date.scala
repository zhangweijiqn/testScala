package zwj

/**
  * Created by zhangweijian01 on 17/7/11.
  * refer to the way of java. http://yuncode.net/code/c_5194eee4e69e95
  */
package object test_date {



  def main(args: Array[String]): Unit = {
    import java.util.Date
    import java.util.Calendar
    import java.text.SimpleDateFormat

    val lt:Long = 1499659472000l;//精确到毫秒
    val date = new Date(lt)
    val calendar = Calendar.getInstance()
    calendar.setTime(date)
    calendar.get(Calendar.MINUTE)

  }
}
