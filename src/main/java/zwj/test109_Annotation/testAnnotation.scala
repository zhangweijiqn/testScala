package zwj.test109_Annotation

import org.junit.Test

import scala.annotation.Annotation
import scala.beans.BeanProperty

/**
 * Created by Administrator on 2016/2/23 0023.
 */
class Person{
  @BeanProperty var name:String = _
  //将生成javaBeans风格的getter和setter方法
}
class testAnnotation{
  //scala可以使用java的注解

  @volatile var done = false  //在JVM中将成为volatile字段
  @throws(classOf[Exception])def readFile(fileName:String): Unit ={
    //注解生成可能跑出的异常
    throw new Exception(fileName+" error")
  }

  @Test def testSomeFeature(): Unit ={  //Test注解，Junit,只有在class中才可以执行
    println("test Annotation")
    readFile("aaa")
    val p = new Person
    p.setName("aaa")  //调用注解生成的java风格setter方法
    println(p.getName)
  }
}
