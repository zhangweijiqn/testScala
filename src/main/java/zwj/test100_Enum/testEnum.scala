package zwj.test100_Enum

/**
 * Created by Administrator on 2016/2/11 0011.
 */
object testEnum extends Enumeration{   //继承Enumeration
  type TrafficLightColor=Value  //类型起别名，类型为：testEnum.Value类，testEnum为握有这些值的对象
  val Red,Yellow,Green = Value  //Value方法来初始化各枚举值,返回Value类对象
  val High = Value(10,"high")
  val Middle = Value(11,"middle")
  val Low = Value(12,"low")
}

object test{

  import zwj.test100_Enum.testEnum._    //引入包，就可以直接使用枚举
  def doWhat(color:TrafficLightColor)={
    if(color==Red) "stop"
    else if(color==Yellow) "wait"
    else "go"
  }

  def testType(): Unit ={
    type WeightedPoint = (Vector[Double], Long) //自定义类型
    val v = Vector.fill(10)(0.0)
    val wp= new WeightedPoint(v,1)
    println(wp._1)
    println(wp._2)
  }

  def main(args:Array[String]): Unit ={
    println(testEnum.Red.id)    //id获取id
    println(testEnum.Red.toString)  //toString获取value
    println(testEnum.Middle)

    println(doWhat(testEnum.Green))

    for(c<-testEnum.values)println(c.id+":"+c)  //得到所有id：value

    println(testEnum(0)) //调用Enumeration.apply,根据id返回testEnum.Red对象
    testEnum.withName("Red")  //根据name返回testEnum.Red对象
  }





}
