package zwj.test103_Regex

/**
 * Created by Administrator on 2016/2/11 0011.
 */
object testRegex extends App {

  val pattern1 = "\\s+[0-9]+\\s+".r //r方法构造一个Regex对象
  val pattern2 = """\s+[0-9]+\s""".r //r方法构造一个Regex对象

  val matches = pattern1.findAllIn(" 1 ").toArray

  if(matches.length>0){
    for(m<-matches)println(m)
  }  else println("does not match")

}
