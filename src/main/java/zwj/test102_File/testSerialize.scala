package zwj.test102_File

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Administrator on 2016/2/11 0011.
 */

class Person(val id:Int,var name:String) extends Serializable {
  private var private_age = 0
  def age = private_age //private_age getter method
  def age_=(newValue: Int){ //private_age setter method
    if(newValue>private_age)private_age=newValue
  }

  private val friends = new ArrayBuffer[Person] //ArrayBuffer也可以被序列化和反序列化
  def addFriend(p:Person): Unit ={
    friends+=p
  }
  def getFriends()=friends
}

object testSerialize extends App{
  val fred = new Person(123,"Fred")
  fred.addFriend(new Person(124,"Joy"))

  //序列化
  import java.io._
  val out =new ObjectOutputStream(new FileOutputStream("src\\zwj\\test102_File\\test.obj"))
  out.writeObject(fred)
  out.close()

  //反序列化
  val in = new ObjectInputStream(new FileInputStream("src\\zwj\\test102_File\\test.obj"))
  val savedFred = in.readObject().asInstanceOf[Person]
  for(p<-savedFred.getFriends())println(p.name)
}
