package zwj.test100_Enum

object WeekDay extends Enumeration{
  type WeekDay = Value  //声明枚举对外暴露的变量类型
  val Mon = Value               //默认id，从0开始
  val Tue = Value(1,"Tuesday")  //显式指定id和value
  val Wed = Value
  val Thu = Value
  val Fri = Value
  val Sat = Value
  val Sun = Value
  def checkExists(day:Int) = this.values.exists(_==day) //检测是否存在此枚举值
  def isWorkingDay(day:WeekDay) = ! ( day==Sat || day == Sun) //判断是否是工作日
  def showAll = this.values.foreach(println) // 打印所有的枚举值
}

object testEnumeration {
  def main(args: Array[String]): Unit = {
    println(WeekDay.Mon.id)       //0
    println(WeekDay.Mon)          //Mon
    println(WeekDay.Tue.toString) //Tuesday

    println(WeekDay.checkExists(8))//检测是否存在

    println(WeekDay.Sun==7)//

    WeekDay.showAll //打印所有的枚举值

    println(WeekDay.isWorkingDay(WeekDay.Sun)) //是否是工作日
  }
}
