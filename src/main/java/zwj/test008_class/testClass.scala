package zwj.test008_class

import java.io.FileReader
import java.util.Properties

/**
 * Created by Administrator on 2016/2/10 0010.
 */
//一个文件中可以定义多个class，默认都是public

//variable , method
class Counter{
  private var value = 0   //private, value must be initialized
  def increment(){
    value+=1
  }
  def current=value   //here current without (), we can add ()
}

//default getter and setter
class p{
  var age = 0
  //value default getter age, setter age=
}

//user-define getter and setter
class Person{
  private var private_age = 0
  def age = private_age //private_age getter method
  def age_=(newValue: Int){ //private_age setter method
    if(newValue>private_age)private_age=newValue
  }
}

//对象私有字段
class PrivateO{
  private var value = 0
  def increment(){value+=1}
  def isLess(other:PrivateO)=value<other.value  //可以访问同一个类的另一个对象私有字段
}
class PrivateO2{
  private[this] var value = 0   //private[class] ,class either current class or outer class
  //private指定的class才能访问
  def increment(){value+=1}
  //def isLess(other:PrivateO2)=value<other.value   //compile error
}

//use annotation to gennerate getter and setter
//import scala.reflect.BeanProperty

//auxiliary constructor 辅助构造器
class PersonC{
  private var name = ""
  private var age = 0

  def this(name:String){  //constructor name this
    this()  // call the main constructor
    this.name = name
  }
  def this(name:String,age:Int){
    this(name)
    this.age = age
  }
}

//test main constructor
class PersonM(private val name:String, val age:Int=0){ //主构造器，传入的参数被编译成字段，值被初始化成传入的参数(also can be initialized by default value
  println("Just constructed another person")  //main constructor will execute all the statements
  private val props = new Properties  //java Properties 可以直接使用java类
  props.load(new FileReader("D:\\MyProjects\\ScalaTest\\src\\zwj\\test008_class\\myprog.properties")) //java FileReader
  println(props.get("age"))
}

//inner class
import scala.collection.mutable.ArrayBuffer
class Network{
  class Member(val name:String){
    val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name:String)={
    val m = new Member(name)
    members+=m
    m
  }
}

// main
object testClass {
  def main(args:Array[String]){
    //test counter
    val myCounter = new Counter
    myCounter.increment()
    println(myCounter.current)  //must use .current rather than .current()

    //test p
    val per = new p
    println(per.age)
    per.age=10
    println(per.age)

    //test Person
    val fred = new Person
    fred.age = 30   //call default getter .age_=()
    fred.age_=(21)  //default getter .age_=()
    println(fred.age)

    //test PrivateO
    val po1 = new PrivateO
    val po2 = new PrivateO
    println(po1.isLess(po2))

    //test PersonC
    val personC1 = new PersonC
    val personC2 = new PersonC("Freda")
    val personC3 = new PersonC("Freda",15)

    //test PersonM
    val personM = new PersonM("zhang")

    //test Network
    val chatter = new Network
    val myFace = new Network

  }
}